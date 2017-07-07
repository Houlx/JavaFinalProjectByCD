package entity.room;

import common.RoomState;

/**
 * Presidential suite class extending from room class
 *
 * @author houlx
 *         Created by CD on 2017/7/7 23:08.
 */
public class PresidentialSuite_CD extends Room_CD {
    public PresidentialSuite_CD(int roomNumber, RoomState state) {
        super(roomNumber, state);
    }

    public PresidentialSuite_CD() {
    }

    public int getCost() {
        return 1120;
    }
}
