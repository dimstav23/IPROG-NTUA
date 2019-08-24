import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import shapes.Circle;
import shapes.Shape;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Class MyFrame.
 */
public class MyFrame extends JFrame implements KeyListener{

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
		setPreferredSize(new Dimension(500,500));
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addKeyListener(this);

		// Create the objects' list
		shapeList = new ArrayList<Shape>();
		
		
		// Add the canvas and the selection area to the frame
		canvas = new Canvas(shapeList);
		selectionArea = new SelectionArea(canvas);

		getContentPane().add(canvas, BorderLayout.NORTH);
		getContentPane().add(selectionArea, BorderLayout.CENTER);

		// Start the thread that creates the items
		new ShapeThread(canvas, shapeList, selectionArea).run();

		pack();
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
	    		itr.next();
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
