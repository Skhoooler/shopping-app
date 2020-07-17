package com.doria.byui.shopface;

import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
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

public class AmazonConnect
{
    private  String api_key = "api_key=1CB231FADBBC448988C960384DCBF7D4";
    private  String type = "type=search";
    private  String amazon_domain = "amazon_domain=amazon.com";
    private  String urlSample = "https://api.rainforestapi.com/request?";
    public String query = "";
    public URLEncoder encoder;


    public ArrayList<Product> search(String incomingQuery)  {
        query = incomingQuery;
        String amazonRequest = constructURL(query);
        ArrayList<Product> amazonProducts = new ArrayList<>();
        URL url = null;
        try {
            url = new URL(amazonRequest);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection amazonConnection = null;
        try {
            amazonConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            amazonConnection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        amazonConnection.setConnectTimeout(5000);
        amazonConnection.setReadTimeout(5000);

        Gson gson = new Gson();
        String rawAmazonData = "";
        try {
            BufferedReader inputBuffer;

            inputBuffer = new BufferedReader(
                    new InputStreamReader(amazonConnection.getInputStream()));

            StringBuilder amazonStringBuilder = new StringBuilder();

            while(true){
                try {
                    if (((rawAmazonData = inputBuffer.readLine()) == null)) break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                amazonStringBuilder.append(rawAmazonData);
            }
            ;
            try {
                inputBuffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            amazonConnection.disconnect();
            String responseString = amazonStringBuilder.toString();

            Map<String, Map> nonProductArray;
           // System.out.println(responseString);
            nonProductArray = gson.fromJson(responseString, Map.class);
            ArrayList searchResults =(ArrayList) nonProductArray.get("search_results");

            for (int i = 0; i < searchResults.size(); i++){
                Product product = new Product();
                //System.out.println("Crashing on index: " + i);
                Map<String, Map<String, Object>> items1 = (Map<String, Map<String, Object>>) searchResults.get(i);
                Map<String, Object> items2 = (Map<String, Object>) searchResults.get(i);
                product.setName(items2.get("title").toString());
                product.setLink(items2.get("link").toString());
                product.setPic(items2.get("image").toString());

                ArrayList<Map<String, Object>> prices = (ArrayList<Map<String, Object>>) items1.get("prices");

                Map<String,Object> priceValues = prices.get(0);
               // System.out.println(prices.get(0));
                product.setPrice(Float.parseFloat(priceValues.get("value").toString()));
                amazonProducts.add(product);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
        return amazonProducts;
    }

    private String constructURL(String query){
        //String finishedURL = urlSample + api_key + '&' +  type + '&' + amazon_domain + getPayloadString();

        return urlSample + api_key + '&' +  type + '&' + amazon_domain + getPayloadString();
    }

    private String getPayloadString() {
        String keywords;

        try {
            keywords = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());              // Encodes the query into URL format
        }catch (UnsupportedEncodingException exception){
            throw new RuntimeException(exception.getCause());
        }

        String URL = "&search_term=" + keywords;

        return URL;
    }


}