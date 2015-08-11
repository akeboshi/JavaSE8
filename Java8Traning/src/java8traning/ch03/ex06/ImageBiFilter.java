/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */
package java8traning.ch03.ex06;

import java.util.function.BiFunction;

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
public class ImageBiFilter extends Application{
    public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg){
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y,
                        f.apply(in.getPixelReader().getColor(x, y), arg));
        return out;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("test.png");
        int width = (int)image.getWidth();
        int height = (int)image.getHeight();
        Image transFormed = ImageBiFilter.transform(image, (color, brightness) ->
        	color.deriveColor(0, 1, brightness, 1)
        , 1.5);

        FlowPane flowPane = new FlowPane(new ImageView(image),new ImageView(transFormed));
        flowPane.setOrientation(Orientation.HORIZONTAL);

        stage.setScene(new Scene(flowPane, width * 2, height * 2, Color.WHITE));
        stage.show();
    }

    public static void main (String[] args) {
        launch();
    }
}
