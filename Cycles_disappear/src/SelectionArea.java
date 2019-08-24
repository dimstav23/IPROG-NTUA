import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import shapes.Circle;
import shapes.Shape;

/**
 * The Class SelectionArea.
 */
public class SelectionArea  extends JPanel implements ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The canvas. */
	private Canvas canvas;


	/**
	 * Instantiates a new selection area.
	 *
	@param canvas the canvas
	 */
	public SelectionArea(Canvas canvas) {
		setPreferredSize(new Dimension(500,500));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.canvas = canvas;
	}
	//@Override


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	


	
}
