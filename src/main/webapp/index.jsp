<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />
<%
    storage.generateDrinks();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drink Shop</title>
    </head>
    <body>
        <h2>Drink Shop</h2>
        <p><a href="showAllDrinks.jsp">Show drink list</a></p>
        <p><a href="addDrink.jsp">Add a drink</a></p>
    </body>
</html>
