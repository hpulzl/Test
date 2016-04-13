package qb.edu.com.testsystem.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.entity.User;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG ="UserInfoActivity";
    private TextView tv_name;
    private TextView tv_number;
    private TextView tv_class;
    private Button btn_look_grade,btn_look_wrongQus;
    private ImageButton btn_back;
    private Intent mIntent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initView();
    }

    private void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_number = (TextView) findViewById(R.id.tv_number);
        tv_class = (TextView) findViewById(R.id.tv_class);
        btn_look_wrongQus = (Button) findViewById(R.id.btn_look_wrongQus);
        btn_look_grade = (Button) findViewById(R.id.btn_look_grade);
        btn_back = (ImageButton) findViewById(R.id.btn_back);


        btn_look_wrongQus.setOnClickListener(this);
        btn_look_grade.setOnClickListener(this);
        btn_back.setOnClickListener(this);

        User u = storeUserByBundle();
        tv_name.setText(u.getName());
        tv_number.setText(u.getUserName());
        tv_class.setText(u.getClassGrade());
    }
    //获取传过来的User对象
    private User storeUserByBundle(){
        //获取User对象
        Intent mIntent = getIntent();
        Bundle bundle = mIntent.getExtras();
        return (User) bundle.get("user");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_look_grade:  //查看成绩
                //查看成绩页面
                mIntent.setClass(this,LookGradeActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_look_wrongQus:  //查看错题
                //查看成绩页面
                mIntent.setClass(this,WrongQusActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_back:
                //返回MainActivity
                startActivity(new Intent(UserInfoActivity.this,MainActivity.class));
                break;
        }
    }
}
