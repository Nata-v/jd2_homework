package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BrowserServlet", urlPatterns = "/browser")
public class BrowserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAgent = req.getHeader("User-Agent");

        String browser = getUserBrowser(userAgent);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        out.println("Приветствую пользователя " + browser);

        out.println("</body></html>");
    }

private String getUserBrowser(String userAgent) {
    if (userAgent == null) {
        return "Unknown";

    } else if (userAgent.matches("(?i).*Firefox.*")) {
        return "Firefox";
    } else if (userAgent.matches("(?i).*Opera.*") || userAgent.matches("(?i).*OPR.*")) {
        return "Opera";
    } else if (userAgent.matches("(?i).*Edge.*") || userAgent.matches("(?i).*Edg.*")) {
        return "Edge";
    } else if (userAgent.matches("(?i).*IE.*")) {
        return "Internet Explorer";
    } else if (userAgent.matches("(?i).*Chrome.*")) {
        return "Chrome";
    } else if (userAgent.matches("(?i).*Safari.*")) {
        return "Safari";
    } else {
        return userAgent;
    }
}


}





