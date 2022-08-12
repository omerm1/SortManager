package com.sparta.om;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLoggingFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return LocalDate.now() + " - " + LocalTime.now()
                + " " + record.getLevel()
                + " - " + record.getSourceClassName()
                + " " + record.getMessage()
                + " \n";
    }
}

