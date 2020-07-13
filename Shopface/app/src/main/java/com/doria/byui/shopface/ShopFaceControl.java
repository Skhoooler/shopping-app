package com.doria.byui.shopface;

import java.util.ArrayList;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

class ShopFaceControl {

    public String query;
    private ArrayList<Product> sortedProducts = new ArrayList<>();
    private DescriptiveStatistics stats = new DescriptiveStatistics();


    ShopFaceControl(String incomingQuery, ArrayList<Product> allProducts) {
        query = incomingQuery;

        sort(allProducts);

        new ShopFaceView(sortedProducts, query);
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
        }

        float range = (float) (stats.getMean() - stats.getStandardDeviation());
        for (int i = 0; i < allProducts.size(); i++){
            if (allProducts.get(i).getPrice() > range) {
                sortedProducts.add(allProducts.get(i));
                System.out.println(allProducts.get(i).getName() + " for $" + allProducts.get(i).getPrice());
            }
        }

        System.out.println("Number of Items: " + allProducts.size());
        System.out.println("Number of sorted Items: " + sortedProducts.size());
    }
}