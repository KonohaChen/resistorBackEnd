package com.lrz;

import com.lrz.resistor.*;
import org.opencv.core.Mat;
import org.opencv.core.RotatedRect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.CvType;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Base64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class App {

    static {
        //加载opencv动态链接库
        String path = System.getProperty("user.dir") + "\\opencv\\build\\java\\x64\\opencv_java320.dll";
        System.load(path);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public static class ImageUploadRequest{
        private String dataURL;

        public String getDataURL(){
            return dataURL;
        }

        public void setDataURL(String dataURL){
            this.dataURL = dataURL;
            System.out.println(dataURL);
        }
    }

    @RestController
    @RequestMapping("/api")
    @CrossOrigin(origins="http://142.189.244.40/")
    class UploadController {
        @PostMapping("/upload")
        public ResponseEntity<String> uploadImage(@RequestBody ImageUploadRequest imageUploadRequest) {
            String dataURL = imageUploadRequest.getDataURL();
            BufferedImage image = dataURLToBufferedImage(dataURL);
            Mat mat = BufferedImageToMat(image);
            GetResult getResult = new GetResult();
            Mat processedMat = getResult.getResult(mat); // Update this method to return a BufferedImage
            BufferedImage processedImage = matToBufferedImage(processedMat);
            String processedDataURL = bufferedImageToDataURL(processedImage);
            return ResponseEntity.ok(processedDataURL);
        }
    }


    public static BufferedImage dataURLToBufferedImage(String dataURL){
        try{
        String base64Image = dataURL.split(",")[1];
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
        BufferedImage image = ImageIO.read(bis);
        bis.close();
        return image;}
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Mat BufferedImageToMat(BufferedImage img) {
        int type = CvType.CV_8UC3;
        if (img.getType() == BufferedImage.TYPE_BYTE_GRAY) {
            type = CvType.CV_8UC1;
        }
        Mat mat = new Mat(img.getHeight(), img.getWidth(), type);
        byte[] data = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        mat.put(0, 0, data);
        return mat;
    }


    public static BufferedImage matToBufferedImage(Mat mat){
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (mat.channels() > 1){
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = mat.channels() * mat.cols() * mat.rows();
        byte[] buffer = new byte[bufferSize];
        mat.get(0, 0, buffer);
        BufferedImage img = new BufferedImage(mat.cols(), mat.rows(), type);
        byte[] targetPixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
        System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
        return img;
    }

    public static String bufferedImageToDataURL(BufferedImage image){
        try{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", bos);
        byte[] imageBytes = bos.toByteArray();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        bos.close();
        return "data:image/jpeg;base64," + base64Image;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}


