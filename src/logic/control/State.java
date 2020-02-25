package logic.control;

public abstract class State {
	
	protected State next;
	
	public void goNext() {
		Context.getReference().setCurrent(next);
	}
	
	public void onCancButtonClick() {
		Controller.getReference().cancAllDigits();
		this.next = new OnNoOp();
		Context.getReference().goNext();

	}
	public abstract void onNumButtonClick(NumButtons b);
	public abstract void onEqButtonClick();
	public abstract void onAddButtonClick();
	public abstract void onSubButtonClick();
	public abstract void onMulButtonClick();
	public abstract void onDivButtonClick();
}
