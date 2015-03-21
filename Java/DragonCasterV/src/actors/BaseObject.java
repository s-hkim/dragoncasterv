package actors;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BaseObject {

	// DrawX and DrawY are center points
	int drawX, drawY;
	int drawPriority;
	BufferedImage image;

	// Default draw priority
	public BaseObject(String path) throws IOException {
		drawX = 0;
		drawY = 0;
		drawPriority = 0;
		image = loadImage(path);
	}
	
	/*
	 * With these functions:
	 * 	x, y, priority
	 * 
	 * We can do a builder pattern
	 * initialization rather than
	 * lots of overloading
	 * 
	 * Ex.
	 * 		BaseObject title = new BaseObject().x(100).y(100).priority(5);
	 * 		This creates an object with
	 * 			drawX = 100
	 * 			drawY = 100
	 * 			drawPriority = 5
	 * 		Rather than the default 0's for all of them.
	 */
	public BaseObject x(int x) {
		drawX = x;
		return this;
	}
	
	public BaseObject y(int y) {
		drawY = y;
		return this;
	}
	
	public void priority(int priorityVal) {
		drawPriority = priorityVal;
	}

	
	/*
	 * Loads the image and returns the JLabel
	 * (Whatever that is)
	 */
	public BufferedImage loadImage(String imagePath) throws IOException {
		File file = new File(imagePath);
		return ImageIO.read(file);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int width() {
		return image.getWidth();
	}
	
	public int height() {
		return image.getHeight();
	}
	
	public int getLeftX() {
		return drawX - (int)(image.getWidth() / 2);
	}
	
	public int getTopY() {
		return drawY - (int)(image.getHeight() / 2);
	}
	
	public int getRightX() {
		return drawX + (int)(image.getWidth() / 2);
	}
	
	public int getBottomY() {
		return drawY + (int)(image.getHeight() / 2);
	}
	
	public int getX() {
		return drawX;
	}
	
	public int getY() {
		return drawY;
	}

	public void resetHovered() {} // DOES NOTHING ONLY USED IN BUTTONS
	public void setHovered() {} // ALSO DOES NOTHING
}
