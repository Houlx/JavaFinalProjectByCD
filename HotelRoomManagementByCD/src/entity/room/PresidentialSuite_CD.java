package entity.room;

import common.RoomState;
import entity.Customer_CD;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Presidential suite class extending from room class
 *
 * @author houlx
 *         Created by CD on 2017/7/7 23:08.
 */
public class PresidentialSuite_CD extends Room_CD {
    /**
     * constructor method
     * the cost of presidential suite is 1120 per room per day
     * the maximum of customers living in presidential suite is 5
     */
    public PresidentialSuite_CD(int roomNumber, RoomState state) {
        super(roomNumber, state);
        roomType="Presidential Suite";
        cost = 1120;
        customerMaxNum = 5;
        customerCheckedIn = new ArrayList<>(customerMaxNum);
    }

    public PresidentialSuite_CD(int roomNumber, RoomState state, int customerMaxNum, int customerCurrentNum, int cost, Customer_CD reservedBy, Date reservedDate, Date checkInDate, Date checkOutDate, List<Customer_CD> customerCheckedIn) {
        super(roomNumber, state, customerMaxNum, customerCurrentNum, cost, reservedBy, reservedDate, checkInDate, checkOutDate, customerCheckedIn);
    }

    public PresidentialSuite_CD() {
    }

}
