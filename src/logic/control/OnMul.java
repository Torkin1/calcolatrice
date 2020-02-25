package logic.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.view.Starter;

public class OnMul extends State {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private Boolean isEqPressedBeforeInsertingNums = false;

	@Override
	public void onNumButtonClick(NumButtons b) {
		Controller.getReference().cancAllDigits();
		if (isEqPressedBeforeInsertingNums) {
			isEqPressedBeforeInsertingNums = false;
			this.next = new OnNoOp();
			Context.getReference().goNext();
			Context.getReference().onNumButtonClick(b);
		}
		else {
			this.next = new OnAddingDigits(this.getClass(), b.getVal());
			Context.getReference().goNext();
		}
	}

	@Override
	public void onEqButtonClick() {
		this.isEqPressedBeforeInsertingNums = true; 
		Controller.getReference().setPrevNumber(String.valueOf(Controller.getReference().doMul(Float.parseFloat(Controller.getReference().getPrevNumber()), Float.parseFloat(Controller.getReference().getNumber()))));
		logger.log(Level.INFO, Controller.getReference().getPrevNumber());
		Starter.view.updateDisplay(Controller.getReference().getPrevNumber());
		
	}

	@Override
	public void onAddButtonClick() {
		this.next = new OnAdd();
		Context.getReference().goNext();
		
	}

	@Override
	public void onSubButtonClick() {
		this.next = new OnSub();
		Context.getReference().goNext();
		
	}

	@Override
	public void onMulButtonClick() {
		this.next = new OnMul();
		Context.getReference().goNext();
		
	}

	@Override
	public void onDivButtonClick() {
		this.next = new OnDiv();
		Context.getReference().goNext();
		
	}
}
