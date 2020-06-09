package logic.control;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import logic.beans.OpBean;

public class OnAddingDigits extends State {

	// op is the operation previous to adding digits.
	private Class<? extends State> op;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public OnAddingDigits(Class<? extends State> op, int firstDigit) {
		Controller.getReference().addDigit(firstDigit);
		this.op = op;
	}

	@Override
	public void onNumButtonClick(NumButtons b) {
		// More digits to concatenate to the number displayed
		Controller.getReference().addDigit(b.getVal());
	}

	@Override
	public void onEqButtonClick() {
		// Done digiting, time to elaborate using a new instance of op
		try {
			this.next = op.newInstance();
			Context.getReference().goNext();
			Context.getReference().onEqButtonClick();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.toString());
		}
	}

	private void onOpButtonClick(OpBean bean) {
		// if button clicked is an op, invokes the right controller method to do the calculus and store its result in Controller.prevNumber
		try {
			Method opMethod = null;
			Method[] controllerMethods = Controller.class.getMethods();
			for (int i = 0; i < controllerMethods.length; i ++) {
				if (controllerMethods[i].getName().substring(2).equals(op.getSimpleName().substring(2))) {
					opMethod = controllerMethods[i];
					logger.log(Level.INFO, "retrieved method: {0}", opMethod.getName());
				}
			}
			Controller.getReference().setPrevNumber(
					String.valueOf(
							opMethod.invoke(
									Controller.getReference(), 
									bean
									)
							)
					);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			logger.log(Level.SEVERE, e.toString());
		} catch (InvocationTargetException  e) {
			logger.log(Level.WARNING, e.getCause().toString());
				
			this.next = new OnError();
				Context.getReference().goNext();
				return;
		}
	}
	
	@Override
	public void onAddButtonClick() {
		this.onOpButtonClick(new OpBean(
				Float.parseFloat(Controller.getReference().getPrevNumber()),
				Float.parseFloat(Controller.getReference().getNumber())
				));
		this.next = new OnAdd();
		Context.getReference().goNext();
		Context.getReference().onAddButtonClick();
	}

	@Override
	public void onSubButtonClick() {
		this.onOpButtonClick(new OpBean(
				Float.parseFloat(Controller.getReference().getPrevNumber()),
				Float.parseFloat(Controller.getReference().getNumber())
				));
		this.next = new OnSub();
		Context.getReference().goNext();
		Context.getReference().onSubButtonClick();

	}

	@Override
	public void onMulButtonClick() {
		this.onOpButtonClick(new OpBean(
				Float.parseFloat(Controller.getReference().getPrevNumber()),
				Float.parseFloat(Controller.getReference().getNumber())
				));
		this.next = new OnMul();
		Context.getReference().goNext();
		Context.getReference().onMulButtonClick();
	}

	@Override
	public void onDivButtonClick() {
		this.onOpButtonClick(new OpBean(
				Float.parseFloat(Controller.getReference().getPrevNumber()),
				Float.parseFloat(Controller.getReference().getNumber())
				));
		this.next = new OnAdd();
		Context.getReference().goNext();
		Context.getReference().onAddButtonClick();
	}

	@Override
	public void onSqrtButtonClick() {
		this.onOpButtonClick(new OpBean(
				Float.parseFloat(Controller.getReference().getPrevNumber()),
				Float.parseFloat(Controller.getReference().getNumber())
				));
		this.next = new OnSqrt();
		Context.getReference().goNext();
		Context.getReference().onSqrtButtonClick();
	}

}
