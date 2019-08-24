package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements KeyListener{
	
	static Canvas canvas;
	
	
	public MyFrame() throws HeadlessException {
		super("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
		//this.setSize(600, 800);
		canvas = new Canvas(this);
		getContentPane().add(canvas,BorderLayout.SOUTH);
		this.addKeyListener(this);
		this.setVisible(true);
		pack();
	}

	public static void main(String[] args) {
		new MyFrame();
	}



	//@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar()=='A')canvas.newc();
		if (e.getKeyChar()=='R')canvas.delc();
	}

}

