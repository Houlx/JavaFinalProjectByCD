package entity;

import entity.room.Room_CD;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class of customers
 *
 * @author houlx
 *         Created by CD on 2017/7/7 21:44.
 */
public class Customer_CD {
    private String name;
    private long idNumber;
    private List<Room_CD> reservedRooms;
    private Room_CD roomLive;
    private int expense;

    /**
     * constructor method
     *
     * @param name          customer's name
     * @param idNumber      customer's ID number
     * @param reservedRooms the room(s) this customer reserve
     * @param roomLive      the room this customer lives in
     * @param expense       money the customer need to pay
     */
    public Customer_CD(String name, long idNumber, List<Room_CD> reservedRooms, Room_CD roomLive, int expense) {
        this.name = name;
        this.idNumber = idNumber;
        this.reservedRooms = reservedRooms;
        this.roomLive = roomLive;
        this.expense = expense;
    }

    public Customer_CD(String name, long idNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.expense = 0;
        this.reservedRooms = new ArrayList<>();
        this.roomLive = null;
    }

    public Customer_CD() {
        this.name = "";
        this.idNumber = 0;
        this.expense = 0;
        this.reservedRooms = new ArrayList<>();
        this.roomLive = null;
    }

    /**
     * getter and setter method
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public List<Room_CD> getReservedRooms() {
        return reservedRooms;
    }

    public void setReservedRooms(List<Room_CD> reservedRooms) {
        this.reservedRooms = reservedRooms;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public Room_CD getRoomLive() {
        return roomLive;
    }

    public void setRoomLive(Room_CD roomLive) {
        this.roomLive = roomLive;
    }
}
