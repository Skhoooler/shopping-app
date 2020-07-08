package com.doria.byui.shopface;

import java.net.MalformedURLException;
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
    private  String api_key = "1CB231FADBBC448988C960384DCBF7D4";
    private  String type = "type=search";
    private  String amazon_domain = "amazon_domain=amazon.com";
    private  String urlSample = "https://api.rainforestapi.com/request?";
    public String query = "";
    public URLEncoder encoder;

    public ArrayList search(String incomingQuery) throws IOException {
        query = incomingQuery;
        String amazonRequest = constructURL(query);
        ArrayList<Product> amazonProducts = new ArrayList<>();
        URL url = new URL (amazonRequest);
        HttpURLConnection amazonConnection = (HttpURLConnection) url.openConnection();
        amazonConnection.setRequestMethod("GET");
        amazonConnection.setConnectTimeout(5000);
        amazonConnection.setReadTimeout(5000);

        Gson gson = new Gson();
        String rawAmazonData = "";

        BufferedReader inputBuffer = new BufferedReader(
                new InputStreamReader(amazonConnection.getInputStream()));
        StringBuilder amazonStringBuilder = new StringBuilder();

        while((rawAmazonData = inputBuffer.readLine()) != null){
            amazonStringBuilder.append(rawAmazonData);
        }
        inputBuffer.close();
        amazonConnection.disconnect();
        String responseString = amazonStringBuilder.toString();

        Map<String, Object> nonProductArray;

        nonProductArray = gson.fromJson(responseString, Map.class);
        ArrayList searchResults =(ArrayList) nonProductArray.get("search_results");

        for (int i = 0; i < searchResults.size(); i++){
            Product product = new Product();

            Map<String, Object> items = (Map<String, Object>) searchResults.get(i);
            product.setName(items.get("title").toString());
            product.setLink(items.get("link").toString());
            product.setPic(items.get("image").toString());
            ArrayList prices = (ArrayList) items.get("prices");
            Map<String,Object> priceValues = (Map<String,Object>) prices.get(0);
            product.setPrice(Float.valueOf(priceValues.get("value").toString()));
            amazonProducts.add(product);
        }
        return amazonProducts;
    }

    private String constructURL(String query){
       String finishedURL = urlSample + '&' +  type + '&' + amazon_domain + getPayloadString();

        return finishedURL;
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
