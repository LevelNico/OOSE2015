package med4.game_of_oose;

import java.awt.Dimension;

import javax.swing.JPanel;

public class ApplicationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static final int HEIGHT = 600;
	public static final int WIDTH = 800;
	
	public ApplicationPanel(){
		setPreferredSize (new Dimension(WIDTH,HEIGHT));
	}
	
}
