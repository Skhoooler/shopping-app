package com.doria.byui.shopface;

import java.util.Map;

class ShopFaceModel extends Connect{
    Map<String, Product> data;

    ShopFaceModel(String query){
        //Connect connect = new Connect(query);
        //data = connect.getAllData();
        data = null;
    }

    Map<String, Product> getMapData(String query){
        Connect connect = new Connect(query);
        data = connect.getAllData();
        return data;
    }
}
