package lab2;

/* CST8221-JAP: LAB 03, Exercise 1
   File name: MouseTest.java
   Image source: http://www.tech-faq.com/emoticons/
*/
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 Demonstrates how to handle mouse events in Swing.
 @version 1.14.2
 @author Svillen Ranev
*/
public class MouseTest extends JFrame 
    implements ActionListener,MouseListener,MouseMotionListener, MouseWheelListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//generate serialVersionUID here after the code has been completed and working
    private final JButton button;
    private final JPanel pane;
    private static final String frameTitle = "Mouse Test";
    private final Icon buttonImage = new ImageIcon("happy.gif");   
    private final JLabel label_01;
    private final JLabel label_02;
    private final String labelText1 = "Number of Clicks: ";
    private final String labelText2 = "The clicked Button is: ";
    private int contClick;
    

/**
  Default constructor. Sets the frame properties.
*/ 
   public MouseTest(){ 
     // Sets the GUI 
     // set frame title
    	super(frameTitle);     	   
    	// set frame width, height
      setSize(200,200);   
	// Create and set up containers and components.
      label_01 = new JLabel(labelText1 + "0");
      label_02 = new JLabel(labelText2);
	// Create a button with an image and text
	button = new JButton("Mouse Test Button",buttonImage);
	// Create a Tool Tip. Will show up when the mouse hovers over the button
	button.setToolTipText("Please play with the mouse");
   button.setPreferredSize(new Dimension(button.getText().length()*20,60));
   // Set the frame to be the event handler for the button click
   button.addActionListener(this);
	/* Register the three Mouse Listeners here: */
	button.addMouseListener(this);
	button.addMouseMotionListener(this);
	button.addMouseWheelListener(this);
    
   
	
	pane = new JPanel();
	// set a border around the JPanel
	pane.setBorder(BorderFactory.createEmptyBorder(25, 25, 10, 25));

	// Add components to JPanel container.
	pane.add(button);
	pane.add(label_01);
	pane.add(label_02);
	
	pane.setLayout(new GridLayout(3, 1));
	
       // Install JPanel pane as the content pane of the frame
         this.setContentPane(pane);
   // The GUI is ready.   
  }

/** 
    The main method.The GUI will start with the default Look and Feel - Metal Look and Feel 
    Runs the application GUI in the event dispatch thread (EDT).
    Anonymous class is used to create a runnable object.
    @param args not used
*/  
   public static void main(String[] args) {
     // Make all components to configured by the event dispatch thread.
     // This is the thread that passes user provoked events such as mouse clicks to 
     // the GUI components which have registered listeners for the events.
     // The following code fragment forces the statements in the run() method to be executed in the
     // event dispatch thread. 
     EventQueue.invokeLater(new Runnable(){
            @Override
            public void run()
            {
               MouseTest frame = new MouseTest();
               // set up the Close button (X) of the frame
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setResizable(false); 
               frame.pack();
               // make the GUI visible
               frame.setVisible(true);	
            }
         });
     }

 /****************************** Beginning of Event handling Section ***********************/
  // Handle the button clicks. 
  // Override and Implement the actionPerformed() method of the Action Listener interface

  public void actionPerformed(ActionEvent e) {
	 // process the event
	 //mouseClicked(e); 

   }


  
/**************************************************************/
/* Below implement all the methods of the MouseListener interface */
@Override
public void mouseClicked(MouseEvent e) {
	System.out.println("Method mouseClicked Called");
	
	if (e.getButton() == 1){
		label_02.setText(labelText2 + "Left");
	}else if(e.getButton() == 2){
		label_02.setText(labelText2 + "Middle");
	}else if(e.getButton() == 3){
		label_02.setText(labelText2 + "Right");
	}
	label_01.setText(labelText1 + contClick);
	contClick++;
}

@Override
public void mouseEntered(MouseEvent e) {
	System.out.println("Method mouseEntered Called");
}

@Override
public void mouseExited(MouseEvent e) {
	System.out.println("Method mouseExited Called");
}

@Override
public void mousePressed(MouseEvent e) {
	System.out.println("Method mousePressed Called");
}

@Override
public void mouseReleased(MouseEvent e) {
	System.out.println("Method mouseReleased Called");
}

/*******************************************************************/
/* Below implement all the methods of the MouseMotionListener methods */
@Override
public void mouseDragged(MouseEvent e) {
	System.out.println("Method mouseDragged Called");
}

@Override
public void mouseMoved(MouseEvent e) {
	System.out.println("Method mouseMoved Called");
	System.out.println("X: "+e.getXOnScreen() + " Y: "+ e.getYOnScreen());
} 
/*******************************************************************/

/* Below implement all the methods of the MouseWheelListener methods */
@Override
public void mouseWheelMoved(MouseWheelEvent e) {
	System.out.println("Method mouseWheelMoved Called");
        System.out.println("Amount: " + e.getPreciseWheelRotation());
	if(e.getUnitsToScroll() < 0){
	    System.out.println("");
	}
}
 /****************************** End of Event handling Section *****************************/
 } //end of class  
      
