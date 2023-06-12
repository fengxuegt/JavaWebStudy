package com.lw;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

public class RequestTestServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter printWriter = resp.getWriter();
//        printWriter.println(req);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            System.out.println(entry.getKey());
            for (String val : entry.getValue()) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        Enumeration parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.print (parameterNames.nextElement() + " ");
        }
        System.out.println();

        String name = req.getParameter("name");
        System.out.println("name: " + name);

        System.out.println(req.getParameterValues("aihao"));

    }
}
