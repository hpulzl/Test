package qb.edu.com.testsystem.http.jsonparsein.impl;

import org.json.JSONException;
import org.json.JSONObject;

import qb.edu.com.testsystem.entity.User;
import qb.edu.com.testsystem.http.jsonparsein.JsonObjectParseIn;

/**
 * Created by admin on 2016/4/5.
 * 将获取的JsonObject转换成User对象
 */
public class UserJsonObject implements JsonObjectParseIn<User> {
    @Override
    public User parseJsonByObject(JSONObject jsonObject) {
        User u = new User();
        try {
            u.setUserName(jsonObject.getString("userid"));
            u.setName(jsonObject.getString("name"));
            u.setClassGrade(jsonObject.getString("classGrade"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return u;
    }
}
