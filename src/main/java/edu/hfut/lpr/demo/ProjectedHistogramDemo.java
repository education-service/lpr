package edu.hfut.lpr.demo;

import static edu.hfut.lpr.core.CoreFunc.projectedHistogram;
import static org.bytedeco.javacpp.opencv_highgui.imread;

import org.bytedeco.javacpp.opencv_core.Mat;

import edu.hfut.lpr.core.CoreFunc;

public class ProjectedHistogramDemo {

	public static void main(String[] args) {
		String imgPath = "data/image/test_image/chars_identify_E.jpg";

		Mat src = imread(imgPath);
		projectedHistogram(src, CoreFunc.Direction.HORIZONTAL);
	}

}
