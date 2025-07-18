package com.amazonaws.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    public static final String ALTERNATE_ISO8601_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String COMPRESSED_DATE_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
    /* access modifiers changed from: private */
    public static final TimeZone GMT_TIMEZONE = TimeZone.getTimeZone("GMT");
    public static final String ISO8601_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String RFC822_DATE_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
    private static final Map<String, ThreadLocal<SimpleDateFormat>> SDF_MAP = new HashMap();

    private static ThreadLocal<SimpleDateFormat> getSimpleDateFormat(final String str) {
        Map<String, ThreadLocal<SimpleDateFormat>> map = SDF_MAP;
        ThreadLocal<SimpleDateFormat> threadLocal = map.get(str);
        if (threadLocal == null) {
            synchronized (map) {
                threadLocal = map.get(str);
                if (threadLocal == null) {
                    threadLocal = new ThreadLocal<SimpleDateFormat>() {
                        /* access modifiers changed from: protected */
                        public SimpleDateFormat initialValue() {
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
                            simpleDateFormat.setTimeZone(DateUtils.GMT_TIMEZONE);
                            simpleDateFormat.setLenient(false);
                            return simpleDateFormat;
                        }
                    };
                    map.put(str, threadLocal);
                }
            }
        }
        return threadLocal;
    }

    public static Date parse(String str, String str2) {
        try {
            return getSimpleDateFormat(str).get().parse(str2);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String format(String str, Date date) {
        return getSimpleDateFormat(str).get().format(date);
    }

    public static Date parseISO8601Date(String str) {
        try {
            return parse(ISO8601_DATE_PATTERN, str);
        } catch (IllegalArgumentException unused) {
            return parse(ALTERNATE_ISO8601_DATE_PATTERN, str);
        }
    }

    public static String formatISO8601Date(Date date) {
        return format(ISO8601_DATE_PATTERN, date);
    }

    public static Date parseRFC822Date(String str) {
        return parse(RFC822_DATE_PATTERN, str);
    }

    public static String formatRFC822Date(Date date) {
        return format(RFC822_DATE_PATTERN, date);
    }

    public static Date parseCompressedISO8601Date(String str) {
        return parse(COMPRESSED_DATE_PATTERN, str);
    }

    public static Date cloneDate(Date date) {
        if (date == null) {
            return null;
        }
        return new Date(date.getTime());
    }

    public static long numberOfDaysSinceEpoch(long j) {
        return TimeUnit.MILLISECONDS.toDays(j);
    }
}
