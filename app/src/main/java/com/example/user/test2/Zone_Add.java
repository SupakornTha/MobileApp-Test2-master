package com.example.user.test2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Zone_Add extends Activity implements View.OnClickListener {

    private Button btnOk;
    private Button btnCancle;
    private Spinner spinner;

    private ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone__add);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        btnOk = (Button)findViewById(R.id.btnOk);
        btnCancle = (Button)findViewById(R.id.btnCancle);
        spinner = (Spinner) findViewById(R.id.spinner);

        btnOk.setOnClickListener(this);
        btnCancle.setOnClickListener(this);

        spinner();
    }

    private void spinner() {
        data.add("Green Oak");
        data.add("Lettuce");
        data.add("Red Lectture");
        data.add("Red Oak");
    }

    @Override
    public void onClick(View v) {
        if (v == btnOk){
            finish();
        }
    }
}
