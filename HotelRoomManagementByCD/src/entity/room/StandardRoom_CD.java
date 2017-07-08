package entity.room;

import common.RoomState;

import java.util.ArrayList;

/**
 * Standard room class extending from room class
 *
 * @author houlx
 *         Created by CD on 2017/7/7 23:07.
 */
public class StandardRoom_CD extends Room_CD {
    public StandardRoom_CD(int roomNumber, RoomState state) {
        super(roomNumber, state);
        cost = 520;
        customerCheckedIn = new ArrayList<>(2);
    }

    public StandardRoom_CD() {
    }

}
