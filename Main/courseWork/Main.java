package courseWork;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
* the entry point for the program as all java applications need a main class to start From
* 
*/
public class Main extends Application {
	
	/**
	 * This function is where the program will start and setup our UI where the user can enter values
	 *
	 * @param primaryStage This is passed in so we can create our UI and show the options for creating the 
	 * simulation
	 * 
	 * @throws printStackTrace if there is an error in setting up the UI the program wont crash 
	 * and will output the code executed leading up to the error
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Menu.fxml"));
			loader.setController(new MenuController());
			final Parent root = loader.load();

			final Scene scene = new Scene(root, 300, 500);
			primaryStage.setTitle("List database");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
