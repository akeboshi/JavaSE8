/*
 * Copyright (c) 2015. Isao Aruga. All rights reserved.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8traning.ch03.ex01;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 条件的なロギングを提供することで、遅延ロギング技法を強化しなさい。 典型的な呼び出しは、
 * logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10])
 * となります。ロガーがメッセージをロギングしないのであれば、 その条件を評価しないようにしなさい
 *
 * @author akari
 */
public class MyLogger {
        private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        public void logIf (Level level, Supplier<Boolean> predicate, Supplier<String> msg) {
            if (logger.isLoggable(level) && predicate.get())
                logger.info(msg.get());
        }
        
        public void setLevel (Level level) {
            logger.setLevel(level);
        }
}