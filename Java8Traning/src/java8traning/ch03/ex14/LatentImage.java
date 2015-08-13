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
    private Color[][] cashe;

    private LatentImage() {
    }

    private LatentImage(Image in) {
        this.setInputImage(in);
        this.cashe = new Color[(int)in.getWidth()][(int)in.getHeight()];
    }

    private void setInputImage(Image in) {
        this.in = in;
    }

    private Color getColor (int x, int y, PixelReader r) {
        if (cashe[x][y] == null)
            return r.getColor(x, y);
        return cashe[x][y];
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add((x, y, r) -> f.apply(getColor(x, y, r)));
        return this;
    }

    public LatentImage transform(ColorTransformer f) {
        pendingOperations.add((x, y, r) -> f.apply(x, y, getColor(x, y, r)));
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
        PixelReader reader = in.getPixelReader();

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                for (ImageTransformer f : pendingOperations)
                    cashe[x][y] = f.apply(x, y, reader);
                out.getPixelWriter().setColor(x, y, cashe[x][y]);
            }
        return out;
    }
}
