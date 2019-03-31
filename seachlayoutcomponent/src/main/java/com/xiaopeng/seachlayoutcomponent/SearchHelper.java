package com.xiaopeng.seachlayoutcomponent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Date: 2019/3/31
 * Created by LiuJian
 *
 * @author LiuJian
 */

class SearchHelper extends SQLiteOpenHelper {

  public SearchHelper(Context context){
      super(context,"record.db",null,1);
  }



    @Override
    public void onCreate(SQLiteDatabase db) {

        // 打开数据库 & 建立了一个叫records的表，里面只有一列name来存储历史记录：
        db.execSQL("create table records(id integer primary key autoincrement,name varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
