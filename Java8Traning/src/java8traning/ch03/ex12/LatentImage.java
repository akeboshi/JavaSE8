/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex12;

import java8traning.ch03.ex05.ColorTransformer;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by akari on 2015/08/11.
 */
public class LatentImage {
    private Image in;
    private List<ColorTransformer> pendingOperations = new ArrayList<>();

    private LatentImage(){}

    private void setInputImage(Image in) {
        this.in = in;
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add((x, y, color) -> f.apply(color));
        return this;
    }

    public LatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public static LatentImage from(Image in) {
        LatentImage img = new LatentImage();
        img.setInputImage(in);
        return img;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (ColorTransformer f : pendingOperations)
                    c = f.apply(x, y, c);
                out.getPixelWriter().setColor(x, y, c);
            }
        return out;
    }
}
