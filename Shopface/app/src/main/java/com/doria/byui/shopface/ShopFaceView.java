package com.doria.byui.shopface;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


// Sorry, I needed to test some stuff
public class ShopFaceView {
    private ShopFaceControl sort;



    private ArrayList<Product> sortedData;


    public ShopFaceView(ArrayList<Product> sortedProducts, String query){
        sortedData = sortedProducts;
        imageDecode();
    }

    public void imageDecode(){
        String url = "";
        for (Integer i = 0; i < sortedData.size(); i++){
            if (!sortedData.get(i).getPic().isEmpty())
             url = sortedData.get(i).getPic();
            Bitmap drawable_from_url;


                HttpURLConnection connection = null;
                try {
                    connection = (HttpURLConnection) new URL(url).openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                connection.setRequestProperty("User-agent", "Mozilla/4.0");

                try {
                    connection.connect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                InputStream input = null;
                try {
                    input = connection.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                drawable_from_url = BitmapFactory.decodeStream(input);

                sortedData.get(i).setImage(new BitmapDrawable(Resources.getSystem(),drawable_from_url));

        }
    }
}
