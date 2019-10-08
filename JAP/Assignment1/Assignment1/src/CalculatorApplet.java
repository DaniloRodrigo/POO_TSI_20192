

import javax.swing.JApplet;


public class CalculatorApplet extends JApplet {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		CalculatorView c = new CalculatorView();
		
		this.setContentPane(c);
	}
}
