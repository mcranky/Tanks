package tanks;

import java.util.ArrayList;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class tankWold extends World<blocks> {
	private static int gridsize = 30;
	private Spritesheet sheet = new Spritesheet();

	public tankWold() {
		super(new BoundedGrid<blocks>(gridsize, gridsize));
		fill();
	}

	@Override
	public void step() {
		Grid<blocks> g = getGrid();
		locationClicked(new Location(0, 0));
	}

	private void fill() {
		//add randomly to the world
		Grid<blocks> g = this.getGrid();
		for (int r = 0; r < g.getNumRows(); r++) {
			for (int c = 0; c < g.getNumCols(); c++) {
				Location loc = new Location(r, c);
				add(loc, new grass(sheet.getGrass()));
			}
		}
		Location loc = new Location(14, 14);
		add(loc, new wall(sheet.GetWallMetal()));
		loc = new Location(14, 15);
		add(loc, new wall(sheet.GetWallMetal()));
		loc = new Location(15, 15);
		add(loc, new wall(sheet.GetWallMetal()));
		loc = new Location(15, 14);
		add(loc, new wall(sheet.GetWallMetal()));

		for (int i = 0; i < g.getNumCols(); i++) {
			loc = new Location(0, i);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(g.getNumRows() - 1, g.getNumCols() - i - 1);
			add(loc, new wall(sheet.GetWallMetal()));
		}
		for (int i = 0; i < g.getNumRows(); i++) {
			loc = new Location(i, 0);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(g.getNumRows() - 1 - i, g.getNumCols() - 1);
			add(loc, new wall(sheet.GetWallMetal()));
		}
		for (int i = 0; i < 6; i++) {
			loc = new Location(5, i + 12);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 12, 5);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(24, i + 12);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 12, 24);
			add(loc, new wall(sheet.GetWallMetal()));
		}
		for (int i = 0; i < 5; i++) {
			loc = new Location(10, i + 8);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 8, 10);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(10, i + 17);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 8, 19);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(19, i + 8);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 17, 10);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(19, i + 17);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 17, 19);
			add(loc, new wall(sheet.GetWallMetal()));
		}
		for (int i = 0; i < 5; i++) {
			loc = new Location(10, i + 8);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 8, 10);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(10, i + 17);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 8, 19);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(19, i + 8);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 17, 10);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(19, i + 17);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 17, 19);
			add(loc, new wall(sheet.GetWallMetal()));
		}
		for (int i = 0; i < 3; i++) {
			loc = new Location(3, i + 3);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 3, 3);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(3, i + 24);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 3, 26);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(26, i + 3);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 24, 3);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(26, i + 24);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 24, 26);
			add(loc, new wall(sheet.GetWallMetal()));
		}
		for (int i = 0; i < 2; i++) {
			loc = new Location(7, i + 6);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 6, 7);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(7, i + 22);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 6, 22);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(22, i + 6);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 22, 7);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(22, i + 22);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(i + 22, 22);
			add(loc, new wall(sheet.GetWallMetal()));
		}
	}

	private void swap(Location one, Location loc) {
		blocks Oone = this.getGrid().get(one);
		this.getGrid().put(one, this.getGrid().get(loc));
		this.getGrid().put(loc, Oone);

	}
}
