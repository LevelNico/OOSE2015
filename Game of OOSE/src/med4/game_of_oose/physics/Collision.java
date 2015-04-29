package med4.game_of_oose.physics;

import java.awt.Point;

import med4.game_of_oose.objects.Block;
import med4.game_of_oose.objects.MovingBlock;

public class Collision {
	public static boolean playerBlock(Point p, Block b) {
		return b.contains(p); //if the point is within the block this boolean will be true.
	}
	
	public static boolean playerMovingBlock(Point p, MovingBlock b){
		return b.contains(p);
	}
}
