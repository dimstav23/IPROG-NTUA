package paint;


public class MyThread extends Thread {

	public final Canvas canvas;
	private int curr=0;

	public MyThread(Canvas canvas) {
		this.canvas = canvas;
		this.setDaemon(true);
	}
	public void run(){
		while (true){
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");

				e.printStackTrace();
			}
			for (int i=curr; i<canvas.arr.size();i++){
				System.out.println("X="+canvas.arr.get(i).x+"\tY="+canvas.arr.get(i).x);
			}
			curr=canvas.arr.size();
		}
	}


}
