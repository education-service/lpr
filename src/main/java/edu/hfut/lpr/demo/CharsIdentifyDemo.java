package edu.hfut.lpr.demo;

import static org.bytedeco.javacpp.opencv_highgui.imread;

import org.bytedeco.javacpp.opencv_core.Mat;

import edu.hfut.lpr.core.CharsIdentify;

public class CharsIdentifyDemo {

	public static void main(String[] args) {
		String imgPath = "data/image/test_image/chars_identify_E.jpg";

		Mat src = imread(imgPath);
		CharsIdentify charsIdentify = new CharsIdentify();
		String result = charsIdentify.charsIdentify(src, false, true);
		System.out.println(result);
	}

}
