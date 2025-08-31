package com.parmida.common.utils;

import java.util.regex.Pattern;

public class CSVTools {
    private CSVTools() {
        throw new IllegalStateException("Utility class");
    }

    public static String[] parseCSVLine(String line) {
        // Create a pattern to match breaks
        Pattern pattern = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
        // Split input with the pattern
        String[] fields = pattern.split(line);
        for (int i = 0; i < fields.length; i++) {
            // Get rid of residual double quotes
            fields[i] = fields[i].replace("\"", "");
        }
        return fields;
    }
}
