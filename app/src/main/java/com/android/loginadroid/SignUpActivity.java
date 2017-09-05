package com.android.loginadroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText userName = (EditText) findViewById(R.id.userName);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText password1 = (EditText) findViewById(R.id.password1);
        Button next = (Button) findViewById(R.id.next);

        final User user = new User();
        final UserRepo userRepo = new UserRepo();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password2 = password.getText().toString();
                String password3 = password1.getText().toString();

                if (!password2.equals(password3)) {
                    Toast.makeText(SignUpActivity.this, "输入密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                } else {
                    user.setName(userName.getText().toString());
                    user.setPass(password2);

                    if (userRepo.isUserExists(SignUpActivity.this, user.getName())) {
                        Toast.makeText(SignUpActivity.this, "用户名已存在", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (!userRepo.saveUser(SignUpActivity.this, user)) {
                        Toast.makeText(SignUpActivity.this, "数据库操作错误", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(SignUpActivity.this, HelloActivity.class);
                        intent.putExtra("UserName", user.getName());
                        startActivity(intent);
                    }


                }
            }
        });


    }
}
