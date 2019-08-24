package thema2_2015;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class MyWhiteCanvas extends JLabel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6920203360072106894L;
	private int x = -1;
	private int y = -1;
	public static int rad = 50;
	
	private boolean yellow = true;
	
	public MyWhiteCanvas(){
		setPreferredSize(new Dimension(700, 700));
		addMouseListener(this);
	}
	
	public void paint(Graphics g)
	{	
		Graphics gui = (Graphics) g;
		//System.out.println(rad);
		if(x<0)
			reset();
		if(yellow){
			gui.setColor(Color.yellow);
			gui.drawOval( x-rad, y-rad, 2*rad, 2*rad);
		}
		else {
			gui.setColor(Color.blue);
			gui.drawOval(x-rad,  y-rad , 2*rad, 2*rad);
		}
	}
	
	public void reset()
	{
		x=getWidth()/2;
		y=getHeight()/2;
	}
	
	public boolean isYellow()
	{
		return yellow;
	}

	public void setYellow(boolean yellow)
	{
		this.yellow = yellow;
	}
	
	public int newRad()
	{
		return rad;
	}
	
	public void setRad(int new_rad)
	{
		rad = new_rad;
		//System.out.println(rad);
		//System.out.println(new_rad);
		repaint();
	}
	

	@Override 
	public void mouseClicked(MouseEvent ev)
	{
		x=ev.getX();
		y=ev.getY();
		
		repaint();
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0)
	{
		
	}
	
	@Override 
	public void mousePressed(MouseEvent arg0)
	{
		
	}
	
	@Override 
	public void mouseReleased(MouseEvent arg0)
	{
		
	}
}
