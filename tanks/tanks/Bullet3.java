package tanks;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Bullet3 {
	private int dir;
	private Location x;
	private Grid<blocks> grid;
	private Image Explosion;
	private Image Bullet;
	private Graphics g;
	private Spritesheet sheet = new Spritesheet();
<<<<<<< HEAD
	private  tank enemy1;
	
	public Bullet3(int dir, Location y,Grid<blocks> gr,Graphics g,tank p1) {
		this.dir=dir;
		x=y;
=======
	private tank enemy1;
	private boolean shooting = true;

	public Bullet3(int dir, Location y, Grid<blocks> gr, Graphics g, tank p1) {
		this.dir = dir;
		x = y;
>>>>>>> origin/master
		grid = gr;
		this.g = g;
		enemy1 = p1;
		shoot();
	}

	private void shoot() {
		if (dir == 0) {
			x.getAdjacentLocation(Location.NORTH);
			while (shooting) {
				if (grid.get(new Location((x.getRow() / 16) - 1, (x.getCol() / 16))).isSolid() == true) {
					explode();
					return;
				} else
					x = new Location(x.getRow() - 1, x.getCol());
				//draw();
				tankHit();
			}
		}

		if (dir == 1) {
			x.getAdjacentLocation(Location.EAST);

			while (shooting) {
				if (grid.get(new Location((x.getRow() / 16), (x.getCol() / 16) + 1)).isSolid() == true) {
					explode();
					return;
				} else
					x = new Location(x.getRow(), x.getCol() + 1);
				//draw();
				tankHit();
			}
		}

		if (dir == 2) {
			x.getAdjacentLocation(Location.SOUTH);
			while (shooting) {
				if (grid.get(new Location((x.getRow() / 16) + 1, (x.getCol() / 16))).isSolid() == true) {
					explode();
					return;
				} else
					x = new Location(x.getRow() + 1, x.getCol());
				//draw();
				tankHit();
			}
		}

		if (dir == 3) {
			x.getAdjacentLocation(Location.WEST);
			while (shooting) {
				if (grid.get(new Location((x.getRow() / 16), (x.getCol() / 16) - 1)).isSolid() == true) {
					explode();
					return;
				} else
					x = new Location(x.getRow(), x.getCol() - 1);
				//draw();
				tankHit();
			}
		}
	}

	private void explode() {
		// TODO Auto-generated method stub
		//g.drawImage(sheet.getExplosion(), x.getCol(), x.getRow(), 16, 16, null);
		System.out.println("explosion at" + x.getCol() + " " + x.getRow());

	}

	private void draw() {
		// TODO Auto-generated method stub
		g.drawImage(sheet.getBullet(), x.getCol(), x.getCol(), 16, 16, null);

	}

	private void tankHit() {
		System.out.println("bullet at" + x.getCol() / 16 + " " + x.getRow() / 16 + " " + enemy1.getLocation());
		if ((new Location(enemy1.getLocation().getCol() / 16, enemy1.getLocation().getRow() / 16)).equals(new Location(x.getCol() / 16, x.getRow() / 16))) {
			System.out.println("tank hit\n\n\n\n\n\n");
			this.explode();
			enemy1.reducescore();
			shooting = false;
		}
	}

}
