package med4.game_of_oose.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static BufferedImage[] blocks;
	
	public Images(){
		blocks= new BufferedImage[1];
		try {
		blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/pixelbrix.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}