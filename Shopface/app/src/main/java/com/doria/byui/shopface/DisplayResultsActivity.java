package com.doria.byui.shopface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.URI;
import java.util.ArrayList;

public class DisplayResultsActivity extends AppCompatActivity {
    ArrayList<Product> products;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);
        super.onPause();

        products = (ArrayList<Product>) getIntent().getSerializableExtra("data");

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, products);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);

        //displayProducts();
    }

    public void displayProducts(){

        /* int i = 0;
        Context context = getApplicationContext();
        ImageView imageview1 = new ImageView(context);
        imageview1.setImageDrawable(products.get(i).getImage());
        ImageView img= (ImageView) findViewById(R.id.image);
        img.setImageResource(R.drawable.imageview1);
    */
    }

    public void onClickProduct(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(products.get(recyclerView.getChildLayoutPosition(view)).getLink()));
        System.out.println("Product has been Clicked");
        startActivity(browserIntent);
    }

    // Copy Pasted from MainActivity with a few modifications
    public void onClickSearch(View view) throws InterruptedException {
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
}
