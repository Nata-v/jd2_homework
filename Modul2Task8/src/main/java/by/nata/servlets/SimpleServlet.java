package by.nata.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
//@WebServlet(name = "SimpleServlet", urlPatterns = "/servlet")

public class SimpleServlet extends HttpServlet{
        private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>First Servlet</title></head>");
            out.println("<body><h1>This is my First Servlet</h1>");
            out.println("</body></html>");
        }
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            doGet(request, response);
        }

    }

