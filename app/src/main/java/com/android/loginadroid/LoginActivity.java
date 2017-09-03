package com.android.loginadroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText userName = (EditText)findViewById(R.id.username_login);
        EditText password = (EditText)findViewById(R.id.password_login);
        Button next = (Button)findViewById(R.id.next_login);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HelloActivity.class);
                startActivity(intent);
            }
        });

    }
}
