/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex11;

import java8traning.ch03.ex05.ColorFrameFilter;
import java8traning.ch03.ex05.ColorTransformer;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;

/**
 * Created by akari on 2015/08/11.
 */
public class ColorTransFormerCompose extends Application{
    public static ColorTransformer compose (ColorTransformer op1, ColorTransformer op2) {
        return (x, y, color) -> op1.apply(x, y, op2.apply(x, y, color));
    }

    public static ColorTransformer toColorTransformer (UnaryOperator<Color> op) {
        return (x, y, color) -> op.apply(color);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("test.png");
        int width = (int)image.getWidth();
        int height = (int)image.getHeight();
        Image transFormed = ColorFrameFilter.transform(image, compose(
                toColorTransformer(Color::brighter),
                (x, y, color) -> {
                    if (x < 10 || y < 10 || x > width - 10 || y > height - 10) return Color.GRAY;
                    return color;
                }));

        FlowPane flowPane = new FlowPane(new ImageView(image),new ImageView(transFormed));
        // 方向を設定する(Orientation.VERTICAL : 垂直／Orientation.HORIZONTAL : 水平)
        flowPane.setOrientation(Orientation.HORIZONTAL);

        stage.setScene(new Scene(flowPane, width * 2, height * 2, Color.WHITE));
        stage.show();
    }

    public static void main (String[] args) {
        launch();
    }
}
