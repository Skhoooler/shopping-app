package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//when created what needs to be done?

        super.onPause();//when paused what needs to be done?
    }

    void uiThread(){
        //uiThread functions
    }

    void onClick(View view){
        //search button
    }
}