package shapes;
import java.awt.Color;
import java.awt.Graphics;


/**
 * The Class Circle.
 */
public class Circle extends Shape {

	/** The circle coordinates. */
	private int rad, x, y;
	
	/**
	 * Instantiates a new circle.
	 *

	@param g the g
	 */
	public Circle() {
		rad = (int)(Math.random()*100);
		x = (int)(Math.random()*800);
		y = (int)(Math.random()*450);
	}
	
	
	/**
	 * Draw circle.
	 *

	@param g the g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawOval(x - rad, y - rad, 2*rad, 2*rad);
	}

}
