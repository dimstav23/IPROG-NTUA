import java.util.Iterator;
import java.util.List;

import shapes.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * The Class ShapeThread.
 */
public class ShapeThread extends Thread implements KeyListener{
	
	/** The canvas. */
	public final Canvas canvas; 
	
	/** The shape list. */
	private List<Shape> shapeList;

	/** The selection area. */
	private SelectionArea selectionArea;


	/**
	 * Instantiates a new shape thread.
	 *
	@param canvas the canvas
	 * @param shapeList the shape list
	 * @param selectionArea the selection area
	 */
	public ShapeThread(Canvas canvas, List<Shape> shapeList, SelectionArea selectionArea) {
		this.shapeList = shapeList;
		this.selectionArea = selectionArea;
		this.canvas = canvas;
		this.setDaemon(true);
		
	}


	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		boolean appear = false;
		while (true){
			// Add new object and repaint
			appear = !appear;
			canvas.setAppear(appear);
			
			//Shape shape;
			//shape = new Circle();
			//shapeList.add(shape);
			//canvas.repaint();
			
			// Sleep 5 seconds
			mySleep(2000);
			// Remove old objects
			canvas.repaint();
		}
	}
	
	
	/**
	 * My sleep.
	 *
	@param time the time
	 */
	private void mySleep(int time) {
		try {
			sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}


	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.shapeList = canvas.getList();
		System.out.println(e.getKeyChar());
		if (e.getKeyChar()=='P'){
			Shape shape;
			shape = new Circle();
			shapeList.add(shape);
		}
		else if (e.getKeyChar()=='U'){
			Iterator<Shape> itr = shapeList.iterator();
	    	while (itr.hasNext()){
	    		;
	    	}
	    	itr.remove();
	  	}
		canvas.setList(this.shapeList);
		canvas.repaint();
	}


	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
