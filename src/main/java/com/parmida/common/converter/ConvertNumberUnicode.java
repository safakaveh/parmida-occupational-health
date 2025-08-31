package com.parmida.common.converter;

public interface ConvertNumberUnicode {
    public static String convertNo(String str) {
        String strNumbers = "۰۱۲۳۴۵۶۷۸۹";
        StringBuilder result = new StringBuilder();
        str.chars().mapToObj(c -> (char) c).forEach(c -> {
            int idx = strNumbers.indexOf(c);
            if (idx != -1) {
                result.append(idx);
            } else {
                result.append(c);
            }
        });
        return result.toString();
    }
}
