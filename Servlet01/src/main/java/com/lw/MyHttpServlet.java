package com.lw;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyHttpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String remoteAddr = req.getRemoteAddr();
        printWriter.println("<h1> Welcome liwang </h1>");
        printWriter.println(remoteAddr);
        req.getParameter("");
        req.getParameterMap();
        req.getParameterValues("");
        req.getParameterNames();

        




    }
}
