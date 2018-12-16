package com.example.user.test2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Lack_Add extends Activity implements View.OnClickListener {

    private Button btnok;
    private Button btnCancle;

    private TextView LackName;
    private TextView Quantityplan;
    private TextView KeyLack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lack__add);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        btnok = (Button)findViewById(R.id.btnok);
        btnCancle = (Button)findViewById(R.id.btnCancle);

        LackName = (TextView)findViewById(R.id.textViewLack);
        Quantityplan = (TextView)findViewById(R.id.textViewZone);
        KeyLack = (TextView)findViewById(R.id.KeyLack);

        btnok.setOnClickListener(this);
        btnCancle.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnok){
            Intent returnIntent = new Intent();
            String Name = LackName.getText().toString().trim();
            String quan = Quantityplan.getText().toString().trim();
            String key = KeyLack.getText().toString().trim();
            setResult(Activity.RESULT_OK,returnIntent);
            finish();

        }
        if (v == btnCancle){
            finish();
        }
    }
}
