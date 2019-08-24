import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import shapes.*;

/**
 * The Class Canvas.
 *
 */
public class Canvas extends JPanel implements KeyListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The shapeList. */
	private List<Shape> shapeList;
	
	/** The number of circles. */
	private int circleNumber = 0;
	private boolean appear=true;

	/**
	 * Instantiates a new canvas.
	 *
	 * @param shapeList the shape list
	 */
	public Canvas(List<Shape> shapeList) {
		this.shapeList = shapeList;
		setPreferredSize(new Dimension(500,500));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		addKeyListener(this);
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
	
	public List<Shape> getList(){
		return shapeList;
	}
	
	public void setList( List<Shape> shapeList){
		this.shapeList = shapeList;
	}
	
	
	/**
	 * Resets the canvas.
	 */
	public void reset(){
		shapeList.clear();
		this.repaint();
	}
	
	public void setAppear(boolean appear){
		this.appear = appear;
	}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){
		
		// Reset the canvas
		g.setColor(Color.white);
		g.fillRect (0, 0, getWidth(), getHeight());

		// Print all objects in the list
		if (appear){
			Iterator<Shape> itr = shapeList.iterator();
	    	while (itr.hasNext())
	    		itr.next().draw(g);
		}
	}


	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		if (e.getKeyChar()=='P'){
			Shape shape;
			shape = new Circle();
			shapeList.add(shape);
			repaint();
		}
		else if (e.getKeyChar()=='U'){
			Iterator<Shape> itr = shapeList.iterator();
	    	while (itr.hasNext()){
	    		;
	    	}
	    	itr.remove();
	    	repaint();
		}
		
		
	}


	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		/*System.out.println(e.getKeyChar());
		if (e.getKeyChar()=='P'){
			Shape shape;
			shape = new Circle();
			shapeList.add(shape);
			repaint();
		}
		else if (e.getKeyChar()=='U'){
			Iterator<Shape> itr = shapeList.iterator();
	    	while (itr.hasNext()){
	    		;
	    	}
	    	itr.remove();
	    	repaint();
		}*/
	}
	
}
