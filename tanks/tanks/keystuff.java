package tanks;

import java.util.ArrayList;

import javax.swing.plaf.SliderUI;

public class keystuff extends Thread {
	tankPannel pan;
	private boolean running = true;
	private ArrayList<Character> list = new ArrayList<>();
	private double first = System.currentTimeMillis();

	public keystuff(tankPannel p) {
		// TODO Auto-generated constructor stub
		pan = p;
	}

	public void run() {
		// TODO Auto-generated method stub
		while (running) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (System.currentTimeMillis() - first > 100) {
				first = System.currentTimeMillis();
				for (int i = 0; i<list.size();i++) {
					pan.movetank(list.get(i));
				}
			}
		}
	}

	public void add(char c) {
		// TODO Auto-generated method stub
		if(!list.contains(c)){
		System.out.println(c + " added");
		list.add(c);
		}
	}

	public void remove(char c) {
		// TODO Auto-generated method stub
		System.out.println(c + " released");
		list.remove(new Character(c));
	}
}
