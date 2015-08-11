/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex12;

import java8traning.ch03.ex05.ColorFrameFilter;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by akari on 2015/08/11.
 */
public class LatentImageApp extends Application {
    static public void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("test.png");
        int width = (int)image.getWidth();
        int height = (int)image.getHeight();
        Image transFormed = LatentImage.from(image)
                .transform(Color::grayscale)
                .transform((x, y, color) -> {
                    if (x < 10 || y < 10 || x > width - 10 || y > height - 10) return Color.GRAY;
                    return color;
                })
                .toImage();
        FlowPane flowPane = new FlowPane(new ImageView(image),new ImageView(transFormed));
        // 方向を設定する(Orientation.VERTICAL : 垂直／Orientation.HORIZONTAL : 水平)
        flowPane.setOrientation(Orientation.HORIZONTAL);

        stage.setScene(new Scene(flowPane, width * 2, height * 2, Color.WHITE));
        stage.show();
    }
}
