package com.doria.byui.shopface;

import java.util.ArrayList;

public class ShopFaceStatistics {
    private ArrayList<Float> data;
    private int count;

    ShopFaceStatistics(){
        data = new ArrayList<>();
        count = 0;
    }

    void addData(float dataPoint){
        data.add(dataPoint);
        count++;
    }

    float getStandardDeviation(){
        float standardDeviation = 0;
        float avg = getAverage();
        float summation = 0;

        for (int i = 0; i < count; i++){
            // adds up (x - avg)^2
            summation = (float) (summation + (Math.pow((data.get(i) - avg), 2)));
        }

        standardDeviation = (float) Math.pow(summation/count, .5);
        standardDeviation = (float) (Math.round(standardDeviation * 100)/100);

        return standardDeviation;
    }

    float getAverage(){
        float avg = 0;
        for (int i = 0; i < data.size(); i++){
            avg = avg + data.get(i);
        }

        avg = avg/count;
        avg = (float) (Math.round(avg * 100.0)/100.0);

        return avg;

    }
}
