package com.example.user.test2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Report1 extends AppCompatActivity implements View.OnClickListener{

    private Button btnMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);
    }

    @Override
    public void onClick(View view) {
        if (view == btnMemo){

        }
    }
}
