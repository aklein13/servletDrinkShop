package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> errors = new ArrayList<String>();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (request.getParameter("name") != "") {
            boolean checkName = nameCheck(request.getParameter("name"));
            if (!checkName) errors.add("Imie moze zawierac tylko litery!");
        } else {
            errors.add("Brak podanego imienia!");
        }
        if (request.getParameter("hobby") == null) {
            errors.add("Brak wybranego hobby!");
        }
        if (request.getParameter("opis") == null) {
            errors.add("Brak wpisanego opisu!");
        }
        if (request.getParameter("gender") == null) {
            errors.add("Brak wybranej plci!");
        }
        if (request.getParameterValues("car") == null) {
            errors.add("Brak wybranego auta/aut!");
        }
        if (request.getParameter("bday") != "") {
            boolean checkData = dateCheck(request.getParameter("bday"));
            if (!checkData) errors.add("Wymagany format daty to: DD-MM-RRRR!");
        } else {
            errors.add("Brak podanej daty!");
        }

        if (errors.size() == 0) {
            String selectedHobby = "";
            for (String hobby : request.getParameterValues("hobby")) {
                selectedHobby += hobby + " ";
            }
            String selectedCars = "";
            for (String hobby : request.getParameterValues("car")) {
                selectedCars += hobby + " ";
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(request.getParameter("bday"), formatter);
            LocalDate now = LocalDate.now();
            int age = Period.between(date, now).getYears();
            String adult = age >= 18 ? "tak" : "nie";
            out.println("<html><body><h2>Twoje dane:</h2>" +
                    "<p>Imie: " + request.getParameter("name") + "<br />" +
                    "<p>Hobby: " + selectedHobby + "<br />" +
                    "<p>Opis: " + request.getParameter("opis") + "<br />" +
                    "<p>Plec: " + request.getParameter("gender") + "<br />" +
                    "<p>Ulubione auta: " + selectedCars + "<br />" +
                    "<p>Data urodzenia " + date + "<br />" +
                    "<p>Wiek: " + age + "<br />" +
                    "<p>Czy jestem pelnoletni?: " + adult + "<br />" +
                    "</body></html>");
            out.close();
        } else {
            for (String element : errors) {
                out.print(element + "<br />");
            }
        }
    }

    boolean nameCheck(String imie) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(imie);
        if (m.find()) {
            return false;
        } else return true;
    }

    boolean dateCheck(String data) {
        Pattern p = Pattern.compile("[0-9][0-9][-][0-9][0-9][-][0-9][0-9][0-9][0-9]");
        Matcher m = p.matcher(data);
        if (m.find()) {
            return true;
        } else return false;
    }

}
