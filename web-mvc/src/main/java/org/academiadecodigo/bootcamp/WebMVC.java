package org.academiadecodigo.bootcamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebMVC extends HttpServlet {

    public Marble getMarble(String name, String team) {

        Marble marble = new Marble();
        marble.setName(name);
        marble.setTeam(team);

        return marble;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Marble smoggy = getMarble("Smoggy", "Hazers");

        request.setAttribute("smoggy", smoggy);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/web_mvc.jsp");
        dispatcher.forward(request, response);
    }
}
