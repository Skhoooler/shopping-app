package com.doria.byui.shopface;

import com.ebay.services.finding.*;
import java.util.Map;

class Connect {
    // String is the name of the product
    Map<String, Product> rawData;
    String query;

    Connect(String queryFromSearchBar){

    }

    Connect() {

    }

    /**
     * Returns a map full of Product objects
     * @return a map with the raw data from the connect interface
     */
    Map<String, Product> getAllData(){

        return null;
    }

    /**
     * Queries the different APIs to get the top 10 results from each website and puts
     * it in a map
     */
    void search(){

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
    Product deserializeJSON(){
        return null;
    }

    /**
     * Deserializes the information from XML to a Product object
     * @return a Product with the information stored in it
     */
    Product deserializeXML(){
        return null;
    }
}
