package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
//@WebServlet(name = "CountServlet", urlPatterns = "/counter")

public class CountServlet extends HttpServlet implements Serializable{
    private static final long serialVersionUID = 1L;
    private int counter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("Количество посещений: " + counter);
        out.println("</body></html>");
        writeCounterToFile(counter);
    }

    private void writeCounterToFile(int counter) {
        try {
            String path = System.getProperty("user.home") + "\\count.txt";

            File file = new File(path);
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(String.valueOf(counter));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

