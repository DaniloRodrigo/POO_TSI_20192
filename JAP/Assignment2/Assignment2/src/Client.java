import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;


public class Client {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ClientView client = new ClientView();
				
				JFrame frame = new JFrame();
				frame.setTitle(ClientView.applicationTitle);
				frame.setMinimumSize(new Dimension(ClientView.WIDTH, ClientView.HEIGHT));
				
				frame.setContentPane(client);
				//frame.pack();
				frame.setVisible(true);
				
			}
		});
	}
}
