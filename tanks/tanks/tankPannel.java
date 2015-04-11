package tanks;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.CHAR_ARRAY;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class tankPannel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	tankWold tankWorld;
	int boxHeightWidth = 16;
	private boolean showScore = false;
	private Image img = null;
	private Image img2 = null;
	private Image img3 = null;
	private Image img4 = null;
	private double time = 0;
	private boolean one = false;
	private Location first = null;
	private Spritesheet sheet = new Spritesheet();
	private tank p1;
	private tank p2;
	private keystuff key = new keystuff(this);

	public tankPannel(tankWold tankWorld) {
		this.tankWorld = tankWorld;
		p1 = new tank(new Location(boxHeightWidth * tankWorld.getGrid().getNumCols() - (boxHeightWidth * 3), boxHeightWidth), sheet.getTankGreenUp(), sheet.getTankGreenRight(), sheet.getTankGreenDown(), sheet.getTankGreenLeft(), tankWorld.getGrid());
		p2 = new tank(new Location(boxHeightWidth, boxHeightWidth * tankWorld.getGrid().getNumCols() - (boxHeightWidth * 3)), sheet.getTankRedUp(), sheet.getTankRedRight(), sheet.getTankRedDown(), sheet.getTankRedLeft(), tankWorld.getGrid());
		this.setPreferredSize(new Dimension(boxHeightWidth * tankWorld.getGrid().getNumCols() - boxHeightWidth, boxHeightWidth * tankWorld.getGrid().getNumRows() - boxHeightWidth));
		repaint();
		key.start();
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				key.add((e.getKeyChar()));
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				key.remove((arg0.getKeyChar()));
			};
		});
	}

	public void movetank(char c) {
		if (c == 'w') {
			p1.move(0);
		}
		if (c == 'e') {
			p1.shoot(p2);
		}
		if (c == 'a') {
			p1.move(3);
		}
		if (c == 's') {
			p1.move(2);
		}
		if (c == 'd') {
			p1.move(1);
		}
		if (c == 'p') {
			p2.shoot(p1);
		}
		if (c == 'o') {
			p2.move(0);
		}
		if (c == 'k') {
			p2.move(3);
		}
		if (c == 'l') {
			p2.move(2);
		}
		if (c == ';') {
			p2.move(1);
		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Grid<blocks> grid = this.tankWorld.getGrid();

		draw(grid, g);
		drawscore(g);
		drawExtraStuff(g);
		this.requestFocusInWindow();
	}

	private void draw(Grid<blocks> grid, Graphics g) {
		for (int i = 0; i < grid.getNumRows(); i++) {
			for (int j = 0; j < grid.getNumCols(); j++) {
				grid.get(new Location(i, j)).draw(g, j * boxHeightWidth, i * boxHeightWidth, boxHeightWidth);
			}
		}
	}

	private void drawscore(Graphics g) {
		// Location p1s=new Location(bottomright, bottomright);
		//Location p2s=new Location(bottomrightbellow,bottomrightbellow);
		int l = 432;
		int m = 16;
		if ((p1.getscore()) <= 0 || (p2.getscore()) <= 0) {
			Color c = new Color(0, 0, 0);
			Color w = new Color(250, 250, 250);
			String winner = "Player 1 Won!";
			g.setColor(c);
			g.fillRect(0, 0, 480, 480);
			g.setColor(w);
			if (p1.getscore() <= 0) winner = "Player 2 Won!";
			JLabel jlabel = new JLabel("GameOver " + winner, JLabel.CENTER);
			jlabel.setFont(new Font("Verdana", 0, 20));

			jlabel.setForeground(w);
			this.add(jlabel);
			this.setBorder(new LineBorder(Color.WHITE)); // make it easy to see

		} else {
			for (int i = 0; i < (p1.getscore()); i++) {
				g.drawImage(sheet.getTankGreenRight(), m + l, 448, null);
				m = m - 16;
			}
			m = 16;
			for (int i = 0; i < (p2.getscore()); i++) {
				g.drawImage(sheet.getTankRedRight(), m + l, 432, null);
				m = m - 16;
			}
		}
	}

//	private void drawscore(Graphics g) {
	// Location p1s=new Location(bottomright, bottomright);
	//Location p2s=new Location(bottomrightbellow,bottomrightbellow);
	//	int l = 432;
	//	int m = 16;
	//   for (int i = 0; i < p1.getscore(); i++) {
	//	g.drawImage(sheet.getTankGreenRight(), m + l, 448, null);
	//g.drawImage(sheet.getTankRedRight(), m + l, 432, null);
	//	m = m - 16;
	//}

	//}

	private void drawExtraStuff(Graphics g) {
		p1.draw(g, boxHeightWidth);
		p2.draw(g, boxHeightWidth);
	}

}
