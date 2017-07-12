package Management;

import common.Formatter;
import common.RoomState;
import entity.Customer_CD;
import entity.room.PresidentialSuite_CD;
import entity.room.Room_CD;
import entity.room.SingleRoom_CD;
import entity.room.StandardRoom_CD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Management class for check-in/out and expense calculation and so on
 *
 * @author houlx
 *         Created by CD on 2017/7/7 22:06.
 */
public class HotelManagement_CD {
    private List<Room_CD> allRooms = new ArrayList<>(50);
    private Formatter format = new Formatter("yyyy-MM-dd");

    public List<Room_CD> getAllRooms() {
        return allRooms;
    }

    public void showRooms() {
        String state = "";
        for (Room_CD room : allRooms) {
            switch (room.getState()) {
                case FREE:
                    state = "FREE";
                    break;
                case CHECKIN:
                    state = "CHECKIN";
                    break;
                case RESERVED:
                    state = "RESERVED";
                    break;
                default:
                    break;
            }
            System.out.println(room.getRoomNumber() + "\t" + room.getRoomType() + "\t" + state + "\t最多住" + room.getCustomerMaxNum() + "人\t现在" + room.getCustomerCurrentNum() + "人\t" + room.getCost() + "\t预订日" + format.dateToString(room.getReservedDate()) + "\t预订人" + room.getReservedBy() + "\t入住日" + format.dateToString(room.getCheckInDate()) + "\t退房日" + format.dateToString(room.getCheckOutDate()));
        }
    }

    public void showRooms(Room_CD room) {
        if (room != null) {
            System.out.println(room.getRoomNumber() + "\t" + room.getRoomType() + "\t最多住" + room.getCustomerMaxNum() + "人\t现在" + room.getCustomerCurrentNum() + "人\t" + room.getCost());
        }
    }

    public void init() {
        for (int i = 1; i <= 10; i++) {
            allRooms.add(new PresidentialSuite_CD(i, RoomState.FREE));
        }
        for (int i = 11; i <= 30; i++) {
            allRooms.add(new StandardRoom_CD(i, RoomState.FREE));
        }
        for (int i = 31; i <= 50; i++) {
            allRooms.add(new SingleRoom_CD(i, RoomState.FREE));
        }
    }

    public Room_CD findRoom(int roomNumber) {
        if (roomNumber >= 1 && roomNumber <= 50) {
            return allRooms.get(roomNumber - 1);
        } else {
            return null;
        }
    }

    public Room_CD findFreeRoom(String roomType) {
        if (roomType.equalsIgnoreCase("Single")) {
            for (int i = 31; i <= 50; i++) {
                if (allRooms.get(i - 1).getState() == RoomState.FREE) {
                    return allRooms.get(i - 1);
                }
            }

        } else if (roomType.equalsIgnoreCase("Standard")) {
            for (int i = 11; i <= 30; i++) {
                if (allRooms.get(i - 1).getState() == RoomState.FREE) {
                    return allRooms.get(i - 1);
                }
            }

        } else if (roomType.equalsIgnoreCase("Presidential")) {
            for (int i = 1; i <= 10; i++) {
                if (allRooms.get(i - 1).getState() == RoomState.FREE) {
                    return allRooms.get(i - 1);
                }
            }

        }
        return null;
    }

    public void reserve(Customer_CD customer, Room_CD room, String reserveDate) throws ParseException {
        if (room.getState() == RoomState.FREE) {
            room.setState(RoomState.RESERVED);
            room.setReservedBy(customer);
            room.setReservedDate(format.parse(reserveDate));
        }
    }

    public void cancellReserve(Room_CD room) {
        if (room.getState() == RoomState.RESERVED) {
            room.setReservedDate(null);
            room.setReservedBy(null);
            room.setState(RoomState.FREE);
        }
    }

    public void checkIn(Customer_CD customerReserve, Customer_CD customerLive, Room_CD room, String checkInDate) throws ParseException {
        if (room.getReservedBy() == customerReserve && room.getCustomerMaxNum() > room.getCustomerCurrentNum()) {
            room.getCustomerCheckedIn().add(customerLive);
            room.setCustomerCurrentNum(room.getCustomerCurrentNum() + 1);
            customerLive.setRoomLive(room);
            room.setState(RoomState.CHECKIN);
            room.setCheckInDate(format.parse(checkInDate));
        }
    }

    public void checkOut(Customer_CD customerReserve, Room_CD room, String checkOutDate) throws ParseException {
        if (room.getState() == RoomState.CHECKIN) {
            room.setState(RoomState.FREE);
            room.setCustomerCurrentNum(0);
            for (Customer_CD customer : room.getCustomerCheckedIn()) {
                customer.setRoomLive(null);
            }
            room.getCustomerCheckedIn().clear();
            room.setCheckOutDate(format.parse(checkOutDate));
            room.setReservedDate(null);
            room.setReservedBy(null);
            customerReserve.getReservedRooms().remove(room);
            customerReserve.setExpense((int) (customerReserve.getExpense() + ((room.getCheckOutDate().getTime() - room.getCheckInDate().getTime()) / (24 * 60 * 60 * 1000)) * room.getCost()));
        }
    }
}
