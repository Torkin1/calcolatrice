package logic.control;

public abstract class OnOp extends State {

	protected Boolean isEqPressedBeforeInsertingNums = false;

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
	@Override
	public void onSqrtButtonClick() {
		this.next = new OnSqrt();
		Context.getReference().goNext();
		Context.getReference().onEqButtonClick();
	};

}
