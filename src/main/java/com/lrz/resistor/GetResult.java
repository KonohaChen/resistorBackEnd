package com.lrz.resistor;

import org.opencv.core.Mat;
import org.opencv.core.RotatedRect;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
public class GetResult {
    static {
        //加载opencv动态链接库
        String path = "F:\\cisc498\\opencv\\build\\java\\x64\\opencv_java320.dll";
        //String path = "F:\\cisc498\\opencv\\build\\java\\x64\\opencv_java455.dll";
        System.load(path);
    }
    public void getResult(String path){
        Mat image = Imgcodecs.imread(path);
        //定位电阻
        List<RotatedRect> rectLoc = new ArrayList<>();
        ResLocate resLocate = new ResLocate();
        resLocate.resLocate(image,rectLoc);

        CalculateRes calculateRes = new CalculateRes();
        List<Double> resistance;
        resistance = calculateRes.calculateAllRes();

        //编辑图片
        ImageEdit imageEdit = new ImageEdit();
        Mat origin = Imgcodecs.imread("res\\img\\resistor\\originWithContour.jpg");
        imageEdit.addRes(origin,rectLoc,resistance);
    }
}
