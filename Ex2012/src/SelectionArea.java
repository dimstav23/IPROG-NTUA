import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * The Class SelectionArea.
 */
public class SelectionArea  extends JPanel implements ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The text. */
	private JTextArea text;

	/** The canvas. */
	private Canvas canvas;


	/**
	 * Instantiates a new selection area.
	 *
	@param canvas the canvas
	 */
	public SelectionArea(Canvas canvas) {
		setPreferredSize(new Dimension(800,150));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.canvas = canvas;

		text = new JTextArea(1,10);
		text.setText("5");
		JScrollPane scrollPane = new JScrollPane(text); 
		add(scrollPane);
		
		JButton button=new JButton("Reset");
		button.addActionListener(this);
		add(button);
	}
	
	/**
	 * Gets the text area.
	 *
	@return the text area
	 */
	public String getTextArea() {
		return text.getText();
	}

	//@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() instanceof JButton) {
			canvas.reset();
		}		
	}


	
}
