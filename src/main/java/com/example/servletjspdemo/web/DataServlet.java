package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.print.AttributeException;
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
        
        if(request.getParameter("name") != "") {
        	boolean checkImie = imieCheck(request.getParameter("name"));
        	if(!checkImie) errors.add("Imie moze zawierac tylko litery!");
        }else {
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
        if(request.getParameter("bday") != "") {
        	boolean checkData = dataCheck(request.getParameter("bday"));
        	if(!checkData) errors.add("Wymagany format daty to: DD-MM-RRRR!");
        }else {
        	errors.add("Brak podanej daty!");
        }
        
        if(errors.size() == 0) {
        	//lista hobby
            String selectedHobby = "";
            for (String hobby : request.getParameterValues("hobby")) {
                selectedHobby += hobby + " ";
            }
            //lista aut
            String selectedCars = "";
            for (String hobby : request.getParameterValues("car")) {
            	selectedCars += hobby + " ";
            }        
            
            //zamiana string to date
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        	LocalDate date = LocalDate.parse(request.getParameter("bday"), formatter);
        	LocalDate now = LocalDate.now();
        	//obliczanie wieku
            int wiek = Period.between(date, now).getYears();
            String peln ="";
            if(wiek>=18) {
            	peln="tak";
            }
            else {
            	peln="nie";
            }
            //wypis html
                out.println("<html><body><h2>Your data</h2>" +
					 "<p>Imie: " + request.getParameter("name") + "<br />" +
					 "<p>Hobby: " + selectedHobby + "<br />" +
					 "<p>Opis: " + request.getParameter("opis") + "<br />" +
					 "<p>Plec: " + request.getParameter("gender") + "<br />" +
					 "<p>Ulubione auta: " + selectedCars + "<br />" +
					 "<p>Data urodzenia " + date + "<br />" +
					 "<p>Wiek: " + wiek + "<br />" +
					 "<p>Czy jestem pelnoletni?: " + peln + "<br />" +
					 "</body></html>");
            out.close();
        }else {
            for(String element : errors) {
          		out.print(element + "<br />");
          }
        }
    }
    
    boolean imieCheck(String imie) {
    	Pattern p = Pattern.compile("[0-9]");
    	Matcher m = p.matcher(imie);
    	if(m.find()) {
    	    return false;
    	}
    	else return true;
    }
    
    boolean dataCheck(String data) {
    	Pattern p = Pattern.compile("[0-9][0-9][-][0-9][0-9][-][0-9][0-9][0-9][0-9]");
    	Matcher m = p.matcher(data);
    	if(m.find()) {
    	    return true;
    	}
    	else return false;
    }

}
