package med4.game_of_oose.gamestate;

import java.awt.Graphics;
import java.util.Stack;

public class ApplicationStateManager {
	
	public Stack<ApplicationState> states;
	
	public ApplicationStateManager(){
		states = new Stack<ApplicationState>();
		states.push(new MenuState(this));
	}
	
	public void tick(){
		states.peek().tick();
	}
	
	public void draw(Graphics g){
		states.peek().draw(g);
	}
	
	public void keyPressed(int k){
		states.peek().keyPressed(k);
	}
	
	public void keyReleased(int k){
		states.peek().keyReleased(k);
		
	}	
}