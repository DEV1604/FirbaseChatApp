package com.example.this_pc.mychatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.this_pc.mywhatsapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart(){
        super.onStart();
        // to check if user is signed in or not

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser==null){
            Intent startIntent = new Intent(MainActivity.this, StartActivity.class);
            startActivity(startIntent);
            finish();
        }

    }


}
