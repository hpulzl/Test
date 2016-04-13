package qb.edu.com.testsystem.util;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import qb.edu.com.testsystem.entity.Grade;
import qb.edu.com.testsystem.entity.Qusbank;
import qb.edu.com.testsystem.http.URLAddress;
import qb.edu.com.testsystem.http.network.VolleyUtil;
import qb.edu.com.testsystem.shareprefrence.OperateShareprefrence;

/**
 * Created by admin on 2016/4/7.
 * 试卷测试题的工具类
 * 存储试卷中所有的试题
 */
public class QusListUtil {
    private List<Qusbank> qusbanks;
    public static final int gradeEve = 5; //设置每道题5分
    private Context context;
    private String userid;
    public QusListUtil(List<Qusbank> list,Context context){
        this.qusbanks = list;
        this.context = context;
       userid =  OperateShareprefrence.loadShareprefrence(context).getAccount();
    }

    /**
     * 获取下一个试题内容
     * @param i
     * @return
     */
    public Qusbank nextQusbank(int i){
        return qusbanks.get(i);
    }

    /**
     * 通过类型和问题来区分问题、选项
     * @param sissue
     * @return
     */
    public static String[] DistinguishQusbank(String sissue){
        String regex = "[A-D]、";
        return sissue.split(regex);
    }

    /**
     * 将题目区分出来
     * @param sissue
     * @return
     */
    public static String distinguishQus(String sissue){
        String regex = "A、";
        String siss[] = sissue.split(regex);
        return siss[0];
    }
    /**
     * 计算成绩
     * @param answerList
     * @return
     */
    public int getCountGrade(List<String> answerList){
        int countGrade = 0;
        if(answerList==null||answerList.isEmpty()){
           countGrade = 0;
            return countGrade;
        }
       //总是获取集合较少那个数据，作为遍历范围
        int listSize = answerList.size() > qusbanks.size()? qusbanks.size() : answerList.size();
        //这里按照试卷个数去获取答案。
        for(int i=0;i<listSize;i++){
            if(qusbanks.get(i).getQusanswer().equals(answerList.get(i))){
                //答案正确加分
                countGrade += gradeEve;
            }else{
                //答案错误就要保存试题。并提交到服务器端。
                saveWrongQus(qusbanks.get(i).getQusid(), userid);
            }
        }
       //返回成绩
        return countGrade;
    }

    /**
     * 将成绩保存到数据库中
     * 用户id，时间，成绩。
     */
    public void saveGrade(Grade g) {
       new OperateSQLite(context).saveGrade(g);
    }
    /**
     * 将错题存储到后台服务器中。
     * @param qusid
     * @param account
     */
    private void saveWrongQus(String qusid, String account) {
        String url = URLAddress.getURLPath("SaveWrongQusSer");
        Map<String,String> map = new HashMap<>();
        map.put("qusid",qusid);
        map.put("userid",account);
        JSONObject obj = new JSONObject(map);
        VolleyUtil.sendJsonObjectRequest(context, url, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        });
    }


}
