package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateFormat {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static Date dateFormat(String dataString) {
        try {
            return format.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
