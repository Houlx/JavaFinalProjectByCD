package servlet;

import Management.HotelManagement_CD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet of administrator login
 * get parameters from index.jsp and call isAdminLogin() to verify, if successfully then redirect to room.jsp
 *
 * @author houlx
 *         Created by CD on 2017/7/14 15:09.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HotelManagement_CD manage = new HotelManagement_CD();
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if (manage.isAdminLogin(account, password)) {
            response.sendRedirect("rooms.jsp");
        } else {
            PrintWriter out = response.getWriter();
//            response.sendRedirect("index.jsp");
            out.println("<script type=\"text/javascript\">");
            out.println("alert(\"Login Failed\");");
            out.println("window.history.back(-1);");
            out.println("</script>");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
