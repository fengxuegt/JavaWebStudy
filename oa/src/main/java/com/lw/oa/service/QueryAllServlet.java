package com.lw.oa.service;

import com.lw.oa.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtils.getConnection();
            statement = connection.prepareStatement("select deptno, dname, loc from  dept");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String deptno = resultSet.getString("deptno");
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection, resultSet, statement);
        }
    }
}
