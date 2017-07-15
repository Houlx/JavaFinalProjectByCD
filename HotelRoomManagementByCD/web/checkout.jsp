<%@ page import="Management.HotelManagement_CD" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.room.Room_CD" %>
<%@ page import="java.text.ParseException" %><%--
  Created by IntelliJ IDEA.
  User: houlx
  Date: 2017/7/14
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout</title>
</head>
<body>
<form action="/CheckOutServlet" method="post">
    Room:<select name="room_num" id="room_num">

</select>
    <br>
    Date:<input type="text" name="checkout_date">
    <br>
    <input type="submit" value="Submit">
</form>
<script type="text/javascript">
    var x = document.getElementById("room_num");
    <%
        HotelManagement_CD management=new HotelManagement_CD();
        try {
            List<Room_CD> rooms=management.getCheckedRooms();
            for (Room_CD room:rooms){
                %>
                x.options.add(new Option("<%=room.getRoomNumber()%>","<%=room.getRoomNumber()%>"))
    <%
            }
        } catch (ParseException e) {
    e.printStackTrace();
        }
    %>
</script>
</body>
</html>
