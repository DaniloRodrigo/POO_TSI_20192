import java.text.DecimalFormat;
import java.util.Observable;

/**
*  Build the Model of the Calculator
*  @version 1.0
*  @author Danilo Rodrigo
*  Created on Linux Ubuntu 14.04
*/
public class CalculatorModel extends Observable{
	
	private String firstElement;
	private String operation;
	private String result;
	private Boolean integerOparation = false;
	private Boolean oneDecFlag = false;
	private Boolean twoDecFlag = true;
	private Boolean sciFlag = false;
	private Boolean secondElementFlag = false;
	private Boolean error = false;
	
	
	public CalculatorModel(){
		
	}
	
	/**
	*  Build a class with necessary data to the result
	*  @version 1.0
	*  @author Danilo Rodrigo
	*  Created on Linux Ubuntu 14.04
	*/
	protected class Result{
		private String result;
		private Boolean error;
		
		/**
		 *  The constructor
		 */
		public Result(String result, Boolean error) {
			this.result = result;
			this.error = error;
		}
		
		/**
		 *  get the result
		 */
		public String getResult() {
			return result;
		}

		/**
		 *  get the error
		 */
		public Boolean getError() {
			return error;
		}
		
		/**
		 *  Set the result
		 *  @param String result
		 */
		public void setResult(String result) {
			this.result = result;
		}
		
		/**
		 *  Set the error
		 *  @param Boolean error
		 */
		public void setError(Boolean error) {
			this.error = error;
		}
	}
	
	/**
	 *  update the observers
	 */
	public void updateObservers(){
		this.setChanged();
		this.notifyObservers(new Result(this.result, this.error));
	}
	
	/**
	 *  get the result
	 */
	public String getResult(){
		return this.result;
	}

	/**
	 *  get the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 *  Set the first element
	 *  @param String firstElement
	 */
	public void setFirstElement(String firstElement) {
		this.firstElement = firstElement;
		this.setSecondElementFlag(true);
	}

	/**
	 *  Set the operation and second value
	 *  @param String operation
	 *  @param String val
	 */
	public void setOperation(String operation, String val) {
		this.operation = operation;		
		if(this.secondElementFlag){
			this.result = this.performCalculations(val);
			this.setFirstElement(this.result);
			this.updateObservers();
			
		}else{
			this.setFirstElement(val);
			
		}
		
	}

	/**
	 *  Set the result
	 *  @param String val
	 */
	public void setResult(String val) {	
		this.result = this.performCalculations(val);
		this.setSecondElementFlag(true);
		this.updateObservers();
	}

	/**
	 *  perform the calculation
	 *  @param String val
	 */
	public String performCalculations (String val){
		
		//this.setSecondElement(val);
		String str1 = this.firstElement;
		String str2 = val;
		String result = "";
		if (val.equals("0") || val.equals("0.0") || val.equals("0.00")){
			this.error = true;
			result = "--";
		}else{
		
			if (this.operation.equals("+")){
				if (this.integerOparation){
					int n1 = Integer.parseInt(str1);
					int n2 = Integer.parseInt(str2);
					
					result = String.valueOf(n1+n2);
				}else if (this.oneDecFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.0");
					result = df.format(n1+n2);
				}else if (this.twoDecFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.00");
					result = df.format(n1+n2);
				}else if (this.sciFlag){			
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.#####E00");
					result = df.format(n1+n2);
				}
	
				
					
			}else if (this.operation.equals("-")){
			
				if (this.integerOparation){
					int n1 = Integer.parseInt(str1);
					int n2 = Integer.parseInt(str2);
					
					result = String.valueOf(n1-n2);
				}else if (this.oneDecFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.0");
					result = df.format(n1-n2);
				}else if (this.twoDecFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.00");
					result = df.format(n1-n2);
				}else if (this.sciFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.#####E00");
					result = df.format(n1-n2);
				}
					
			}else if (this.operation.equals("*")){
	
				if (this.integerOparation){
					int n1 = Integer.parseInt(str1);
					int n2 = Integer.parseInt(str2);
					
					result = String.valueOf(n1*n2);
				}else if (this.oneDecFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.0");
					result = df.format(n1*n2);
				}else if (this.twoDecFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.00");
					result = df.format(n1*n2);
				}else if (this.sciFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.#####E00");
					result = df.format(n1*n2);
				}
				
			}else if (this.operation.equals("/")){
					
				if (this.integerOparation){
					int n1 = Integer.parseInt(str1);
					int n2 = Integer.parseInt(str2);
					
					result = String.valueOf(n1/n2);
				}else if (this.oneDecFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.0");
					result = df.format(n1/n2);
				}else if (this.twoDecFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.00");
					result = df.format(n1/n2);
				}else if (this.sciFlag){
					double n1 = Double.parseDouble(str1);
					double n2 = Double.parseDouble(str2);
					DecimalFormat df = new DecimalFormat("0.#####E00");
					result = df.format(n1/n2);
				}
				
			}
	}	
		return result;
	}

	/**
	 *  Clean the element, flag, and operation
	 */
	public void setClean(){
		this.firstElement = "";
		this.secondElementFlag = false;
		this.operation = "";
	}

	/**
	 *  get the Integer operation flag
	 */
	public Boolean getIntegerOparation() {
		return integerOparation;
	}

	/**
	 *  get the flag to 1 decimal house
	 */
	public Boolean getOneDecFlag() {
		return oneDecFlag;
	}

	/**
	 *  get the flag to 2 decimal house
	 */
	public Boolean getTwoDecFlag() {
		return twoDecFlag;
	}

	/**
	 *  get the flag to scientific mode
	 */
	public Boolean getSciFlag() {
		return sciFlag;
	}

	/**
	 *  set the Integer operation flag
	 *  @param Boolean integerOperation
	 */
	public void setIntegerOparation(Boolean integerOparation) {
		this.integerOparation = integerOparation;
	}

	/**
	 *  set the Integer 1 decimal house flag
	 *  @param Boolean oneDecFlag
	 */
	public void setOneDecFlag(Boolean oneDecFlag) {
		this.oneDecFlag = oneDecFlag;
		this.twoDecFlag = false;
		this.sciFlag = false;
	}

	/**
	 *  set the 2 decimal houses flag
	 *  @param Boolean twoDecFlag
	 */
	public void setTwoDecFlag(Boolean twoDecFlag) {
		this.twoDecFlag = twoDecFlag;
		this.oneDecFlag = false;
		this.sciFlag = false;
	}

	/**
	 *  set the scientific mode flag
	 *  @param Boolean sciDecFlag
	 */
	public void setSciFlag(Boolean sciFlag) {
		this.sciFlag = sciFlag;
		this.oneDecFlag = false;
		this.twoDecFlag = false;
	}

	/**
	 *  Set the display
	 *  @param Boolean secondElementFlag
	 */
	public Boolean getSecondElementFlag() {
		return secondElementFlag;
	}

	/**
	 *  get second element flag
	 */
	public void setSecondElementFlag(Boolean secondElementFlag) {
		this.secondElementFlag = secondElementFlag;
	}

	/**
	 *  set the error flag
	 *  @param Boolean error
	 */
	public void setError(Boolean error) {
		this.error = error;
	}
}
