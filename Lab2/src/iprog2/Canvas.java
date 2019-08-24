package iprog2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

public class Canvas extends JLabel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6920203360072106894L;
	private int x = -1;
	private int y = -1;
	private int rad = 50;
	private boolean circle = true;
	
	public Canvas(){
		setPreferredSize(new Dimension(700, 700));
		addMouseListener(this);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		if(x<0)
			reset();
		if(circle)
			g.drawOval( x-rad, y-rad, 2*rad, 2*rad);
		else g.drawRect(x-rad,  y-rad , 2*rad, 2*rad);
	}
	public void reset()
	{
		x=getWidth()/2;
		y=getHeight()/2;
	}
	
	public boolean isCircle()
	{
		return circle;
	}

	public void setCircle(boolean circle)
	{
		this.circle = circle;
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
