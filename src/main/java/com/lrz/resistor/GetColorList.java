package com.lrz.resistor;

import java.util.HashMap;

public class GetColorList {
    public static HashMap<String, int[]> getColorList() {
        HashMap<String, int[]> colorList = new HashMap<String, int[]>();
        //black
        colorList.put("lower_black", new int[]{0,0,0});
        colorList.put("upper_black", new int[]{180, 255, 30});
        //brown
        colorList.put("lower_brown1", new int[]{0,150,150});
        colorList.put("upper_brown1", new int[]{10, 180, 180});
        colorList.put("lower_brown2", new int[]{170,150,150});
        colorList.put("upper_brown2", new int[]{180, 180, 180});
        //red1
        colorList.put("lower_red1", new int[]{0,180,180});
        colorList.put("upper_red1", new int[]{10, 230, 255});
        //red2
        colorList.put("lower_red2", new int[]{170,180,180});
        colorList.put("upper_red2", new int[]{180, 255, 255});
        //orange
        colorList.put("lower_orange", new int[]{10,220,180});
        colorList.put("upper_orange", new int[]{20,255,255});
        //yellow
        colorList.put("lower_yellow", new int[]{21,150,210});
        colorList.put("upper_yellow", new int[]{30, 220, 255});
        //green
        colorList.put("lower_green", new int[]{30,110,125});
        colorList.put("upper_green", new int[]{40, 145, 165});
        //blue
        colorList.put("lower_blue", new int[]{100,110,140});
        colorList.put("upper_blue", new int[]{120, 160, 160});
        //violet
        colorList.put("lower_violet", new int[]{125,95,140});
        colorList.put("upper_violet", new int[]{140, 140, 165});
        //gray
        colorList.put("lower_gray", new int[]{0,0,46});
        colorList.put("upper_gray", new int[]{180, 43, 220});
        //white
        colorList.put("lower_white", new int[]{0,0,221});
        colorList.put("upper_white", new int[]{180, 30, 255});
        //gold
        colorList.put("lower_gold", new int[]{10,150,150});
        colorList.put("upper_gold", new int[]{20,180,255});
        return colorList;
    }
}

