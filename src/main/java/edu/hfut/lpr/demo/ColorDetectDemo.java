package edu.hfut.lpr.demo;

import static edu.hfut.lpr.core.CoreFunc.getPlateType;
import static org.bytedeco.javacpp.opencv_highgui.imread;

import org.bytedeco.javacpp.opencv_core.Mat;

import edu.hfut.lpr.core.CoreFunc;

public class ColorDetectDemo {

	public static void main(String[] args) {
		String imgPath = "data/image/test_image/core_func_yellow.jpg";

		Mat src = imread(imgPath);

		CoreFunc.Color color = getPlateType(src, true);
		System.out.println("Color Deteted: " + color);
	}

}
