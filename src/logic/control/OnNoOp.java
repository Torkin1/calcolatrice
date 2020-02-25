package logic.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.view.Starter;

public class OnNoOp extends State {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public OnNoOp() {
		Controller.getReference().cancAllDigits();
		Starter.view.updateDisplay(Controller.getReference().DEFAULT_NUMBER);
	}
	
	@Override
	public void onNumButtonClick(NumButtons b) {
		Controller.getReference().addDigit(b.getVal());
	}

	@Override
	public void onEqButtonClick() {
		logger.log(Level.INFO, Controller.getReference().getNumber());
		Starter.view.updateDisplay(Controller.getReference().getNumber());
	}

	@Override
	public void onAddButtonClick() {
		Controller.getReference().setPrevNumber(Controller.getReference().getNumber());
		this.next = new OnAdd();
		Context.getReference().goNext();
		
	}

	@Override
	public void onSubButtonClick() {
		Controller.getReference().setPrevNumber(Controller.getReference().getNumber());
		this.next = new OnSub();
		Context.getReference().goNext();
		
	}

	@Override
	public void onMulButtonClick() {
		Controller.getReference().setPrevNumber(Controller.getReference().getNumber());
		this.next = new OnMul();
		Context.getReference().goNext();
		
	}

	@Override
	public void onDivButtonClick() {
		Controller.getReference().setPrevNumber(Controller.getReference().getNumber());
		this.next = new OnDiv();
		Context.getReference().goNext();
		
	}

	

}
