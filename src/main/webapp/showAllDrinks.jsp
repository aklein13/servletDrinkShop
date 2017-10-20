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
<%
    int amount;
    for (Drink drink : storage.getAllDrinks()) {
        amount = drink.getAmount();
        out.print("<p>Name: " + drink.getName() + "; Price: " + drink.getPrice() + "; Amount: " + amount);
        if (amount > 0) {
            out.print(" <a href='buyDrink.jsp'><button>Buy</button></a>" );
        }
        out.println("</p>");
    }
%>
<p>
    <a href="addDrink.jsp">Add another drink</a>
</p>
<h2>Your bucket:</h2>
<%
    out.println(session.getAttribute("bucket"));
%>

</body>
</html>