package med4.game_of_oose.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import med4.game_of_oose.main.ApplicationPanel;

public class GameOverState extends ApplicationState {
	
	private String[] options= {"Retry","Give Up"};
	private int currentSelection = 0;
	
	public GameOverState(ApplicationStateManager asm) {
		super(asm);
	}
	
	
	public void init() {}
	
	public void tick() {
		
		
	}

	public void draw(Graphics g) {
		
		g.setColor(new Color(120,130,255));
		g.fillRect(0, 0, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT);
		
		for(int i = 0; i < options.length; i++){
			if(i == currentSelection){
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.BLACK);
			}
			
			g.setFont(new Font("Ariel", Font.PLAIN, 72));
			g.drawString(options[i],ApplicationPanel.WIDTH/2 - 75, 200 + i * 150);
		}
		
	}	
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_S || k==KeyEvent.VK_DOWN){
			currentSelection++;
			if(currentSelection>= options.length){
				currentSelection = 0;
			}
		} else if(k==KeyEvent.VK_W || k==KeyEvent.VK_UP){
			currentSelection--;
			if(currentSelection < 0){
				currentSelection = options.length - 1;
			}
		}
		
		if(k == KeyEvent.VK_ENTER) {
			if (currentSelection == 0){
				asm.states.push(new Level1State(asm));
			}
			else if (currentSelection == 1){
				asm.states.push(new MenuState(asm));
			}
		}
	}

	public void keyReleased(int k) {
		
		
	}
}