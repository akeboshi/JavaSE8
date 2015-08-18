package java8traning.ch04.ex04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import static javafx.beans.binding.Bindings.*;

public class CenterCircle extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Circle circle = new Circle(30, 30, 30);
		circle.setFill(Color.RED);
		Pane pane = new Pane();
		pane.getChildren().add(circle);
		Scene scene = new Scene(pane);
		circle.centerXProperty().bind(divide(scene.widthProperty(), 2.0));
		circle.centerYProperty().bind(divide(scene.heightProperty(), 2.0));
		circle.radiusProperty()
				.bind(divide(
						min(scene.widthProperty(), scene.heightProperty()), 2.0));

		stage.setScene(scene);
		stage.show();

	}

}
