package com.android.loginadroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText userName = (EditText) findViewById(R.id.username_login);
        final EditText password = (EditText) findViewById(R.id.password_login);
        Button next = (Button) findViewById(R.id.next_login);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> usrs = new UserRepo().getAllUser(LoginActivity.this);

                for (int i = 0; i < usrs.size(); i++) {

                    if (userName.getText().toString().equals(usrs.get(i).getName())) { // 匹配到了用户。
                        if (password.getText().toString().equals(usrs.get(i).getPass())) {
                            Intent intent = new Intent(LoginActivity.this, HelloActivity.class);
                            intent.putExtra("UserName", userName.getText().toString());
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                        }

                        return;
                    }
                }

                Toast.makeText(LoginActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
