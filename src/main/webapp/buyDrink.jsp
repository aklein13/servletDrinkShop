<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Added a drink</title>
</head>
<body>
<jsp:useBean id="drink" class="com.example.servletjspdemo.domain.Drink" scope="session" />
<jsp:setProperty name="drink" property="*" />
<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />

<%
  String drinkToBuy = request.getParameter("buy");
  String basket = (String) session.getAttribute("basket");
  if(basket == null){
      basket = "";
  }
  basket += drinkToBuy + "<br/>";
  session.setAttribute("basket", basket);
  storage.buyDrink(drinkToBuy);
  out.println("<h2>Kupiłeś " + drinkToBuy + "</h2>");
%>

<p>
  <a href="showAllDrinks.jsp">Show all drinks</a>
</p>
</body>
</html>
