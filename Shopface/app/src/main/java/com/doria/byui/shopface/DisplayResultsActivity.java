package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class DisplayResultsActivity extends AppCompatActivity {
    ArrayList<Product> products;

    public ShopFaceView displayProducts(String query){
        ShopFaceView view1 = null;
        return view1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        products = (ArrayList<Product>) getIntent().getSerializableExtra("data");
        setContentView(R.layout.activity_display_results);
        super.onPause();
    }
    void onClickSearch(View view){

    }
    void onClickBack(View view){

    }
    void onClickProduct(View view){

    }
}
