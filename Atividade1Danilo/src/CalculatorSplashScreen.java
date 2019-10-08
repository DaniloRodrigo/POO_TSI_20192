import java.awt.*;

import javax.swing.*;

/**
*  Build a splash screen with the logo, name, and author of the software
*  @version 1.0
*  @author Danilo Rodrigo
*/
public class CalculatorSplashScreen extends JWindow{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6248477390124803341L;
	
	private JProgressBar progressBar;
	
	
	public CalculatorSplashScreen() {
	    
	}
	
	/**
	 *  Build the slash screen before the calculator
	 */
	public void showSplashWindow(){
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel panelSouth = new JPanel(new GridLayout(2, 1));
		
		progressBar = new JProgressBar();
	    progressBar.setMinimum(1);
	    progressBar.setMaximum(1000);
	    
		
		int width = 450+5;
		int height = 350+5;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width-width)/2;
	    int y = (screen.height-height)/2;
	    this.setBounds(x, y, width, height);
	    
		
	    panel.setBorder(BorderFactory.createLineBorder(Color.gray, 5));
	    panel.setBackground(Color.black); 
		
		
		
	    ImageIcon icon = new ImageIcon("res/logo.png"); //Somente esta linha foi alterada  
	    icon.setImage(icon.getImage().getScaledInstance(325, 325, 100));
	    JLabel label = new JLabel(icon);
		JLabel nameApp = new JLabel("Calculator v1.0, Developed by Danilo Rodrigo", JLabel.CENTER);
		
		panelSouth.setBackground(Color.gray);
		panelSouth.add(nameApp);
		panelSouth.add(progressBar);
		
		panel.add(label, BorderLayout.CENTER);
		panel.add(panelSouth, BorderLayout.SOUTH);
		
		
		panel.setVisible(true);
		
		this.setContentPane(panel);
		this.setAlwaysOnTop(true);	
		this.setVisible(true);
		
		try {
			for (int i = 1; i <= 1000; i++) {
				final int percent=i;
				
				try {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							updateProgressBar(percent);
						}
					});
					
					java.lang.Thread.sleep(25);
				} catch (InterruptedException e) {;}
			} 
			
		}
		catch (Exception e) {e.printStackTrace();}
		
		dispose(); 
	}
	
	/**
	 *  update the Progress Bar
	 *  @param int newValue
	 */
	public void updateProgressBar(int newValue) {
	   
	    
	    progressBar.setStringPainted(true);
	    progressBar.setIndeterminate(false);
	    progressBar.setValue(newValue);
	    progressBar.setString("Loading...");
	    return;
	    
	}
	


}
