package logic.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.view.Starter;

public class OnNoOp extends OnOp {

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
		super.onAddButtonClick();
		
	}

	@Override
	public void onSubButtonClick() {
		Controller.getReference().setPrevNumber(Controller.getReference().getNumber());
		super.onSubButtonClick();
		
	}

	@Override
	public void onMulButtonClick() {
		Controller.getReference().setPrevNumber(Controller.getReference().getNumber());
		super.onMulButtonClick();
		
	}

	@Override
	public void onDivButtonClick() {
		Controller.getReference().setPrevNumber(Controller.getReference().getNumber());
		super.onDivButtonClick();
		
	}

	@Override
	public void onSqrtButtonClick() {
		Controller.getReference().setPrevNumber(Controller.getReference().getNumber());
		super.onSqrtButtonClick();
	}

	

}
