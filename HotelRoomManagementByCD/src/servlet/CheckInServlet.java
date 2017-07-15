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
 *         Created by CD on 2017/7/14 17:26.
 */
@WebServlet(name = "CheckInServlet")
public class CheckInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HotelManagement_CD management = new HotelManagement_CD();
        String name = request.getParameter("name");
        int id = 0;
        int roomNum = 0;
        if (request.getParameter("room_number") != null && request.getParameter("id") != null) {
            roomNum = Integer.valueOf(request.getParameter("room_number"));
            id = Integer.valueOf(request.getParameter("id"));
        }
        String checkInDate = request.getParameter("checkin_date");
        try {
            Room_CD foundRoom = management.findRoom(roomNum);
            management.getResultSet().close();
            management.checkIn(name, id, foundRoom, checkInDate);
            response.sendRedirect("rooms.jsp");
        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
