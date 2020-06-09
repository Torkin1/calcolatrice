package logic.view.component;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;

public class DisplayComponent extends ViewComponent {

	@Override
	public Node buildComponent() {
		FXMLLoader displayLoader = new FXMLLoader();
		TextField display = new TextField();
		displayLoader.setRoot(display);
		try (FileInputStream src = new FileInputStream("src/logic/view/component/Display.fxml")){
			displayLoader.load(src);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
		return display;
	}

}
