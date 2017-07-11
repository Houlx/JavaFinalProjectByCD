package Management;

import entity.Customer_CD;

import java.text.ParseException;

/**
 * @author houlx
 *         Created by CD on 2017/7/11 23:17.
 */
public class Test {
    public static void main(String[] args) {
        HotelManagement_CD manager = new HotelManagement_CD();
        manager.init();
//        manager.showRooms();
        Customer_CD reserveCustomer = new Customer_CD("订房人", 1111111);
        Customer_CD livingCustomer = new Customer_CD("住宿人", 1234567);
        Customer_CD livingCustomer2 = new Customer_CD("住宿人2", 7654321);
        try {
            manager.reserve(reserveCustomer,manager.findFreeRoom("standard"),"2017-08-08");
            manager.reserve(reserveCustomer,manager.findFreeRoom("single"),"2016-09-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        manager.showRooms();
        try {
            manager.checkIn(reserveCustomer,livingCustomer,manager.findRoom(11),"2017-07-07");
            manager.checkIn(reserveCustomer,livingCustomer2,manager.findRoom(11),"2018-08-08");
//            manager.checkIn(reserveCustomer,reserveCustomer,manager.findRoom(11),"2019-09-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        manager.showRooms();
    }
}
