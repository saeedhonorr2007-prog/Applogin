package com.example.calculator; // نام پکیج را مطابق پروژه خودت تغییر بده

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String USERNAME = "mobile";
    private static final String PASSWORD = "1234";

    private EditText etUsername, etPassword;
    private TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        tvError = findViewById(R.id.tvError);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String user = etUsername.getText().toString().trim();
        String pass = etPassword.getText().toString();

        if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
            tvError.setVisibility(View.GONE);

            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            intent.putExtra("username", user);
            startActivity(intent);
            finish(); // با دکمه برگشت به صفحه لاگین برنگردد
        } else {
            tvError.setVisibility(View.VISIBLE);
        }
    }
}
