<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="storage" class="com.example.servletjspdemo.service.StorageService" scope="application" />
<jsp:useBean id="drink" class="com.example.servletjspdemo.domain.Drink" scope="session" />

<form action="addedDrink.jsp">

  Name :<input type="text" name="name" value="${drink.name}" /><br />
  Price :<input type="text"  name="price" value="${drink.price}" /><br />
  Amount :<input type="text"  name="amount" value="${drink.amount}" /><br />
  <input type="submit" value=" OK ">
  
</form>

</body>
</html>