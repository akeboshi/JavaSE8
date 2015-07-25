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