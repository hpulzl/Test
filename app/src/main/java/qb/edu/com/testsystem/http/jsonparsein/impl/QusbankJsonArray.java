package qb.edu.com.testsystem.http.jsonparsein.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import qb.edu.com.testsystem.entity.Qusbank;
import qb.edu.com.testsystem.http.jsonparsein.JsonArrayParseIn;

/**
 * Created by admin on 2016/4/7.
 * 对试卷的解析
 */
public class QusbankJsonArray implements JsonArrayParseIn<List<Qusbank>> {
    @Override
    public List<Qusbank> parseJsonByArray(JSONArray jsonArray) {
       List<Qusbank>  qusList = new ArrayList<>();

            try {
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jo = (JSONObject) jsonArray.get(i);
                    Qusbank qus = new Qusbank();
                    qus.setQusid(jo.getString("qusid"));
                    qus.setQusissue(jo.getString("qussiue"));
                    qus.setQusanswer(jo.getString("qusAnswer"));
                    qus.setQustype(jo.getString("qusType"));

                    qusList.add(qus);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return qusList;
    }
}
