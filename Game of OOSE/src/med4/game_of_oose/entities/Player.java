package med4.game_of_oose.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import med4.game_of_oose.gamestate.ApplicationState;
import med4.game_of_oose.gamestate.Level1State;
import med4.game_of_oose.gamestate.Level2State;
import med4.game_of_oose.main.ApplicationPanel;
import med4.game_of_oose.objects.Block;
import med4.game_of_oose.objects.MovingBlock;
import med4.game_of_oose.physics.Collision;

public class Player {
	
	public static int score = 0;
	public boolean dead, goal = false;
	private int lives = 3;
	
	//movement booleans
	private boolean right = false, left = false, jumping = false, falling = false;
	private boolean topCollision = false;
	
	//bounds
	private double x, y;
	private int width, height;
	
	//move speed
	private double moveSpeed = 4;
	
	//Jump speed
	private double jumpSpeed = 8;
	private double currentJumpSpeed = jumpSpeed;
	
	//fall speed
	private double maxFallSpeed = 8;
	private double fallSpeed = 0.2;
	private double currentFallSpeed = fallSpeed;
	
	public Player(int width, int height) {
		x = ApplicationPanel.WIDTH/2;
		y = ApplicationPanel.HEIGHT/2;
		this.width = width;
		this.height = height;
	}
	
public void tick(Block[][] b, ArrayList<MovingBlock> movingBlocks, ArrayList<BasicEnemy> basicEnemies) {
		
		int iX = (int)x;
		int iY = (int)y;
		
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b[0].length; j++){
			if(b[i][j].getID() != 0 && Collision.playerBlock(new Point(iX + (int)ApplicationState.xOffset, iY + (int)ApplicationState.yOffset), b[i][j]) && b[i][j].getID() == 7){
				victory();
			}
			else if(b[i][j].getID() != 0 && b[i][j].getID() != 7){
			//right
			if(Collision.playerBlock(new Point(iX + width + (int)ApplicationState.xOffset, iY + (int)ApplicationState.yOffset + 2), b[i][j])
					|| Collision.playerBlock(new Point(iX + width + (int)ApplicationState.xOffset, iY + height + (int)ApplicationState.yOffset - 2), b[i][j])){
					right=false;
			}
			
			//left
			if(Collision.playerBlock(new Point(iX + (int)ApplicationState.xOffset - 1, iY + (int)ApplicationState.yOffset + 2), b[i][j])
					|| Collision.playerBlock(new Point(iX + (int)ApplicationState.xOffset - 1, iY + height + (int)ApplicationState.yOffset - 2), b[i][j])){
					left=false;
			}
			
			//top
			if(Collision.playerBlock(new Point(iX + (int)ApplicationState.xOffset + 1, iY + (int)ApplicationState.yOffset), b[i][j]) 
					|| Collision.playerBlock(new Point(iX + width + (int)ApplicationState.xOffset - 3, iY + (int)ApplicationState.yOffset), b[i][j])){
					jumping = false;
					falling = true;
			}
			//bottom
			if(Collision.playerBlock(new Point(iX + (int)ApplicationState.xOffset + 2, iY + height + (int)ApplicationState.yOffset + 1), b[i][j]) 
					|| Collision.playerBlock(new Point(iX + width + (int)ApplicationState.xOffset - 3, iY + height + (int)ApplicationState.yOffset + 2), b[i][j])){
					y = b[i][j].getY() - height - ApplicationState.yOffset;
					falling = false;
					topCollision = true;
					
			} else {
				if(!topCollision && !jumping) {
					falling = true;
				}
			}
			}
			}
		}
		
		for(int i = 0; i < movingBlocks.size(); i++) //Moving block collision
		if(movingBlocks.get(i).getID() != 0 && movingBlocks.get(i).getID() != 7){
			//right
			if(Collision.playerMovingBlock(new Point(iX + width + (int)ApplicationState.xOffset, iY + (int)ApplicationState.yOffset + 2), movingBlocks.get(i))
					|| Collision.playerMovingBlock(new Point(iX + width + (int)ApplicationState.xOffset, iY + height + (int)ApplicationState.yOffset - 1), movingBlocks.get(i))){
					right=false;
					ApplicationState.xOffset += movingBlocks.get(i).getMove();
			}
			
			//left
			if(Collision.playerMovingBlock(new Point(iX + (int)ApplicationState.xOffset- 1, iY + (int)ApplicationState.yOffset + 2), movingBlocks.get(i))
					|| Collision.playerMovingBlock(new Point(iX + (int)ApplicationState.xOffset - 1, iY + height + (int)ApplicationState.yOffset - 1), movingBlocks.get(i))){
					left=false;
					ApplicationState.xOffset += movingBlocks.get(i).getMove();
			}
			
			//top
			if(Collision.playerMovingBlock(new Point(iX + (int)ApplicationState.xOffset + 1, iY + (int)ApplicationState.yOffset), movingBlocks.get(i)) 
					|| Collision.playerMovingBlock(new Point(iX + width + (int)ApplicationState.xOffset - 3, iY + (int)ApplicationState.yOffset), movingBlocks.get(i))){
					jumping = false;
					falling = true;
			}
			//bottom
			if(Collision.playerMovingBlock(new Point(iX + (int)ApplicationState.xOffset + 2, iY + height + (int)ApplicationState.yOffset + 1), movingBlocks.get(i)) 
					|| Collision.playerMovingBlock(new Point(iX + width + (int)ApplicationState.xOffset - 3, iY + height + (int)ApplicationState.yOffset + 1), movingBlocks.get(i))){
				y = movingBlocks.get(i).getY() - height - ApplicationState.yOffset;	
				falling = false;
					topCollision = true;
					
					ApplicationState.xOffset += movingBlocks.get(i).getMove(); //so player moves with the moving block.
			} else {
				if(!topCollision && !jumping) {
					falling = true;
				}
			}
			}
		
		for(int i = 0; i < basicEnemies.size(); i++) //basic enemy collision
			if(basicEnemies.get(i).getID() != 0){
				//right
				if(Collision.playerBasicEnemy(new Point(iX + width + (int)ApplicationState.xOffset, iY + (int)ApplicationState.yOffset + 2), basicEnemies.get(i))
						|| Collision.playerBasicEnemy(new Point(iX + width + (int)ApplicationState.xOffset, iY + height + (int)ApplicationState.yOffset - 1), basicEnemies.get(i))){
						right=false;
						ApplicationState.xOffset += basicEnemies.get(i).getMove();
						die();
				}
				
				//left
				if(Collision.playerBasicEnemy(new Point(iX + (int)ApplicationState.xOffset- 1, iY + (int)ApplicationState.yOffset + 2), basicEnemies.get(i))
						|| Collision.playerBasicEnemy(new Point(iX + (int)ApplicationState.xOffset - 1, iY + height + (int)ApplicationState.yOffset - 1), basicEnemies.get(i))){
						left=false;
						ApplicationState.xOffset += basicEnemies.get(i).getMove();
						die();
				}
				
				//top
				if(Collision.playerBasicEnemy(new Point(iX + (int)ApplicationState.xOffset + 1, iY + (int)ApplicationState.yOffset), basicEnemies.get(i)) 
						|| Collision.playerBasicEnemy(new Point(iX + width + (int)ApplicationState.xOffset - 3, iY + (int)ApplicationState.yOffset), basicEnemies.get(i))){
						jumping = false;
						falling = true;
						die();
				}
				//bottom
				if(Collision.playerBasicEnemy(new Point(iX + (int)ApplicationState.xOffset + 2, iY + height + (int)ApplicationState.yOffset + 1), basicEnemies.get(i)) 
						|| Collision.playerBasicEnemy(new Point(iX + width + (int)ApplicationState.xOffset - 3, iY + height + (int)ApplicationState.yOffset + 1), basicEnemies.get(i))){
					y = basicEnemies.get(i).getY() - height - ApplicationState.yOffset;	
						falling = false;
						topCollision = true;
						//enemy die?
						
						ApplicationState.xOffset += basicEnemies.get(i).getMove(); //so player moves with the basic enemy.
				} else {
					if(!topCollision && !jumping) {
						falling = true;
					}
				}
				}
		
		topCollision = false;
		
		if(right){
			ApplicationState.xOffset += moveSpeed;
		}
		if(left){
			ApplicationState.xOffset -= moveSpeed;
		}
		if(jumping){
			ApplicationState.yOffset -= currentJumpSpeed;
			
			currentJumpSpeed -= fallSpeed;
			
			if(currentJumpSpeed<=0){
				currentJumpSpeed=jumpSpeed;
				jumping= false;
				falling=true;
			}
		}
		if(falling){
			ApplicationState.yOffset+=currentFallSpeed;
			
			if(currentFallSpeed<maxFallSpeed) {
				currentFallSpeed+=fallSpeed;
			}
			currentJumpSpeed=jumpSpeed;
		}
		
		if(!falling){
			currentFallSpeed=fallSpeed;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_D) right = true;
		if(k == KeyEvent.VK_A) left = true;
		if(k == KeyEvent.VK_W && !jumping && !falling) jumping = true;
	}
	
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_D) right = false;
		if(k == KeyEvent.VK_A) left = false;
	}
	
	public void die(){
		if (lives > 0){
			lives--;
			reset();
		} else {
		dead = true;
		}
	}
	
	public void victory(){
		if (ApplicationState.level == 4){
			goal = true;
		}
		else if (ApplicationState.level != 4){
			ApplicationState.level++;
		}
		
	}
	
	public void reset(){
		
		if(ApplicationState.level == 1){
			ApplicationState.xOffset = Level1State.level1XSpawn;
			ApplicationState.yOffset = Level1State.level1YSpawn;
		}
		if(ApplicationState.level == 2){
			ApplicationState.xOffset = Level2State.level2XSpawn;
			ApplicationState.yOffset = Level2State.level2YSpawn;
		}
		
		jumping = false;
		left = false;
		right = false;
	}
}
