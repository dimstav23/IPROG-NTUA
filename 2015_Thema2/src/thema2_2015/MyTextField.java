package thema2_2015;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyTextField extends JTextField implements ActionListener{
	public int rad;
	public MyTextField(){
		setPreferredSize(new Dimension(700, 40));
		addActionListener(this);
	}
	
	MyWhiteCanvas canvas = new MyWhiteCanvas();
	
	
	public MyWhiteCanvas getCanvas()
	{
		return canvas;
	}
	
	
	public void setCanvas(MyWhiteCanvas canvas){
		this.canvas=canvas;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ev)
	{
		
		JTextField textfield = (JTextField)ev.getSource();
		String text = textfield.getText();
		canvas.setRad(Integer.parseInt(text));
		//canvas.paint(g2);
		//JComboBox<?> combo = (JComboBox<?>)ev.getSource();
		//if (combo.getSelectedItem().equals("yellow"))
		//	canvas.setYellow(true);
		//else canvas.setYellow(false);			
		canvas.repaint();
		//System.out.println(text);
	}
	
	
}