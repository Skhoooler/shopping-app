package com.doria.byui.shopface;

import android.view.View;

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
    void nextPage(int index){
        //calls sort.getData
    }
}
