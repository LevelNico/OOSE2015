package med4.game_of_oose.gamestate;

import java.awt.Graphics;

import med4.game_of_oose.entities.Player;
import med4.game_of_oose.main.ApplicationPanel;
import med4.game_of_oose.mapping.Map;
import med4.game_of_oose.objects.Block;

public class Level1State extends ApplicationState {
	
	private Player player;
	private Map map;
	
	public Level1State(ApplicationStateManager asm) {
		super(asm);
	}

	
	public void init() {
		player = new Player(30, 30);
		map = new Map("",4,4);
		
		xOffset =- 200;
		yOffset =- 400;
	}

	
	public void tick() {
		player.tick(map.getBlocks());
	}

	
	public void draw(Graphics g){
		g.clearRect(0, 0, ApplicationPanel.WIDTH, ApplicationPanel.HEIGHT);
		player.draw(g);
		map.draw(g);
	}

	
	public void keyPressed(int k) {
		player.keyPressed(k);
	}

	
	public void keyReleased(int k) {
		player.keyReleased(k);
	}

}
