package com.example.user.test2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class GreenhouseActivity extends Activity {

    private RecyclerView recyclerView;
    private List<GreenhouseCard> items;
    private CardAdapter adapter;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    private Button btnAdd;
    private Button press;

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 10) {
//            if(resultCode == Activity.RESULT_OK){
//
//            }
//            if (resultCode == Activity.RESULT_CANCELED) {
//                //none
//            }
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greenhouse);

//        database = FirebaseDatabase.getInstance();
//        reference = database.getReference("GreenhouseList");

//        System.out.println(reference);

        items = new ArrayList<>();

//        System.out.println(items);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(llm);

        items.add(new GreenhouseCard("A", "1"));

//        createResult();

        adapter = new CardAdapter(items);
        recyclerView.setAdapter(adapter);

//        updateList();

        btnAdd = (Button) findViewById(R.id.btnAdd);
        press = (Button) findViewById(R.id.press);

        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == press) {
                    finish();
                    startActivity(new Intent(GreenhouseActivity.this, Zone.class));
                }
            }
        });

        final Intent i = new Intent(this, GreenhouseAdd.class);

//        Intent j = new Intent(GreenhouseActivity.this, GreenhouseCard.class);
//        String keyIdentifer  = "Greenhouse";
//        j.putExtra("page", keyIdentifer );

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == btnAdd) {
                    startActivityForResult(i, 10);
                }
            }
        });
    }
}
//    @Override
//        public boolean onContextItemSelected(MenuItem item) {
//
//            switch (item.getItemId()){
//                case 0:
//                    break;
//                case 1:
//                    break;
//
//            }
//            return super.onContextItemSelected(item);
//    }

//    private void createResult() {
//        for (int i = 0; i < 1; i++) {
//            items.add(new GreenhouseCard("A", "1"));
//        }
//    }

//    @Override
//    public void onClick(View v) {
//        if (v == press){
//            finish();
//            startActivity(new Intent(this, Zone.class));
//        }
//    }

//    private void updateList(){
//        reference.addChildEventListener(new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                items.add(dataSnapshot.getValue(GreenhouseCard.class));
//                adapter.notifyDataSetChanged();
//            }

//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                GreenhouseCard card = dataSnapshot.getValue(GreenhouseCard.class);
//
//                int index = getItemIndex(card);
//
//                items.set(index, card);
//                adapter.notifyItemChanged(index);
//
//            }

//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                GreenhouseCard card = dataSnapshot.getValue(GreenhouseCard.class);
//
//                int index = getItemIndex(card);
//
//                items.remove(index);
//                adapter.notifyItemRemoved(index);
//            }

//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }

//    private int getItemIndex(GreenhouseCard product){
//        int index = -1;
//        for (int i=0;i<items.size();i++){
//            if (items.get(i).key.equals(product.key)){
//                index = i;
//                break;
//            }
//        }
//        return index;
//    }
