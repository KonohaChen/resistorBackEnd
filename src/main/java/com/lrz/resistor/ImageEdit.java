package com.lrz.resistor;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.List;

public class ImageEdit {
    private static final String PATH = "../src/res_img/edited.png";
    public Mat addRes(Mat src, List<RotatedRect> rectLoc, List<Double> resistance){
        int font = Core.FONT_HERSHEY_COMPLEX;
        double fontScale = 1.5;
        Scalar color_word = new Scalar(0, 0, 0);
        Scalar color_back = new Scalar(255, 255, 255);
        int thickness = 4;
        for(int i=0;i<rectLoc.size();i++){
            Point[] rect_points = new Point[4];
            rectLoc.get(i).points(rect_points);
            //Point pt = new Point(rect_points[1].x,rect_points[1].y+30);
            Point pt = new Point(rectLoc.get(i).center.x-150,rectLoc.get(i).center.y);
            //Imgproc.putText(src,String.valueOf(resistance.get(i)),pt,font, fontScale, color, thickness);
            Imgproc.putText(src,String.valueOf(resistance.get(i))+" ohm",pt,font, fontScale, color_back, thickness+5);
            Imgproc.putText(src,String.valueOf(resistance.get(i))+" ohm",pt,font, fontScale, color_word, thickness);
        }
        Imgcodecs.imwrite(PATH , src);
        return src;
    }
}
