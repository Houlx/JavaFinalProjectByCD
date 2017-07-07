package entity;

import entity.room.Room_CD;

import java.util.List;

/**
 * Entity class of customers
 *
 * @author houlx
 *         Created by CD on 2017/7/7 21:44.
 */
public class Customer_CD {
    private String name;
    private long IdNumber;
    private List<Room_CD> reservedRooms;
    private int expense;

    public Customer_CD(String name, long idNumber, List<Room_CD> reservedRooms, int expense) {
        this.name = name;
        IdNumber = idNumber;
        this.reservedRooms = reservedRooms;
        this.expense = expense;
    }

    public Customer_CD() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(long idNumber) {
        IdNumber = idNumber;
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
}
