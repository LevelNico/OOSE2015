package med4.game_of_oose.gamestate;

import java.awt.Graphics;

public abstract class ApplicationState {
	
	protected ApplicationStateManager asm;
	public static double xOffset;
	public static double yOffset;
	
	public ApplicationState(ApplicationStateManager asm) {
		this.asm = asm;
		
		this.xOffset = 0; //These are to move the map rather than moving the player.
		this.yOffset = 0;
		init();
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	
}
