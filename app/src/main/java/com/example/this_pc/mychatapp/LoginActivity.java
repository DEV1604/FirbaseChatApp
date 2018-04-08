package com.example.this_pc.mychatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.this_pc.mywhatsapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout mloginemail;
    private TextInputLayout mloginpassword;

    private Button mloginbtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        mloginemail=(TextInputLayout)findViewById(R.id.loginemail);
        mloginpassword=(TextInputLayout)findViewById(R.id.loginpassword);
        mloginbtn=(Button)findViewById(R.id.loginbtn);
        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mloginemail.getEditText().getText().toString();
                String password=mloginpassword.getEditText().getText().toString();

                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password))
                {
                    Toast.makeText(LoginActivity.this," Email or Passward can not be Empty ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    loginuser(email,password);

                }
            }
        });


    }

    private void loginuser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
                else
                {
                    Log.d("Test",task.getException().getMessage());
                    Toast.makeText(LoginActivity.this,"You got some error.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
