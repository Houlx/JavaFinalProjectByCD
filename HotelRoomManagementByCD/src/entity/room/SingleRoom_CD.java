package entity.room;

import common.RoomState;

import java.util.ArrayList;

/**
 * Single room class extending from room class
 *
 * @author houlx
 *         Created by CD on 2017/7/7 23:06.
 */
public class SingleRoom_CD extends Room_CD {
    public SingleRoom_CD(int roomNumber, RoomState state) {
        super(roomNumber, state);
        cost = 320;
        customerCheckedIn = new ArrayList<>(1);
    }

    public SingleRoom_CD() {
    }


}
