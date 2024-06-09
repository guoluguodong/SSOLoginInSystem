package com.lky.logincas.controller;

import com.alibaba.fastjson.JSONObject;
import com.lky.logincas.domain.User;
import com.lky.logincas.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        HttpSession session = request.getSession();
        try {
            UserService.getInstance().logout(token);
            Cookie cookieName = new Cookie("username", null);
            Cookie cookieToken = new Cookie("token", null);
            response.addCookie(cookieName);
            response.addCookie(cookieToken);
            response.sendRedirect("http://www.loginsystem.com:8081/jsp/login.jsp?web=main");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}