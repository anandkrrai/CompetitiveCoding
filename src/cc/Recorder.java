package cc;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Recorder {

	public static int screenWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

	public static int screenHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	public static int captureInterval = 69;

	public static String store = "src";

	public static boolean record = false;

	public static void startRecord() {
		Thread recordThread = new Thread() {
			@Override
			public void run() {
				Robot rt;
				int cnt = 0;
				try {
					rt = new Robot();
					while (cnt == 0 || record) {
						BufferedImage img = rt.createScreenCapture(new Rectangle(screenWidth, screenHeight));
//						ImageIO.write(img, "jpeg", new File("./" + store + "/" + "img" + ".jpg"));
						ImageIO.write(img, "jpeg", new File("./" + store + "/" + System.currentTimeMillis() + ".jpeg"));

						if (cnt == 0) {
							record = true;
							cnt = 1;
						}
						Thread.sleep(captureInterval);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		recordThread.start();
	}

	public static void main(String args[]) {
		startRecord();
	}

}