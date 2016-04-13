package qb.edu.com.testsystem.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import qb.edu.com.testsystem.R;
import qb.edu.com.testsystem.http.URLAddress;
import qb.edu.com.testsystem.http.network.NetWorkUtil;
import qb.edu.com.testsystem.http.network.VolleyUtil;
import qb.edu.com.testsystem.shareprefrence.Account;
import qb.edu.com.testsystem.shareprefrence.OperateShareprefrence;
import qb.edu.com.testsystem.util.ToastUtil;

/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText inputUsername;
    private EditText inputPassword;
    private ProgressDialog waitDialog;
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputUsername = (EditText) findViewById(R.id.username);
        inputPassword = (EditText) findViewById(R.id.password);
        Button loginBtn = (Button) findViewById(R.id.login);
        TextView register = (TextView) findViewById(R.id.register);

        loginBtn.setOnClickListener(this);
        register.setOnClickListener(this);

        Account account = OperateShareprefrence.loadShareprefrence(this);
        if(account!=null){
            inputUsername.setText(account.getAccount());
            inputPassword.setText(account.getPassword());
        }
    }

    private boolean prepareForLogin() {

        if(!NetWorkUtil.isNetWorkAvailable(this)){   //先检查网络
            ToastUtil.toast(this,"网络异常");
            return true;
        }else if (inputUsername.length() == 0) {
            inputUsername.setError("请输入账号");
            inputUsername.requestFocus();
            return true;
        }else if (inputPassword.length() == 0) {
            inputPassword.setError("请输入密码");
            inputPassword.requestFocus();
            return true;
        }

        return false;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                if (prepareForLogin()) {
                    return;
                }
                // if the data has ready
                final String username = inputUsername.getText().toString();
                final String password = inputPassword.getText().toString();
                //进行登录...
                userLogin(username,password);
                break;
            case R.id.register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    /**
     * 用户进行登录
     * @param username  用户名
     * @param password  密码
     */
    private void userLogin(final String username, final String password){
        //设置登录进度条
        waitDialog = new ProgressDialog(this);
        waitDialog.setMessage("登录中");
        waitDialog.setCancelable(false);
        waitDialog.show();
        String url = URLAddress.getURLPath("UserLoginSer");
        Map<String,String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        JSONObject jsonObject = new JSONObject(map);
        VolleyUtil.sendJsonObjectRequest(this, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                //网络访问成功,
                try {
                    if(jsonObject.getBoolean("result")){
                        ToastUtil.toast(LoginActivity.this,"登录成功！");
                        OperateShareprefrence.storeShareprefrence(LoginActivity.this,username,password);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        ToastUtil.toast(LoginActivity.this,"登录失败！");
                    }
                    waitDialog.dismiss();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                ToastUtil.toast(LoginActivity.this,"网络请求失败"+volleyError);
                Log.i(TAG,"jsonObject:"+volleyError);
                waitDialog.dismiss();
            }
        });
    }
}
