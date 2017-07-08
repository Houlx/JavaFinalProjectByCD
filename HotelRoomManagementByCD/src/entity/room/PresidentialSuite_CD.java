package entity.room;

import common.RoomState;

import java.util.ArrayList;

/**
 * Presidential suite class extending from room class
 *
 * @author houlx
 *         Created by CD on 2017/7/7 23:08.
 */
public class PresidentialSuite_CD extends Room_CD {
    public PresidentialSuite_CD(int roomNumber, RoomState state) {
        super(roomNumber, state);
        cost = 1120;
        customerCheckedIn = new ArrayList<>(5);
    }

    public PresidentialSuite_CD() {
    }

}
