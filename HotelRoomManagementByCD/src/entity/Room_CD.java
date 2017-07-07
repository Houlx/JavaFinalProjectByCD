package entity;

import common.RoomState;

/**
 * Entity class of rooms in hotel
 * @author houlx
 *         Created by CD on 2017/7/7.
 */
public class Room_CD {
    private int roomNumber;
    private RoomState state;

    public Room_CD(int roomNumber, RoomState state) {
        this.roomNumber = roomNumber;
        this.state = state;
    }

    public Room_CD() {

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
}
