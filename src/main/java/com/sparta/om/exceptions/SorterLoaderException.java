package com.sparta.om.exceptions;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SorterLoaderException extends Exception {
    private final String message;
    private static final Logger logger = Logger.getLogger("sort exception logger");

    public SorterLoaderException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/sortException.log", false);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.setUseParentHandlers(false);

        logger.log(Level.WARNING, "User entered incorrect value, restarting...");
        return message;
    }
}
