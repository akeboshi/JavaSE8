/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

package java8traning.ch03.ex09;

import java.lang.reflect.Field;
import java.nio.file.NoSuchFileException;
import java.util.Comparator;

/**
 * Created by akari on 2015/08/11.
 */
public class LexicographicComparator {
    public static <T> Comparator<T> lexicographicComparator (String... fieldNames){
        return (o1, o2) -> {
            for (String s : fieldNames){
                T o1f = getValue(o1, s);
                T o2f = getValue(o2, s);
                if (!o1f.equals(o2f))
                    return ((Comparable)o1f).compareTo(o2f);
            }
            return 0;
        };
    }

    private static <T> T getValue(T t, String fieldName){
        Class<?> cls = t.getClass();
        T cmp = null;
        try {
            Field fld = cls.getDeclaredField(fieldName);
            fld.setAccessible(true);
            cmp = (T)fld.get(t);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (cmp == null)
            throw new IllegalArgumentException();
        return cmp;
    }

}
