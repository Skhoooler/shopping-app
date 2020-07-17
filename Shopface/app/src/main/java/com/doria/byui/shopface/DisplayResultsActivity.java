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

public class DisplayResultsActivity extends AppCompatActivity implements RecyclerViewAdapter.OnNoteListener {
    ArrayList<Product> products;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);
        super.onPause();

        products = (ArrayList<Product>) getIntent().getSerializableExtra("data");

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, products, this);

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

    @Override
    public void onNoteClick(int position) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(products.get(position).getLink()));
        startActivity(browserIntent);
    }


    // Copy Pasted from MainActivity with a few modifications
    public void onClickSearch(View view) throws InterruptedException {
        EditText searchBox = (EditText)findViewById(R.id.editText);
        final String query = searchBox.getText().toString();
        Intent intent = new Intent(getBaseContext(), SearchActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }


}
