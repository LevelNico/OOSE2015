package med4.game_of_oose.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static BufferedImage[] blocks;
	public static BufferedImage[] backs;
	public static int maxImgCount = 2;
	
	public Images(){
		blocks = new BufferedImage[maxImgCount];
		try {
		blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/pixelbrix.png"));
		blocks[1] = ImageIO.read(getClass().getResourceAsStream("/Blocks/pinky.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		backs = new BufferedImage[1];
		try {
			backs[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/sky.gif"));
			} catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	
}