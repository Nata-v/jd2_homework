package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormServlet", urlPatterns = "/form")

public class FormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if ((name.isEmpty()) || (phone.isEmpty() && email.isEmpty())) {
            out.println("<html><body>");
            out.println("<h2>Ошибка: Заполните все поля!</h2>");
            out.println("</body></html>");
        } else {
            User user = new User(name, phone, email);

            out.println("<html><body>");
            out.println("<h2>Данные пользователя: </h2>");
            out.println("<p>Имя: " + user.getName() + "</p>");
            out.println("<p>Телефон: " + user.getPhone() + "</p>");
            out.println("<p>Email: " + user.getEmail() + "</p>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

