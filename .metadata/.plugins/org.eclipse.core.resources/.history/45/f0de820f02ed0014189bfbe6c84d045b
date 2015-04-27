package med4.game_of_oose;

import java.awt.Graphics;

public abstract class ApplicationState {
	
	protected ApplicationStateManager asm;
	
	public ApplicationState(ApplicationStateManager asm) {
		this.asm = asm;
		init();
	}
	
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	
}
