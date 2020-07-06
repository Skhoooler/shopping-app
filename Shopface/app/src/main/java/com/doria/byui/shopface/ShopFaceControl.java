package com.doria.byui.shopface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShopFaceControl {

    public String query;
    private HashMap<Integer, Product> sortedProducts;


    ShopFaceControl(String incomingQuery, ArrayList<HashMap<Integer, Product>> productMaps){
        query = incomingQuery;

        sort(productMaps);
    }

    /**
     * Sorts the raw data that comes from the ShopFaceModel Class into a second
     * map that contains the best results from the search.
     */
    private void sort(ArrayList<HashMap<Integer, Product>> productMaps){
        /*
        Figured the best way to sort through the maps of products is to start at one Standard
        Deviation before the Average of all the prices, so I made a ShopfaceStatistics class to
        facilitate that. Didn't get around to testing it yet though
         */
        ShopFaceStatistics stats = new ShopFaceStatistics();
        for (int i = 0; i < productMaps.size(); i++){
            for (int j = 0; j < productMaps.get(i).size(); i++){
                stats.addData(productMaps.get(i).get(j).getPrice());
                System.out.println(productMaps.get(i).get(j).getPrice());
            }
        }
        System.out.println("Average: " + stats.getAverage());
        System.out.println("St Dev: " + stats.getStandardDeviation());
    }

    /**
     * This method gets the data from the search
     * @return a map with the data that resulted from the search query
     */
    public Map<String, Product> getData(){


        return null;
    }

  /*  /**
     * Overload of the default getData() method. This method returns the product at a
     * specific key
     * @param //key The key to access a specific product inside the map
     * @return returns a single product from the data map
     *
    public Product getSortedData(){
        Product searchedProduct = sortedData.get(index);

        return searchedProduct;
        return null
    }

    /**
     * Gets the raw data from the ShopFaceModel class
     *
    private void getModelData(){
        ShopFaceModel shopFaceModel = new ShopFaceModel(query);
        rawData = shopFaceModel.getMapData(query);
    }
*/
}
