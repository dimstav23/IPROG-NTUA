package shapes;

import java.awt.Graphics;

/**
 * The Class Shape.
 */
public abstract class Shape {
	
	/**
	 * Draw.
	 */
	abstract public void draw(Graphics g,int x,int y,int rad,boolean color);
	abstract public int getX();
	abstract public void setX(int x);
}
