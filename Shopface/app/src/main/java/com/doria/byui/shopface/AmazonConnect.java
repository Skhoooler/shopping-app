package com.doria.byui.shopface;

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
import java.util.HashMap;
import java.util.Map;

public class AmazonConnect implements ConnectStore
{
    private  String api_key = "1CB231FADBBC448988C960384DCBF7D4";
    private  String type = "search";
    private  String amazon_domain = "amazon.com";
    private  String urlSample = "https://api.rainforestapi.com/request?";
    public String query = "";
    @Override
    public HashMap<Integer, Product> search(String incomingQuery, boolean Sandbox) {
        query = incomingQuery;
        return null;
    }


}
