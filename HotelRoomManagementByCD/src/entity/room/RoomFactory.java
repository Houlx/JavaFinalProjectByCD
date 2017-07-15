package entity.room;

import common.RoomState;

import java.util.Date;

/**
 * Room Factory class, create 3 varieties of rooms, presidential suites, standard room and single room
 *
 * @author houlx
 *         Created by CD on 2017/7/15 11:50.
 */
public class RoomFactory {
    /**
     * create room by its type using default constructor
     *
     * @param roomType type of room
     * @return room
     */
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

    /**
     * create room by its type, number and state
     *
     * @param roomType   type of room
     * @param roomNumber room number
     * @param state      room state
     * @return room
     */
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

    /**
     * create room by its type and all other parameters
     *
     * @param roomType        type of room
     * @param roomNumber      room number
     * @param state           room state
     * @param customerMax     maximum of customer able to live
     * @param customerCurrNum current number of customer
     * @param cost            room cost
     * @param checkIn         date of check-in
     * @param checkOut        date of checkout
     * @return room
     */
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
