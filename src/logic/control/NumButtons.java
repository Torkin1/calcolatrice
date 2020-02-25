package logic.control;

public enum NumButtons {
	
	ZERO (0),
	ONE (1),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9),
	;
	
	private int val;
	
	private NumButtons(int num) {
		this.val = num;
	}
	
	public int getVal() {
		return this.val;
	}
}
