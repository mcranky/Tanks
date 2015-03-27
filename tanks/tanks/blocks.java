package tanks;

import java.awt.Graphics;
import java.awt.Image;

public abstract class blocks extends Object {
	protected boolean solid;
	protected Image image;
	public void draw(Graphics g,int x, int y,int heightWidth) {
		g.drawImage(image, x, y, heightWidth, heightWidth, null);
	}
	public boolean isSolid() {
		return solid;
	}
	public Image getImage() {
		return image;
	}
}
