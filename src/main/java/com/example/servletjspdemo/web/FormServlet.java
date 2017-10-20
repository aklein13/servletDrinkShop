package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Simple form servlet</h2>" +
                "<form action='data'>" +
                "First name: <input type='text' name='name' /> <br />" +
                "<input type='checkbox' name='hobby' value='bicycle'>I like riding a bicycle<br />" +
                "<input type='checkbox' name='hobby' value='tv'>I like watching TV<br />" +
                "Dodaj cos od siebie: <br /><textarea name='opis' rows='4' cols='50'></textarea><br />" +
                "Podaj plec:<br /><input type='radio' name='gender' value='male'> Mezczyzna<br/>" +
                "<input type='radio' name='gender' value='female'> Kobieta<br/>" +
                "Twoje ulubione auto to:<br /> <select name='car' multiple>\n" +
                "  <option value='volvo'>Volvo</option>\n" +
                "  <option value='saab'>Saab</option>\n" +
                "  <option value='mercedes'>Mercedes</option>\n" +
                "  <option value='audi'>Audi</option>\n" +
                "</select><br/>" +
                "<br />Data urodzenia:<input type='text' name='bday' />" +
                "<br /><input type='submit' value=' Wyslij ' />" +
                "</form>" +
                "</body></html>");
        out.close();
    }

}
