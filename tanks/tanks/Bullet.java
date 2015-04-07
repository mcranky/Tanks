package tanks;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Bullet {
	private int dir;
	private Location x;
	private Grid<blocks> grid;
	private BufferedImage mainImg;
	private static Image Explosion;
	private static Image Bullet;
	private Graphics g;
	private Spritesheet sheet = new Spritesheet();

	public Bullet(int dir, Location y, Grid<blocks> gr, Graphics g) {
		this.dir = dir;
		x = y;
		grid = gr;
		this.g = g;
		shoot();
	}

	private void shoot() {

		if (dir == 0) {
			while (true) {
				if (grid.get(new Location((x.getRow() / 16) - 1, x.getCol() / 16)).isSolid() == true) {
					explode();
					return;
				} else
					x = new Location(x.getRow() - 1, x.getCol());
				draw();
			}
		}

		if (dir == 1) {
			while (true) {
				if (grid.get(new Location(x.getRow() / 16, (x.getCol() / 16) + 1)).isSolid() == true) {
					explode();
					return;
				} else
					x = new Location(x.getRow(), x.getCol() + 1);
				draw();
			}
		}

		if (dir == 2) {
			while (true) {
				if (grid.get(new Location((x.getRow() / 16) + 1, x.getCol() / 16)).isSolid() == true) {
					explode();
					return;
				} else
					x = new Location(x.getRow() + 1, x.getCol());
				draw();
			}
		}

		if (dir == 3) {
			while (true) {
				if (grid.get(new Location(x.getRow() / 16, (x.getCol() / 16) - 1)).isSolid() == true) {
					explode();
					return;
				} else
					x = new Location(x.getRow(), x.getCol() - 1);
				draw();
			}
		}
	}

	private void explode() {
		// TODO Auto-generated method stub
		g.drawImage(sheet.getExplosion(), x.getCol(), x.getRow(), 16, 16, null);
		System.out.println("elplosion at"+ x.getCol()+" "+  x.getRow());
	}

	private void draw() {
		// TODO Auto-generated method stub
		g.drawImage(sheet.getBullet(), x.getCol(), x.getCol(), 16, 16, null);

	}

}
