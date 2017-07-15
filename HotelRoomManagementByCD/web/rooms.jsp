<%@ page import="Management.HotelManagement_CD" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.room.Room_CD" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="common.RoomState" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: houlx
  Date: 2017/7/14
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

%>
<html>
<head>
    <title>Rooms</title>
</head>
<body>
<a href="checkin.jsp">check-in</a>
<br>
<a href="customers.jsp">customers</a>
<br>
<a href="checkout.jsp">checkout</a>
<table border="1">
    <tr>
        <th>Type</th>
        <th>No.</th>
        <th>State</th>
        <th>cost</th>
        <th>max</th>
        <th>current</th>
        <th>check-in</th>
        <th>checkout</th>
    </tr>
    <%
        HotelManagement_CD hotelManagement = new HotelManagement_CD();
        try {
            for (Room_CD room : hotelManagement.getAllRooms()) {
    %>
    <tr>
        <td><%=room.getRoomType()%>
        </td>
        <td><%=room.getRoomNumber()%>
        </td>
        <td><%=hotelManagement.getFormat().stateToString(room.getState())%>
        </td>
        <td><%=room.getCost()%>
        </td>
        <td><%=room.getCustomerMaxNum()%>
        </td>
        <td><%=room.getCustomerCurrentNum()%>
        </td>
        <td><%=hotelManagement.getFormat().dateToString(room.getCheckInDate())%>
        </td>
        <td><%=hotelManagement.getFormat().dateToString(room.getCheckOutDate())%>
        </td>
    </tr>
    <%
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } /*finally {
            try {
                if (hotelManagement.getResultSet() != null) {
                    hotelManagement.getResultSet().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    %>
</table>
</body>
</html>
