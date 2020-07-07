package com.doria.byui.shopface;

import java.util.ArrayList;


public interface ConnectStore {

    /**
     * Search method calls different methods that connect to the various APIs
     * , grabs the information, organizes it into a map of Products, and
     * then returns that map
     * @param query The search query from the user
     * @param Sandbox True to connect to the API sandbox instead of the normal
     *                database
     * @return A map of Products
     */
    ArrayList<Product> search(String query, boolean Sandbox);
}
