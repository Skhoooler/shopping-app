package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    void onClickSearch(View view) throws InterruptedException {
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

        Thread processProductsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Product> allProducts = new ArrayList<>();
                allProducts.addAll(ebayProducts[0]);
                //allProducts.addAll(amazonProducts[0]);

                ArrayList<Product> sortedProducts = new ShopFaceControl(allProducts).sort(allProducts);
                products = new ShopFaceView(sortedProducts).imageDecode();

                Intent intent = new Intent(getBaseContext(), DisplayResultsActivity.class);
                intent.putExtra("data", products);
                startActivity(intent);
            }});

        processProductsThread.start();
    }
    void onClickBack(View view){

    }
    void onClickProduct(View view){

    }
}
