package entity.room;

import common.RoomState;

/**
 * @author houlx
 *         Created by CD on 2017/7/7 23:06.
 */
public class SingleRoom_CD extends Room_CD {
    public SingleRoom_CD(int roomNumber, RoomState state) {
        super(roomNumber, state);
    }

    public int getCost() {
        return 320;
    }

    public SingleRoom_CD() {
    }

}
