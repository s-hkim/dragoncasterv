package actors;

public class BaseObject extends LoadingImage{

	// DrawX and DrawY are center points
	int x, y;

	// Default draw priority
	public BaseObject(String path) {
		super(path);
		x = 0;
		y = 0;
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
		this.x = x;
		return this;
	}
	
	public BaseObject y(int y) {
		this.y = y;
		return this;
	}
	
	public int getImageLeftX() {
		return x - (int)(image.getWidth() / 2);
	}
	
	public int getImageTopY() {
		return y - (int)(image.getHeight() / 2);
	}
	
	public int getImageRightX() {
		return x + (int)(image.getWidth() / 2);
	}
	
	public int getImageBottomY() {
		return y + (int)(image.getHeight() / 2);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
