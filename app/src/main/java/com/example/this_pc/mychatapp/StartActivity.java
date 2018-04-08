package com.example.this_pc.mychatapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.this_pc.mywhatsapp.R;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mregbtn;
    private Button mlogbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mregbtn=findViewById(R.id.startregbutton);
        mlogbtn=findViewById(R.id.startloginbutton);

        mregbtn.setOnClickListener(this);
        mlogbtn.setOnClickListener(this);


    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mregbtn:
                        Intent regIntent = new Intent(StartActivity.this,RegisterActivity.class);
                        startActivity(regIntent);
                        break;
            case R.id.mlogbtn:
                        Intent LogIntent = new Intent(StartActivity.this,LoginActivity.class);
                        startActivity(LogIntent);
                        break;
        }

    }
}
