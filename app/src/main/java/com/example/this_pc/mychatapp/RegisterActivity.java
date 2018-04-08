package com.example.this_pc.mychatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.this_pc.mywhatsapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mName;
    private TextInputLayout mEmail;
    private TextInputLayout mPassword;
    private Button mCreateBtn;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        mName = (TextInputLayout)findViewById(R.id.regName);
        mEmail= (TextInputLayout)findViewById(R.id.regEmail);
        mPassword  = (TextInputLayout)findViewById(R.id.regPassword);
        mCreateBtn = (Button) findViewById(R.id.regCreateBtn);
        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = mName.getEditText().getText().toString();
                String Email=mEmail.getEditText().getText().toString();
                String Password=mPassword.getEditText().getText().toString();

                register_user(Name,Email,Password);

            }
        });
    }

    private void register_user(String Name, String Email, String Password) {                             //TRY TO USE NAME

        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    Intent mainIntent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }

                else{
                    Log.d("Test",task.getException().getMessage());
                    Toast.makeText(RegisterActivity.this,"You got some error.", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
