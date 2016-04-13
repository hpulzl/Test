package qb.edu.com.testsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.adapter.TestPaperAdapter;
import qb.edu.com.testsystem.entity.QusTestPaper;
import qb.edu.com.testsystem.entity.User;
import qb.edu.com.testsystem.http.URLAddress;
import qb.edu.com.testsystem.http.jsonparsein.impl.QusTestPaperJsonArray;
import qb.edu.com.testsystem.http.jsonparsein.impl.UserJsonObject;
import qb.edu.com.testsystem.http.network.VolleyUtil;
import qb.edu.com.testsystem.shareprefrence.Account;
import qb.edu.com.testsystem.shareprefrence.OperateShareprefrence;
import qb.edu.com.testsystem.util.HandlerMsgNum;
import qb.edu.com.testsystem.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SwipeRefreshLayout.OnRefreshListener{
    private ImageButton btn_Userinfo;
    private static final String TAG="MainActivity";
    private User u;
    private SwipeRefreshLayout swipe_refresh_widget;
    private RecyclerView Test_paper_recycler;
    private LinearLayoutManager mLayoutManager;
    private List<QusTestPaper> qusTestPaperList = new ArrayList<>();
    private TestPaperAdapter   testPaperAdapter;
    private int pageNo = 1;   //设置初始页为1
    private int  lastVisibleItem;
    private int totalTestPage = 0;
    private View footView;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case HandlerMsgNum.INIT_INFO:
                    u = (User) msg.obj;
                    break;
                case HandlerMsgNum.REFRESH_ZERO:  //第一次加载数据
                    qusTestPaperList = (List<QusTestPaper>) msg.obj;
                    setRecyclerView(qusTestPaperList);
                    swipeReFreshState(false);
                    break;
                case HandlerMsgNum.REFRESH_ONE:  //不是第一次加载数据.上拉加载数据
                    qusTestPaperList.addAll((List<QusTestPaper>) msg.obj);
                    testPaperAdapter.notifyDataSetChanged();
                    testPaperAdapter.notifyItemRemoved(testPaperAdapter.getItemCount());
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       initView();
    }

    private void initView() {
        Account account = OperateShareprefrence.loadShareprefrence(this);
        btn_Userinfo = (ImageButton) findViewById(R.id.btn_infor);
        Test_paper_recycler = (RecyclerView) findViewById(R.id.Test_paper_recycler);
        Test_paper_recycler.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        Test_paper_recycler.setLayoutManager(mLayoutManager);
        Test_paper_recycler.setItemAnimator(new DefaultItemAnimator());
        getUserNetWork(account.getAccount());   //访问网络数据
        initSwipeRefresh();
        getTotalTestPaper();
        //加载第一页数据
        initFirstPage();

        btn_Userinfo.setOnClickListener(this);
    }

    /**
     * 初始化下拉刷新条。
     */
    private void initSwipeRefresh(){
        swipe_refresh_widget = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);

        //设置刷新条的颜色
        swipe_refresh_widget.setColorSchemeColors(R.color.color_theme,
                R.color.colorAccent,R.color.colorPrimary,R.color.colorPrimaryDark);
        swipe_refresh_widget.setOnRefreshListener(this);

        //第一次进入页面时，显示加载进度条
        swipe_refresh_widget.setProgressViewOffset(false,0,(int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        swipeReFreshState(true);  //开始进入界面，显示刷新条
    }
    private void initFirstPage(){
        //加载第一页的数据.
        getTestPaper(1);
    }

    /**
     * 设置Recyclerview的布局
     */
    private void setRecyclerView(List<QusTestPaper> list){
        testPaperAdapter = new TestPaperAdapter(this,list);
        Test_paper_recycler.setAdapter(testPaperAdapter);
        footView = LayoutInflater.from(this).inflate(R.layout.item_foot,Test_paper_recycler,false);
        testPaperAdapter.setFootView(footView);
        setRecyclerScrollListener();
        //设置TestPaperAdapter点击事件
        setRecyclerItemOnclick(list);
    }
    //出现滑动时候，才去设置滑动监听
    private void setRecyclerScrollListener(){
        Test_paper_recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d(TAG, "StateChanged = " + newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem+1 == testPaperAdapter.getItemCount()){
                    if(lastVisibleItem+1 <= totalTestPage) {
                        //如果是最后一个item，那么开始加载更多
                        getTestPaper(pageNo);
                    }else{
                      ProgressBar loadMorePv = (ProgressBar) footView.findViewById(R.id.loadMore_pb);
                        TextView loadMoreTv = (TextView) footView.findViewById(R.id.loadMore_tv);
                        loadMoreTv.setText("没有更多数据");
                        loadMorePv.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });
    }
    private void setRecyclerItemOnclick(final List<QusTestPaper> list){

            Log.i(TAG,"执行了"+list.size()+"----");
            testPaperAdapter.setOnItemClickListener(new TestPaperAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    if(!list.isEmpty()&&list.size()>0) {
                        String testid = list.get(position).getTestid();
                        String testName = list.get(position).getTestname();
                        Intent mIntent = new Intent(MainActivity.this, StartExamActivity.class);
                        Bundle mBundle = new Bundle();
                        mBundle.putString("testid", testid);
                        mBundle.putString("testName", testName);
                        mBundle.putString("userName", u.getName());
                        mBundle.putString("userid", u.getUserName());  //是userid。
                        mIntent.putExtras(mBundle);
                        startActivity(mIntent);
                    }
                }
            });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_infor:   //点击跳转至用户界面
                Bundle bundle = new Bundle();
                bundle.putSerializable("user",u);
                Intent mIntent = new Intent(this,UserInfoActivity.class);
                mIntent.putExtras(bundle);
                startActivity(mIntent);
                break;
        }
    }
    /**
     * 通过userid访问服务器，获取用户的信息
     * @param userid
     * @return
     */
    private void getUserNetWork(final String userid){
        String url = URLAddress.getURLPath("SelectUserSer");
        Map<String,String> map = new HashMap<>();
        map.put("userid",userid);
        JSONObject obj = new JSONObject(map);
        VolleyUtil.sendJsonObjectRequest(this, url, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                    if(jsonObject!=null){  //获取数据，并封装成User对象
                        UserJsonObject userJsonObject = new UserJsonObject();
                        User u = userJsonObject.parseJsonByObject(jsonObject);
                        Message msg = new Message();
                        msg.obj = u;
                        msg.what = HandlerMsgNum.INIT_INFO;
                        mHandler.sendMessage(msg);
                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ToastUtil.toast(MainActivity.this,"网络访问异常");
            }
        });
    }

    /**
     * 分页直接获取所有的试卷信息。
     */
    private void getTestPaper(final int pageNum){
        pageNo = pageNum;
        String url = URLAddress.getURLPath("SelectAllTestPaperSer?pageNo="+pageNo);
        VolleyUtil.sendJsonArrayRequest(this, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i(TAG,"访问成功"+jsonArray);
                QusTestPaperJsonArray qusTestPaperJsonArray = new QusTestPaperJsonArray();
                List<QusTestPaper> qtsList = qusTestPaperJsonArray.parseJsonByArray(jsonArray);
                Message msg = new Message();
                if(pageNo == 1) {  //如果PageNum是1，查询第一条数据.
                    msg.what = HandlerMsgNum.REFRESH_ZERO;
                }else{
                    msg.what = HandlerMsgNum.REFRESH_ONE;
                }
                pageNo++;
                msg.obj = qtsList;
                mHandler.sendMessage(msg);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i(TAG,"访问失败"+volleyError.toString());
            }
        });
    }

    /**
     * 获取试卷的总数
     */
    private void getTotalTestPaper(){
        String url = URLAddress.getURLPath("TotalTestPaperSer");
        VolleyUtil.sendJsonObjectRequest(this, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.i(TAG,"访问成功"+jsonObject);
                try {
                    totalTestPage = jsonObject.getInt("totalTestPage");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i(TAG,"访问失败"+volleyError.toString());
            }
        });
    }
    /**
     * 设置是否下拉刷新
     * @param flag
     */
    private void swipeReFreshState(boolean flag){
        swipe_refresh_widget.setRefreshing(flag);
    }
    @Override
    public void onRefresh() {
        //下拉刷新监听事件，只刷新第一页的内容
        qusTestPaperList.clear();
        getTotalTestPaper();
        getTestPaper(1);
    }
}
