package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.jar.Attributes;

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

    void uiThread(){
        //uiThread functions
    }

    public void SearchOnClick(View view) throws InterruptedException {
        EditText searchBox = (EditText)findViewById(R.id.editText);
        final String query = searchBox.getText().toString();

        final ArrayList[] amazonProducts = new ArrayList[]{new ArrayList<>()};
        Thread amazonConnectThread = new Thread(new Runnable() {
            @Override
            public void run(){
                //amazonProducts[0] = new AmazonConnect().search(query);
            }
        });

        final ArrayList[] ebayProducts = new ArrayList[]{new ArrayList<>()};
        Thread ebayConnectThread = new Thread(new Runnable() {
            @Override
            public void run(){
                ebayProducts[0] = new EbayConnect().search(query);
            }
        });

       // amazonConnectThread.start();
        ebayConnectThread.start();

        //amazonConnectThread.join();
        ebayConnectThread.join();

        ArrayList<Product> allProducts = new ArrayList<>();
        allProducts.addAll(ebayProducts[0]);
        //allProducts.addAll(amazonProducts[0]);

        ArrayList<Product> sortedProducts = new ShopFaceControl(allProducts).sort(allProducts);
        ArrayList<Product> processedProducts = new ShopFaceView(sortedProducts).imageDecode();


        Intent intent = new Intent(this, DisplayResultsActivity.class);
        intent.putExtra("data", processedProducts);
        startActivity(intent);
    }

    public void DeleteOnStop(){

    }
}