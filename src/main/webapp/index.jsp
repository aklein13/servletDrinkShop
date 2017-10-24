<%@page import="com.example.servletjspdemo.domain.Drink" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Drink list</title>
</head>
<body>
<h1>Drink list</h1>
<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application"/>
<form action="buyDrink.jsp">
    <%
        storage.generateDrinks();
        int amount;
        for (Drink drink : storage.getAllDrinks()) {
            amount = drink.getAmount();
            out.print("<p>Name: " + drink.getName() + " Price: " + drink.getPrice() + "zł Available: " + amount);
            if (amount > 0) {
                out.print(" <input type='number' value='1' name='" + drink.getName() + "'/>");
                out.print(" <input type='checkbox' value='" + drink.getName() + "' name='buy'/>");
            } else {
                out.print(" <button disabled>Out of stock</button>");
            }
            out.println("</p>");
        }
    %>
    <button type="submit" name="buydrinks" value="Buy">Buy checked drinks</button>
</form>
<p>
    <%--<a href="addDrink.jsp">Add another drink</a>--%>
</p>
<h2>Your basket:</h2>
<%
    String basket = (String) session.getAttribute("basket");
    if(basket != null){
        out.println(basket);
        out.println("<br/>Total price: " + session.getAttribute("totalPrice") + "zł");
    }
    else{
        out.println("Your basket is empty");
    }
%>
</body>
</html>