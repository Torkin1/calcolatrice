package logic.control;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OnAddingDigits extends State {

	private Class<? extends State> op;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	public OnAddingDigits(Class<? extends State> op, int firstDigit) {
		Controller.getReference().addDigit(firstDigit);
		this.op = op;
	}

	@Override
	public void onNumButtonClick(NumButtons b) {
		Controller.getReference().addDigit(b.getVal());

	}

	@Override
	public void onEqButtonClick() {
		try {
			this.next = op.newInstance();
			Context.getReference().goNext();
			Context.getReference().onEqButtonClick();
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.toString());
		}
	}

	@Override
	public void onAddButtonClick() {
		
		try {
			Method opMethod = null;
			Method[] controllerMethods = Controller.class.getMethods();
			for (int i = 0; i < controllerMethods.length; i ++) {
				if (controllerMethods[i].getName().substring(2).compareTo(op.getSimpleName().substring(2)) == 0) {
					opMethod = controllerMethods[i];
				}
			}
			Controller.getReference().setPrevNumber(String.valueOf(opMethod.invoke(Controller.getReference(), Float.parseFloat(Controller.getReference().getPrevNumber()), Float.parseFloat(Controller.getReference().getNumber()))));
			this.next = new OnAdd();
			Context.getReference().goNext();
			Context.getReference().onAddButtonClick();
		} catch (IllegalAccessException | IllegalArgumentException e) {
			logger.log(Level.SEVERE, e.toString());
		} catch (InvocationTargetException  e) {
			logger.log(Level.WARNING, e.getCause().toString());
			if (e.getCause().getClass() == DivisionByZeroException.class) {
				this.next = new OnError();
				Context.getReference().goNext();
				return;
			}
		}
		

	}

	@Override
	public void onSubButtonClick() {
		try {
			Method opMethod = null;
			Method[] controllerMethods = Controller.class.getMethods();
			for (int i = 0; i < controllerMethods.length; i ++) {
				if (controllerMethods[i].getName().substring(2).compareTo(op.getSimpleName().substring(2)) == 0) {
					opMethod = controllerMethods[i];
				}
			}
			Controller.getReference().setPrevNumber(String.valueOf(opMethod.invoke(Controller.getReference(), Float.parseFloat(Controller.getReference().getPrevNumber()), Float.parseFloat(Controller.getReference().getNumber()))));
			this.next = new OnSub();
			Context.getReference().goNext();
			Context.getReference().onSubButtonClick();
		} catch (IllegalAccessException | IllegalArgumentException e) {
			logger.log(Level.SEVERE, e.toString());
		} catch (InvocationTargetException  e) {
			logger.log(Level.WARNING, e.getCause().toString());
			if (e.getCause().getClass() == DivisionByZeroException.class) {
				this.next = new OnError();
				Context.getReference().goNext();
				return;
			}
		}

	}

	@Override
	public void onMulButtonClick() {
		try {
			Method opMethod = null;
			Method[] controllerMethods = Controller.class.getMethods();
			for (int i = 0; i < controllerMethods.length; i ++) {
				if (controllerMethods[i].getName().substring(2).compareTo(op.getSimpleName().substring(2)) == 0) {
					opMethod = controllerMethods[i];
				}
			}
			Controller.getReference().setPrevNumber(String.valueOf(opMethod.invoke(Controller.getReference(), Float.parseFloat(Controller.getReference().getPrevNumber()), Float.parseFloat(Controller.getReference().getNumber()))));
			this.next = new OnMul();
			Context.getReference().goNext();
			Context.getReference().onMulButtonClick();
		} catch (IllegalAccessException | IllegalArgumentException e) {
			logger.log(Level.SEVERE, e.toString());
		} catch (InvocationTargetException  e) {
			logger.log(Level.WARNING, e.getCause().toString());
			if (e.getCause().getClass() == DivisionByZeroException.class) {
				this.next = new OnError();
				Context.getReference().goNext();
				return;
			}
		}
	}

	@Override
	public void onDivButtonClick() {
		try {
			Method opMethod = null;
			Method[] controllerMethods = Controller.class.getMethods();
			for (int i = 0; i < controllerMethods.length; i ++) {
				if (controllerMethods[i].getName().substring(2).compareTo(op.getSimpleName().substring(2)) == 0) {
					opMethod = controllerMethods[i];
				}
			}
			Controller.getReference().setPrevNumber(String.valueOf(opMethod.invoke(Controller.getReference(), Float.parseFloat(Controller.getReference().getPrevNumber()), Float.parseFloat(Controller.getReference().getNumber()))));
			this.next = new OnDiv();
			Context.getReference().goNext();
			Context.getReference().onDivButtonClick();
		} catch (IllegalAccessException | IllegalArgumentException e) {
			logger.log(Level.SEVERE, e.toString());
		} catch (InvocationTargetException  e) {
			logger.log(Level.WARNING, e.getCause().toString());
			if (e.getCause().getClass() == DivisionByZeroException.class) {
				this.next = new OnError();
				Context.getReference().goNext();
				return;
			}
		}
	}

}
