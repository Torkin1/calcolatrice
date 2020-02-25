package logic.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Starter extends Application{

	public static ViewJFX view;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Starter.view = ViewJFXFactory.getReference().getView(Theme.CLASSIC);
		primaryStage.setScene(Starter.view.buildScene());
		primaryStage.setTitle("MEGACALCOLO 2.0");
		primaryStage.show();
	}
}
