package com.doria.byui.shopface;

import java.util.Map;

public class ShopFaceControl {

    private Map<String, Product> rawData;
    private Map<Integer, Product> sortedData;
    private Integer index;
    public String query;


    ShopFaceControl(String query){

    }

    /**
     * Sorts the raw data that comes from the ShopFaceModel Class into a second
     * map that contains the best results from the search.
     */
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
     * @param //key The key to access a specific product inside the map
     * @return returns a single product from the data map
     */
    public Product getSortedData(){
        Product searchedProduct = sortedData.get(index);

        return searchedProduct;
    }

    /**
     * Gets the raw data from the ShopFaceModel class
     */
    private void getModelData(){
        ShopFaceModel shopFaceModel = new ShopFaceModel(query);
        rawData = shopFaceModel.getMapData(query);
    }

}
