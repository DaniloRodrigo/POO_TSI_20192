import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.transform.Result;


/**
*  Build the GUI of the calculator
*  @version 1.0
*  @author Danilo Rodrigo
*  Created on Linux Ubuntu 14.04
*/
public class CalculatorView extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField display;
	private JLabel mode;
	private JButton dotButton;
	public static final String APP_NAME;
	private final String FLOAT_MODE_TEXT;
	private final String INT_MODE_TEXT;
	private final String ERROR_MODE_TEXT;
	private final String DISPLAY_INITIAL_TEXT;	
	private CalculatorModel model;
	//private Boolean dotFlag;
	
	
	
	static{
		APP_NAME = "Calculator";
		
	}
	{
		model = new CalculatorModel();
		
		//dotFlag = false;
		
		// mode possible texts
		FLOAT_MODE_TEXT = "F";
		INT_MODE_TEXT = "I";
		ERROR_MODE_TEXT = "E";
		
		// mode initialization and configuration
		mode = new JLabel(FLOAT_MODE_TEXT);
		mode.setOpaque(true);
		mode.setBackground(Color.yellow);
		mode.setPreferredSize(new Dimension(25, 25));
		mode.setHorizontalAlignment(JLabel.CENTER);
		mode.setToolTipText("mode display");
		
		// display initial text
		DISPLAY_INITIAL_TEXT = "0.00";
		
		// display initialization and configuration
		display = new JTextField(DISPLAY_INITIAL_TEXT);
		display.setColumns(16);
		display.setPreferredSize(new Dimension(getWidth(), 30));
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setBackground(Color.white);
		display.setEditable(false);
		display.setToolTipText("display");
		
		
	}
	
	/**
	 *  The constructor
	 */
	public CalculatorView() {
		// definition of main panel
		super(new BorderLayout());
		

		// border and background color of main panel
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
		this.setBackground(Color.BLACK);
		
		// declaration of the other panels
		JPanel displayPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel optionsPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel keyboardButtonsPane = new JPanel(new GridLayout(4, 4, 5, 5));
		JPanel northPane = new JPanel(new BorderLayout());
		Box precisionPane = Box.createHorizontalBox();
		
		
		// sets of display panel
		displayPane.setBackground(Color.white);
		
		
		
		// sets of option pane
		optionsPane.setBackground(Color.BLACK);
		
		
		// sets of keyboardPane
		keyboardButtonsPane.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		
		
		// displayPane and optionsPane into North part of main panel
		northPane.add(displayPane, BorderLayout.NORTH);
		northPane.add(optionsPane, BorderLayout.SOUTH);
		
		// displayPane configuration
		// creation and sets of backspace
		JButton backspace = new JButton("\u2190");
		backspace.setActionCommand("\u2190");
		backspace.setMnemonic('b');
		backspace.setBorder(BorderFactory.createLineBorder(Color.red, 1));
		backspace.setPreferredSize(new Dimension(25, 25));
		backspace.setMinimumSize(new Dimension(25, 25));
		backspace.setOpaque(true);
		backspace.setContentAreaFilled(false);
		backspace.setForeground(Color.red);
		backspace.setToolTipText("backspace");
		
		// listener registration
		backspace.addActionListener(new Controller());
		
		
		// add mode, display, and backspace into displayPane
		displayPane.add(mode);
		displayPane.add(display);
		displayPane.add(backspace);
		
		// optionsPane configuration
		// creation and sets of integer JCheckBox	
		
		Controller numericButtonsHander = new Controller();
		
		JCheckBox integerOption = new JCheckBox("int");
		integerOption.setBackground(Color.green);
		integerOption.setActionCommand("Int");
		integerOption.setToolTipText("integer");
		//integerOption.setPreferredSize(new Dimension(50, 20));
		
		
		// registration of integer's listener 
		integerOption.addActionListener(numericButtonsHander);
		
		
		// creation of the three JRadioButton
		JRadioButton oneDec = new JRadioButton(".0", false);
		JRadioButton twoDec = new JRadioButton(".00", true);
		JRadioButton sci = new JRadioButton("Sci", false);
		
		// registration of the three JRadioButtons' listener
		oneDec.addActionListener(numericButtonsHander);
		twoDec.addActionListener(numericButtonsHander);
		sci.addActionListener(numericButtonsHander);
		
		// sets of of the three JRadioButtons	
		oneDec.setBackground(Color.yellow);
		//oneDec.setPreferredSize(new Dimension(50, 20));
		oneDec.setActionCommand(".0");
		oneDec.setToolTipText(".0");
		twoDec.setBackground(Color.yellow);
		//twoDec.setPreferredSize(new Dimension(50, 20));
		twoDec.setActionCommand(".00");
		twoDec.setToolTipText(".00");
		sci.setBackground(Color.yellow);
		//sci.setPreferredSize(new Dimension(50, 20));
		sci.setActionCommand("sci");
		sci.setToolTipText("sci");
		
		// creation and inclusion of the three JRadioButton into a ButtonGroup
		ButtonGroup precisionGroup = new ButtonGroup();
		precisionGroup.add(oneDec);
		precisionGroup.add(twoDec);
		precisionGroup.add(sci);
		
		// add the three JRadioButton into a precisionPane
		precisionPane.add(integerOption);
		precisionPane.add(Box.createHorizontalStrut(5));
		precisionPane.add(oneDec);		
		//precisionPane.add(Box.createHorizontalGlue());
		precisionPane.add(twoDec);
		//precisionPane.add(Box.createHorizontalGlue());
		precisionPane.add(sci);
		//precisionPane.add(Box.createHorizontalGlue());
		
		// add the JCheckBox and the BoxLayout into the South of North part of the main panel
		//optionsPane.add(integerOption);
		optionsPane.add(precisionPane);
			
		// numeric and operation buttons
		// creation of the controller and the numeric button array and numericButtonsTexts array
		
		String numericButtonTexts[] = new String[]{"7","8","9","/","4","5","6","*","1","2","3","-","\u00B1","0",".","+"}; 
		
		
		// dynamic generation and insertion of the numeric button into grid panel
		for (int i = 0; i < 16; i++){
			
			if((i == 3) || (i == 7) || (i == 11) || (i == 15) || (i == 16) || (i == 19)){
				keyboardButtonsPane.add(createButton(numericButtonTexts[i], numericButtonTexts[i], Color.yellow, Color.blue, numericButtonsHander));
			}else if (numericButtonTexts[i].equals(".")){
				dotButton = createButton(numericButtonTexts[i], numericButtonTexts[i], Color.yellow, Color.blue, numericButtonsHander);
				keyboardButtonsPane.add(dotButton);
			}else{
				keyboardButtonsPane.add(createButton(numericButtonTexts[i], numericButtonTexts[i], Color.black, Color.blue, numericButtonsHander));
			}
			
		}
			
		
		// creation of lateral buttons
		JButton clearButton = createButton("C", "c", Color.black, Color.red, numericButtonsHander);
		JButton equalButton = createButton("=", "=", Color.black, Color.yellow, numericButtonsHander);
		
		// insertion of the other content panels and lateral button into the main panel
		this.add(northPane, BorderLayout.NORTH);
		this.add(keyboardButtonsPane, BorderLayout.CENTER);
		this.add(equalButton, BorderLayout.EAST);
		this.add(clearButton, BorderLayout.WEST);

	}
	
	/**
	*  Handle the events involved on the GUI
	*  @version 1.0
	*  @author Danilo Rodrigo
	*/
	private class Controller implements ActionListener, Observer{
		
		private static final int ERROR = 0;
		private static final int FLOAT = 1;
		private static final int INT = 2;
		
	
		
		{
			model.addObserver(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//display.setText(e.getActionCommand());
			switch (e.getActionCommand()) {
			case "0":
				setDisplay("0");
				break;
			case "1":
				setDisplay("1");
				break;
			case "2":
				setDisplay("2");
				break;
			case "3":
				setDisplay("3");
				break;
			case "4":
				setDisplay("4");
				break;
			case "5":
				setDisplay("5");
				break;
			case "6":
				setDisplay("6");
				break;
			case "7":
				setDisplay("7");
				break;
			case "8":
				setDisplay("8");
				break;
			case "9":
				setDisplay("9");
				break;
			case ".0":
				model.setOneDecFlag(true);
				break;
			case ".00":
				model.setTwoDecFlag(true);
				break;
			case "sci":
				model.setSciFlag(true);
				break;
			case "Int":
				intState();
				break;
			case "\u2190":
				if(!mode.getText().equals("E")){backspaceAction();}
				break;
			case "c":
				clearAction();
				break;
			case ".":
				if(!mode.getText().equals("E")){setDot();}
				break;
			case "\u00B1":
				if(!mode.getText().equals("E")){setSignal();}
				break;
			case "+":
				if(!mode.getText().equals("E")){model.setOperation(e.getActionCommand(), display.getText());	}				
				break;
			case "-":
				if(!mode.getText().equals("E")){model.setOperation(e.getActionCommand(), display.getText());	}
							
				break;
			case "*":
				if(!mode.getText().equals("E")){model.setOperation(e.getActionCommand(), display.getText());	}			
				break;
			case "/":
				if(!mode.getText().equals("E")){model.setOperation(e.getActionCommand(), display.getText());	}
				break;
			case "=":
				if(!mode.getText().equals("E")){model.setResult(display.getText());}
			}
		}
		
		
		
		
		@Override
		public void update(Observable o, Object arg) {
			CalculatorModel.Result r = (CalculatorModel.Result) arg;
			if(r.getError()){
				setMode(Controller.ERROR);
				model.setClean();
			}
			display.setText(r.getResult());
			
			
		}
		
		
	}
	
	/**
	 *  Set the display without direct action
	 */
	private void setDisplay(String n){
		this.setDisplay(n, false);
	}
	
	/**
	 *  Set the display with dirext action
	 */
	private void setDisplay(String n, Boolean directSet){
		if(display.getText().length() <= 16){
			if(!mode.getText().equals("E")){
				
				if (directSet){
					display.setText(n);
				}else if ((display.getText().equals("0")) || (display.getText().equals("0.0")) || (display.getText().equals("0.00")) || (display.getText().equals("--"))){
					display.setText(n);
				}else if(model.getSecondElementFlag()){
					display.setText(n);
					model.setSecondElementFlag(false);
				}else{
					display.setText(display.getText() + n);
				}
			}
		}else{
			if (!mode.getText().equals("E")){this.setMode(Controller.ERROR);}
			
		}
	}
	
	/**
	 *  Set negative and positive signal
	 */
	private void setSignal(){
		if ((!display.getText().equals("0.0")) && (!display.getText().equals("0.")) && (!display.getText().equals("0")) && (!display.getText().equals("0.00")) && (!display.getText().equals(""))){
			if (display.getText().substring(0, 1).equals("-")){
				display.setText(display.getText().substring(1, display.getText().length()));
			}else{
				display.setText("-" + display.getText());
			}
		}
	}
	
	/**
	 *  Set the dot on the numbers
	 */
	private void setDot(){
		for (int i = 0; i < display.getText().length(); i++){
			if (!display.getText().contains(".")){
				display.setText(display.getText() + ".");
			}
		}
	}
	
	/**
	 *  Set all settings about integer mode
	 */
	private void intState(){
		if (!model.getIntegerOparation()){
			dotButton.setEnabled(false);
			dotButton.setBackground(Color.gray);
			model.setIntegerOparation(true);
			if(!mode.getText().equals("E")){this.setMode(Controller.INT);}			
			if(display.getText().contains(".")){
				display.setText(display.getText().substring(0, display.getText().indexOf(".")));
			}
		}else{
			dotButton.setEnabled(true);
			dotButton.setBackground(Color.blue);
			model.setIntegerOparation(false);
			if(!mode.getText().equals("E")){this.setMode(Controller.FLOAT);}	
			
		}
	}
	
	/**
	 *  Set the JLabel mode
	 *  @param int o
	 */
	private void setMode(int o){
		if (o == 0){
			mode.setText(ERROR_MODE_TEXT);
			mode.setBackground(Color.red);
		}else if(o == 1){
			mode.setText(FLOAT_MODE_TEXT);
			mode.setBackground(Color.yellow);
		}else if (o == 2){
			mode.setText(INT_MODE_TEXT);
			mode.setBackground(Color.green);
		}
	}
	
	/**
	 *  Set all commands about clear the display and operations
	 */
	private void clearAction(){
		model.setClean();
		model.setError(false);
		if (model.getIntegerOparation()){
			display.setText("0");
			setMode(Controller.INT);
		}else{
			display.setText("0.0");
			setMode(Controller.FLOAT);
			model.setError(false);
		}
	}
	
	/**
	 *  Set all settings about the backspace button
	 */	
	private void backspaceAction(){
		if ((!display.getText().equals("0")) && (!display.getText().equals("0.0")) && (!display.getText().equals("0.00"))){
			
			if(display.getText().startsWith("-") && display.getText().length() == 2){
				display.setText(display.getText().substring(0, display.getText().length() - 2));
			}else{
				display.setText(display.getText().substring(0, display.getText().length() - 1));
			}
			
		}
		
		if (display.getText().length() == 0){
			if (model.getIntegerOparation()){
				display.setText("0");
			}else if(model.getOneDecFlag()){
				display.setText("0.0");
			}else if(model.getTwoDecFlag()){
				display.setText("0.00");
			}else if(model.getSciFlag()){
				display.setText("0.00");
			}
		}
		
		if (display.getText().length() <= 16){
			if (model.getIntegerOparation()){
				this.setMode(Controller.INT);
			}else{
				this.setMode(Controller.FLOAT);
			}
		}
	}
	

	
	/**
	*  Return a button created using the parameters
	*  @param text the text of the button.
	*  @param ac the action command of the button.
	*  @param fg the color of the button text.
	*  @param bg the background color of the button.
	*  @param handler button's listener.
	*  @return button.
	*/  
	private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler){
		
		
		
		JButton button = new JButton(text);
		button.setActionCommand(ac);
		button.setForeground(fg);
		button.setBackground(bg);
		button.setToolTipText(text);
		button.addActionListener(handler);
		button.setFont(new Font(button.getFont().getName(), Font.BOLD, 20));
		
		return button;
	}

	
}
