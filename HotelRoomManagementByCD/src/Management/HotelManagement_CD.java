package Management;

import common.Formatter;
import common.RoomState;
import dao.Dao_CD;
import entity.Customer_CD;
import entity.room.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Management class for check-in/out and expense calculation and so on
 *
 * @author houlx
 *         Created by CD on 2017/7/7 22:06.
 */
public class HotelManagement_CD {
    private List<Room_CD> allRooms = new ArrayList<>();
    private List<Customer_CD> customers = new ArrayList<>();
    private ResultSet resultSet;
    private Dao_CD dao;
    private Formatter format = new Formatter("yyyy-MM-dd");

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Dao_CD getDao() {
        return dao;
    }

    public Formatter getFormat() {
        return format;
    }

    /**
     * get all customers from database
     *
     * @return list of customers
     */
    public List<Customer_CD> getCustomers() {
        dao = new Dao_CD();
        ResultSet resultSet2 = dao.executeGet("SELECT * FROM customer;");
        try {
            while (resultSet2.next()) {
                String name = resultSet2.getString("name");
                int id = resultSet2.getInt("id");
                int roomLiving = resultSet2.getInt("room_living");
                int expense = resultSet2.getInt("expense");
                customers.add(new Customer_CD(name, id, findRoom(roomLiving), expense));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customers;
    }

    /**
     * get all rooms from database
     *
     * @return list of rooms
     * @throws ParseException date formatting exception
     */
    public List<Room_CD> getAllRooms() throws ParseException {
        dao = new Dao_CD();
        List<Room_CD> rooms = new ArrayList<>();
        ResultSet resultSet1 = dao.executeGet("SELECT * FROM rooms");
        RoomFactory factory = new RoomFactory();
        try {
            while (resultSet1.next()) {
                String roomType = resultSet1.getString("room_type");
                String state = resultSet1.getString("room_state");
                int roomNum = resultSet1.getInt("room_number");
                int cost = resultSet1.getInt("cost");
                int max = resultSet1.getInt("maximum_customer");
                int curCus = resultSet1.getInt("current_cus_num");
                String checkInDate = resultSet1.getString("checkin_date");
                String checkOutDate = resultSet1.getString("checkout_date");
                Room_CD room = factory.createRoom(roomType, roomNum, format.stringToState(state), max, curCus, cost, format.stringToDate(checkInDate), format.stringToDate(checkOutDate));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    /**
     * get all rooms at 'checkin' state from database
     *
     * @return list of rooms
     * @throws ParseException date formatting exception
     */
    public List<Room_CD> getCheckedRooms() throws ParseException {
        List<Room_CD> checkedRooms = new ArrayList<>();
        for (Room_CD room : getAllRooms()) {
            if (room.getState() == RoomState.CHECKIN) {
                checkedRooms.add(room);
            }
        }
        return checkedRooms;
    }

    /**
     * find customer by id number
     *
     * @param id id number
     * @return customer
     */
    public Customer_CD findCustomerById(int id) {
        dao = new Dao_CD();
        resultSet = dao.executeGet("SELECT * FROM customer WHERE id=" + id + ";");
        Customer_CD customer = null;
        try {
            if (resultSet.next()) {
                System.out.println("???");
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getInt("room_living"));
                customer = new Customer_CD(resultSet.getString("name"), resultSet.getInt("id"), findRoom(resultSet.getInt("room_living")), resultSet.getInt("expense"));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            dao.statementClose();
            dao.connectionClose();
        }
        return customer;
    }

    /**
     * initialize room database, used only once at the very beginning
     * 50 rooms in total, 10 presidential suites (No.1 to 10), 20 standard rooms (No.11 to 30), 20 single rooms (No.31 to 50)
     */
    public void init() {
        dao = new Dao_CD();
        for (int i = 1; i <= 10; i++) {
            dao.executeSet("INSERT INTO rooms (room_type,room_number,room_state,cost,maximum_customer,current_cus_num) VALUES ('presidential'," + i + ",'FREE',1120,5,0);");
        }
        for (int i = 11; i <= 30; i++) {
            dao.executeSet("INSERT INTO rooms (room_type,room_number,room_state,cost,maximum_customer,current_cus_num) VALUES ('standard'," + i + ",'FREE',520,2,0);");
        }
        for (int i = 31; i <= 50; i++) {
            dao.executeSet("INSERT INTO rooms (room_type,room_number,room_state,cost,maximum_customer,current_cus_num) VALUES ('single'," + i + ",'FREE',320,1,0);");
        }
    }

    /**
     * find certain room by room number
     *
     * @param roomNumber room number
     * @return room
     */
    public Room_CD findRoom(int roomNumber) throws ParseException {
        dao = new Dao_CD();
        RoomFactory factory = new RoomFactory();
        Room_CD room = null;
        resultSet = dao.executeGet("SELECT * FROM rooms WHERE room_number =" + roomNumber + ";");
        try {
            if (resultSet.next()) {
                System.out.println(resultSet.getString("room_type"));
                room = factory.createRoom(resultSet.getString("room_type"), roomNumber, format.stringToState(resultSet.getString("room_state")));
                room.setCustomerCurrentNum(resultSet.getInt("current_cus_num"));
                room.setCheckInDate(format.stringToDate(resultSet.getString("checkin_date")));
                room.setCheckOutDate(format.stringToDate(resultSet.getString("checkout_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return room;
    }

    /**
     * find rooms that are able to be lived in by type (number of customer at present is not full)
     *
     * @param roomType type of room. Whether single, standard or presidential
     * @return room
     */
    public List<Room_CD> findRoomsAbleToLive(String roomType) {
        RoomFactory factory = new RoomFactory();
        dao = new Dao_CD();
//        Room_CD room = null;
        List<Room_CD> rooms = new ArrayList<>();
        resultSet = dao.executeGet("SELECT * FROM rooms WHERE room_type='" + roomType + "' AND current_cus_num < maximum_customer;");
        try {
            while (resultSet.next()) {
                int roomNum = resultSet.getInt("room_number");
                RoomState state = format.stringToState(resultSet.getString("room_state"));
                Room_CD room = factory.createRoom(roomType, roomNum, state);
                room.setCustomerCurrentNum(resultSet.getInt("current_cus_num"));
                room.setCheckInDate(format.stringToDate(resultSet.getString("checkin_date")));
                room.setCheckOutDate(format.stringToDate(resultSet.getString("checkout_date")));
                rooms.add(room);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return rooms;
    }

    /**
     * check-in operation
     *
     * @param customerName customer's name
     * @param customerId   customer's id
     * @param room         number of the room the customer will live in
     * @param checkInDate  date of check-in
     */
    public void checkIn(String customerName, int customerId, Room_CD room, String checkInDate) {
        dao = new Dao_CD();

        if (room.getCustomerCurrentNum() < room.getCustomerMaxNum() && room.getState() != RoomState.CHECKIN) {
            dao.executeSet("DELETE FROM customer WHERE room_living = " + room.getRoomNumber() + ";");
            dao.executeSet("INSERT INTO customer (name,id,expense,room_living) VALUES ('" + customerName + "'," + customerId + ",0," + room.getRoomNumber() + ");");
            dao.executeSet("UPDATE rooms SET room_state = 'checkin', current_cus_num = current_cus_num+1, checkin_date='" + checkInDate + "',checkout_date=NULL WHERE room_number = " + room.getRoomNumber() + ";");
        } else if (room.getCustomerCurrentNum() < room.getCustomerMaxNum() && room.getState() == RoomState.CHECKIN) {
            dao.executeSet("INSERT INTO customer (name,id,expense,room_living) VALUES ('" + customerName + "'," + customerId + ",0," + room.getRoomNumber() + ");");
            dao.executeSet("UPDATE rooms SET current_cus_num=current_cus_num+1 WHERE room_number=" + room.getRoomNumber() + ";");
        }
    }

    /**
     * calculate dates from check-in to checkout
     *
     * @param checkInDate  check-in date
     * @param checkOutDate checkout date
     * @return days
     */
    private int calculateDays(String checkInDate, String checkOutDate) {
        int result = 0;
        if (checkInDate != null && checkOutDate != null) {
            System.out.println("OK");
            try {
                result = (int) ((format.stringToDate(checkOutDate).getTime() - format.stringToDate(checkInDate).getTime()) / (24 * 60 * 60 * 1000));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * checkout operation
     *
     * @param roomNumber   the number of room that will be checked out
     * @param checkOutDate the date of checkout
     */
    public void checkOut(int roomNumber, String checkOutDate) {
        dao = new Dao_CD();
        resultSet = dao.executeGet("SELECT * FROM rooms WHERE room_number=" + roomNumber + ";");
        try {
            if (resultSet.next() && resultSet.getString("room_state").equalsIgnoreCase("checkin")) {
                int cost = resultSet.getInt("cost");
                String checkInDate = resultSet.getString("checkin_date");
                int expense = cost * calculateDays(checkInDate, checkOutDate);
                resultSet.close();
                dao.executeSet("UPDATE rooms SET room_state = 'FREE', current_cus_num = 0, checkout_date = '" + checkOutDate + "' WHERE room_number = " + roomNumber + ";");
                System.out.println("You need to pay " + expense);
                dao.executeSet("update customer set expense=" + expense + " where room_living=" + roomNumber + ";");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * whether the administrator logged in successfully
     *
     * @param account  admin's account
     * @param password admin's password
     * @return if login successfully, return true, else false
     */
    public boolean isAdminLogin(String account, String password) {
        dao = new Dao_CD();
        resultSet = dao.executeGet("SELECT * FROM admin WHERE account = '" + account + "';");
        try {
            if (resultSet.next() && resultSet.getString("password").equals(password)) {
                resultSet.close();
                dao.statementClose();
                dao.connectionClose();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * close all connection to database
     */
    private void closeAll() {
        try {
            resultSet.close();
            dao.statementClose();
            dao.connectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        HotelManagement_CD management = new HotelManagement_CD();
        management.init();
    }*/
}
