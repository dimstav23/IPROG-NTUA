import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import shapes.*;

/**
 * The Class Canvas.
 *
 */
public class Canvas extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The shapeList. */
	private List<Shape> shapeList;
	
	/** The number of circles. */
	private int circleNumber = 5;


	/**
	 * Instantiates a new canvas.
	 *
	 * @param shapeList the shape list
	 */
	public Canvas(List<Shape> shapeList) {
		this.shapeList = shapeList;
		setPreferredSize(new Dimension(800,450));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setOpaque(true);
	}


	/**
	 * Sets the circles number.
	 *
	@param num the new circles number
	 */
	public void setCirclesNumber(int num) {
		circleNumber = num;
	}


	/**
	 * Gets the circles number.
	 *
	@return the circles number
	 */
	public int getCirclesNumber() {
		return circleNumber;
	}
	
	
	/**
	 * Resets the canvas.
	 */
	public void reset(){
		shapeList.clear();
		this.repaint();
	}
	
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){
		
		// Reset the canvas
		g.setColor(Color.white);
		g.fillRect (0, 0, getWidth(), getHeight());

		// Print all objects in the list
		Iterator<Shape> itr = shapeList.iterator();
	    while (itr.hasNext())
	      itr.next().draw(g);
	}
	
}
