import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import shapes.*;

/**
 * The Class Canvas.
 *
 */
public class Canvas extends JPanel implements MouseListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The shapeList. */
	private List<Shape> shapeList;
	
	/** The number of circles. */
	private int circleNumber = 0;
	private int[] rad = new int[100];
	private int[] x = new int[100];
	private int[] y = new int[100];
	private int temprad;
	private boolean yellow ;
	private boolean[] color = new boolean[100];
	 //color2 = new ArrayList;
	/**
	 * Instantiates a new canvas.
	 *
	 * @param shapeList the shape list
	 */
	public Canvas(List<Shape> shapeList) {
		this.shapeList = shapeList;
		setPreferredSize(new Dimension(800,450));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBackground(Color.WHITE);
		setOpaque(true);
		addMouseListener(this);
		this.yellow=true;
		//
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
		int i = 0;
		Iterator<Shape> itr = shapeList.iterator();
	    while (itr.hasNext()){
	    	if (circleNumber == 0){
	    		break;
	    	}
	    	else if (x[i]+2*rad[i]<0){
	    		i++;
	    	}
	    	else{
	    		itr.next().draw(g,x[i],y[i],rad[i],color[i]);
	    		i++;
	    	}
	    }
	}

	public void setRad(int new_rad)
	{
		temprad = new_rad;
		System.out.println(temprad);
		//rad[circleNumber] = new_rad;
		//System.out.println(rad);
		//System.out.println(new_rad);
		//repaint();
	}
	
	public void move_cycles(){
		int i;
		for (i=0;i<circleNumber;i++){
			x[i]-=10;
		}
		repaint();
	
	}
	
	public void setYellow(boolean yellow)
	{
		this.yellow = yellow;
	}
	
	public void mouseClicked(MouseEvent ev) {
		// TODO Auto-generated method stub
		//System.out.println(circleNumber);
		Shape shape;
		shape = new Circle();
		this.shapeList.add(shape);
		color[circleNumber] = this.yellow;
		rad[circleNumber] = temprad;
		x[circleNumber]=ev.getX();
		y[circleNumber]=ev.getY();
		this.circleNumber++;
		System.out.println(this.circleNumber);
		repaint();
	}


	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
