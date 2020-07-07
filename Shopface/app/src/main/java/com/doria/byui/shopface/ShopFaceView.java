package com.doria.byui.shopface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ShopFaceView {
    private ShopFaceControl sort;

    public Map<String, Product> getSortedData() {
        return sortedData;
    }

    public void setSortedData(Map<String, Product> sortedData) {
        this.sortedData = sortedData;
    }

    private Map<String, Product> sortedData;

    public ShopFaceView(String query){

    }
    void display(){

    }
    Bitmap imageDecode(){
        for (Integer i = 0; i < sortedData.size(); i++){
            if (sortedData.(i).image)
            String url = sortedData.(i).image;
            Bitmap drawable_from_url(String url) throws java.net.MalformedURLException, java.io.IOException
            {

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

                return BitmapFactory.decodeStream(input);
            }
        }
    }
    void nextPage(int index){
        //calls sort.getData
    }
}
