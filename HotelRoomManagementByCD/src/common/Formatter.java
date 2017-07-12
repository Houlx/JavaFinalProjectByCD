package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * date formatter class
 *
 * @author houlx
 *         Created by CD on 2017/7/12 17:29.
 */
public class Formatter extends SimpleDateFormat {

    public Formatter(String pattern) {
        super(pattern);
    }

    public Formatter() {
    }

    public Date stringToDate(String date) throws ParseException {
        if (date != null) {
            return this.parse(date);
        } else {
            return null;
        }
    }

    public String dateToString(Date date) {
        if (date != null) {
            return this.format(date);
        } else {
            return null;
        }
    }
}
