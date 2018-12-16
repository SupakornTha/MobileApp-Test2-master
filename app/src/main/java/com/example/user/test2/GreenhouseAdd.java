package com.example.user.test2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class GreenhouseAdd extends Activity implements View.OnClickListener {


    private Button btnOk;
    private Button btnCancle;
    private TextView NameView;
    private TextView NoZone;

    public DatabaseReference myRef;
    public FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greenhouse_add);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        btnOk = (Button)findViewById(R.id.btnOk);
        btnCancle = (Button)findViewById(R.id.btnCancle);
        NameView = (TextView)findViewById(R.id.NameView);
        NoZone = (TextView)findViewById(R.id.NoZone);

        btnOk.setOnClickListener(this);
        btnCancle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnOk){


//            Intent returnIntent = new Intent();
//            String Name = NameView.getText().toString().trim();
//            String Zone = noView.getText().toString().trim();
//            returnIntent.putExtra("Name",Name);
//            returnIntent.putExtra("Zone",Zone);
//            setResult(Activity.RESULT_OK,returnIntent);
//            finish();


            Intent returnIntent = new Intent();
            String Name = NameView.getText().toString().trim();
            String Zone = NoZone.getText().toString().trim();
            myRef = FirebaseDatabase.getInstance().getReference();
            db = FirebaseDatabase.getInstance();
            myRef.child("GreenhouseList").child("Name").setValue(Name);
            myRef.child("GreenhouseList").child("Zone").setValue(Zone);
            setResult(Activity.RESULT_OK,returnIntent);
            finish();

        }
        if (v == btnCancle){
            finish();
        }
    }
}