/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex08;

import java8traning.ch03.ex05.ColorFrameFilter;
import java8traning.ch03.ex05.ColorTransformer;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by akari on 2015/08/11.
 */
public class ColorFrameFilterKai extends Application {
    public static ColorTransformer colorFrame(Image in, int frameWidth, Color frameColor) {
        return (x, y, color) -> {
            int width = (int) in.getWidth();
            int height = (int) in.getHeight();
            if (x < frameWidth || y < frameWidth ||
                    x > width - frameWidth || y > height - frameWidth)
                return frameColor;
            return color;
        };
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("test.png");
        Image transFormed = ColorFrameFilter.transform(image, colorFrame(image, 20, Color.AQUA));

        FlowPane flowPane = new FlowPane(new ImageView(image), new ImageView(transFormed));
        // 方向を設定する(Orientation.VERTICAL : 垂直／Orientation.HORIZONTAL : 水平)
        flowPane.setOrientation(Orientation.HORIZONTAL);

        stage.setScene(new Scene(flowPane, image.getWidth() * 2, image.getHeight() * 2, Color.WHITE));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
