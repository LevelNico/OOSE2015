package med4.game_of_oose.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static BufferedImage[] blocks;
	public static BufferedImage[] backs;
	public static int maxImgCount = 2;
	public static int maxBackCount = 3;
	
	public Images(){
		blocks = new BufferedImage[maxImgCount];
		try {
		blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/pixelbrix.png"));
		blocks[1] = ImageIO.read(getClass().getResourceAsStream("/Blocks/pinky.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		backs = new BufferedImage[maxBackCount];
		try {
			backs[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Background_Back.png"));
			backs[1] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Background_Middle.png"));
			backs[2] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Background_Front.png"));
			} catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	
}