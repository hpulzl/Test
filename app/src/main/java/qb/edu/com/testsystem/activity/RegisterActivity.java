package qb.edu.com.testsystem.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.entity.User;
import qb.edu.com.testsystem.http.URLAddress;
import qb.edu.com.testsystem.http.network.VolleyUtil;
import qb.edu.com.testsystem.util.ToastUtil;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG="RegisterActivity";
    private EditText inputUserName;
    private EditText inputPassword;
    private EditText inputClass;
    private EditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputUserName = (EditText) findViewById(R.id.username);
        inputPassword = (EditText) findViewById(R.id.password);
        inputClass = (EditText) findViewById(R.id.register_class);
        inputName = (EditText) findViewById(R.id.register_name);   //学生姓名
        Button registerBtn = (Button) findViewById(R.id.register);

        registerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:

                if(checkInput()) {
                    User user = new User();
                    user.setUserName(inputUserName.getText().toString());
                    user.setPassword(inputPassword.getText().toString());
                    user.setClassGrade(inputClass.getText().toString());
                    user.setName(inputName.getText().toString());
                    //进行注册
                    userRegister(user);
                }else{
                    Toast.makeText(RegisterActivity.this,"请补全信息",Toast.LENGTH_SHORT).show();
                }
        }
    }
    //判断输入是否为空..
    private boolean checkInput(){
        if(!inputUserName.getText().toString().equals("")&&!inputPassword.getText().toString().equals("")
                &&!inputClass.getText().toString().equals(""))
            return true;
        else
            return false;
    }

    /**
     * 用户注册
     * @param u
     */
    private void userRegister(User u){
        final ProgressDialog waitDialog = new ProgressDialog(RegisterActivity.this);

        waitDialog.setMessage("注册中");
        waitDialog.setCancelable(false);
        waitDialog.show();

        String url = URLAddress.getURLPath("UserRegisterSer");
        Map<String,String> map = new HashMap<>();
        map.put("username",u.getUserName());
        map.put("password",u.getPassword());
        map.put("classGrade",u.getClassGrade());
        map.put("name",u.getName());
        JSONObject obj = new JSONObject(map);
        VolleyUtil.sendJsonObjectRequest(this, url, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.i(TAG,"jsonObject="+jsonObject);
                try {
                    if(jsonObject.getBoolean("result")){
                        ToastUtil.toast(RegisterActivity.this,"注册成功");
                        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        finish();
                    }else{
                        ToastUtil.toast(RegisterActivity.this,"注册失败");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                waitDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ToastUtil.toast(RegisterActivity.this,"网络请求失败");
                waitDialog.dismiss();
            }
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
