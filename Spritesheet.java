package tanks;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Spritesheet {
	BufferedImage mainImg;
	
	public Spritesheet(){
		try{
			mainImg=ImageIO.read( new File ("Tank SpreadSheet.jpg"));
			}
			catch(Exception e){
				System.out.println(" You ShackShum");
			}	
			
	}
	Image Explosion=mainImg.getSubimage(16, 0, 26, 16);
	Image Grass=mainImg.getSubimage(32, 0, 16, 16);
	Image Bullet=mainImg.getSubimage(48, 0, 16, 16);
	Image wallMetal=mainImg.getSubimage(64, 0, 16, 16);
	Image tankGreenUp=mainImg.getSubimage(0, 15, 16, 16);
	Image tankRedUp=mainImg.getSubimage(16, 15,16, 16);
	Image sand=mainImg.getSubimage(32, 15, 16, 16);
	Image tankGreenDown=mainImg.getSubimage(0, 32, 16, 16);
	Image tankRedDown=mainImg.getSubimage(16, 32, 16, 16);
	Image tankGreenLeft=mainImg.getSubimage(0, 48, 16, 16);
	Image tankRedLeft=mainImg.getSubimage(16, 48, 16, 16);
	Image tankGreenRight=mainImg.getSubimage(0, 64, 16, 16);
	Image tankRedRight=mainImg.getSubimage(16, 64, 16, 16);
	public Image getExplosion() {
		// TODO Auto-generated method stub
		return Explosion;
	}
	public Image getGrass(){
		return Grass;
	}
	public Image getBullet(){
		return Bullet;
	}
	public Image GetWallMetal(){
		return wallMetal;
	}
	public Image getTankGreenUp(){
		return tankGreenUp;
	}
	public Image getTankRedUp(){
		return tankRedUp;
	}
	public Image getSand(){
		return sand;
	}
	public Image getTankGreenDown(){
		return tankGreenDown;
	}
	public Image getTankRedDown(){
		return tankRedDown;
	}
	public Image getTankGreenLeft(){
		return tankGreenLeft;
	}
	public Image getTankRedLeft(){
		return tankRedLeft;
	}
	
	

}



