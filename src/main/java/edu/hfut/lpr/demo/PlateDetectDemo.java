package edu.hfut.lpr.demo;

import static edu.hfut.lpr.core.CoreFunc.showImage;
import static org.bytedeco.javacpp.opencv_highgui.imread;

import java.util.Vector;

import org.bytedeco.javacpp.opencv_core.Mat;

import edu.hfut.lpr.core.PlateDetect;

public class PlateDetectDemo {

	public static void main(String[] args) {
		String imgPath = "data/image/hd20150608/10.10.20.236_20150608091955754.bmp";
		//		String imgPath = "data/image/general_test/川C28888.jpg";

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

}
