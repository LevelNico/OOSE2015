package med4.game_of_oose.entities;


import java.awt.Graphics;
import java.awt.Rectangle;

import med4.game_of_oose.gamestate.ApplicationState;
import med4.game_of_oose.objects.Block;
import med4.game_of_oose.resources.Images;

public class BasicEnemy  extends Rectangle{
	private static final long serialVersionUID = 1L;
	
	private int leftBound, rightBound;
	private int move = 1;
	private int id;
	
	public BasicEnemy(int x, int y, int id, int leftBound, int rightBound, int xSize, int ySize){
		setBounds(x, y, xSize * Block.blockSize, ySize * Block.blockSize);
		this.id = id;
		//this.width = xSize * Block.blockSize;
		//this.height = ySize * Block.blockSize;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
		
	}
	
	public void tick(){
		//hits rightBound
		if(x + width - ApplicationState.xOffset >= rightBound - ApplicationState.xOffset && move != -1) {
			move *= -1;
		}
		//hits leftbound
		if(x - ApplicationState.xOffset <= leftBound - ApplicationState.xOffset && move != 1) {
			move *= -1;
		}
		
		x += move;
		
	}
	
	public void draw(Graphics g) {
		if(id != 0) {
			g.drawImage(Images.blocks[id - 1], x - (int)ApplicationState.xOffset, y - (int)ApplicationState.yOffset, width, height, null);
		}
	}
	
	public int getMove(){
		return move;
	}
	
	public int getID(){
		return id;
	}
}
