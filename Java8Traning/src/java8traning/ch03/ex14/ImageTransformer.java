/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex14;

import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

/**
 * Created by akari on 2015/08/12.
 */
public interface ImageTransformer {

    public Color apply(int x, int y, PixelReader reader);
}
