package com.doria.byui.shopface;

import java.io.File;

class Search {
    private File file;

    Search(String query){
        System.out.println(query);
        new Connect(query);
    }

}
