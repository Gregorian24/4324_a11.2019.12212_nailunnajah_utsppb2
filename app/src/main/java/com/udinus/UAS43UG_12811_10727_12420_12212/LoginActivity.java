package com.udinus.UAS43UG_12811_10727_12420_12212;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button reg, btnLogin;
    EditText inputEmail, inputPassword;
    TextView forgot;
    String email,password;
    public CheckBox chkKeepLogin;

    private FirebaseAuth mAuth;

    private SharedPreferences share_pref;

    private static final String KEEP_LOGIN_KEY = "key_keep_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        inputEmail = findViewById(R.id.username);
        inputPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekLogin();

                }
        });
        reg = findViewById(R.id.btnRegister);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        forgot = findViewById(R.id.forgotpassword);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ActivityForgotPassword.class));
                finish();
            }
        });

        //Initiate SharedPreferences
        this.share_pref = this.getSharedPreferences("dtsapp_share_prefs", Context.MODE_PRIVATE);

        this.initComponents();

        this.autoLogin();
    }
    private void initComponents()
    {
        // Init components
        this.inputEmail = this.findViewById(R.id.username);
        this.inputPassword = this.findViewById(R.id.password);
        this.chkKeepLogin = this.findViewById(R.id.chk_remember);
    }


    private void cekLogin() {
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();
        if(TextUtils.isEmpty(inputEmail.getText().toString().trim())
        || TextUtils.isEmpty(inputPassword.getText().toString().trim()))
        {
            Toast.makeText(LoginActivity.this,"Field tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        else
        {
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(LoginActivity.this,"Login sukses", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(), activity_login_success.class));
                                makeAutoLogin();
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LoginActivity.this, "Login gagal email/ password anda salah", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    private void makeAutoLogin()
    {
        // Mengatur agar selanjutnya pada saat aplikasi dibuka menjadi otomatis login
        SharedPreferences.Editor editor = this.share_pref.edit();

        if(this.chkKeepLogin.isChecked())
            editor.putBoolean(KEEP_LOGIN_KEY, true);
        else
        {
            editor.remove(KEEP_LOGIN_KEY);
        }
        editor.apply();
    }

    private void autoLogin()
    {
        // Cek apakah sebelumnya aplikasi diatur agar bypass login?
        // Jika ya maka langsung buka activity berikutnya
        boolean keepLogin = this.share_pref.getBoolean(KEEP_LOGIN_KEY, false);
        if (keepLogin)
        {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }
    }
}