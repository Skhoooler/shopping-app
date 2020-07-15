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
    public ShopFaceView displayProducts(ArrayList<Product> sortedProducts){
        sortedData = sortedProducts;
        int i = 0;
        Context context = getApplicationContext();
        ImageView my_image = new ImageView(context);
        my_image.setImageDrawable(sortedProducts.get(i).getImage());
        ImageView img= (ImageView) findViewById(R.id.image);
        img.setImageResource(R.drawable.imageview1);
        return view1;
    }

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
