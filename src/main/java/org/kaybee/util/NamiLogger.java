package org.kaybee.util;

import org.jboss.logging.Logger;

public final class NamiLogger {
    private static final Logger LOGGER = Logger.getLogger(NamiLogger.class);

    public static void printMsg(String msg) {
        LOGGER.info(msg);
    }

    public static void printError(String err) {
        LOGGER.error(err);
    }

    public static void printDebug(String debug) {
        LOGGER.debug(debug);
    }

    public static void printException(String exception) {
        LOGGER.error(exception);
    }

}
