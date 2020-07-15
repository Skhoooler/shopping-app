package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DisplayProductActivity extends AppCompatActivity {
    ArrayList<Product> sortedData;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);
        super.onPause();
    }

    public void display(){

    }
    void onClickSearch(View view){

    }
    void onClickBack(View view){

    }
}
