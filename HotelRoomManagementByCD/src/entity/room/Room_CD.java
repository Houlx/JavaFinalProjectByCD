package entity.room;

import common.RoomState;
import entity.Customer_CD;

import java.util.Date;
import java.util.List;

/**
 * Entity class of rooms in hotel
 *
 * @author houlx
 *         Created by CD on 2017/7/7.
 */
public abstract class Room_CD {
    private int roomNumber;
    private RoomState state;
    protected int customerMaxNum;
    private int customerCurrentNum;
    protected int cost;
    protected String roomType;
    private Date checkInDate;
    private Date checkOutDate;
    protected List<Customer_CD> customerCheckedIn;

    /**
     * constructor method
     *
     * @param roomNumber the ID of this room
     * @param state      the state of this room (FREE|RESERVED|CHECKIN)
     */
    public Room_CD(int roomNumber, RoomState state) {
        this.roomNumber = roomNumber;
        this.state = state;
        customerCurrentNum = 0;
        checkInDate = null;
        checkOutDate = null;
        customerCheckedIn = null;
    }

    public Room_CD(int roomNumber, RoomState state, int customerMaxNum, int customerCurrentNum, int cost, Date checkInDate, Date checkOutDate, List<Customer_CD> customerCheckedIn) {
        this.roomNumber = roomNumber;
        this.state = state;
        this.customerMaxNum = customerMaxNum;
        this.customerCurrentNum = customerCurrentNum;
        this.cost = cost;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerCheckedIn = customerCheckedIn;
    }

    public int getCustomerMaxNum() {
        return customerMaxNum;
    }

    public Room_CD() {

    }

    /**
     * getter and setter method
     */
    public int getCost() {
        return cost;
    }

    public int getRoomNumber() {

        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomState getState() {
        return state;
    }

    public void setState(RoomState state) {
        this.state = state;
    }

    public void CheckIn(Customer_CD customer) {
        customerCheckedIn.add(customer);
    }

    public List<Customer_CD> getCustomerCheckedIn() {
        return customerCheckedIn;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getCustomerCurrentNum() {
        return customerCurrentNum;
    }

    public void setCustomerCurrentNum(int customerCurrentNum) {
        this.customerCurrentNum = customerCurrentNum;
    }

    public String getRoomType() {
        return roomType;
    }

}
