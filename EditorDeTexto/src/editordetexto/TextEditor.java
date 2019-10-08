package editordetexto;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class TextEditor {
	
	public static void main( String[] args ) { 
		
	     EventQueue.invokeLater(new Runnable() {
	            public void run() {   
	            	
	            	
	            	
	            	TextEditorView textEditor = new TextEditorView();
		             
		            JFrame frame = new JFrame();
		            frame.setTitle("TDanilo Rodrigo's Midterm Test - Fall 14");
		            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		            frame.setMinimumSize(new Dimension(600, 700));
		            frame.setContentPane(textEditor);
		            frame.setVisible( true ); // display frame	
	            }
	       });   
	      
	     
	 }

}
