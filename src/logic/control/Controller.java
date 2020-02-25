package logic.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.view.Starter;

// salvare l'espressione in una stringa per poi valutarla non è possibile: pertanto, serve codificare uno stato per ogni operazione.

public class Controller {
	
	public final String DEFAULT_NUMBER = "0";
	
	private static Controller ref = null;
	private String curNumber = this.DEFAULT_NUMBER;
	private String prevNumber = this.DEFAULT_NUMBER;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public static Controller getReference() {
		if (ref == null) {
			ref = new Controller();
		}
		return ref;
	}
	
	private Controller() {}
	
	public void setPrevNumber(String val) {
		this.prevNumber = val;
	}
	
	public String getPrevNumber() {
		return this.prevNumber;
	}
	
	public void addDigit(int d) {
		if (this.curNumber == this.DEFAULT_NUMBER) {
			this.curNumber = String.format("%d", d);
		}
		else {
			this.curNumber += String.format("%d", d);
		}
		logger.log(Level.INFO, this.curNumber);
		Starter.view.updateDisplay(this.curNumber);
		
	}
	
	public float doAdd(float first, float second) {
		return first + second;
	}
	
	public float doSub(float first, float second) {
		return first - second;
	}
	
	public float doMul(float first, float second) {
		return first * second;
	}
	
	public float doDiv(float first, float second) throws DivisionByZeroException {
		if (second == 0) {
			throw new DivisionByZeroException();
		}
		else {
			return first / second;
		}
	}
	
	public void cancAllDigits() {
		this.curNumber = this.DEFAULT_NUMBER;
		logger.log(Level.INFO, this.curNumber);
		Starter.view.updateDisplay(this.curNumber);
	}
	
	public String getNumber() {
		return this.curNumber;
	}

}
