/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex14;

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
        ImageTransformer edgeFilter = (x, y, reader) -> {
            Color c = reader.getColor(x, y);

            Color n;
            if ( y == 0)
                n = reader.getColor(x, y);
            else
                n = reader.getColor(x , y - 1);

            Color e;
            if ( x == 0)
                e = reader.getColor(x, y);
            else
                e = reader.getColor(x - 1, y);


            Color w;
            if ( x == width - 1)
                w = reader.getColor(x, y);
            else
                w = reader.getColor(x + 1, y);

            Color s;
            if ( y == height - 1)
                s = reader.getColor(x, y);
            else
                s = reader.getColor(x, y + 1);
            double r = c.getRed() * 4 - n.getRed() - e.getRed() - w.getRed() - s.getRed();
            r = r > 1.0 ? 1.0 : r;
            double g = c.getGreen() * 4 - n.getGreen() - e.getGreen() - w.getGreen() - s.getGreen();
            g = g > 1.0 ? 1.0 : g;
            double b = c.getBlue() * 4 - n.getBlue() - e.getBlue() - w.getBlue() - s.getBlue();
            b = b > 1.0 ? 1.0 : b;
            return Color.color(r < 0.0 ? 0.0 : r, g < 0.0 ? 0 : g, b < 0.0 ? 0 : b);
        };
        Image transFormed = LatentImage.from(image)
                .transform(edgeFilter)
            //    .transform(Color::grayscale)
             //   .transform(grayFrame)
                .toImage();
        FlowPane flowPane = new FlowPane(new ImageView(image), new ImageView(transFormed));
        // 方向を設定する(Orientation.VERTICAL : 垂直／Orientation.HORIZONTAL : 水平)
        flowPane.setOrientation(Orientation.HORIZONTAL);

        stage.setScene(new Scene(flowPane, width * 2, height * 2, Color.WHITE));
        stage.show();
    }
}
