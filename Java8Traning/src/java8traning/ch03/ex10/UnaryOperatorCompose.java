/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex10;

import java8traning.ch03.ex05.ColorFrameFilter;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * default <V> Function<V,R> compose(Function<? super V,? extends T> before)
 *
 * UnaryOperator op = Color::brighter とすると、opの型はUnarayOperator<Color> であり
 * composeの引数、戻り値ともに、Function<V,R>であるので、transformの引数のUnarayOperator<Color>
 * と一致しないため、適切ではない。
 * 設問の呼び出しに対応するには、public static <T> UnaryOperator<T> compose (
 * UnaryOperator<T> op1, UnaryOperator<T> op2) を実装する。
 * ストラクチャル型であれば、返り値に関してその場で指定できるが、ノミナル型であると、
 * 事前に関数インターフェイスで意図を定義しなければならず、意図から外れると、うまく適合できなくなる。
 * Created by akari on 2015/08/11.
 */
public class UnaryOperatorCompose extends ColorFrameFilter{
    public static <T> UnaryOperator<T> compose(UnaryOperator<T> op1, UnaryOperator<T> op2) {
        return t -> op1.apply(op2.apply(t));
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("test.png");
        int width = (int)image.getWidth();
        int height = (int)image.getHeight();
        Image transFormed = UnaryOperatorCompose.transform(image, compose(Color::brighter,Color::grayscale));

        FlowPane flowPane = new FlowPane(new ImageView(image),new ImageView(transFormed));
        // 方向を設定する(Orientation.VERTICAL : 垂直／Orientation.HORIZONTAL : 水平)
        flowPane.setOrientation(Orientation.HORIZONTAL);

        stage.setScene(new Scene(flowPane, width * 2, height * 2, Color.WHITE));
        stage.show();
    }

    public static void main (String[] args) {
        launch();
    }
}
