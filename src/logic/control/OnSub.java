package logic.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.beans.OpBean;
import logic.view.Starter;

public class OnSub extends OnOp {

	private final Logger logger = Logger.getLogger(this.getClass().getName());
	

	@Override
	public void onEqButtonClick() {
		this.isEqPressedBeforeInsertingNums = true;
		OpBean bean = new OpBean(
				Float.parseFloat(Controller.getReference().getPrevNumber()),
				Float.parseFloat(Controller.getReference().getNumber())
				);
		Controller.getReference().setPrevNumber(
				String.valueOf(
						Controller.getReference().doSub(
								bean
								)
						)
				);
		logger.log(Level.INFO, Controller.getReference().getPrevNumber());
		Starter.view.updateDisplay(Controller.getReference().getPrevNumber());
	}
}
