package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JLabel;


public class Canvas extends JLabel implements MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int x = -1;
	private int y = -1;
	public ArrayList<Dot> arr = new ArrayList<Dot>();
	public int created = 0;
	public Color col = Color.white;
	public boolean swap;


	public Canvas() {
		setPreferredSize(new Dimension(500,500));
		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		for (int i = 0; i < arr.size(); i++) {
			Dot temp = arr.get(i);
			g.setColor(Color.gray);
			g.fillOval(temp.x-temp.r, temp.y-temp.r, 2 * temp.r, 2 * temp.r);
		}
	}


	//@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		Dot d = new Dot(this, x,y,5);
		if (created > 0){
			int i = arr.size()-1;
			arr.get(i).isLast = false;
		}
		arr.add(d);	
		d.start();
		created++;
		repaint();
	}

	//@Override
	public void mouseMoved(MouseEvent e) {
	}
}
