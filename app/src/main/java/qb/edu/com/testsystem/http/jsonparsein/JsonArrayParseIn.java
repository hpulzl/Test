package qb.edu.com.testsystem.http.jsonparsein;

import org.json.JSONArray;

/**
 * Created by admin on 2016/4/5.
 * 提供jsonArray解析的接口
 */
public interface JsonArrayParseIn<T> {
    public static String TAG = "JsonArrayParseIn--->";
    T parseJsonByArray(JSONArray jsonArray);
}
