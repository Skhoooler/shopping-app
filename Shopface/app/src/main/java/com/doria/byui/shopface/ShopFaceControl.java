package com.doria.byui.shopface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ShopFaceControl {

    public String query;
    private HashMap<Integer, Product> sortedProducts = new HashMap<>();


    ShopFaceControl(String incomingQuery, HashMap<Integer, Product> allProducts){
        query = incomingQuery;

        sort(allProducts);
    }

    /**
     * Sorts the raw data that comes from the ShopFaceModel Class into a second
     * map that contains the best results from the search.
     */
    private void sort(HashMap<Integer, Product> allProducts){
        /*
        Figured the best way to sort through the maps of products is to start at one Standard
        Deviation before the Average of all the prices, so I made a ShopfaceStatistics class to
        facilitate that. Didn't get around to testing it yet though
         */

        // The next loop populates the data for ShopfaceStatistics
        ShopFaceStatistics stats = new ShopFaceStatistics();
        for (int i = 0; i < productMaps.size(); i++){
            for (int j = 0; j < productMaps.get(i).size(); j++){
                stats.addData(productMaps.get(i).get(j).getPrice());
                System.out.println("Price: " + productMaps.get(i).get(j).getPrice());
            }
        }

        // These next for loops select the best 10 items from all of the stores, based on the
  /*      // standard deviation from the average
        for (int i = 0; i < 10; i++){
            Product product = new Product();



            sortedProducts.put(i, product);
        }
*/
        System.out.println("Median: " + stats.getMedian());
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
