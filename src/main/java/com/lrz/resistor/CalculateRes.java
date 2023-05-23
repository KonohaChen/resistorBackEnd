package com.lrz.resistor;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import com.lrz.resistor.ResIdentify;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CalculateRes {
    public List<Double> calculateAllRes(List<Mat> resList){
        int iteration = 1;
        List<Double> resResult = new ArrayList<Double>();
        ResIdentify resIdentify = new ResIdentify();
        for(int i=0;i<resList.size();i++){
            List<Mat> rings = resIdentify.resIdentify(resList.get(i),iteration);
            int x = 0;
            while((rings.size() != 4)&&x<15){
                iteration+=1;
                rings = resIdentify.resIdentify(resList.get(i),iteration);
                x++;
            }
            resResult.add(calculateRes(rings));
        }
        
        return resResult;
    }

    public double calculateRes(List<Mat> rings){
        List<String> ringList = new ArrayList<String>();
        for(int i=0;i<rings.size();i++){
            
            ResIdentify resIdentify = new ResIdentify();
            ringList.add(resIdentify.getColor(rings.get(i)));
            
        }
        System.out.println(ringList);
        //four-ring Res
        if(ringList.size()==4){
            return ((color2Num(ringList.get(3))*10+color2Num(ringList.get(2)))*color2Multiplier(ringList.get(1)));
        }else{
            return -1;
        }
    }
    public static int color2Num(String color){
        if(color == "black"){
            return 0;
        }else if(color == "brown"){
            return 1;
        }else if(color == "red"){
            return 2;
        }else if(color == "orange"){
            return 3;
        }else if(color == "yellow"){
            return 4;
        }else if(color == "green"){
            return 5;
        }else if(color == "blue"){
            return 6;
        }else if(color == "violet"){
            return 7;
        }else if(color == "gray"){
            return 8;
        }else if(color == "white"){
            return 9;
        }else{
            return -1;
        }
    }

    public static double color2Multiplier(String color){
        if(color == "black"){
            return 1;
        }else if(color == "brown"){
            return 10;
        }else if(color == "red"){
            return 100;
        }else if(color == "orange"){
            return 1000;
        }else if(color == "yellow"){
            return 10000;
        }else if(color == "green"){
            return 100000;
        }else if(color == "blue"){
            return 1000000;
        }else if(color == "violet"){
            return 10000000;
        }else if(color == "gray"){
            return 100000000;
        }else if(color == "white"){
            return 1000000000;
        }else{
            return -1;
        }
    }
}
