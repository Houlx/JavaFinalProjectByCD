package entity.room;

import common.RoomState;

/**
 * Standard room class extending from room class
 *
 * @author houlx
 *         Created by CD on 2017/7/7 23:07.
 */
public class StandardRoom_CD extends Room_CD {
    public StandardRoom_CD(int roomNumber, RoomState state) {
        super(roomNumber, state);
    }

    public StandardRoom_CD() {
    }

    public int getCost() {
        return 520;
    }
}
