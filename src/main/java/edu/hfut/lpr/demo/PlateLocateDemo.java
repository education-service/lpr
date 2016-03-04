package edu.hfut.lpr.demo;

import static edu.hfut.lpr.core.CoreFunc.showImage;
import static org.bytedeco.javacpp.opencv_highgui.imread;

import java.util.Vector;

import org.bytedeco.javacpp.opencv_core.Mat;

import edu.hfut.lpr.core.PlateLocate;

public class PlateLocateDemo {

	public static void main(String[] args) {
		String imgPath = "data/image/test_image/test.jpg";

		Mat src = imread(imgPath);

		PlateLocate plate = new PlateLocate();
		plate.setDebug(true);
		plate.setLifemode(true);

		Vector<Mat> resultVec = plate.plateLocate(src);

		int num = resultVec.size();
		for (int j = 0; j < num; j++) {
			showImage("Plate Located " + j, resultVec.get(j));
		}
	}

}
