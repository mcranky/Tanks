package tanks;

import javax.swing.JFrame;

public class tankFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public tankFrame(tankWold tankWorld) {
		super("Tank on Tank...Hardcore");
		makeToolbar();// so you can make a toolbar, like "real" apps

		// the JwlPanel is where the Jwls and other stuff will
		// be displayed.  The code to display stuff is triggered in 
		// the     paintComponent(Graphics g) method we are overriding
		this.add(new tankPannel(tankWorld));
		this.pack();
		this.validate();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void add(tankPannel tankPanel) {
		// TODO Auto-generated method stub
		super.add(tankPanel);
	}

	private void makeToolbar() {
		// TODO Auto-generated method stub

	}
}
