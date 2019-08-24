package thema2_2015;

import thema2_2015.MyWhiteCanvas;

public class My3secThread extends Thread {
	
	public final MyWhiteCanvas canvas;
	
	public My3secThread(MyWhiteCanvas canvas)
	{
		this.canvas = canvas;
		this.setDaemon(true);
		
	}
 public void run(){
	 while(true)
	 {
		 try{ System.out.println("going to sleep ...");
		 sleep(3000);
		 }catch (InterruptedException e){
			 System.out.println("sleep interrupted");
			 e.printStackTrace();
		 }
		 System.out.println("woke up");
		 //canvas.reset();
		 //canvas.repaint();
		 
	 }
 }
}
