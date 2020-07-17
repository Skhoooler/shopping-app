package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        query = (String) getIntent().getSerializableExtra("query");
        try {
            Search();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void Search() throws InterruptedException {

        final ArrayList[] amazonProducts = new ArrayList[]{new ArrayList<>()};
        Thread amazonConnectThread = new Thread(new Runnable() {
            @Override
            public void run(){
                amazonProducts[0] = new AmazonConnect().search(query);
            }
        });

        final ArrayList[] ebayProducts = new ArrayList[]{new ArrayList<>()};
        Thread ebayConnectThread = new Thread(new Runnable() {
            @Override
            public void run(){
                ebayProducts[0] = new EbayConnect().search(query);
            }
        });

        amazonConnectThread.start();
        ebayConnectThread.start();

        amazonConnectThread.join();
        ebayConnectThread.join();

        Thread processProductsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<Product> allProducts = new ArrayList<>();
                allProducts.addAll(ebayProducts[0]);
                allProducts.addAll(amazonProducts[0]);

                ArrayList<Product> sortedProducts = new ShopFaceControl(allProducts).sort(allProducts);

                Intent intent = new Intent(getBaseContext(), DisplayResultsActivity.class);
                intent.putExtra("data", sortedProducts);
                startActivity(intent);
            }});

        processProductsThread.start();

    }
}
