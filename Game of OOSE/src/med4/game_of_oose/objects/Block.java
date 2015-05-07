package med4.game_of_oose.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import med4.game_of_oose.gamestate.ApplicationState;
import med4.game_of_oose.resources.Images;

public class Block extends Rectangle {
	public static final long serialVersionUID= 1L;
	
	public static final int blockSize = 64;
	private int id;
	
	public Block(int x, int y, int id){
		setBounds(x,y,blockSize,blockSize);
		this.id = id;
	}
	
	public void tick() {
		
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		if(id != 0) {
			g.drawImage(Images.blocks[id-1], x - (int)ApplicationState.xOffset, y - (int)ApplicationState.yOffset, width, height, null);
			
		}
	}
	
	//getters and setters
	public void setID(int id){
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
}
