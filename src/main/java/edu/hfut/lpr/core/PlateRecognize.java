package edu.hfut.lpr.core;

import java.util.Vector;

import org.bytedeco.javacpp.opencv_core.Mat;

/**
 * 车牌识别核心类
 *
 * @author wanggang
 *
 */
public class PlateRecognize {

	private PlateDetect plateDetect = new PlateDetect();
	private CharsRecognize charsRecognise = new CharsRecognize();

	public int plateRecognize(Mat src, Vector<String> licenseVec) {
		// 车牌方块集合
		Vector<Mat> plateVec = new Vector<>();
		int resultPD = plateDetect.plateDetect(src, plateVec);
		if (resultPD == 0) {
			int num = plateVec.size();
			for (int j = 0; j < num; j++) {
				Mat plate = plateVec.get(j);
				// 获取车牌颜色
				String plateType = charsRecognise.getPlateType(plate);
				// 获取车牌号
				String plateIdentify = charsRecognise.charsRecognise(plate);
				String license = plateType + ":" + plateIdentify;
				licenseVec.add(license);
			}
		}

		return resultPD;
	}

	/**
	 * 设置是否开启生活模式
	 *
	 * @param lifemode
	 */
	public void setLifemode(boolean lifemode) {
		plateDetect.setPDLifemode(lifemode);
	}

	/**
	 * 是否开启调试模式
	 *
	 * @param debug
	 */
	public void setDebug(boolean debug) {
		plateDetect.setPDDebug(debug);
		charsRecognise.setCRDebug(debug);
	}

}
