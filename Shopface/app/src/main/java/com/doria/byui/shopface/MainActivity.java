package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String queryKey = "key";
    public static final String queryStore = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//when created what needs to be done?
        //sharedPreferences = getSharedPreferences(queryStore, Context.MODE_PRIVATE);
        super.onPause();//when paused what needs to be done?
        //super.onStop(DeleteOnStop());
        //get(null);
    }


    public void SearchOnClick(View view) throws InterruptedException {
        EditText searchBox = (EditText)findViewById(R.id.editText);
        final String query = searchBox.getText().toString();
        Intent intent = new Intent(getBaseContext(), SearchActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);

    }

    public void DeleteOnStop(){

    }
}