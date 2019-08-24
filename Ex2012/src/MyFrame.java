import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import shapes.Shape;


/**
 * The Class MyFrame.
 */
public class MyFrame extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The canvas. */
	Canvas canvas;
	
	/** The selection area. */
	SelectionArea selectionArea;
	
	/** The objects list. */
	List<Shape> shapeList;
	
	/**
	 * The main method.
	 *

	@param args the arguments
	 */
	public static void main(String[] args) {
		new MyFrame();
	}

	/**
	 * Instantiates a new my frame.
	 *

	@throws HeadlessException the headless exception
	 */
	public MyFrame() throws HeadlessException {
		super("2h askhsh");
		setPreferredSize(new Dimension(800,600));
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// Create the objects' list
		shapeList = new ArrayList<Shape>();
		
		
		// Add the canvas and the selection area to the frame
		canvas = new Canvas(shapeList);
		selectionArea = new SelectionArea(canvas);

		getContentPane().add(canvas, BorderLayout.NORTH);
		getContentPane().add(selectionArea, BorderLayout.CENTER);

		// Start the thread that creates the items
		new ShapeThread(canvas, shapeList, selectionArea).start();

		pack();
	}

}
