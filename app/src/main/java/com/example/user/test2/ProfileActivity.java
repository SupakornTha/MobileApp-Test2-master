package com.example.user.test2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends Activity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private TextView textViewUserEmail;
    private Button buttonLogout;
    private Button btnGreenhouse;
    private Button btnAppoinments;
    private Button btnReportNPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        btnGreenhouse = (Button) findViewById(R.id.btnGreenhouse);
        btnAppoinments = (Button) findViewById(R.id.btnAppoinments);
        btnReportNPlan = (Button) findViewById(R.id.btnReportNPlan);

        buttonLogout.setOnClickListener(this);
        btnGreenhouse.setOnClickListener(this);
        btnAppoinments.setOnClickListener(this);
        btnReportNPlan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        if (view == btnGreenhouse){
            startActivity(new Intent(this, GreenhouseActivity.class));
        }
        if (view == btnAppoinments){
            startActivity(new Intent(this, AppoinmentActivity.class));
        }
        if (view == btnReportNPlan){
            startActivity(new Intent(this, ReportAndPlanActivity.class));
        }
    }
}
