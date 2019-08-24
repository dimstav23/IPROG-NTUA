package iprog2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7470266387152527219L;
	Canvas canvas = new Canvas();
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public void setCanvas(Canvas canvas){
		this.canvas=canvas;
	}
	public static void main(String[] args){
		new MyFrame();
	}
	
	public MyFrame() throws HeadlessException {
		super("This is my frame");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(canvas);
		//getContentPane().setBackground(Color.YELLOW);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(new JLabel("Select Shape:"));
		String [] options ={"circle", "square"};
		JComboBox<?> combo = new JComboBox<Object>(options);
		combo.addActionListener(this);
		panel.add(combo);
		getContentPane().add(panel, BorderLayout.NORTH);
		new MyThread(canvas).start();
		pack();
		
		
		}
		
		@Override
		public void actionPerformed(ActionEvent ev)
		{
			JComboBox<?> combo = (JComboBox<?>)ev.getSource();
			if (combo.getSelectedItem().equals("circle"))
				canvas.setCircle(true);
			else canvas.setCircle(false);
			canvas.repaint();
		}
		
	}

