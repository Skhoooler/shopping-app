package com.doria.byui.shopface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ShopFaceStatistics {
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

    void removeData(float dataPoint){
        data.remove(dataPoint);
        count--;
    }

    float getPriceBuffer(){
        float buffer = 0;
        if (getAverage() - getStandardDeviation() <= 0){

        }
        else{
            buffer = getAverage() - getStandardDeviation();
        }
        return buffer;
    }

    float getStandardDeviation(){
        float standardDeviation = 0;
        float avg = getAverage();
        float summation = 0;

        for (int i = 0; i < count; i++){
            // adds up (x - avg)^2
            summation = (float) (summation + (Math.pow((data.get(i) - avg), 2)));
        }

        standardDeviation = (float) Math.pow(summation/(count - 1), .5);
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


    float getMedian(){
        int medianIndex = (int) data.size() / 2;
        return data.get(medianIndex);
    }

    private int getMedianIndex(){
        return (int) data.size() / 2;
    }

    float getIQR()
    {
        int quarterIndex = (int) data.size() / 4;

        int Q1index = getMedianIndex() - quarterIndex;
        int Q3index = getMedianIndex() + quarterIndex;

      return data.get(Q3index - Q1index);
    }

    float getSmallestPrice(){
        return Collections.min(data);
    }

    float getLargestPrice(){
        return Collections.max(data);
    }
}
