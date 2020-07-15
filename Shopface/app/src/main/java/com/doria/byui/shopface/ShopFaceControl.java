package com.doria.byui.shopface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

class ShopFaceControl {

    private ArrayList<Product> sortedProducts = new ArrayList<>();
    private DescriptiveStatistics stats = new DescriptiveStatistics();

    ShopFaceControl(ArrayList<Product> allProducts) {
        Collections.sort(allProducts, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return Math.round(o1.getPrice() - o2.getPrice());
                    }
                });
    }

    /**
     * Sorts the raw data that comes from the ShopFaceModel Class into a second
     * map that contains the best results from the search.
     */
    public ArrayList<Product> sort(ArrayList<Product> allProducts) {
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
            }
        }

        return sortedProducts;
    }
}