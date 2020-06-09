package logic.control;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Context {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	private static Context ref = null;
	private State current;
	
	private Context() {
		this.setCurrent(new OnNoOp());
	}
	
	public static Context getReference() {
		if (ref == null) {
			ref = new Context();
		}
		return ref;
	}
	
	public void setCurrent(State current) {
		logger.log(Level.INFO, "setting current state to " + current.getClass().getSimpleName());
		this.current = current;
	}
	
	public void onNumButtonClick(NumButtons b) {
		current.onNumButtonClick(b);
	}
	
	public void onEqButtonClick() {
		current.onEqButtonClick();
	}
	
	public void onCancButtonClick() {
		current.onCancButtonClick();
	}
	
	public void onAddButtonClick() {
		current.onAddButtonClick();
	}
	
	public void onSubButtonClick() {
		current.onSubButtonClick();
	}
	
	public void onMulButtonClick() {
		current.onMulButtonClick();
	}
	
	public void onDivButtonClick() {
		current.onDivButtonClick();
	}
	
	public void onSqrtButtonClick() {
		current.onSqrtButtonClick();
	}
	
	public void goNext() {
		this.current.goNext();
	}
}
