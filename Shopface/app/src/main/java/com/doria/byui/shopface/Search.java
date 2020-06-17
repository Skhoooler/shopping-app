package com.doria.byui.shopface;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;

class Search {
    private String query;
    private File file;

    Search(String query){
        this.query = query;
        //System.out.println(query);
        Connect connect  = new Connect(query);
    }

}
