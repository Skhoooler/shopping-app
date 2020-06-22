package com.doria.byui.shopface;

import com.ebay.services.finding.*;

public class EbayConnect {

    private String eBaySandboxAppID = "DavidDor-Shopface-SBX-7c8ee5576-a64d1c6f";
    private String eBayAppID        = "DavidDor-Shopface-PRD-2c8e8a00c-c0119913";

    EbayConnect(){

    }

    void searchEbay(String query, boolean sandbox){
        String URL = "";

        if (sandbox){
            URL = constructSandboxAPICall(0);
        }
        else {
            URL = constructAPICall();
        }
    }

    /**
     * Constructs the correct API call URL to be able to send it off
     * @return the URL to the API as a fully concatenated string
     */
    private String constructAPICall(String opName)
    {
        String base          = "https://svcs.sandbox.ebay.com/services/search/FindingService/v1";
        String operationName = "?OPERATION-NAME=";                                               // Required
        String appName       = "&SECURITY-APPNAME=";                                             // Required
        String dataFormat    = "&RESPONSE-DATA-FORMAT=JSON";                                     // Could also use XML instead of JSON


        appName       = appName +eBayAppID;
        operationName = operationName + opName;

        return base + operationName + appName + dataFormat;
    }

    /**
     * Constructs the correct API call URL to be able to send it off to the Sandbox
     * @return the URL to the API as a fully concatenated string
     */
    private String constructSandboxAPICall(String opName)
    {
        String base          = "https://svcs.sandbox.ebay.com/services/search/FindingService/v1";
        String operationName = "?OPERATION-NAME=";                                               // Required
        String appName       = "&SECURITY-APPNAME=";                                             // Required
        String dataFormat    = "&RESPONSE-DATA-FORMAT=JSON";                                     // Could also use XML instead of JSON


        appName       = appName + eBaySandboxAppID;
        operationName = operationName + opName;

        return base + operationName + appName + dataFormat;
    }
}
