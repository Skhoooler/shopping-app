package com.doria.byui.shopface;

import com.ebay.services.finding.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class EbayConnect implements ConnectStore{

    private String eBaySandboxAppID = "DavidDor-Shopface-SBX-7c8ee5576-a64d1c6f";
    private String eBayAppID        = "DavidDor-Shopface-PRD-2c8e8a00c-c0119913";

    private String query = "";

    EbayConnect(){

    }


    public Map<Integer, Product> search(String incomingQuery, boolean sandbox){
        query = incomingQuery;

        String URL = "";
        String opName = "findItemsByKeywords";

        if (sandbox){
            URL = constructSandboxAPICall(opName);
        }
        else {
            URL = constructAPICall(opName);
        }
        return null;
    }

    /**
     * Compiles a string to be appended to the end of the URL string based
     * on the Search Query the user inputs. This is the actual "search"
     * part of the API call
     * @return a String that is appended to the end of the API call
     */
    private String getPayloadString() {
        String keywords = "";

        try {
            keywords = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());              // Encodes the query into URL format
        }catch (UnsupportedEncodingException exception){
            throw new RuntimeException(exception.getCause());
        }

        String URL = keywords;

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
