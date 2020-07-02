package com.doria.byui.shopface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ebay.services.finding.*;

import java.sql.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class Connect {
    // String is the name of the product
    //Map<String, Product> rawData;
    String query;
    Product[] ebayResults;

    Connect(String queryFromSearchBar){
        query = queryFromSearchBar;

        EbayConnect ebayConnect = new EbayConnect();
        ebayConnect.search(query, true);
    }

    Connect() {

    }

    /**
     * Returns a map full of Product objects
     * @return a map with the raw data from the connect interface
     */
    Map<String, Product> getAllData(){
        EbayConnect ebayConnect = new EbayConnect();
        Map<Integer,Product> ebaySearch = ebayConnect.search(query, true);
        search(ebaySearch);

        return null;
    }

    /**
     * Queries the different APIs to get the top 10 results from each website and puts
     * it in a map
     * //@param //ebaySearch
     */
    void search(Map<Integer, Product> ebaySearch){
        ebayResults = new Product[10];
        ;
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
