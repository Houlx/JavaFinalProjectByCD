package entity.room;

import common.RoomState;
import entity.Customer_CD;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Single room class extending from room class
 *
 * @author houlx
 *         Created by CD on 2017/7/7 23:06.
 */
public class SingleRoom_CD extends Room_CD {
    /**
     * constructor method
     * the cost of single room is 320 per room per day
     * the maximum of customers living in single room is 1
     */
    public SingleRoom_CD(int roomNumber, RoomState state) {
        super(roomNumber, state);
        roomType="Single";
        cost = 320;
        customerMaxNum = 1;
        customerCheckedIn = new ArrayList<>(customerMaxNum);
    }

    public SingleRoom_CD(int roomNumber, RoomState state, int customerMaxNum, int customerCurrentNum, int cost, Customer_CD reservedBy, Date reservedDate, Date checkInDate, Date checkOutDate, List<Customer_CD> customerCheckedIn) {
        super(roomNumber, state, customerMaxNum, customerCurrentNum, cost, reservedBy, reservedDate, checkInDate, checkOutDate, customerCheckedIn);
    }

    public SingleRoom_CD() {
    }


}
