/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex15;

import java8traning.ch03.ex05.ColorTransformer;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

/**
 * Created by akari on 2015/08/12.
 */
public class ParallelLatentImage {
    private Image in;
    private List<ImageTransformer> pendingOperations = new ArrayList<>();

    private ParallelLatentImage() {
    }

    private ParallelLatentImage(Image in) {
        this.setInputImage(in);
    }

    private void setInputImage(Image in) {
        this.in = in;
    }

    public ParallelLatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add((x, y, r) -> f.apply(r.getColor(x, y)));
        return this;
    }

    public ParallelLatentImage transform(ColorTransformer f) {
        pendingOperations.add((x, y, r) -> f.apply(x, y, r.getColor(x, y)));
        return this;
    }

    public ParallelLatentImage transform(ImageTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public static ParallelLatentImage from(Image in) {
        return new ParallelLatentImage(in);
    }

    public Image toImage() {
        int n = Runtime.getRuntime().availableProcessors();
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        ImagePixelReader reader = new ImagePixelReader(width, height, in.getPixelReader());

        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++) {
                int fromY = i * height / n;
                int toY = (i + 1)  * height / n;
                pool.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                    for (int x = 0; x < width; x++)
                        for (int y = fromY; y < toY; y++) {
                            for (ImageTransformer f : pendingOperations)
                                reader.setColorCache(x, y, f.apply(x, y, reader));
                        }
                });
            }
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e){
            e.printStackTrace();;
        }
        return reader.getImage();
    }
}
