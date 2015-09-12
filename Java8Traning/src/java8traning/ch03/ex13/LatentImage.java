/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex13;

import java8traning.ch03.ex05.ColorTransformer;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by akari on 2015/08/12.
 */
public class LatentImage {
    private Image in;
    private List<ImageTransformer> pendingOperations = new ArrayList<>();

    private LatentImage() {
    }

    private void setInputImage(Image in) {
        this.in = in;
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add((x, y, image) -> f.apply(image[x][y]));
        return this;
    }

    public LatentImage transform(ColorTransformer f) {
        pendingOperations.add((x, y, image) -> f.apply(x, y, image[x][y]));
        return this;
    }

    public LatentImage transform(ImageTransformer f) {
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
        Color[][] image = new Color[width][height];
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                image[x][y] = in.getPixelReader().getColor(x, y);


        for (ImageTransformer f : pendingOperations)
            for (int x = 0; x < width; x++)
                for (int y = 0; y < height; y++) {
                    image[x][y] = f.apply(x, y, image);
                    out.getPixelWriter().setColor(x, y, image[x][y]);
                }
        return out;
    }
}
