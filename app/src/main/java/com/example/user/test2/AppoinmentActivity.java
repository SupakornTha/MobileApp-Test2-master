package com.example.user.test2;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;


public class AppoinmentActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinmrnts);

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkBox6);

        boolean checked = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("checkBox", false);

        checkBox.setChecked(checked);
        checkBox2.setChecked(checked);
        checkBox3.setChecked(checked);
        checkBox4.setChecked(checked);
        checkBox5.setChecked(checked);
        checkBox6.setChecked(checked);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkBox:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("checkBox", checked).apply();
            case R.id.checkBox2:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("checkBox2", checked).apply();
            case R.id.checkBox3:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("checkBox3", checked).apply();
            case R.id.checkBox4:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("checkBox4", checked).apply();
            case R.id.checkBox5:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("checkBox5", checked).apply();
            case R.id.checkBox6:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("checkBox6", checked).apply();
                break;
        }
    }
}
