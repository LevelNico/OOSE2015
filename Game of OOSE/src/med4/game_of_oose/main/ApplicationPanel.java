package med4.game_of_oose.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import med4.game_of_oose.gamestate.ApplicationStateManager;

public class ApplicationPanel extends JPanel implements Runnable, KeyListener{
	private static final long serialVersionUID = 1L;
	
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	
	private Thread thread;
	private boolean isRunning = false;
	
	private int FPS = 60;
	private long targetTime = 1000/FPS;
	
	private ApplicationStateManager asm;
	
	public ApplicationPanel(){
		setPreferredSize (new Dimension(WIDTH,HEIGHT));
		
		addKeyListener(this);
		setFocusable(true);
		
		start();
	}
	
	private void start(){
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		long start, elapsed, wait;
		
		asm = new ApplicationStateManager();
		
		while(isRunning){
			start = System.nanoTime();
			
			tick();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if(wait <= 0){
				wait = 5;
			}
			try {
				Thread.sleep(wait);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void tick(){
		asm.tick(); //call methods from AplicationStateManager
					//ASM selects which state the game is in (menu, level1, etc) and methods are called from that state.
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.clearRect(0, 0, WIDTH, HEIGHT);
		asm.draw(g);
	}
	

	public void keyPressed(KeyEvent e) {
		asm.keyPressed(e.getKeyCode());
		
	}

	public void keyReleased(KeyEvent e) {
		asm.keyReleased(e.getKeyCode());
		
	}

	public void keyTyped(KeyEvent e) {
		
		
	}
}
