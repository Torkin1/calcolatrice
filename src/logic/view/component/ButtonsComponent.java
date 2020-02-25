package logic.view.component;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class ButtonsComponent extends ViewComponent {

	@Override
	public Node buildComponent() {
		FXMLLoader buttonsLoader = new FXMLLoader();
		GridPane frame = new GridPane();
		buttonsLoader.setRoot(frame);
		try (FileInputStream src = new FileInputStream("src/logic/view/component/Buttons.fxml")){
			buttonsLoader.load(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		return frame;
	}

}
