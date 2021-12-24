package com.learning.sanjay9977;

import lombok.extern.log4j.Log4j2;

/**
 * Hello world!
 */
@Log4j2
public class App {

    /**
     * Method to log given msg with logger
     *
     * @param msg - msg to log
     */
    public void logMsg(final String msg) {
        log.info(msg);
    }
}
