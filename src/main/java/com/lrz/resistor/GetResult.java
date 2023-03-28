package com.lrz.resistor;

import org.opencv.core.Mat;
import org.opencv.core.RotatedRect;
import org.opencv.imgcodecs.Imgcodecs;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
public class GetResult {
    static {
        //加载opencv动态链接库
<<<<<<< HEAD
        String path = "C:\\Users\\20595\\Downloads\\opencv\\build\\java\\x64\\opencv_java320.dll";
        //String path = "F:\\opencv\\build\\java\\x64\\opencv_java455.dll";
=======
        String path = "F:\\cisc498\\opencv\\build\\java\\x64\\opencv_java320.dll";
        //String path = "F:\\cisc498\\opencv\\build\\java\\x64\\opencv_java455.dll";
>>>>>>> abf2cb0de8f24f4b8024a888e85d4a6b0e5be5cf
        System.load(path);
    }
    public Mat getResult(Mat image){
        //定位电阻
        List<RotatedRect> rectLoc = new ArrayList<>();
        ResLocate resLocate = new ResLocate();
        resLocate.resLocate(image,rectLoc);

        CalculateRes calculateRes = new CalculateRes();
        List<Double> resistance;
        resistance = calculateRes.calculateAllRes();

        //编辑图片
        ImageEdit imageEdit = new ImageEdit();
        imageEdit.addRes(image,rectLoc,resistance);

        return image;
    }
}
