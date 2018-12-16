package com.example.user.test2;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Lack extends Activity {

    private RecyclerView recyclerView;
    private List<GreenhouseCard> items;
    private CardAdapter adapter;

    private TextView phValue;
    private TextView ECValue;
    private TextView ZoneInGH;
    private TextView Lackname;
    private TextView DayValue;
    private TextView QuantityValue;
    private TextView StatusValue;

    public DatabaseReference testapp;

    private Button btnAdd;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if(resultCode == Activity.RESULT_OK){

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //none
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lack);

        phValue = (TextView) findViewById(R.id.phValue);
        ECValue = (TextView) findViewById(R.id.ECValue);
        ZoneInGH = (TextView) findViewById(R.id.ZoneInGH);
        Lackname = (TextView) findViewById(R.id.Lackname);
        DayValue = (TextView) findViewById(R.id.DayValue);
        QuantityValue = (TextView) findViewById(R.id.QuantityValue);
        StatusValue = (TextView) findViewById(R.id.StatusValue);

        btnAdd = (Button) findViewById(R.id.btnAdd);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        testapp = database.getReference("Greenhouse1");
        testapp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map1 = (Map) dataSnapshot.child("Zone1").getValue();
                Map map2 = (Map) dataSnapshot.child("Zone1").child("lack1").getValue();

                String ph = String.valueOf(map2.get("PH"));
                String ec = String.valueOf(map2.get("EC"));
                String zone = String.valueOf(map1.get("Zone"));
                String lack = String.valueOf(map1.get("lack"));
                String day = String.valueOf(map1.get("day"));
                String quan = String.valueOf(map1.get("quan"));
                String status = String.valueOf(map1.get("status"));

                phValue.setText(ph);
                ECValue.setText(ec);
                ZoneInGH.setText(zone);
                Lackname.setText(lack);
                DayValue.setText(day);
                QuantityValue.setText(quan);
                StatusValue.setText(status);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
