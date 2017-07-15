package servlet;

import Management.HotelManagement_CD;
import entity.room.Room_CD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * @author houlx
 *         Created by CD on 2017/7/14 18:06.
 */
@WebServlet(name = "CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HotelManagement_CD management = new HotelManagement_CD();
        int roomNumber = 0;
        if (request.getParameter("room_num") != null) {
            roomNumber = Integer.valueOf(request.getParameter("room_num"));
        }
        String checkOutDate = request.getParameter("checkout_date");
        management.checkOut(roomNumber, checkOutDate);
        try {
            management.getResultSet().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("rooms.jsp");
//        management.getDao().connectionClose();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
