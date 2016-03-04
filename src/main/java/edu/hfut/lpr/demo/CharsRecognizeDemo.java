package edu.hfut.lpr.demo;

import static org.bytedeco.javacpp.opencv_highgui.imread;

import org.bytedeco.javacpp.opencv_core.Mat;

import edu.hfut.lpr.core.CharsRecognize;

public class CharsRecognizeDemo {

	public static void main(String[] args) {
		String imgPath = "data/image/test_image/chars_recognise_huAGH092.jpg";

		Mat src = imread(imgPath);
		CharsRecognize cr = new CharsRecognize();
		cr.setCRDebug(true);
		String result = cr.charsRecognise(src);
		System.out.println("Chars Recognised: " + result);
	}

}
