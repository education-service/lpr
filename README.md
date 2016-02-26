
# LPR系统

## 简介

> 假设我们有如下的原始图片，需要识别出中间的车牌字符与颜色：

![原始图片](data/image/test_image/plate_recognize.jpg)

> 经过LPR的第一步处理车牌检测（PlateDetect）以后，我们获得了原始图片中仅包含车牌的图块：

![LPR 车牌](data/image/test_image/chars_segment.jpg)

> 接着，我们对图块进行OCR过程，在LPR中，叫做字符识别（CharsRecognize）。我们得到了一个包含车牌颜色与字符的字符串：

`“蓝牌：苏EUK722”`
 


