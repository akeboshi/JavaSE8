package java8traning.ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		String msg = "Hello,JavaFX";
		Label msgLabel = new Label();
		msgLabel.setFont(new Font(100));
		TextField msgTextField = new TextField(msg);
		msgLabel.textProperty().bind(msgTextField.textProperty());
		stage.setScene(new Scene(new VBox(msgLabel, msgTextField)));
		stage.setTitle("Hello,JavaFX World");
		stage.show();
	}
}
