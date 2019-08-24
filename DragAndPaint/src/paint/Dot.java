package paint;

import paint.Canvas;

public class Dot extends Thread {

	Canvas canvas;
	int interval;
	int r,x,y;
	boolean isLast = true;

	public Dot(Canvas c, int x, int y, int r) {
		super();
		this.canvas = c;
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public void run(){
		while(true){
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			this.r = 10;

			canvas.repaint();

			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			while (isLast);

			this.r = 5;
			canvas.repaint();
			break;

		}
	}

}