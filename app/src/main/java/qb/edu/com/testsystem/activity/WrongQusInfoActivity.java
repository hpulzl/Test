package qb.edu.com.testsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.entity.Qusbank;
import qb.edu.com.testsystem.util.QusListUtil;

/**
 * 查看错题的详细内容及答案
 */
public class WrongQusInfoActivity extends AppCompatActivity {
    private ImageButton btn_backToWrongQus;
    private TextView question;
    private CheckBox singleOptionA;
    private CheckBox singleOptionB;
    private CheckBox singleOptionC;
    private CheckBox singleOptionD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_qus_info);
        initView();
    }
    private Qusbank getWrongQus(){
        Intent mIntent = getIntent();
        return (Qusbank) mIntent.getSerializableExtra("qusbank");
    }
    private void initView() {
        question = (TextView) findViewById(R.id.question);
        btn_backToWrongQus = (ImageButton) findViewById(R.id.btn_backToWrongQus);
        singleOptionA = (CheckBox) findViewById(R.id.single_option_A);
        singleOptionB = (CheckBox) findViewById(R.id.single_option_B);
        singleOptionC = (CheckBox) findViewById(R.id.single_option_C);
        singleOptionD = (CheckBox) findViewById(R.id.single_option_D);

        setInfoToView(getWrongQus());

        btn_backToWrongQus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  //返回到上一个activity
            }
        });
    }

    /**
     * 向界面中添加内容信息
     * @param qus
     */
    public void setInfoToView(Qusbank qus) {
        //设置不能点击。
        singleOptionA.setEnabled(false);
        singleOptionB.setEnabled(false);
        singleOptionC.setEnabled(false);
        singleOptionD.setEnabled(false);
       String[] strs = QusListUtil.DistinguishQusbank(qus.getQusissue());
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
        //设置选中内容
        char[] chars = qus.getQusanswer().toCharArray();
        for(int i=0;i<chars.length;i++){
            Log.i("info...",chars[i]+"");
            //这里可能是多选题，因此只能用if不能用else
            if(chars[i]=='A'){
                singleOptionA.setChecked(true);
            }
            if(chars[i]=='B'){
                singleOptionB.setChecked(true);
            }
            if(chars[i]=='C'){
                singleOptionC.setChecked(true);
            }
            if(chars[i]=='D'){
                singleOptionD.setChecked(true);
            }
        }

    }
}
