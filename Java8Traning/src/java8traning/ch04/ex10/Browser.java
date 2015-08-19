package java8traning.ch04.ex10;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Browser extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Button back = new Button("<-");
		TextField url = new TextField();
		WebView browser = new WebView();

		WebEngine engine = browser.getEngine();
		back.setOnAction(event -> {
			engine.getHistory().go(-1);
		});
		back.disableProperty().bind(
				Bindings.equal(0, engine.getHistory().currentIndexProperty()));
		url.setOnAction(event -> {
			engine.load(url.getText());
		});
		engine.documentProperty().addListener(
				(observable, oldValue, newValue) -> stage.setTitle(
						engine.getTitle() == null ? "" : engine.getTitle()));
		engine.locationProperty().addListener(
				(observable, oldValue, newValue) ->
					url.setText(newValue));
		engine.load("http://google.co.jp/");

		HBox hbox = new HBox(back, url);
		HBox.setHgrow(url, Priority.ALWAYS);
		VBox vbox = new VBox(hbox, browser);
		VBox.setVgrow(browser, Priority.ALWAYS);

		stage.setScene(new Scene(vbox, 720, 480));
		stage.show();

	}

}
