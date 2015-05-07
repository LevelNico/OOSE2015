package med4.game_of_oose.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Application {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Yous VS. Not-Seas");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(new ApplicationPanel(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
