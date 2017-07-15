<%--suppress ALL --%>
<%@ page import="Management.HotelManagement_CD" %>
<%@ page import="entity.room.Room_CD" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: houlx
  Date: 2017/7/14
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check-in</title>
</head>
<body>
<h1>入住</h1>
<form action="/CheckInServlet" method="post">
    Name:<input type="text" name="name">
    <br>
    ID:<input type="number" name="id">
    <br>
    Room:
    <select id="room_type" onchange="change()">
        <option>presidential</option>
        <option>standard</option>
        <option>single</option>
    </select>
    <select id="room_number" name="room_number">

    </select>
    <br>
    Date:<input type="text" name="checkin_date">
    <br>
    <input type="submit" value="Submit">
</form>
<script type="text/javascript">
    function change() {
        <%
            HotelManagement_CD management = new HotelManagement_CD();
//            List<Room_CD> rooms = management.getAllRooms();
        %>
        var x = document.getElementById("room_type");
        var y = document.getElementById("room_number");
        //noinspection JSAnnotator
        y.options.length = 0;
        if (x.selectedIndex == 0) {
            <%
                for (Room_CD room: management.findRoomsAbleToLive("presidential")){
                    %>
            y.options.add(new Option("<%=room.getRoomNumber()%>", "<%=room.getRoomNumber()%>"))
            <%
                }
            %>
        }

        if (x.selectedIndex == 1) {
            <%
                for (Room_CD room: management.findRoomsAbleToLive("standard")){
                    %>
            y.options.add(new Option("<%=room.getRoomNumber()%>", "<%=room.getRoomNumber()%>"))
            <%
                }
            %>
        }

        if (x.selectedIndex == 2) {
            <%
                for (Room_CD room: management.findRoomsAbleToLive("single")){
                    %>
            y.options.add(new Option("<%=room.getRoomNumber()%>", "<%=room.getRoomNumber()%>"))
            <%
                }
            %>
        }

    }
</script>
</body>
</html>
