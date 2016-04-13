package qb.edu.com.testsystem.http.jsonparsein;

import org.json.JSONObject;

/**
 * Created by admin on 2016/4/5.
 * 提供jsonObject解析的接口
 */
public interface JsonObjectParseIn<T> {
    public static String TAG = "JsonObjectParseIn--->";
    T parseJsonByObject(JSONObject jsonObject);
}
