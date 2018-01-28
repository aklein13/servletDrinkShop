<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Added a drink</title>
</head>
<body>
<jsp:useBean id="drink" class="com.example.servletjspdemo.domain.Drink" scope="session"/>
<jsp:setProperty name="drink" property="*"/>
<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application"/>

<%
    String drinkToBuy[] = request.getParameterValues("buy");
    Double totalPrice = (Double) session.getAttribute("totalPrice");
    if (totalPrice == null) {
        totalPrice = 0.0;
    }
    String basket = (String) session.getAttribute("basket");
    if (basket == null) {
        basket = "";
    }
    for (String aDrinkToBuy : drinkToBuy) {
        int amount = Integer.parseInt(request.getParameter(aDrinkToBuy));
        if (amount < 1){
            out.println("<h2>Can't buy " + aDrinkToBuy + ", you tried to buy more then in stock or 0</h2>");
            continue;
        }
        Double price = storage.buyDrink(aDrinkToBuy, amount);
        if(price == 0.0){
            out.println("<h2>Can't buy " + aDrinkToBuy + ", you tried to buy more then in stock</h2>");
            continue;
        }
        totalPrice += amount * price;
        basket += amount + " x " + aDrinkToBuy + " " + amount * price + " zł<br/>";
        out.println("<h2>You bought " + amount + " x " + aDrinkToBuy + "</h2>");
    }
    session.setAttribute("basket", basket);
    session.setAttribute("totalPrice", totalPrice);
%>

<p>
    <a href="index.jsp">Show all drinks</a>
</p>
</body>
</html>
