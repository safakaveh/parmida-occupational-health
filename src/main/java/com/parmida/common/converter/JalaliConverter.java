package com.parmida.common.converter;

public class JalaliConverter {
    private static final int DEF_NUMBER = 492269;
    private final long days;
    private int[] yearMonthDay;
    private int[] hourMinuteSecond;

    public JalaliConverter(long timeMillis) {
        this.days = (timeMillis / (1000 * 60 * 60 * 24)) + DEF_NUMBER;
        yearMonthDay = getYearMonthDay();
    }

    public JalaliConverter(int year, int month, int day, int hour, int minute, int second) {
        hourMinuteSecond = new int[]{hour - 4, minute - 30, second};
        days = getDays(year, month, day);
    }

    public JalaliConverter(int year, int month, int day) {
        this(year, month, day, 0, 0, 0);
    }

    public JalaliConverter() {
        this(System.currentTimeMillis());
    }

    public int getYear() {
        return yearMonthDay[0];
    }

    public int getMonth() {
        return yearMonthDay[1];
    }

    public int getDay() {
        return yearMonthDay[2];
    }

    public long getTimeMillis() {
        final int ONE_SECOND_MS = 1000;
        final int ONE_MINUTE_MS = 60 * ONE_SECOND_MS;
        final int ONE_HOUR_MS = 60 * ONE_MINUTE_MS;
        final long ONE_DAY_MS = 24 * (long) ONE_HOUR_MS;
        return ((this.days - DEF_NUMBER) * ONE_DAY_MS) + ((long) hourMinuteSecond[0] * ONE_HOUR_MS)
                + ((long) hourMinuteSecond[1] * ONE_MINUTE_MS) + ((long) hourMinuteSecond[2] * ONE_SECOND_MS);
    }

    public boolean isJalaliLeapYear(int year) {
        return ((year % 33 == 1) || (year % 33 == 5) || (year % 33 == 9) || (year % 33 == 13) || (year % 33 == 17)
                || (year % 33 == 22) || (year % 33 == 26) || (year % 33 == 30));
    }

    private int getJalaliMonthLength(int year, int month) {
        if (month <= 6) {
            return 31;
        }
        if (month <= 11) {
            return 30;
        }
        return isJalaliLeapYear(year) ? 30 : 29;
    }

    private int[] getYearMonthDay() {
        int[] result = new int[3];
        long last = days;
        int year = 1;
        while (last > 366) {
            last -= 365;
            last = isJalaliLeapYear(year) ? last - 1 : last;
            year++;
        }
        if ((last == 366) && (!(isJalaliLeapYear(year)))) {
            last -= 365;
            year++;
        }
        result[0] = year;

        int momth = 1;
        while (last > getJalaliMonthLength(year, momth)) {
            last -= getJalaliMonthLength(year, momth);
            momth++;
        }
        result[1] = momth;
        result[2] = (int) last;
        return result;
    }

    private long getDays(int year, int month, int day) {
        int cntLeapDay = 0;
        for (int i = 0; i < year; i++) {
            if (isJalaliLeapYear(i)) {
                cntLeapDay++;
            }
        }

        year = year == 0 ? 1 : year;
        int dy = (year - 1) * 365 + cntLeapDay;
        for (int i = 1; i < month; i++) {
            dy += getJalaliMonthLength(year, i);
        }
        return (dy + day);
    }

}
