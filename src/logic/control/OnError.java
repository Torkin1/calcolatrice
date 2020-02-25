package logic.control;

import logic.view.Starter;

public class OnError extends State {

	public OnError() {
		Starter.view.updateDisplay("ERROR!");
	}
	
	@Override
	public void onNumButtonClick(NumButtons b) {
		return;

	}

	@Override
	public void onEqButtonClick() {
		return;

	}

	@Override
	public void onAddButtonClick() {
		return;

	}

	@Override
	public void onSubButtonClick() {
		return;

	}

	@Override
	public void onMulButtonClick() {
		return;

	}

	@Override
	public void onDivButtonClick() {
		return;

	}

}
