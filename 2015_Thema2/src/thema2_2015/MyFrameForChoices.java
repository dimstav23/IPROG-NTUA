package thema2_2015;

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
import javax.swing.JTextField;

public class MyFrameForChoices extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7470266387152527219L;
	MyWhiteCanvas canvas = new MyWhiteCanvas();
	MyTextField textfield = new MyTextField();
	
	public MyWhiteCanvas getCanvas()
	{
		return canvas;
	}
	
	public MyTextField getTextField()
	{
		return textfield;
	}
	
	
	public void setCanvas(MyWhiteCanvas canvas){
		this.canvas=canvas;
	}
	
	public void setTextField(MyTextField textfield){
		this.textfield=textfield;
	}
	
	public static void main(String[] args){
		new MyFrameForChoices();
	}
	
	
	
	public MyFrameForChoices() throws HeadlessException {
		super("Thema 2 Kanoniki 2015");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(canvas);
		getContentPane().setBackground(Color.WHITE);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(new JLabel("Select Color:"));
		String [] options ={"yellow", "blue"};
		JComboBox<?> combo = new JComboBox<Object>(options);
		combo.addActionListener(this);
		//JTextField textfield = new JTextField(20);
		//textfield.addActionListener(this);
		
		panel.add(combo);
		//panel.add(textfield);
		
		//getContentPane().add(combo,BorderLayout.NORTH);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		//new My3secThread(canvas).start();
		pack();
		
		
		}
		
		@Override
		public void actionPerformed(ActionEvent ev)
		{
			//JTextField textfield = (JTextField)ev.getSource();
			//String text = textfield.getText();
			
			JComboBox<?> combo = (JComboBox<?>)ev.getSource();
			if (combo.getSelectedItem().equals("yellow"))
				canvas.setYellow(true);
			else canvas.setYellow(false);			
			canvas.repaint();
			
		}
		
	}

