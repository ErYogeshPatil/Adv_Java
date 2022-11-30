<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MovieShowAdminPanel</title>
<!-- bootstrap CSS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">


    <!-- text animation -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

    <!-- Google font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Alkalami&family=Inter:wght@500&display=swap" rel="stylesheet">

    <!-- flikety -->
    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">
    
    <style>
    .data{
    	padding-top:80px;
    	text-align:center;
    }
    </style>
</head>
<body>
 <!-- Nav Bar -->
    <nav class="navbar bg-light"
        style="background-color: #bbddf5;position:fixed; width:100%;z-index:1;border-bottom:2px solid black;box-shadow:10px 10px 15px burlywood;">
        <div class="container-fluid">
            <a href="home.html" class="navbar-brand">🅼🅾🆅🅸🅴🆂🅷🅾🆆</a>
            <h2>𝓐𝓭𝓶𝓲𝓷 𝓟𝓪𝓷𝓮𝓵</h2>
            <form class="d-flex" role="search" method="POST" action="SearchByName">
                <input class="form-control me-2" type="search" placeholder="Search Product" aria-label="Search"
                    name="SearchByName" id="SearchName">
                <button class="btn btn-outline-success" type="submit" name="send" value="Find"
                    onclick="Get()">Search</button>
                <a href="Order.html"><img src="./img/titket.jpg" alt="" height="35px" width="60px"></a>
            </form>
        </div>
    </nav>


<div class="data">

<h1>User Registration Details.</h1>

<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://Localhost:3306/batch12to2" user="root" password="Yogesh@1996"></sql:setDataSource>

<sql:query dataSource="${db}" var="rs">
select*from Registration;
</sql:query>

<table class="table md-8">
  <thead>
    <tr>
      <th scope="col"> Name </th>
      <th scope="col"> Email </th>
      <th scope="col"> Password  </th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.Name}"/></td>
<td><c:out value="${table.Email}"/></td>
<td><c:out value="${table.Password}"/></td>
</tr>
</c:forEach>
</table>

<br>
<br>
<hr>


<h1>Ticket Booking Details.</h1>
<sql:setDataSource var="db1" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://Localhost:3306/batch12to2" user="root" password="Yogesh@1996"></sql:setDataSource>

<sql:query dataSource="${db1}" var="Tk">
select*from Ticket_Booking;
</sql:query>

<table class="table md-8">
  <thead>
    <tr>
      <th scope="col"> B_id </th>
      <th scope="col"> Username </th>
      <th scope="col"> Movie </th>
      <th scope="col"> Location </th>
      <th scope="col"> Numseats  </th>
      <th scope="col"> Total </th>
      <th scope="col"> SeatNo </th>
      <th scope="col"> Delete</th>
    </tr>
  </thead>
  <tbody>
<c:forEach var="Booking" items="${Tk.rows}">
<tr>
<td><c:out value="${Booking.B_id}"/></td>
<td><c:out value="${Booking.Username}"/></td>
<td><c:out value="${Booking.Movie}"/></td>
<td><c:out value="${Booking.Location}"/></td>
<td><c:out value="${Booking.Numseats}"/></td>
<td><c:out value="${Booking.Total}"/></td>
<td><c:out value="${Booking.SeatNo}"/></td>
<td><a href="Order.html">Delete</a></td>
</tr>
</c:forEach>
</table>

<br>
<br>
<hr>

<h1>Payment Details.</h1>
<sql:setDataSource var="db2" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://Localhost:3306/batch12to2" user="root" password="Yogesh@1996"></sql:setDataSource>

<sql:query dataSource="${db2}" var="PY">
select*from Payment;
</sql:query>

<table class="table md-8">
  <thead>
    <tr>
      <th scope="col"> Mail </th>
      <th scope="col"> CardNo </th>
      <th scope="col"> MobileNo</th>
    </tr>
  </thead>
  <tbody>
<c:forEach var="Pyment" items="${PY.rows}">
<tr>
<td><c:out value="${Pyment.Mail}"/></td>
<td><c:out value="${Pyment.CardNo}"/></td>
<td><c:out value="${Pyment.MobileNo}"/></td>
</tr>
</c:forEach>
</table>


</div>
</body>
</html>