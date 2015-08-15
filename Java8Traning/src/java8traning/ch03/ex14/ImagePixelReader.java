/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex14;

import javafx.scene.image.*;
import javafx.scene.paint.Color;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by akari on 2015/08/15.
 */
public class ImagePixelReader implements PixelReader {
    private PixelReader reader;
    private Color[][] cache;

    private ImagePixelReader() {
    }

    public ImagePixelReader(int x, int y,PixelReader reader) {
        this();
        this.reader = reader;
        cache = new Color[x][y];
    }

    @Override
    public PixelFormat getPixelFormat() {
        return reader.getPixelFormat();
    }

    @Override
    public int getArgb(int x, int y) {
        return reader.getArgb(x, y);
    }

    @Override
    public Color getColor (int x, int y) {
        if (cache[x][y] == null)
            return reader.getColor(x, y);
        return cache[x][y];
    }

    public void setColorCache (int x, int y, Color c) {
        if (c == null) cache[x][y] = c;
        cache[x][y] = c;
    }

    @Override
    public <T extends Buffer> void getPixels(int x, int y, int w, int h, WritablePixelFormat<T> pixelformat, T buffer, int scanlineStride) {
        reader.getPixels(x, y, w, h, pixelformat, buffer, scanlineStride);
    }

    @Override
    public void getPixels(int x, int y, int w, int h, WritablePixelFormat<ByteBuffer> pixelformat, byte[] buffer, int offset, int scanlineStride) {
        reader.getPixels(x, y, w, h, pixelformat, buffer, offset, scanlineStride);
    }

    @Override
    public void getPixels(int x, int y, int w, int h, WritablePixelFormat<IntBuffer> pixelformat, int[] buffer, int offset, int scanlineStride) {
        reader.getPixels(x, y, w, h, pixelformat, buffer, offset, scanlineStride);
    }

    public Image getImage() {
        int x = cache.length;
        int y = cache[0].length;
        WritableImage out = new WritableImage(x, y);
        for (int i = 0; i < x ; i++)
            for (int j = 0; j < y ; j++)
                out.getPixelWriter().setColor(i, j, getColor(i, j));
        return out;
    }
}
