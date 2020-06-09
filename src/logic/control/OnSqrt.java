package logic.control;

import java.util.logging.Level;
import java.util.logging.Logger;

import logic.beans.OpBean;
import logic.view.Starter;

public class OnSqrt extends OnOp {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Override
	public void onEqButtonClick() {
		this.isEqPressedBeforeInsertingNums = true;
		OpBean bean = new OpBean(
				Float.parseFloat(Controller.getReference().getPrevNumber())
				);
		try {
			Controller.getReference().setPrevNumber(String.valueOf(Controller.getReference().doSqrt(bean)));
		} catch (NegativeSqrtArgException e) {
			logger.log(Level.WARNING, e.getMessage());
			this.next = new OnError();
			Context.getReference().goNext();
			return;
		}
		logger.log(Level.INFO, Controller.getReference().getPrevNumber());
		Starter.view.updateDisplay(Controller.getReference().getPrevNumber());
	}
}
