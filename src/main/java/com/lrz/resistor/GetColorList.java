package com.lrz.resistor;

import java.util.HashMap;

public class GetColorList {
    public static HashMap<String, int[]> getColorList() {
        HashMap<String, int[]> colorList = new HashMap<String, int[]>();
        //black
        colorList.put("lower_black", new int[]{0,0,0});
        colorList.put("upper_black", new int[]{180, 255, 30});
        //brown
        colorList.put("lower_brown1", new int[]{0,150,50});
        colorList.put("upper_brown1", new int[]{10, 255, 190});
        colorList.put("lower_brown2", new int[]{170,150,50});
        colorList.put("upper_brown2", new int[]{180, 255, 190});
        //red1
        colorList.put("lower_red1", new int[]{0,180,50});
        colorList.put("upper_red1", new int[]{8, 255, 255});
        //red2
        colorList.put("lower_red2", new int[]{170,180,50});
        colorList.put("upper_red2", new int[]{175, 255, 255});
        //orange
        colorList.put("lower_orange", new int[]{10,150,50});
        colorList.put("upper_orange", new int[]{23,255,255});
        //yellow
        colorList.put("lower_yellow", new int[]{24,150,50});
        colorList.put("upper_yellow", new int[]{30, 220, 255});
        //green
        colorList.put("lower_green", new int[]{30,50,50});
        colorList.put("upper_green", new int[]{70, 145, 255});
        //blue
        colorList.put("lower_blue", new int[]{100,110,50});
        colorList.put("upper_blue", new int[]{120, 160, 255});
        //violet
        colorList.put("lower_violet", new int[]{120,60,50});
        colorList.put("upper_violet", new int[]{170, 255, 255});
        //gray
        colorList.put("lower_gray", new int[]{0,0,46});
        colorList.put("upper_gray", new int[]{180, 43, 220});
        //white
        colorList.put("lower_white", new int[]{0,0,221});
        colorList.put("upper_white", new int[]{180, 25, 255});
        //gold
        colorList.put("lower_gold", new int[]{10,150,150});
        colorList.put("upper_gold", new int[]{20,180,255});
        return colorList;
    }
}

