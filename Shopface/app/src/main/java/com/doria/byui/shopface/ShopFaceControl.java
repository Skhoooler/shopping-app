package com.doria.byui.shopface;

import java.util.Map;

public class ShopFaceControl {

    private Map<String, Product> data;
    private int index;


    ShopFaceControl(String query){

    }

    private void sort(){

    }

    /**
     * This method gets the data from the search
     * @return a map with the data that resulted from the search query
     */
    public Map<String, Product> getData(){

        return null;
    }

    /**
     * Overload of the default getData() method. This method returns the product at a
     * specific key
     * @param key The key to access a specific product inside the map
     * @return returns a single product from the data map
     */
    public Product getData(String key){

        return null;
    }

    /**
     * Gets the raw data from the ShopFaceModel class
     */
    private void getModelData(){

    }

}
