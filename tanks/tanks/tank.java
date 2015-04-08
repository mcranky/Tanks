package tanks;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class tank {
	private int score = 48;
	private Image tankup = null;
	private Image tankrihgt = null;
	private Image tankdown = null;
	private Image tankleft = null;
	private Location location;
	private int directoin = 0;
	private int speed = 4;
	private Grid<blocks> grid = null;
	private Graphics g;

	public tank(Location loc, Image image, Image image2, Image image3, Image image4, Grid<blocks> g) {
		// TODO Auto-generated constructor stub
		location = loc;
		tankup = image;
		tankrihgt = image2;
		tankdown = image3;
		tankleft = image4;
		grid = g;
	}

	public void move(int dir) {
		directoin = dir;

		switch (dir) {
		case 0:
			if (grid.get(new Location((location.getRow() - speed) / 16, location.getCol() / 16)).isSolid()) {
				return;
			}
			location = new Location(getLocation().getRow() - speed, getLocation().getCol());
			break;
		case 1:
			if (grid.get(new Location(location.getRow() / 16, (location.getCol() + 16) / 16)).isSolid()) {
				return;
			}
			location = new Location(getLocation().getRow(), getLocation().getCol() + speed);
			break;
		case 2:
			if (grid.get(new Location((location.getRow() + 16) / 16, location.getCol() / 16)).isSolid()) {
				return;
			}
			location = new Location(getLocation().getRow() + speed, getLocation().getCol());
			break;
		case 3:
			if (grid.get(new Location(location.getRow() / 16, (location.getCol() - speed) / 16)).isSolid()) {
				return;
			}
			location = new Location(getLocation().getRow(), getLocation().getCol() - speed);
			break;
		default:
			break;
		}

	}

	public void shoot(tank p1) {
		Bullet3 bulet = new Bullet3(directoin, location, grid, g, p1);
	}

	public void draw(Graphics g, int heightwidth) {
		if (this.g == null) this.g = g;
		BufferedImage temp = ((BufferedImage) getimage());
		for (int i = 0; i < temp.getWidth(); i++) {
			for (int j = 0; j < temp.getHeight(); j++) {
				Color pixel = new Color(temp.getRGB(i, j));
				g.setColor(pixel);
				if (!(pixel.getRed() < 10 && pixel.getGreen() < 255 && pixel.getGreen() > 240 && pixel.getBlue() < 60 && pixel.getBlue() > 40)) {
					g.drawLine(location.getCol() + i, location.getRow() + j, location.getCol() + i, location.getRow() + j);
				}
			}
		}
	}

	public int getscore() {
		return score;

	}

	public void reducescore() {
		if (score > 0) {
			score--;

		}

	}

	public Location getLocation() {
		return location;
	}

	private Image getimage() {
		switch (directoin) {
		case 0:
			return tankup;
		case 1:

			return tankrihgt;
		case 2:

			return tankdown;
		case 3:

			return tankleft;

		default:
			break;
		}
		return null;
	}
}
