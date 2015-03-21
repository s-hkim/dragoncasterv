package actors;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Button extends BaseObject{

	private boolean isHovered;
	private BufferedImage hoveredImage;
	
	public Button(String path) throws IOException {
		super(path);
		isHovered = false;
		seperateImages();
	}
	
	private void seperateImages() {
		int halfWidth = image.getWidth() / 2;
		int fullHeight = image.getHeight();
		BufferedImage temp;
		
		temp = image.getSubimage(0, 0, halfWidth, fullHeight);
		hoveredImage = image.getSubimage(halfWidth, 0, halfWidth, fullHeight);
		image = temp;
	}
	public void resetHovered() {
		isHovered = false;
	}
	
	public void setHovered() {
		isHovered = true;
	}
	
	public boolean getHovered() {
		return isHovered;
	}
	
	@Override
	public BufferedImage getImage() {
		if (isHovered)
			return hoveredImage;	
		else
			return super.getImage();
	}
}
