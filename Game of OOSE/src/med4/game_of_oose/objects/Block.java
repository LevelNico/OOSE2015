package med4.game_of_oose.objects;

import java.awt.Graphics;
import java.awt.Rectangle;

import med4.game_of_oose.gamestate.ApplicationState;

public class Block extends Rectangle {
	public static final long serialVersionUID= 1L;
	
	public static final int blockSize = 64;
	public Block(int x, int y){
		setBounds(x,y,blockSize,blockSize);
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g){
		g.fillRect(x - (int)ApplicationState.xOffset, y - (int)ApplicationState.yOffset, width, height);
	}
}
