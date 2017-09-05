package com.android.loginadroid;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guohao4 on 2017/9/4.
 * Email: Tornaco@163.com
 */

public class UserRepo {

    final static String DB_PATH = "/mydb.db3";


    public boolean saveUser(Context context, User user) {

        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(context.getFilesDir() + DB_PATH, null);

        String sql = "create table IF NOT EXISTS user_inf(user_id integer primary key, user_name varchar(255), user_pass varchar(255))";
        db.execSQL(sql);

        String name = user.getName();
        String pass = user.getPass();

        try {
            db.execSQL("insert into user_inf values(null, ?, ?)", new String[]{name, pass});
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

    public boolean isUserExists(Context context, String uName) {
        return getAllUser(context).contains(new User(uName, null));
    }

    public List<User> getAllUser(Context context) {
        List<User> usrs = new ArrayList<User>();

        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(context.getFilesDir() + DB_PATH, null);
        Cursor cursor = db.rawQuery("select * from user_inf", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndex("user_name"));
            String pass = cursor.getString(cursor.getColumnIndex("user_pass"));
            User user = new User();
            user.setName(name);
            user.setPass(pass);
            usrs.add(user);
            cursor.moveToNext();

        }
        return usrs;
    }


}
