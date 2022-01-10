package com.udinus.UAS43UG_12811_10727_12420_12212;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    TextView log;
    EditText inputEmail, pass1, pass2;
    String email, password1, password2;
    Button btnDaftar;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        log = findViewById(R.id.btnLogin);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        inputEmail = findViewById(R.id.username);
        pass1 = findViewById(R.id.pass1);
        pass2 = findViewById(R.id.pass2);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrasi();

            }
        });
    }

    public void registrasi() {
        email = inputEmail.getText().toString();
        password1 = pass1.getText().toString();
        password2 = pass2.getText().toString();
        if (TextUtils.isEmpty(inputEmail.getText().toString().trim())
            || TextUtils.isEmpty(pass1.getText().toString().trim())
            || (TextUtils.isEmpty(pass2.getText().toString().trim())))
        {
            Toast.makeText(RegisterActivity.this,"Field tidak boleh kosong!",Toast.LENGTH_LONG).show();
        }
        else{
            if (!validpassword()) {
                                Toast.makeText(RegisterActivity.this, "Panjang Password maksimal 15 karakter", Toast.LENGTH_LONG).show();
            } else {
                if (!samepassword())
                {
                    Toast.makeText(RegisterActivity.this, "Password tidak sama!", Toast.LENGTH_LONG).show();
                }
                else
                    {
                        mAuth.createUserWithEmailAndPassword(email,password2)
                                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            Toast.makeText(RegisterActivity.this, "Registrasi sukses", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(getApplicationContext(), activity_register_success.class));
                                            finish();
                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Toast.makeText(RegisterActivity.this, "Registrasi gagal, coba cek e-mail atau password anda", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                    }
            }
        }
    }

    public boolean samepassword() {
        boolean temp = true;
        String pass = pass1.getText().toString();
        String cpass = pass2.getText().toString();
        if (!pass.equals(cpass)) {
            temp = false;
        }
        return temp;
    }
    public boolean validpassword(){
        boolean temp=true;
        String pass = pass1.getText().toString();
        if(pass.length() > 15){
            temp=false;
        }
        return temp;
    }
}
