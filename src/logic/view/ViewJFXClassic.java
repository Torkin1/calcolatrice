package logic.view;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import logic.view.component.ButtonsComponent;
import logic.view.component.DisplayComponent;
import logic.view.component.FrameComponent;

public class ViewJFXClassic extends ViewJFX {
	
	private TextField display;
	
	@Override
	public Scene buildScene() {
		AnchorPane root = new AnchorPane();
		TextField display = (TextField) (new DisplayComponent()).buildComponent();
		this.display = display;
		Node buttons = (new ButtonsComponent()).buildComponent();
		BorderPane frame = (BorderPane) (new FrameComponent()).buildComponent();
		
		
		VBox vBox = new VBox();
		vBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		vBox.getChildren().addAll(display, buttons);
		frame.setCenter(vBox);
		root.getChildren().addAll(frame);
		return new Scene(root);
	}

	@Override
	public void updateDisplay(String updatedVal) {
		display.setText(updatedVal);
	}

}
