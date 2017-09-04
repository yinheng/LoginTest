package com.android.loginadroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.android.loginadroid.UserSaver.DB_PATH;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        TextView hello = (TextView) findViewById(R.id.hello);

        String name = getIntent().getStringExtra("UserName");
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(getFilesDir() + DB_PATH, null);
        Cursor cursor = db.query("user_inf", null, "user_name=?", new String[]{name}, null, null, null);


        boolean exists = cursor.getCount() > 0;

        cursor.moveToFirst();

        String password = cursor.getString(cursor.getColumnIndex("user_pass"));
        cursor.close();

        hello.setText(password);
    }
}
