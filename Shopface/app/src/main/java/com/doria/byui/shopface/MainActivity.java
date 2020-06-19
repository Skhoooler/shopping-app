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

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String queryKey = "key";
    public static final String queryStore = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//when created what needs to be done?
        sharedPreferences = getSharedPreferences(queryStore, Context.MODE_PRIVATE);
        super.onPause();//when paused what needs to be done?
        super.onStop(DeleteOnStop());
        //get(null);
    }

    void uiThread(){
        //uiThread functions
    }

    public void SearchOnClick(View view){
        EditText searchBox = (EditText)findViewById(R.id.editText);
        String query = searchBox.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(queryKey, query);
        editor.commit();
        System.out.println(sharedPreferences.getString(queryKey, ""));
        Search search = new Search(query);
    }
    public  void DeleteOnStop(){

    }
}