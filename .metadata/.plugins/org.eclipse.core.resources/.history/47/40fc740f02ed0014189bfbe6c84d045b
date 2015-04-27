package med4.game_of_oose;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class MenuState extends ApplicationState {
	
	private String[] options= {"Start","Help","Quit"};
	private int currentSelection = 0;
	
	public MenuState(ApplicationStateManager asm) {
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
		if(k==KeyEvent.VK_S){
			currentSelection++;
			if(currentSelection>= options.length){
				currentSelection = 0;
			}
		} else if(k==KeyEvent.VK_W){
			currentSelection--;
			if(currentSelection < 0){
				currentSelection = options.length - 1;
			}
		}
		
		if(k == KeyEvent.VK_ENTER) {
			if (currentSelection == 0){
				//play
			}
			else if (currentSelection == 1){
				//help
			}
			else if (currentSelection == 2){
				System.exit(0);
			}
		}
	}

	public void keyReleased(int k) {
		
		
	}
}