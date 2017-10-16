package com.planmill.api.datahelper;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * Default formats for Planmill 1.5 API
 *
 * Created by konstantin.petrukhnov@planmill.com on 2017-10-16.
 */
public class DefaultPmFormats {

    /**
     * Default time format is: "2011-12-03T10:15:30.123+0100"
     */
    private static DateTimeFormatter dateTimeFormatter = null;


    public static DateTimeFormatter getDateTimeFormatter() {
        if (dateTimeFormatter == null) {
            dateTimeFormatter = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                    .appendOffset("+HHMM", "+0000")
                    .toFormatter();
        }
        return dateTimeFormatter;
    }
}
