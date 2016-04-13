package qb.edu.com.testsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.adapter.LookGradeAdapter;
import qb.edu.com.testsystem.entity.Grade;
import qb.edu.com.testsystem.shareprefrence.OperateShareprefrence;
import qb.edu.com.testsystem.util.OperateSQLite;

public class LookGradeActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,View.OnClickListener{
    private ImageButton btn_user;
    private SwipeRefreshLayout swipeRefreshGrade;
    private RecyclerView lookGradeRecycler;
    private String userid;
    private LinearLayoutManager mLayoutManager;
    private LookGradeAdapter lookGradeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_grade);
        userid = OperateShareprefrence.loadShareprefrence(this).getAccount();
        initView();
    }

    private void initView() {
        initSwipeRefresh();
        btn_user = (ImageButton) findViewById(R.id.btn_user);

        showGrade();
        btn_user.setOnClickListener(this);
    }
    //展示成绩
    private void showGrade(){
        lookGradeRecycler = (RecyclerView) findViewById(R.id.look_grade_recycler);
        lookGradeRecycler.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        lookGradeRecycler.setLayoutManager(mLayoutManager);
        lookGradeRecycler.setItemAnimator(new DefaultItemAnimator());

        lookGradeAdapter = new LookGradeAdapter(lookGradeRecycler,getGradeDatas());
        lookGradeRecycler.setAdapter(lookGradeAdapter);
        swipeReFreshState(false);
    }
    private List<Grade> getGradeDatas(){
        return new OperateSQLite(this).getGradeById(userid);
    }
    /**
     * 初始化下拉刷新条。
     */
    private void initSwipeRefresh(){
        swipeRefreshGrade = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_grade);

        //设置刷新条的颜色
        swipeRefreshGrade.setColorSchemeColors(R.color.color_theme,
                R.color.colorAccent,R.color.colorPrimary,R.color.colorPrimaryDark);
        swipeRefreshGrade.setOnRefreshListener(this);

        //第一次进入页面时，显示加载进度条
        swipeRefreshGrade.setProgressViewOffset(false,0,(int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        swipeReFreshState(true);  //开始进入界面，显示刷新条
    }

    private void swipeReFreshState(boolean b) {
        swipeRefreshGrade.setRefreshing(b);
    }

    @Override
    public void onRefresh() {
        showGrade();
        lookGradeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_user:
                Intent mIntent = new Intent(this,UserInfoActivity.class);
                startActivity(mIntent);
                finish();
                break;
        }
    }
}
