package com.doria.byui.shopface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

class ShopFaceControl {

    public String query;
    private HashMap<Integer, Product> sortedProducts = new HashMap<>();
    private DescriptiveStatistics stats = new DescriptiveStatistics();


    ShopFaceControl(String incomingQuery, ArrayList<Product> allProducts) {
        query = incomingQuery;

        sort(allProducts);
    }

    /**
     * Sorts the raw data that comes from the ShopFaceModel Class into a second
     * map that contains the best results from the search.
     */
    private void sort(ArrayList<Product> allProducts) {
        /*
        Figured the best way to sort through the maps of products is to start at one Standard
        Deviation before the Average of all the prices, so I made a ShopfaceStatistics class to
        facilitate that.
         */

        // The next loop populates the data for the statistics class
        for (int i = 0; i < allProducts.size(); i++) {
            stats.addValue(allProducts.get(i).getPrice());
            System.out.println(allProducts.get(i).getName() + " for $" + allProducts.get(i).getPrice());
        }

        System.out.println("Median: " + stats.getPercentile(50));
        System.out.println("Average: " + stats.getMean());
        System.out.println("St Dev: " + stats.getStandardDeviation());
    }



}