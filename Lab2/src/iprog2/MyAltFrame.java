package iprog2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MyAltFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3469566152115637966L;
	Canvas canvas = new Canvas();
	MyThread timer;

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	public static void main(String[] args) {
		new MyFrame();

	}

	public MyAltFrame() throws HeadlessException {
		super("This is my frame");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(canvas);
		
		timer = new MyThread(canvas);
		timer.start();
				
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel.add(new JLabel("Select shape: "));
		
		
		String [] options = {"circle", "square"};

		JRadioButton circleButton = new JRadioButton(options[0]);
		circleButton.setActionCommand(options[0]);
		circleButton.setSelected(true);
		
		JRadioButton squareButton = new JRadioButton(options[1]);
		squareButton.setActionCommand(options[1]);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(circleButton);
	    group.add(squareButton);
	    
	    circleButton.addActionListener(this);
	    squareButton.addActionListener(this);
	    
		panel.add(circleButton);
		panel.add(squareButton);
		
		panel.add(new JLabel("Set sleeping time: "));
		JTextField text = new JTextField(20);
		//text.setText(""+timer.getSleepingTime());
		text.addActionListener(this);
		panel.add(text);
		
		getContentPane().add(panel, BorderLayout.NORTH);
		pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JRadioButton){
			if (ev.getActionCommand().equals("circle"))
				canvas.setCircle(true);
			else canvas.setCircle(false);
			canvas.repaint();
		}
	else if(ev.getSource() instanceof JTextField){
			try{
//				timer.setSleepingTime(Integer.parseInt(((JTextField)ev.getSource()).getText()));
			}catch(NumberFormatException ex){
				
			}
		}
	}
}
