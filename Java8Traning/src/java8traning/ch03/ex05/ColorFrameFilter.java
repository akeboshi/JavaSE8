/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex05;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

/**
 * Created by akari on 2015/08/10.
 */
public class ColorFrameFilter extends Application{
    public static Image transform(Image in, ColorTransformer f){
        return subTransform(in, (x, y) -> f.apply(x, y, in.getPixelReader().getColor(x, y)));
    }

    public static Image transform(Image in, UnaryOperator<Color> f) {
        return subTransform(in, (x,y) -> f.apply(in.getPixelReader().getColor(x,y)));
    }

    protected static Image subTransform(Image in, BiFunction<Integer, Integer, Color> f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y, f.apply(x,y));
        return out;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("test.png");
        int width = (int)image.getWidth();
        int height = (int)image.getHeight();
        Image transFormed = ColorFrameFilter.transform(image, (x, y, color) -> {
            if (x < 10 || y < 10 || x > width - 10 || y > height - 10) return Color.GRAY;
            return color;
        });

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
