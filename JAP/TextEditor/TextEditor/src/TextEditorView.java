import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.MenuBar;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.stage.FileChooser;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class TextEditorView extends JPanel{
	
	private JMenuBar menu;
	private JToolBar toolBar;
	private JTextArea text;
	private JScrollPane scroll;
	private JPopupMenu popupMenu;
	private JTextField status;

	public TextEditorView() {
		super(new BorderLayout());
		
		JPanel bars = new JPanel(new BorderLayout());
		
		menu = new JMenuBar();
		toolBar = new JToolBar();
		popupMenu = new JPopupMenu("Edit");
		text = new JTextArea();
		scroll = new JScrollPane(text);
		
		text.setRows(80);
		text.setColumns(80);
		
		JMenu files = new JMenu("Files");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		toolBar.setRollover(true);
		toolBar.setOrientation(JToolBar.VERTICAL);
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JFileChooser chooser = new JFileChooser();
		
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text files (.txt)", "txt"));
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("Java files (.java)", "java"));
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("Class files (.class)", "class"));
		
		chooser.setCurrentDirectory(null);
		
		chooser.setAcceptAllFileFilterUsed(false);
		
		Action copyAction = new AbstractAction() {
			{
				ImageIcon icon = new ImageIcon("res/icons/copy-icon.png"); 
				icon.setImage(icon.getImage().getScaledInstance(25, 25, 100));
				putValue(Action.SMALL_ICON, icon);
				putValue(Action.NAME, "Copy");
				putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				text.copy();
				status.setText("Text Copied");
				
			}
		};
		Action cutAction = new AbstractAction() {
			{
				ImageIcon icon = new ImageIcon("res/icons/cut-icon.png"); 
				icon.setImage(icon.getImage().getScaledInstance(25, 25, 100));
				putValue(Action.SMALL_ICON, icon);
				putValue(Action.NAME, "Cut");
				putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				text.cut();
				status.setText("Text Cuted");
				
			}
		};
		Action pasteAction = new AbstractAction() {
			{
				ImageIcon icon = new ImageIcon("res/icons/paste-icon.png"); 
				icon.setImage(icon.getImage().getScaledInstance(25, 25, 100));
				putValue(Action.SMALL_ICON, icon);
				putValue(Action.NAME, "Paste");
				putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				text.paste();
				status.setText("Text Pasted");
				
			}
		};
		Action newAction = new AbstractAction() {
			
			{
				putValue(Action.NAME, "New");
				putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
						
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TextEditor text = new TextEditor();
				
			}
		};
		Action openAction = new AbstractAction() {
			
			{
				putValue(Action.NAME, "Open");
				putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
						
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnValue = chooser.showOpenDialog(menu);
				if (returnValue == JFileChooser.APPROVE_OPTION){
					try {
						File file = new File(chooser.getSelectedFile().toString());  
						FileReader fileReader;
						fileReader = new FileReader(file);
						BufferedReader reader = new BufferedReader(fileReader);  
				        String data = null;  
				        while((data = reader.readLine()) != null){  
//				            text.setText(text.getText() + data.toString());
//				            text.setText(text.getText() + "\n");
				        	text.append(data.toString() + "\n");
				        }  
				        fileReader.close();  
				        reader.close();  
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						status.setText("File Not Found !");
					} 
		        
				}
				
			}
		};
		Action saveAction = new AbstractAction() {
			
			{
				putValue(Action.NAME, "Save");
				putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
						
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal = chooser.showSaveDialog(menu);
				if (returnVal == JFileChooser.APPROVE_OPTION){
					
//					File file = new File(chooser.getSelectedFile().toString());  
					JOptionPane.showMessageDialog(null, chooser.getSelectedFile().getPath());
//			        BufferedWriter writer;
//					try {
//						writer = new BufferedWriter(new FileWriter(file));
//						writer.write(text.getText().toString());  					       
//				        writer.flush();   
//				        writer.close();
//				        JOptionPane.showMessageDialog(null, "File sucessful saved !");
//					} catch (IOException e1) {
//						
//						e1.printStackTrace();
//					}  
			        
				}
				
			}
		};
		Action exitAction = new AbstractAction() {
			
			{
				putValue(Action.NAME, "Exit");
				putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.ALT_MASK));
						
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		};
		
		JButton white = new JButton("W");
		JButton blue = new JButton("B");
		JButton orange = new JButton("O");
		
		white.setMnemonic('W');
		blue.setMnemonic('B');
		orange.setMnemonic('O');
		
		white.setSize(25, 25);
		blue.setSize(25, 25);
		orange.setSize(25, 25);
		
		white.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setBackground(Color.WHITE);
				toolBar.setBackground(Color.WHITE);
				text.setForeground(Color.BLACK);
				toolBar.setForeground(Color.BLACK);
				status.setText("Background Setted to White !");
			}
		});
		blue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setBackground(Color.BLUE);
				toolBar.setBackground(Color.BLUE);
				text.setForeground(Color.WHITE);
				toolBar.setForeground(Color.WHITE);
				status.setText("Background Setted to Blue !");
			}
		});
		orange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setBackground(Color.ORANGE);
				toolBar.setBackground(Color.ORANGE);
				text.setForeground(Color.WHITE);
				toolBar.setForeground(Color.WHITE);
				status.setText("Background Setted to Orange !");
				
			}
		});
		
		toolBar.add(white);
		toolBar.addSeparator();
		toolBar.add(blue);
		toolBar.addSeparator();
		toolBar.add(orange);
		
		
		
		// Files
		JMenuItem newWindow = new JMenuItem(newAction);
		JMenuItem open = new JMenuItem(openAction);		
		JMenuItem save = new JMenuItem(saveAction);
		JMenuItem exit = new JMenuItem(exitAction);		
		
		files.add(newWindow);
		files.addSeparator();
		files.add(open);
		files.add(save);
		files.addSeparator();
		files.add(exit);
		menu.add(files);
		
		
		// Edit
		JMenuItem copy = new JMenuItem(copyAction);
		JMenuItem cut = new JMenuItem(cutAction);
		JMenuItem paste = new JMenuItem(pasteAction);
		
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		menu.add(edit);
		
		// About
		JMenuItem about = new JMenuItem("About");
		about.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(text, "Danilo Rodrigo's Editor Text Program"
						+ "\n Version 1.14.2.2, Fall 14", "About Midterm Test", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		menu.add(help);
		help.add(about);
		
		
		//JMenuItem item = new JMenuItem("Copy");
		popupMenu.add(copyAction);
		popupMenu.add(cutAction);
		popupMenu.add(pasteAction);
		popupMenu.addSeparator();
		popupMenu.add("Settings");
		
		
		
		text.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3){
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
				
			}
		});
		
		
		status = new JTextField();
		status.setEditable(false);
		
		//bars.add(menu, BorderLayout.NORTH);
		//bars.add(toolBar, BorderLayout.SOUTH);
		
		this.add(menu, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(toolBar, BorderLayout.WEST);
		this.add(status, BorderLayout.SOUTH);
		
	
	}
	
	
}
