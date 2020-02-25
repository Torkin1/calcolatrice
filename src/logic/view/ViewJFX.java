package logic.view;

import javafx.scene.Scene;

public abstract class ViewJFX {
	public abstract void updateDisplay(String updatedVal);
	public abstract Scene buildScene();
}
