package entity.room;

import common.RoomState;
import entity.Customer_CD;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Standard room class extending from room class
 *
 * @author houlx
 *         Created by CD on 2017/7/7 23:07.
 */
public class StandardRoom_CD extends Room_CD {
    /**
     * constructor method
     * the cost of standard room is 520 per room per day
     * the maximum of customers living in standard room is 2
     */
    public StandardRoom_CD(int roomNumber, RoomState state) {
        super(roomNumber, state);
        roomType = "standard";
        cost = 520;
        customerMaxNum = 2;
        customerCheckedIn = new ArrayList<>(customerMaxNum);
    }

    public StandardRoom_CD(int roomNumber, RoomState state, int customerMaxNum, int customerCurrentNum, int cost, Date checkInDate, Date checkOutDate, List<Customer_CD> customerCheckedIn) {
        super(roomNumber, state, customerMaxNum, customerCurrentNum, cost, checkInDate, checkOutDate, customerCheckedIn);
        roomType = "standard";
    }

    public StandardRoom_CD() {
    }

}
