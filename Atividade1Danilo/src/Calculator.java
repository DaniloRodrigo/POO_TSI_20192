import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
*  Initializes the calculator software
*  @version 1.0
*  @author Danilo Rodrigo
*/
public class Calculator {
	
	/** 
	*  The main method.The GUI will start with the default Look and Feel - Metal Look and Feel 
	*  Runs the application GUI in the event dispatch thread (EDT).
	*  Anonymous class is used to create a runnable object.
	*  @param args not used
	*/  
	 public static void main( String[] args ) { 
		
   
      
		 CalculatorSplashScreen splash = new CalculatorSplashScreen();
         splash.showSplashWindow();
	     EventQueue.invokeLater(new Runnable() {
	            public void run() {   
	            	
	            	
	            	
	            	
	            	CalculatorView calculator = new CalculatorView(); 
		             
		            JFrame frame = new JFrame();
		            frame.setTitle(calculator.APP_NAME);
		            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		            frame.setMinimumSize(new Dimension(330, 400));
		            frame.setContentPane(calculator);
		            frame.setVisible( true ); // display frame	
	            }
	       });   
	      
	     
	 }

}
