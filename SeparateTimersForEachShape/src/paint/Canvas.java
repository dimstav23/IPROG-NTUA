package paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JFrame;
import javax.swing.JLabel;

import paint.circle;

public class Canvas extends JLabel {
	
	List<circle> circles = new ArrayList<circle>();
	int col = 0;
	MyFrame frame;
	

	public Canvas(MyFrame sfram) {
		super();
		frame = sfram;
		this.setPreferredSize(new Dimension(500,500));
	}

	@Override
	public void paint(Graphics g) {
		circle cur;
		for(int i=0;i<circles.size();i++){
			cur = circles.get(i);
			g.setColor(Color.yellow);
			g.fillRect(cur.x, cur.y, cur.r, cur.r);
			//g.drawRect(cur.x, cur.y, cur.r, cur.r);
		}
	}
	
	


	

	public void newc() {
		circle next = new circle(this);
		circles.add(next);
		next.start();
		this.repaint();
	}
	
	public void delc() {
		if (circles.size()!=0){
			circles.remove(circles.size()-1);
			this.repaint();
		}
	}


	
	
	

}
