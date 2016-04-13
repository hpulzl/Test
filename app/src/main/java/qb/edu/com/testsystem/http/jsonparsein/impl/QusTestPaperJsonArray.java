package qb.edu.com.testsystem.http.jsonparsein.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import qb.edu.com.testsystem.entity.QusTestPaper;
import qb.edu.com.testsystem.http.jsonparsein.JsonArrayParseIn;

/**
 * Created by admin on 2016/4/7.
 * 对试卷的解析
 */
public class QusTestPaperJsonArray implements JsonArrayParseIn<List<QusTestPaper>> {
    @Override
    public List<QusTestPaper> parseJsonByArray(JSONArray jsonArray) {
       List<QusTestPaper>  qtpList = new ArrayList<>();

            try {
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jo = (JSONObject) jsonArray.get(i);
                    QusTestPaper qtp = new QusTestPaper();
                    qtp.setTestid(jo.getString("testid"));
                    qtp.setTestname(jo.getString("testName"));
                    qtp.setTestdifficult(jo.getString("testDifficult"));
                    qtp.setTestCount(jo.getInt("testNum"));

                    qtpList.add(qtp);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        return qtpList;
    }
}
