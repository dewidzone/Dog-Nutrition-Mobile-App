package com.example.dog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etUser, etPwd, etRepwd;
    Button btnRegister, btnGoToLogin;
    DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUser = findViewById(R.id.etUsername);
        etPwd = findViewById(R.id.etPassword);
        etRepwd = findViewById(R.id.etRePassword);
        btnRegister = findViewById(R.id.btnRegister);
        dbHelper = new DBHelper(this);
        btnGoToLogin = findViewById(R.id.btnLogin);
        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

                                            }
                                        });
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user, pwd, rePwd;
                user = etUser.getText().toString();
                pwd = etPwd.getText().toString();
                rePwd = etRepwd.getText().toString();
                if (user.equals("") || pwd.equals("") || rePwd.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Please fill all the fields.", Toast.LENGTH_SHORT).show();
                } else {
                    if(pwd.equals(rePwd)) {
                        if(dbHelper.checkUsername(user)) {
                            Toast.makeText(RegisterActivity.this, "User Already Exists.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        //Proceed with registration
                       boolean registeredSuccess = dbHelper.insertData(user, pwd);
                       if(registeredSuccess)
                           Toast.makeText(RegisterActivity.this, "User Registered Successfully.", Toast.LENGTH_SHORT).show();
                       else
                           Toast.makeText(RegisterActivity.this, "User Registration Failed.", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(RegisterActivity.this, "Passwords Do not match.", Toast.LENGTH_SHORT).show();

                    }


                }
            }
        });

        }

}