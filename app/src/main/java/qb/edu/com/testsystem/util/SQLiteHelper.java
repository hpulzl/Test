package qb.edu.com.testsystem.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 2016/4/9.
 * 创建数据库的帮助类
 */
public class SQLiteHelper extends SQLiteOpenHelper{
    private static final String CREATE_CLASS_TABLE = "create table Grade ("
            +"userid text,"
            + "userName text, "
            + "paperName text, "
            + "joinTime text, "
            + "grade int)";

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CLASS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Grade");
        onCreate(db);
    }
}
