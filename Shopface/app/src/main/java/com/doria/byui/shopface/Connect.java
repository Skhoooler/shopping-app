package com.doria.byui.shopface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Connect {
    // String is the name of the product
    //Map<String, Product> rawData;
    String query;
    Product[] ebayResults;

    Connect(String queryFromSearchBar){
        query = queryFromSearchBar;

        // Returns an ArrayList with Products from Ebay
        EbayConnect ebayConnect          = new EbayConnect();
        ArrayList<Product> ebayResults   = ebayConnect.search(query, true);

        // Returns an ArrayList with Products from Amazon
        AmazonConnect amazonConnect      = new AmazonConnect();
        ArrayList<Product> amazonResults = amazonConnect.search(query, false);


        // Combines all of the products from the ArrayLists into one ArrayList
        ArrayList<Product> allProducts = new ArrayList<>();
        allProducts.addAll(ebayResults);
//        allProducts.addAll(amazonResults);

        // Sorts via Price in descending order (cheapest first)
        Collections.sort(allProducts, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Math.round(o1.getPrice() - o2.getPrice());
            }
        });
        new ShopFaceControl(query, allProducts);

    }

    Connect() {

    }

    /**
     * Returns a map full of Product objects
     * @return a map with the raw data from the connect interface
     */
    Map<String, Product> getAllData(){
        EbayConnect ebayConnect = new EbayConnect();
        ArrayList<Product> ebayResults = ebayConnect.search(query, true);

        //search(ebayResults);

        return null;
    }

    /**
     * Queries the different APIs to get the top 10 results from each website and puts
     * it in a map
     * //@param //ebaySearch
     */
    void search(Map<Integer, Product> ebaySearch){
        ebayResults = new Product[10];

        for  (Integer i = 0; i<10; i++)
        {
            ebayResults[i] = ebaySearch.get(i);
        }
    }

    /**
     * Constructs URLS for all of the different website's who's data base is being queried
     * @return a complete URL in string form
     */
    String constructURLS(){
        return null;
    }

    /**
     * Actually sends the query and receives the information from the database
     * @return a string with the raw XML or JSON information from the database
     */
    String sendQuery(){
        return null;
    }

    /**
     * Deserializes the information from JSON to a Product object
     * @return a Product object with the information stored in it
     */
    //Product deserializeJSON(){
        //return null;
    //}

    /**
     * Deserializes the information from XML to a Product object
     * @return a Product with the information stored in it
     */
    //Product deserializeXML(){
       // return null;
    //}
}
