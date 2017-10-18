package com.synergy.training.entities.servlets;

import com.synergy.training.entities.Holder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tatevik.r.gevorgyan on 10/12/2017.
 */
public class AddEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String desc = request.getParameter("description");
        int totalAmount = Integer.parseInt(request.getParameter("totalAmount"));
        int currencyId = Integer.parseInt(request.getParameter("currencies"));
        int subSector = Integer.parseInt(request.getParameter("subSectors"));

        if(id > 0) {
            Holder.editProject(id, title, desc, totalAmount, currencyId, subSector);
        } else {
            Holder.addProject(id, title, desc, totalAmount, currencyId, subSector);
        }
        response.sendRedirect("/ProjectList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
