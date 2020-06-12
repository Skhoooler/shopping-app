package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class DisplayProductActivity extends AppCompatActivity {
    public ShopFaceView displayProducts(String query);

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
