package com.doria.byui.shopface;

import android.view.View;
import android.widget.EditText;

import java.io.File;

class Search {
    private String query;
    private File file;
    Search(String query){
        this.query = query;
        //System.out.println(query);
        Connect connect  = new Connect(query);
    }
    private void storeSearch(){
        File previousSearch = new File;
    }
}
