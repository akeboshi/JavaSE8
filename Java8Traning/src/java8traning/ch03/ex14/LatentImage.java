/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex14;

import java8traning.ch03.ex05.ColorTransformer;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
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

    private LatentImage(Image in) {
        this();
        this.setInputImage(in);
    }

    private void setInputImage(Image in) {
        this.in = in;
    }


    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add((x, y, r) -> f.apply(r.getColor(x, y)));
        return this;
    }

    public LatentImage transform(ColorTransformer f) {
        pendingOperations.add((x, y, r) -> f.apply(x, y, r.getColor(x, y)));
        return this;
    }

    public LatentImage transform(ImageTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        ImagePixelReader reader = new ImagePixelReader(width, height, in.getPixelReader());

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                for (ImageTransformer f : pendingOperations)
                    reader.setColorCache(x,y,f.apply(x, y, reader));
            }
        return reader.getImage();
    }
}
