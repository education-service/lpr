package edu.hfut.lpr.demo;

import static org.bytedeco.javacpp.opencv_highgui.imread;

import java.util.Vector;

import org.bytedeco.javacpp.opencv_core.Mat;

import edu.hfut.lpr.core.CharsRecognize;
import edu.hfut.lpr.core.PlateDetect;

public class PlateRecognizeDemo {

	public static void main(String[] args) {
		//		String imgPath = "data/image/test_image/test.jpg";
		//		String imgPath = "data/image/test_image/plate_recognize.jpg";
		String imgPath = "data/image/hd20150608/10.10.20.236_20150608091955754.bmp";

		Mat src = imread(imgPath);
		PlateDetect plateDetect = new PlateDetect();
		plateDetect.setPDLifemode(true);
		Vector<Mat> matVector = new Vector<>();
		if (0 == plateDetect.plateDetect(src, matVector)) {
			CharsRecognize cr = new CharsRecognize();

			for (int i = 0; i < matVector.size(); ++i) {
				String result = cr.charsRecognise(matVector.get(i));
				System.out.println("Chars Recognised: " + result);
			}
		}
	}

}
