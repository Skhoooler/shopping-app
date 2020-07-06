package com.doria.byui.shopface;

import com.ebay.services.finding.*;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EbayConnect implements ConnectStore{

    private String eBaySandboxAppID = "DavidDor-Shopface-SBX-7c8ee5576-a64d1c6f";
    private String eBayAppID        = "DavidDor-Shopface-PRD-2c8e8a00c-c0119913";

    private String query = "";

    EbayConnect(){

    }


    public HashMap<Integer, Product> search(String incomingQuery, boolean sandbox) {
        query = incomingQuery;

        String ebayRequest;
        String opName = "findItemsByKeywords";

        // Puts together the API request
        if (sandbox) {
            ebayRequest = constructSandboxAPICall(opName);
        } else {
            ebayRequest = constructAPICall(opName);
        }

        System.out.println(ebayRequest);

        HashMap<Integer, Product> ebayProducts = new HashMap<Integer, Product>();
        // This is where the actual call is sent
        try {
            URL url = new URL(ebayRequest);
            HttpURLConnection ebayConnection = (HttpURLConnection) url.openConnection();
            ebayConnection.setRequestMethod("GET");
            ebayConnection.setConnectTimeout(5000);
            ebayConnection.setReadTimeout(5000);

            int status = ebayConnection.getResponseCode();

            BufferedReader inputBuffer = new BufferedReader(
                    new InputStreamReader(ebayConnection.getInputStream()));
            StringBuilder ebayStringBuilder = new StringBuilder();

            String rawEbayData = "";
            while((rawEbayData = inputBuffer.readLine()) != null){
                ebayStringBuilder.append(rawEbayData);
            }

            inputBuffer.close();
            ebayConnection.disconnect();

            String responseString = ebayStringBuilder.toString();
            Gson gson = new Gson();

            Map<String, ArrayList> map = (Map<String, ArrayList>) gson.fromJson(responseString, Map.class);

            /*
            Made with help from Bro Barney. We looked at a JSON file we got back from ebay (Ebay JSON Sample.JSON)
            and were able to deserialize it layer by layer, until we got to an ArrayList of items from Ebay
            which we can use to grab the rest of the information to populate the map of Products
             */
                                                                                                         // In Ebay JSON sample.JSON file
            ArrayList           responses        = map.get("findItemsByKeywordsResponse");               // Line 2
            Map<String, Object> firstResponse    = (Map<String, Object>) responses.get(0);               // Line 3
            ArrayList           theSearchResults = (ArrayList) firstResponse.get("searchResult");        // Line 13
            Map<String, Object> firstResult      = (Map<String, Object>) theSearchResults.get(0);        // Line 14
            ArrayList           retrievedItems   = (ArrayList) firstResult.get("item");                  // Line 16

            // This populates the map to be returned with the data from Ebay as Product objects

            /*
            Potential bug to be fixed: There's a chance the ebay search will return less than 10 items, and it could
            fill the map with null pointers. The "i<10" part of the for loop needs to be changed to accommodate that
             */
            for (int i = 0; i < 10; i++)
            {
                Product product = new Product();

                Map<String, Object> item             = (Map<String, Object>) retrievedItems.get(i);      // Line 17
                ArrayList           sellingStatus    = (ArrayList) item.get("sellingStatus");            // Line 80
                Map<String, Object> sellingStatusMap = (Map<String, Object>) sellingStatus.get(0);       // Line 81
                ArrayList           currentPrice     = (ArrayList) sellingStatusMap.get("currentPrice"); // Line 82
                Map<String, Object> currentPriceMap  = (Map<String, Object>) currentPrice.get(0);        // Line 83

                product.setName((String) item.get("title").toString());
                product.setLink((String) item.get("viewItemURL").toString());
                if (currentPriceMap.get("__value__") != null) {
                    product.setPrice((float) Float.parseFloat((String) currentPriceMap.get("__value__")));
                } else
                {
                    product.setPrice(0);
                }
                product.setDesc(null);

                ebayProducts.put(i, product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ebayProducts;
    }

    /**
     * Compiles a string to be appended to the end of the URL string based
     * on the Search Query the user inputs. This is the actual "search"
     * part of the API call
     * @return a String that is appended to the end of the API call
     */
    private String getPayloadString() {
        String keywords;

        try {
            keywords = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());              // Encodes the query into URL format
        }catch (UnsupportedEncodingException exception){
            throw new RuntimeException(exception.getCause());
        }

        String URL = "&keywords=" + keywords;

        return URL;
    }

    /**
     * Constructs the correct API call URL to be able to send it off
     * @return the URL to the API as a fully concatenated string
     */
    private String constructAPICall(String opName) {
        String base          = "https://svcs.sandbox.ebay.com/services/search/FindingService/v1";
        String operationName = "?OPERATION-NAME=";                                               // Required
        String appName       = "&SECURITY-APPNAME=";                                             // Required
        String dataFormat    = "&RESPONSE-DATA-FORMAT=JSON";                                     // Could also use XML instead of JSON
        String restPayload   = "&REST-PAYLOAD";                                                  // Anything after this has to do with what we're searching for


        appName       = appName + eBayAppID;
        operationName = operationName + opName;

        String URL =  base + operationName + appName + dataFormat + restPayload;
        URL = URL + getPayloadString();

        return URL;
    }

    /**
     * Constructs the correct API call URL to be able to send it off to the Sandbox
     * @return the URL to the API as a fully concatenated string
     */
    private String constructSandboxAPICall(String opName) {
        String base = "https://svcs.sandbox.ebay.com/services/search/FindingService/v1";
        String operationName = "?OPERATION-NAME=";                                               // Required
        String appName = "&SECURITY-APPNAME=";                                                   // Required
        String dataFormat = "&RESPONSE-DATA-FORMAT=JSON";                                        // Could also use XML instead of JSON
        String restPayload = "&REST-PAYLOAD";                                                    // Anything after this has to do with what we're searching for


        appName = appName + eBaySandboxAppID;
        operationName = operationName + opName;

        String URL =  base + operationName + appName + dataFormat + restPayload;
        URL = URL + getPayloadString();

        return URL;
    }
}
