/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex05;

import javafx.scene.paint.Color;

/**
 * Created by akari on 2015/08/10.
 */
interface ColorTransformer {
    Color apply(int x, int y, Color color);
}
