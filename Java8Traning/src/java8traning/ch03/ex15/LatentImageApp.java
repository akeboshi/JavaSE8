/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex15;

import java8traning.ch03.ex05.ColorTransformer;
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
    static public void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("test.png");
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        ColorTransformer grayFrame = (x, y, color) -> {
            if (x < 10 || y < 10 || x > width - 10 || y > height - 10) return Color.GRAY;
            return color;
        };
        ImageTransformer avgFilter = (x, y, reader) -> {
            double r = 0, g = 0, b = 0;
            double n = 0;
            for (int i = -1; i < 1; i++)
                for (int j = -1; j < 1; j++) {
                    if (x + i >= 0 && y + j >= 0) {
                        n++;
                        Color c = reader.getColor(x + i, y + j);
                        r += c.getRed();
                        g += c.getGreen();
                        b += c.getBlue();
                    }
                }
            return Color.color(r / n, g / n, b / n);
        };
        Image transFormed = ParallelLatentImage.from(image)
                .transform(avgFilter)
                .transform(Color::grayscale)
                .transform(grayFrame)
                .toImage();
        FlowPane flowPane = new FlowPane(new ImageView(image), new ImageView(transFormed));
        // 方向を設定する(Orientation.VERTICAL : 垂直／Orientation.HORIZONTAL : 水平)
        flowPane.setOrientation(Orientation.HORIZONTAL);

        stage.setScene(new Scene(flowPane, width * 2, height * 2, Color.WHITE));
        stage.show();
    }
}
