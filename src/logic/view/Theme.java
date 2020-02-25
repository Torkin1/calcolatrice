package logic.view;

public enum Theme {
	CLASSIC ("Classic")
;

	private String name;

	private Theme (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
