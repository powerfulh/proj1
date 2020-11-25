package com.fridgeCare.fri.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Thumbnail {
	String path , ext;
	File f , t;
	int index;
	String savepath = "C:/Users/hanho/Desktop/jsp/increpas4Team/fridgeCare/WebContent/WEB-INF/resources/thumb";
	public Thumbnail(String filewhere) {
		path = filewhere;
		index = path.lastIndexOf(".");
		ext = path.substring(index+1);
		f = new File(path);
		t = new File(savepath + "/t_" + f.getName());
	}
	public File make(int w , int h) {
		String savename = null;
		BufferedImage img = null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage newimg = new BufferedImage(w,h,BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D drawer = newimg.createGraphics();
		Image load = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		drawer.drawImage(load, 0, 0, w, h, null);
		drawer.dispose();
		try {
			ImageIO.write(newimg, ext, t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		savename = t.getName();
		System.out.println("make success = " + savename);
		return t;
	}
}

class Reference{
	public void abc() {
		String oPath = "C:/Temp/40f0594a-b3f6-4c0f-a0b2-3cebbaf0d74e.jpg"; // 원본 경로
		File oFile = new File(oPath);

		int index = oPath.lastIndexOf(".");
		String ext = oPath.substring(index + 1); // 파일 확장자

		String tPath = oFile.getParent() + File.separator + "t-" + oFile.getName(); // 썸네일저장 경로
		File tFile = new File(tPath);

		double ratio = 2; // 이미지 축소 비율

		try {
			BufferedImage oImage = ImageIO.read(oFile); // 원본이미지
			int tWidth = (int) (oImage.getWidth() / ratio); // 생성할 썸네일이미지의 너비
			int tHeight = (int) (oImage.getHeight() / ratio); // 생성할 썸네일이미지의 높이
			
			BufferedImage tImage = new BufferedImage(tWidth, tHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일이미지
			Graphics2D graphic = tImage.createGraphics();
			Image image = oImage.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
			graphic.drawImage(image, 0, 0, tWidth, tHeight, null);
			graphic.dispose(); // 리소스를 모두 해제

			ImageIO.write(tImage, ext, tFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}