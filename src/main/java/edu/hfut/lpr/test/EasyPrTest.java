package edu.hfut.lpr.test;

import static edu.hfut.lpr.core.CoreFunc.getPlateType;
import static edu.hfut.lpr.core.CoreFunc.projectedHistogram;
import static edu.hfut.lpr.core.CoreFunc.showImage;
import static org.bytedeco.javacpp.opencv_highgui.imread;

import java.util.Vector;

import org.bytedeco.javacpp.opencv_core.Mat;
import org.junit.Test;

import edu.hfut.lpr.core.CharsIdentify;
import edu.hfut.lpr.core.CharsRecognize;
import edu.hfut.lpr.core.CoreFunc;
import edu.hfut.lpr.core.PlateDetect;
import edu.hfut.lpr.core.PlateLocate;

/**
 * @author lin.yao
 * 
 */
public class EasyPrTest {
    
    @Test
    public void testPlateRecognise() {
        //String imgPath = "res/image/test_image/test.jpg";
        String imgPath = "res/image/test_image/plate_recognize.jpg";

        Mat src = imread(imgPath);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            CharsRecognize cr = new CharsRecognize();
            
            for (int i = 0; i < matVector.size(); ++i) {
                String result = cr.charsRecognise(matVector.get(i));
                System.out.println("Chars Recognised: " + result);
            }
        }
    }

    @Test
    public void testPlateDetect() {
        String imgPath = "res/image/test_image/test.jpg";

        Mat src = imread(imgPath);
        PlateDetect plateDetect = new PlateDetect();
        plateDetect.setPDLifemode(true);
        Vector<Mat> matVector = new Vector<Mat>();
        if (0 == plateDetect.plateDetect(src, matVector)) {
            for (int i = 0; i < matVector.size(); ++i) {
                showImage("Plate Detected", matVector.get(i));
            }
        }
    }

    @Test
    public void testPlateLocate() {
        String imgPath = "res/image/test_image/test.jpg";

        Mat src = imread(imgPath);

        PlateLocate plate = new PlateLocate();
        plate.setDebug(true);
        plate.setLifemode(true);

        Vector<Mat> resultVec = plate.plateLocate(src);

        int num = resultVec.size();
        for (int j = 0; j < num; j++) {
            // showImage("Plate Located " + j, resultVec.get(j));
        }

        return;
    }

    @Test
    public void testCharsRecognise() {
        String imgPath = "res/image/test_image/chars_recognise_huAGH092.jpg";

        Mat src = imread(imgPath);
        CharsRecognize cr = new CharsRecognize();
        cr.setCRDebug(true);
        String result = cr.charsRecognise(src);
        System.out.println("Chars Recognised: " + result);
    }

    @Test
    public void testColorDetect() {
        String imgPath = "res/image/test_image/core_func_yellow.jpg";

        Mat src = imread(imgPath);

        CoreFunc.Color color = getPlateType(src, true);
        System.out.println("Color Deteted: " + color);
    }

    @Test
    public void testProjectedHistogram() {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        Mat src = imread(imgPath);
        projectedHistogram(src, CoreFunc.Direction.HORIZONTAL);
    }

    @Test
    public void testCharsIdentify() {
        String imgPath = "res/image/test_image/chars_identify_E.jpg";

        Mat src = imread(imgPath);
        CharsIdentify charsIdentify = new CharsIdentify();
        String result = charsIdentify.charsIdentify(src, false, true);
        System.out.println(result);
    }

}
