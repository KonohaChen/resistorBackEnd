/**
 * Reads a solid color image and outputs the mean value of its HSV color.
 *
 * @author cisc498_group7
 * @version 1.0
 */
package com.lrz.resistor;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class ColorExtract {
    static {
<<<<<<< HEAD
        //加载opencv动态链接库
        //String path = "F:\\cisc498\\opencv\\build\\java\\x64\\opencv_java320.dll";
        String path = "C:\\Users\\20595\\Downloads\\opencv\\build\\java\\x64\\opencv_java320.dll";
=======
        //Loads the OpenCV dynamic link library
        String path = "F:\\cisc498\\opencv\\build\\java\\x64\\opencv_java320.dll";
        //String path = "F:\opencv\build\java\x64\opencv_java455.dll";
>>>>>>> abf2cb0de8f24f4b8024a888e85d4a6b0e5be5cf
        System.load(path);
    }

    public static void main(String[] args) {
        //Reads a color image and tries to minimize the amount of noise pixels in the input image
        Mat src = Imgcodecs.imread("res/img/orange2.jpg");
        Mat dst = new Mat();
        Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGR2HSV);
        List<Double> H = new ArrayList<Double>();
        List<Double> S = new ArrayList<Double>();
        List<Double> V = new ArrayList<Double>();
        //Outputs the mean value of HSV
        for (int i = 0; i < dst.rows(); i++) {
            for (int j = 0; j < dst.cols(); j++) {
                H.add(dst.get(i,j)[0]);
            }
        }
        for (int i = 0; i < dst.rows(); i++) {
            for (int j = 0; j < dst.cols(); j++) {
                S.add(dst.get(i,j)[1]);
            }
        }
        for (int i = 0; i < dst.rows(); i++) {
            for (int j = 0; j < dst.cols(); j++) {
                V.add(dst.get(i,j)[2]);
            }
        }

        //Eliminates outliers and outputs the mean value
        H = deleteOutliers(H);
        System.out.println("H:"+getMean(H));
        S = deleteOutliers(S);
        System.out.println("S:"+getMean(S));
        V = deleteOutliers(V);
        System.out.println("V:"+getMean(V));
    }

    /**
     * Calculates the standard deviation of a given list of values.
     *
     * @param inputList The list of values for which to calculate the standard deviation.
     * @return The standard deviation of the input list.
     */
    public static double getStandardDiviation(List<Double> inputList) {
        int m = inputList.size();
        double sum = 0;
        for (int i = 0; i < m; i++) { // Calculates the sum
            sum += inputList.get(i);
        }
        double dAve = sum / m; // Calculates the mean
        double dVar = 0;
        for (int i = 0; i < m; i++) { // Calculates the standard deviation
            dVar += (inputList.get(i) - dAve) * (inputList.get(i) - dAve);
        }
        return Math.sqrt(dVar / m);
    }

    /**
     * Calculates the mean of a given list of values.
     *
     * @param inputList The list of values for which to calculate the mean.
     * @return The mean of the input list.
     */
    public static double getMean(List<Double> inputList) {
        int m = inputList.size();
        double sum = 0;
        for (int i = 0; i < m; i++) { // Calculates the sum
            sum += inputList.get(i);
        }
        return sum / m;
    }


    /**
     * Removes outliers from a given list of values using the 3-sigma rule
     * and returns a new list with the outliers removed.
     * @param inputList the list of values to remove outliers from
     * @return a new list with outliers removed
     */
    public static List<Double> deleteOutliers(List<Double> inputList) {
        //Use 3sigma removes outliers
        double mean = getMean(inputList);
        double std = getStandardDiviation(inputList);
        List<Integer> removeIndex = new ArrayList<Integer>();
        for (int i = 0; i < inputList.size(); i++) {
            if ((inputList.get(i) > mean + 3 * std) || (inputList.get(i) < mean - 3 * std)) {
                removeIndex.add(i);
            }
        }
        for (int i = removeIndex.size() - 1; i >= 0; i--) {
            inputList.remove((int) removeIndex.get(i));
        }
        return inputList;
    }
}
