/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex03;

import java.util.function.BooleanSupplier;

/**
 * Created by akari on 2015/08/10.
 * 設問：
 * Java 1.4 は、予約語assertでもって、Java言語にアサーションを追加しました。
 * なぜ、アサーションは、ライブラリの機能として提供されなかったのでしょう。 Java 8 ではライブラリの機能として実装することができますか。
 * <p>
 * 解答：
 * java 1.4では遅延実行が出来ず、Assertを無効にしている場合にコストをかけずに実装をすることが出来ないため。
 * java 8 では評価式の遅延実行を用いれば、実装可能？
 * (コンパイラがassertの処理で、static final boolean $assertionsDisabled を作成し、それを用いて処理を行っているため)
 */
public class MyAssert {
    static final boolean assertionsDisabled;

    static {
        assertionsDisabled = !(MyAssert.class.desiredAssertionStatus());
    }

    public static void myAssert(BooleanSupplier sup) {
        if (!assertionsDisabled &&
                !sup.getAsBoolean())
            throw new AssertionError();
    }
}
