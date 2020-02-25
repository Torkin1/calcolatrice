package logic.view.component;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class FrameComponent extends ViewComponent {

	@Override
	public Node buildComponent() {
		FXMLLoader frameLoader = new FXMLLoader();
		BorderPane frame = new BorderPane();
		frameLoader.setRoot(frame);
		try (FileInputStream src = new FileInputStream("src/logic/view/component/Frame.fxml")){
			frameLoader.load(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		return frame;
	}

}
