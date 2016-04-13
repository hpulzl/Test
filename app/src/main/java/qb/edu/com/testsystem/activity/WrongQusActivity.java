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
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.util.List;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.adapter.TestPaperAdapter;
import qb.edu.com.testsystem.adapter.WrongQusAdapter;
import qb.edu.com.testsystem.entity.Qusbank;
import qb.edu.com.testsystem.http.URLAddress;
import qb.edu.com.testsystem.http.jsonparsein.impl.QusbankJsonArray;
import qb.edu.com.testsystem.http.network.VolleyUtil;
import qb.edu.com.testsystem.shareprefrence.OperateShareprefrence;
import qb.edu.com.testsystem.util.HandlerMsgNum;
import qb.edu.com.testsystem.util.ToastUtil;

public class WrongQusActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    private String userid;
    private SwipeRefreshLayout swipeRefreshWrongQus;
    private List<Qusbank> qusList;
    private RecyclerView wrongQusRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private WrongQusAdapter wrongQusAdapter;
    private ImageButton btn_Backuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_qus);
        userid = OperateShareprefrence.loadShareprefrence(this).getAccount();
        initView();
        initWrongQusDatas();
    }
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case HandlerMsgNum.REFRESH_ZERO:
                    qusList = (List<Qusbank>) msg.obj;
                    setRecyclerView(qusList);
                    swipeReFreshState(false);
                    break;
            }
        }
    };

    /**
     * 设置列表
     */
    private void setRecyclerView(List<Qusbank> list) {
        btn_Backuser = (ImageButton) findViewById(R.id.btn_Backuser);
        wrongQusAdapter = new WrongQusAdapter(wrongQusRecyclerView,list);
        wrongQusRecyclerView.setAdapter(wrongQusAdapter);

        //设置TestPaperAdapter点击事件
        setRecyclerItemOnclick();
        btn_Backuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(WrongQusActivity.this,UserInfoActivity.class);
                startActivity(mIntent);
                finish();
            }
        });
    }

    private void setRecyclerItemOnclick() {
        wrongQusAdapter.setOnItemClickListener(new TestPaperAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if(!qusList.isEmpty()&&qusList.size()>0) {
                    Intent mIntent = new Intent(WrongQusActivity.this, WrongQusInfoActivity.class);
                    Bundle mBundle = new Bundle();
                    mBundle.putSerializable("qusbank", (Qusbank) qusList.get(position));
                    mIntent.putExtras(mBundle);
                    startActivity(mIntent);
                }
            }
        });
    }

    /**
     * 初始化错题信息。
     */
    private void initWrongQusDatas() {
        String url = URLAddress.getURLPath("SelectWrongQusSer?userid="+userid);
        VolleyUtil.sendJsonArrayRequest(this, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                Log.i("WrongQus...","jsonArray"+jsonArray);
                QusbankJsonArray qusbank = new QusbankJsonArray();
                Message msg = new Message();
                msg.obj = qusbank.parseJsonByArray(jsonArray);
                msg.what = HandlerMsgNum.REFRESH_ZERO;
                mHandler.sendMessage(msg);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ToastUtil.toast(WrongQusActivity.this,"网络访问失败"+volleyError.toString());
            }
        });
    }

    private void initView() {
        initSwipeRefresh();

        wrongQusRecyclerView = (RecyclerView) findViewById(R.id.look_wrongQus_recycler);
        wrongQusRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        wrongQusRecyclerView.setLayoutManager(mLayoutManager);
        wrongQusRecyclerView.setItemAnimator(new DefaultItemAnimator());


    }
    /**
     * 初始化下拉刷新条。
     */
    private void initSwipeRefresh(){
        swipeRefreshWrongQus = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_WrongQus);

        //设置刷新条的颜色
        swipeRefreshWrongQus.setColorSchemeColors(R.color.color_theme,
                R.color.colorAccent,R.color.colorPrimary,R.color.colorPrimaryDark);
        swipeRefreshWrongQus.setOnRefreshListener(this);

        //第一次进入页面时，显示加载进度条
        swipeRefreshWrongQus.setProgressViewOffset(false,0,(int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        swipeReFreshState(true);  //开始进入界面，显示刷新条
    }

    private void swipeReFreshState(boolean b) {
        swipeRefreshWrongQus.setRefreshing(b);
    }

    @Override
    public void onRefresh() {
        qusList.clear();
        initWrongQusDatas();
    }
}
