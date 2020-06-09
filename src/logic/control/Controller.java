package logic.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Math;

import logic.beans.OpBean;
import logic.view.Starter;

public class Controller {
	
	public final String DEFAULT_NUMBER = "0";
	
	private static Controller ref = null;
	// Controller can store up to two numbers. Prev number holds results of ops, and curNumber stores value digited by user
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
	
	public float doAdd(OpBean bean) {
		return bean.getNextArg() + bean.getNextArg();
	}
	
	public float doSub(OpBean bean) {
		return bean.getNextArg() - bean.getNextArg();
	}
	
	public float doMul(OpBean bean) {
		return bean.getNextArg() * bean.getNextArg();
	}
	
	public float doDiv(OpBean bean) throws DivisionByZeroException {
		float first = bean.getNextArg();
		float second = bean.getNextArg();
		if (second == 0) {
			throw new DivisionByZeroException();
		}
		else {
			return first / second;
		}
	}
	
	public float doSqrt(OpBean bean) throws NegativeSqrtArgException {
		float arg = bean.getNextArg();
		if (arg < 0) {
			throw new NegativeSqrtArgException();
		}
		return (float) Math.pow(arg, 0.5);
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
