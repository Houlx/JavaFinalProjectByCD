package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * formatter class
 *
 * @author houlx
 *         Created by CD on 2017/7/12 17:29.
 */
public class Formatter extends SimpleDateFormat {

    /**
     * constructor
     *
     * @param pattern date pattern
     */
    public Formatter(String pattern) {
        super(pattern);
    }

    public Formatter() {
    }

    /**
     * format string to date
     *
     * @param date date shown by string
     * @return date
     * @throws ParseException parse exception
     */
    public Date stringToDate(String date) throws ParseException {
        if (date != null) {
            return this.parse(date);
        } else {
            return null;
        }
    }

    /**
     * format date to string
     *
     * @param date date
     * @return date shown by string using pattern of formatter
     */
    public String dateToString(Date date) {
        if (date != null) {
            return this.format(date);
        } else {
            return null;
        }
    }

    /**
     * format string to enum State
     *
     * @param state state shown by string
     * @return item of enum in RoomState
     */
    public RoomState stringToState(String state) {
        if (state != null) {
            if (state.equalsIgnoreCase("free")) {
                return RoomState.FREE;
            } else if (state.equalsIgnoreCase("checkin")) {
                return RoomState.CHECKIN;
            }
        }
        return null;
    }

    /**
     * format state to string
     *
     * @param state item in RoomState
     * @return state shown by string
     */
    public String stateToString(RoomState state) {
        switch (state) {
            case CHECKIN:
                return "checkin";
            case FREE:
                return "free";
            default:
                break;
        }
        return "";
    }
}
