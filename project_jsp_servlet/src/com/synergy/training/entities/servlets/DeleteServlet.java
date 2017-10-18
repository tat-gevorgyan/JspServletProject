package com.synergy.training.entities.servlets;

import com.synergy.training.entities.Holder;

import java.io.IOException;

/**
 * Created by user on 10/11/2017.
 */
public class DeleteServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Holder.deleteProject(id);
        response.sendRedirect("/ProjectList.jsp");
    }
}
