package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "ImageServlet", urlPatterns = "/image")
public class ImageServlet extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;
    private int counter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);

        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 48));
        graphics.setColor(Color.green);
        graphics.drawString("Hello World!"  + counter, 100, 100);

        resp.setContentType("image/jpeg");

        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(image, "jpeg", out);
        out.close();


        writeCounterToFile(counter);
    }

    private void writeCounterToFile(int counter) {
        try {
            String path = System.getProperty("user.home") + "\\image.txt";

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

