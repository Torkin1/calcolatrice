package logic.beans;

import java.util.ArrayList;
import java.util.List;

public class OpBean {
	private List<Float> args = new ArrayList<>();
	private int i = 0;

	public OpBean() {}
	public OpBean (float... args) {
		for (float a : args) {
			this.args.add(a);
		}
	}
	
	public float getNextArg() {
		return args.get(i++);
	}
	
	public void addArg(float arg) {
		this.args.add(arg);
	}
}
