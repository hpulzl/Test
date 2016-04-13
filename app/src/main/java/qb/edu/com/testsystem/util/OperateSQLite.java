package qb.edu.com.testsystem.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import qb.edu.com.testsystem.entity.Grade;

/**
 * Created by admin on 2016/4/9.
 * 对SQLite数据库的操作。
 * 主要是对成绩的存储和查询
 */
public class OperateSQLite {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private Context cxt;
    public OperateSQLite(Context context){
        this.cxt = context;
        sqLiteOpenHelper = new SQLiteHelper(context,"TestSystem.db",null,3);
    }
    /**
     * 获取数据库中的成绩列表
     * @param userid
     * @return
     */
    public List<Grade> getGradeById(String userid){
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        List<Grade> grades = new ArrayList<>();
        Cursor cursor = null;
        cursor = db.query("Grade",null,"userid like ?",new String[]{userid},null,null,"joinTime DESC");
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                Grade g = new Grade();
                g.setUserid(cursor.getString(cursor.getColumnIndex("userid")));
                g.setUsername(cursor.getString(cursor.getColumnIndex("userName")));
                g.setTestName(cursor.getString(cursor.getColumnIndex("paperName")));
                g.setTime(cursor.getString(cursor.getColumnIndex("joinTime")));
                g.setGradeScore(cursor.getInt(cursor.getColumnIndex("grade")));

                grades.add(g);
            }
        }
        return grades;
    }
    public boolean saveGrade(Grade g){
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("userid",g.getUserid());
        values.put("userName",g.getUsername());
        values.put("paperName",g.getTestName());
        values.put("joinTime",g.getTime());
        values.put("grade",g.getGradeScore());

        if(db.insert("Grade", null, values)<0) {
            return false;
        }
        return true;
    }
}
