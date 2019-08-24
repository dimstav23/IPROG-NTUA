import java.util.List;

import shapes.*;

/**
 * The Class ShapeThread.
 */
public class ShapeThread extends Thread {
	
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
		while (true){
			// Add new object and repaint
			Shape shape;
			shape = new Circle();
			shapeList.add(shape);
			canvas.repaint();
			
			// Sleep 5 seconds
			mySleep(5000);
			
			// Read the desired number of circles to paint
			String x = selectionArea.getTextArea();
			if (x.length() > 0)
				canvas.setCirclesNumber(Integer.parseInt(x));
			
			// Remove old objects
			while (shapeList.size() >= canvas.getCirclesNumber())
				shapeList.remove(0);
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
}
