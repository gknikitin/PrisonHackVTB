package info.fandroid.quiz.utility;

import android.text.format.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtilities {

    public enum DateTimeFormat {
        DD_MM_YYYY_DASH("dd-MM-yyyy"),
        YYMMDD_HHMMSS("yyyyMMddHHmmss"),
        DD_MONTH("dd LLL"),
        DAY_TIME("EEE kk:mm");
        
        private final String name;

        private DateTimeFormat(String str) {
            this.name = str;
        }

        public String toString() {
            return this.name;
        }
    }

    public static String getCurrentDateinLong() {
        return String.valueOf(Calendar.getInstance().getTimeInMillis());
    }

    public static String getDateFromLong(String str, DateTimeFormat dateTimeFormat) {
        return DateFormat.format(dateTimeFormat.toString(), new Date(Long.parseLong(str))).toString();
    }

    public static long getTimeDifference(long j, long j2, TimeUnit timeUnit) {
        long j3 = j >= j2 ? j - j2 : j2 - j;
        if (timeUnit == TimeUnit.SECONDS) {
            return j3 / 1000;
        }
        if (timeUnit == TimeUnit.MINUTES) {
            return (j3 / 1000) / 60;
        }
        return timeUnit == TimeUnit.HOURS ? (j3 / 1000) / 3600 : j3;
    }

    public static long getTimeDifference(String str, String str2, TimeUnit timeUnit) {
        return getTimeDifference(Long.valueOf(str).longValue(), Long.valueOf(str2).longValue(), timeUnit);
    }

    public static String getFormatedTime(String str) {
        StringBuilder sb;
        String str2;
        long parseLong = (Long.parseLong(getCurrentDateinLong()) - Long.parseLong(str)) / 1000;
        if (parseLong <= 60) {
            return "Now";
        }
        if (parseLong <= 60 || parseLong > 3600) {
            return getDateFromLong(str, DateTimeFormat.DAY_TIME);
        }
        long timeDifference = getTimeDifference(str, getCurrentDateinLong(), TimeUnit.MINUTES);
        if (timeDifference <= 1) {
            sb = new StringBuilder();
            sb.append(timeDifference);
            str2 = " min";
        } else {
            sb = new StringBuilder();
            sb.append(timeDifference);
            str2 = " mins";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static String getDateTimeString(DateTimeFormat dateTimeFormat) {
        return new SimpleDateFormat(dateTimeFormat.toString()).format(new Date());
    }
}
