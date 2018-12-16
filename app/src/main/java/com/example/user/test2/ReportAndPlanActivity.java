package com.example.user.test2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReportAndPlanActivity extends Activity implements View.OnClickListener{

    private Button btnReport;
    private Button btnPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_and_plan);

        btnPlan = (Button) findViewById(R.id.btnPlan);
        btnReport = (Button) findViewById(R.id.btnReport);

        btnReport.setOnClickListener(this);
        btnPlan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnPlan){
            startActivity(new Intent(this, GreenhouseActivity.class));
        }
        if (view == btnReport){
            startActivity(new Intent(this, GreenhouseActivity.class));
        }
    }
}
