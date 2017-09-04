package com.android.loginadroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guohao4 on 2017/9/4.
 * Email: Tornaco@163.com
 */

public class UserSaver {

    final static String DB_PATH = "/mydb.db3";

    List<User> usrs = new ArrayList<User>();


    public List<User> saveUser(Context context, User user) {
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(context.getFilesDir() + DB_PATH, null);

        String sql = "create table IF NOT EXISTS user_inf(user_id integer primary key, user_name varchar(255), user_pass varchar(255))";
        db.execSQL(sql);

        String name = user.getName();
        String pass = user.getPass();

        db.execSQL("insert into user_inf values(null, ?, ?)", new String[]{name, pass});

        usrs.add(user);

        return usrs;
    }
}
