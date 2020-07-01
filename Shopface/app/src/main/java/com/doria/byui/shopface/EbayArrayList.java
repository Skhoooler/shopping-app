package com.doria.byui.shopface;

import java.util.ArrayList;

public class EbayArrayList {
    ArrayList< Object > findItemsByKeywordsResponse = new ArrayList < Object > ();

    void display(){
        for(int i = 0; i < findItemsByKeywordsResponse.size(); i++){
            System.out.println("Size: " + findItemsByKeywordsResponse.size());
            System.out.println(findItemsByKeywordsResponse.get(i).toString());
        }
    }
    // Getter Methods



    // Setter Methods


}
