package qb.edu.com.testsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.entity.Grade;
import qb.edu.com.testsystem.entity.Qusbank;
import qb.edu.com.testsystem.http.URLAddress;
import qb.edu.com.testsystem.http.jsonparsein.impl.QusbankJsonArray;
import qb.edu.com.testsystem.http.network.VolleyUtil;
import qb.edu.com.testsystem.util.DialogUtil;
import qb.edu.com.testsystem.util.HandlerMsgNum;
import qb.edu.com.testsystem.util.QusListUtil;
import qb.edu.com.testsystem.util.ToastUtil;

/**
 *开始考试
 */
public class StartExamActivity extends AppCompatActivity implements View.OnClickListener,DialogUtil.OnDialogClickListener{
    private static final String TAG="StartExamActivity";
    private QusListUtil qusListUtil;
    private Button btn_finish_test;
    private TextView tv_time,question,id;
    private CheckBox singleOptionA;
    private CheckBox singleOptionB;
    private CheckBox singleOptionC;
    private CheckBox singleOptionD;
    private ImageButton back_btn;
    private int nextQus;
    private int totalQusbank;
    private Grade grade1;
    private final int Testtime = 15;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private List<String> answerList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exam);
        initView();
        initTestPaper();
    }
    private void initView() {
        btn_finish_test = (Button) findViewById(R.id.btn_finish_test);
        tv_time = (TextView) findViewById(R.id.tv_time);
        question = (TextView) findViewById(R.id.question);
        id = (TextView) findViewById(R.id.id);
        singleOptionA = (CheckBox) findViewById(R.id.single_option_A);
        singleOptionB = (CheckBox) findViewById(R.id.single_option_B);
        singleOptionC = (CheckBox) findViewById(R.id.single_option_C);
        singleOptionD = (CheckBox) findViewById(R.id.single_option_D);
        back_btn = (ImageButton) findViewById(R.id.btn_back);

        back_btn.setOnClickListener(this);
        btn_finish_test.setOnClickListener(this);
        DialogUtil.DialogUtilInstance().setOnDialogClickListener(this);
    }
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case HandlerMsgNum.REFRESH_ZERO:  //第一次进入考试界面
                    List<Qusbank> list = (List<Qusbank>) msg.obj;
                    qusListUtil = new QusListUtil(list,StartExamActivity.this);
                    totalQusbank = list.size();
                    timeThread(Testtime);
                    showQusbank(0);  //显示第1个题
                    break;
                case HandlerMsgNum.REFRESH_ONE:
                    tv_time.setText(msg.obj+"分钟");
                    break;
                case HandlerMsgNum.REFRESH_THREE:
                    showGradeDialog(finishTest());
                    break;
            }
        }
    };



    /**
     * 显示第i个试题。
     * @param i
     */
    private void showQusbank(int i){
        nextQus = i;
        Qusbank qus = qusListUtil.nextQusbank(i);
        String[] strs = QusListUtil.DistinguishQusbank(qus.getQusissue());
        id.setText("("+qus.getQustype()+")"+(i+1)+"、");
        question.setText(strs[0]);  //问题+题型
        singleOptionA.setText(strs[1]);
        singleOptionB.setText(strs[2]);
        if(strs.length>3){  //表示是个选择题
            singleOptionC.setVisibility(View.VISIBLE);
            singleOptionD.setVisibility(View.VISIBLE);
            singleOptionC.setText(strs[3]);
            singleOptionD.setText(strs[4]);
        }else{ //表示判断题
            singleOptionC.setVisibility(View.GONE);
            singleOptionD.setVisibility(View.GONE);
        }
    }
    /**
     * 获取试卷信息
     */
    private void initTestPaper() {
        getQusList(getTestid());
    }
    /**
     * 获取testid
     * @return
     */
    private String getTestid(){
        Intent mIntent = getIntent();
        grade1 = new Grade();
        grade1.setTestName(mIntent.getStringExtra("testName"));
        grade1.setUsername(mIntent.getStringExtra("userName"));
        grade1.setTime(sdf.format(new Date()));
        grade1.setUserid(mIntent.getStringExtra("userid"));
        return mIntent.getStringExtra("testid");
    }

    /**
     * 通过testid获取试题集
     * @param testid
     */
    private void getQusList(String testid){
        String url = URLAddress.getURLPath("SelectQusByTestidSer?testid="+testid);
        VolleyUtil.sendJsonArrayRequest(this, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                QusbankJsonArray qusbankJsonArray = new QusbankJsonArray();
                List<Qusbank> list = qusbankJsonArray.parseJsonByArray(jsonArray);
                Message msg = new Message();
                msg.what = HandlerMsgNum.REFRESH_ZERO;
                msg.obj = list;
                mHandler.sendMessage(msg);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ToastUtil.toast(StartExamActivity.this,"网络访问失败"+volleyError.toString());
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                showInfoDialog(true);
                break;
            case R.id.btn_finish_test:
                if (nextQus == totalQusbank - 2) {  //如果是最后两题时，点击下一题，将按钮信息改为“交卷”
                    btn_finish_test.setText("交卷");
                }
               //点击下一题时候，应该先去保存上一道题的答案。
                if(saveAnswer()) {
                    if (nextQus >= totalQusbank - 1) {  //如果是最后一道题，就提交试卷
                        Log.i(TAG,"您的成绩是："+finishTest());
                        showGradeDialog(finishTest());
                    }else{
                        showQusbank(++nextQus);
                    }
                }
                break;
        }
    }

    /**
     * 考试结束
     * 1、计算成绩
     * 2、保存成绩到SQLLite数据库中
     */
    private int finishTest() {
        //进行成绩的计算
       return qusListUtil.getCountGrade(answerList);
    }

    /**
     * 将考试成绩保存到SQLLite数据库中。
     * @return
     */
    private void saveGrade(Grade g){
        qusListUtil.saveGrade(g);
    }
    /**
     * 保存答案集合
     * @return
     */
    private boolean saveAnswer(){
        StringBuffer answer=new StringBuffer();
        if(singleOptionA.isChecked()){  //如果A被选中，这里不能用if elseif 语句。因为还有多选。
            answer.append("A");
        }
        if(singleOptionB.isChecked()){
            answer.append("B");
        }
        if(singleOptionC.isChecked()){
            answer.append("C");
        }
        if(singleOptionD.isChecked()){
            answer.append("D");
        }
        if(answer.toString().isEmpty()){
            showInfoDialog(false);
            return false;
        }
        Log.i(TAG,"选中答案："+answer.toString());
        //将答案加到list集合中。
        answerList.add(answer.toString());
        singleOptionA.setChecked(false);
        singleOptionB.setChecked(false);
        singleOptionC.setChecked(false);
        singleOptionD.setChecked(false);
        return true;
    }

    /**
     * 提示信息
     */
    private void showInfoDialog(boolean isReturn) {
        if(isReturn){
        //如果是返回试卷界面的话，你们就要提交试卷,并不产生成绩。
            DialogUtil.DialogUtilInstance().showDialog(this,"返回将自动提交试卷",true);
            return;
        }
        DialogUtil.DialogUtilInstance().showDialog(this,"请选择答案",false);
    }

    /**
     * 展示提示信息，告诉用户得了多少分。
     * 并保存到数据库中
     */
    private void showGradeDialog(int grade) {
        if(!this.isFinishing())   //如果这个activity没有finish时候，显示提示框。
        {
            DialogUtil.DialogUtilInstance().showDialog(this,"您的考试成绩是"+grade+"分",true);
        }
        grade1.setGradeScore(grade);
        saveGrade(grade1);
    }

    @Override
    public void onDialogClick() {
        startIntentActivity();
    }
    /**
     * 跳转
     */
    private void startIntentActivity(){
        Intent mIntent = new Intent(this,MainActivity.class);
        startActivity(mIntent);
        finish();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            showInfoDialog(true);
            return false;
        }else if((keyCode == KeyEvent.KEYCODE_HOME)) {
            showInfoDialog(true);
            return false;
        }else{
            return super.onKeyDown(keyCode, event);
        }
    }
    private void timeThread(final int time){
        tv_time.setText(time+"分钟");
        new Thread(){
            @Override
            public void run() {
                super.run();
                int t = time;
                for(int i=0;i<time;i++){
                    try {
                        sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    t--;   //每间隔1分钟，时间减1
                    Message msg = new Message();
                    msg.what = HandlerMsgNum.REFRESH_ONE;
                    msg.obj = t;
                    mHandler.sendMessage(msg);
                }
                //表示时间到，考试结束。
                Message msg = new Message();
                msg.what = HandlerMsgNum.REFRESH_THREE;
                msg.obj = t;
                mHandler.sendMessage(msg);
            }


        }.start();
    }
}
