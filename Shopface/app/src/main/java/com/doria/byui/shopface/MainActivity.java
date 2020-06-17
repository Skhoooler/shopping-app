package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//when created what needs to be done?

        super.onPause();//when paused what needs to be done?

    }

    void uiThread(){
        //uiThread functions
    }

    public void SearchOnClick(View view){
        EditText searchBox = (EditText)findViewById(R.id.editText);
        String query = searchBox.getText().toString();
        sharedPreferences = getSharedPreferences(query, Context.MODE_PRIVATE);
        System.out.println(sharedPreferences.getString(query, ""));
        Search search = new Search(query);
    }
}