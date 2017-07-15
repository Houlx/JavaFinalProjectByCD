<%@ page import="Management.HotelManagement_CD" %>
<%@ page import="entity.room.Room_CD" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="entity.Customer_CD" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: houlx
  Date: 2017/7/14
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<a href="rooms.jsp">rooms</a>
<table border="1">
    <tr>
        <th>Name</th>
        <th>ID</th>
        <th>Room</th>
        <th>expense</th>
    </tr>
    <%
        HotelManagement_CD hotelManagement = new HotelManagement_CD();
        List<Customer_CD> customers = hotelManagement.getCustomers();
        System.out.println(customers.size());
        for (Customer_CD customer : customers) {
            System.out.println(customer.getIdNumber());
    %>
    <tr>
        <td><%=customer.getName()%>
        </td>
        <td><%=customer.getIdNumber()%>
        </td>
        <td><%=customer.getRoomLive().getRoomNumber()%>
        </td>
        <td><%=customer.getExpense()%>
        </td>
    </tr>
    <%
        }
        try {
            hotelManagement.getResultSet().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
</table>
</body>
</html>
