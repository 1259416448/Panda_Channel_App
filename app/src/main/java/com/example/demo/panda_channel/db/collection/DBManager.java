package com.example.demo.panda_channel.db.collection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 闫雨婷 on 2017/7/31.
 */

public class DBManager {
    private static DBManager dbManager;
    private DaoMaster.DevOpenHelper openHelper;
    private DBManager(Context context){
        openHelper=new DaoMaster.DevOpenHelper(context,"collection");
    }
    public static synchronized DBManager getInstance(Context context){
        if(dbManager==null)
            dbManager=new DBManager(context);
        return dbManager;
    }

    public SQLiteDatabase getWriter(){
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
        return writableDatabase;
    }

    public SQLiteDatabase getReader(){
        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();
        return readableDatabase;
    }
}
