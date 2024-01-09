package org.kaybee.util;

import org.jboss.logging.Logger;

public class NamiLogger {
    private static final Logger LOGGER = Logger.getLogger(NamiLogger.class);

    public static void printMsg(String msg) {
        LOGGER.info(msg);
    }

    public static void printError(String err) {
        LOGGER.error(err);
    }

}
