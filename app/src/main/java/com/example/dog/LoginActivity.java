package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DBHelper dbHelper;
    Button btnLogin;
    EditText etUsername, etPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DBHelper(this);
        etUsername = findViewById(R.id.etUsername);
        etPwd = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isLoggedId = dbHelper.checkUser(etUsername.getText().toString(), etPwd.getText().toString());
                if (isLoggedId) {
                    Intent intent = new Intent(LoginActivity.this, SelectionActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "User Login Successfully.", Toast.LENGTH_SHORT).show();
                }else

                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

            }
        });


    }
}