package tanks;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Spritesheet {
	private BufferedImage mainImg;
	private static Image Explosion;
	private static Image Grass;
	private static Image Bullet;
	private static Image wallMetal;
	private static Image tankGreenUp;
	private static Image tankRedUp;
	private static Image sand;
	private static Image tankGreenDown;
	private static Image tankRedDown;
	private static Image tankGreenLeft;
	private static Image tankRedLeft;
	private static Image tankGreenRight;
	private static Image tankRedRight;

	public Spritesheet() {
		try {
			//mainImg = ImageIO.read(new File("tanks/tanks/Tank SpreadSheet.jpg"));
			mainImg = ImageIO.read(Spritesheet.class.getResourceAsStream("/Tank SpreadSheet.jpg"));
		} catch (Exception e) {
			System.out.println(" You suck trey");
		}
		Explosion = mainImg.getSubimage(16, 0, 26, 16);
		Grass = mainImg.getSubimage(32, 0, 16, 16);
		Bullet = mainImg.getSubimage(48, 0, 16, 16);
		wallMetal = mainImg.getSubimage(64, 0, 16, 16);
		tankGreenUp = mainImg.getSubimage(0, 15, 16, 16);
		tankRedUp = mainImg.getSubimage(16, 15, 16, 16);
		sand = mainImg.getSubimage(32, 15, 16, 16);
		tankGreenDown = mainImg.getSubimage(0, 32, 16, 16);
		tankRedDown = mainImg.getSubimage(16, 32, 16, 16);
		tankGreenLeft = mainImg.getSubimage(0, 48, 16, 16);
		tankRedLeft = mainImg.getSubimage(16, 48, 16, 16);
		tankGreenRight = mainImg.getSubimage(0, 64, 16, 16);
		tankRedRight = mainImg.getSubimage(16, 64, 16, 16);

	}

	public Image getExplosion() {
		// TODO Auto-generated method stub
		return Explosion;
	}

	public Image getGrass() {
		return Grass;
	}

	public Image getBullet() {
		return Bullet;
	}

	public Image GetWallMetal() {
		return wallMetal;
	}

	public Image getTankGreenUp() {
		return tankGreenUp;
	}

	public Image getTankRedUp() {
		return tankRedUp;
	}

	public Image getSand() {
		return sand;
	}

	public Image getTankGreenDown() {
		return tankGreenDown;
	}

	public Image getTankRedDown() {
		return tankRedDown;
	}

	public Image getTankGreenLeft() {
		return tankGreenLeft;
	}

	public Image getTankRedLeft() {
		return tankRedLeft;
	}

	public Image getTankGreenRight() {
		return tankGreenRight;
	}

	public Image getTankRedRight() {
		return tankRedRight;
	}

}
