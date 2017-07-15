package entity.room;

import common.RoomState;

import java.util.Date;

/**
 * @author houlx
 *         Created by CD on 2017/7/15 11:50.
 */
public class RoomFactory {
    public Room_CD createRoom(String roomType) {
        if (roomType != null) {
            if (roomType.equalsIgnoreCase("presidential")) {
                return new PresidentialSuite_CD();
            } else if (roomType.equalsIgnoreCase("standard")) {
                return new StandardRoom_CD();
            } else if (roomType.equalsIgnoreCase("single")) {
                return new SingleRoom_CD();
            }
        }
        return null;
    }

    public Room_CD createRoom(String roomType, int roomNumber, RoomState state) {
        if (roomType != null) {
            if (roomType.equalsIgnoreCase("presidential")) {
                return new PresidentialSuite_CD(roomNumber, state);
            } else if (roomType.equalsIgnoreCase("standard")) {
                return new StandardRoom_CD(roomNumber, state);
            } else if (roomType.equalsIgnoreCase("single")) {
                return new SingleRoom_CD(roomNumber, state);
            }
        }
        return null;
    }

    public Room_CD createRoom(String roomType, int roomNumber, RoomState state, int customerMax, int customerCurrNum, int cost, Date checkIn, Date checkOut) {
        if (roomType != null) {
            if (roomType.equalsIgnoreCase("presidential")) {
                return new PresidentialSuite_CD(roomNumber, state, customerMax, customerCurrNum, cost, checkIn, checkOut, null);
            } else if (roomType.equalsIgnoreCase("standard")) {
                return new StandardRoom_CD(roomNumber, state, customerMax, customerCurrNum, cost, checkIn, checkOut, null);
            } else if (roomType.equalsIgnoreCase("single")) {
                return new SingleRoom_CD(roomNumber, state, customerMax, customerCurrNum, cost, checkIn, checkOut, null);
            }
        }
        return null;
    }
}
