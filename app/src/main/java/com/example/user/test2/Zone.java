package com.example.user.test2;

import android.app.Activity;
import android.content.Intent;
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

public class Zone extends Activity {

    private Button btnAdd;
    private Button press;

    private RecyclerView recyclerView;
    private ZoneAdapter adapter;

    List<CardZone> productList;


    private TextView greenhouseName;
    private TextView tempValue;
    private TextView temcontrolState;
    private TextView textViewZone;
    private TextView textViewLack;

    public DatabaseReference testapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);

//        productList = new ArrayList<>();
//
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(llm);
//
//        productList.add(new CardZone("1", "1"));
//
//        adapter = new ZoneAdapter(productList);
//        recyclerView.setAdapter(adapter);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        press = (Button) findViewById(R.id.press);

        greenhouseName = (TextView) findViewById(R.id.greenhouseName);
        tempValue = (TextView) findViewById(R.id.tempValue);
        temcontrolState = (TextView) findViewById(R.id.temcontrolState);
        textViewZone = (TextView) findViewById(R.id.textViewZone);
        textViewLack = (TextView) findViewById(R.id.textViewLack);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        testapp = database.getReference("Greenhouse1");
        testapp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map map = (Map) dataSnapshot.getValue();
                Map map1 = (Map) dataSnapshot.child("Zone1").getValue();
                String name = String.valueOf(map.get("Name"));
                String temp = String.valueOf(map.get("temp"));
                String pump = String.valueOf(map.get("pump"));
                String zone = String.valueOf(map1.get("Zone"));
                String lack = String.valueOf(map1.get("lack"));


                greenhouseName.setText(name);
                tempValue.setText(temp);
                temcontrolState.setText(pump);
                textViewZone.setText(zone);
                textViewLack.setText(lack);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == press) {
                    finish();
                    startActivity(new Intent(Zone.this, Lack.class));
                }
                if (v == btnAdd){
                    System.out.println("Hello");
                    final Intent j = new Intent(Zone.this, Zone_Add.class);
                    startActivityForResult(j,1);
                }
            }
        });
    }
}
