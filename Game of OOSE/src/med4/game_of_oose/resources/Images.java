package med4.game_of_oose.resources;
 
import java.awt.image.BufferedImage;
import java.io.IOException;
 
import javax.imageio.ImageIO;
 
public class Images {
       
        public static BufferedImage[] blocks;
        public static BufferedImage[] backs;
        public static int maxImgCount = 14;
        public static int maxBackCount = 3;
       
        public Images(){
                blocks = new BufferedImage[maxImgCount];
                try {
                blocks[0] = ImageIO.read(getClass().getResourceAsStream("/Blocks/SurfaceTop.png"));
                blocks[1] = ImageIO.read(getClass().getResourceAsStream("/Blocks/OctopusColor.png"));
                blocks[2] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Crab.png"));
                blocks[3] = ImageIO.read(getClass().getResourceAsStream("/Blocks/IndifferentCrab.png"));
                blocks[4] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Enemy1.1.png"));
                blocks[5] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Enemy1.2.png"));
                blocks[6] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Enemy1.3.png"));
                blocks[7] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Enemy1.4.png"));
                blocks[8] = ImageIO.read(getClass().getResourceAsStream("/Blocks/JuiceBox1.png"));
                blocks[9] = ImageIO.read(getClass().getResourceAsStream("/Blocks/MovingBlock.png"));
                blocks[10] = ImageIO.read(getClass().getResourceAsStream("/Blocks/SurfaceNoTop.png"));
                blocks[11] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Fish_1.png"));
                blocks[12] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Fish_2.png"));
                blocks[13] = ImageIO.read(getClass().getResourceAsStream("/Blocks/Fish_3.png"));
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
