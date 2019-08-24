package shapes;
import java.awt.Color;
import java.awt.Graphics;


/**
 * The Class Circle.
 */
public class Circle extends Shape {

	/** The circle coordinates. */
	private int rad, x, y;
	private boolean color;
	
	/**
	 * Instantiates a new circle.
	 *

	@param g the g
	 */
	public Circle(){//int x,int y,int rad,boolean color) {
		rad = (int)(Math.random()*100);
		x = (int)(Math.random()*800);
		y = (int)(Math.random()*450);	
	}
	
	public int getX (){
		return x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	/**
	 * Draw circle.
	 *

	@param g the g
	 */
	public void draw(Graphics g,int x,int y,int rad,boolean color) {
		if (color)
			g.setColor(Color.yellow);
		else
			g.setColor(Color.blue);
		g.drawOval(x - rad, y - rad, 2*rad, 2*rad);
	}

}
