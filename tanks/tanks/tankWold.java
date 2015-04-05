package tanks;

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
		for (int i = 0; i < g.getNumCols(); i++) {
			Location loc = new Location(0, i);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(g.getNumRows() - 1, g.getNumCols() - i - 1);
			add(loc, new wall(sheet.GetWallMetal()));
		}
		for (int i = 0; i < g.getNumRows(); i++) {
			Location loc = new Location(i, 0);
			add(loc, new wall(sheet.GetWallMetal()));
			loc = new Location(g.getNumRows() - 1 - i, g.getNumCols() - 1);
			add(loc, new wall(sheet.GetWallMetal()));
		}
		

	}

	private void swap(Location one, Location loc) {
		blocks Oone = this.getGrid().get(one);
		this.getGrid().put(one, this.getGrid().get(loc));
		this.getGrid().put(loc, Oone);

	}
}
