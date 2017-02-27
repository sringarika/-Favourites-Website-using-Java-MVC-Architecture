<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.sring.hw4.model.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi" crossorigin="anonymous">

    <!-- Custom styles for this template -->
  <style type="text/css">body {
  padding-top: 50px;
}

.sub-header {
  padding-bottom: 10px;
  border-bottom: 1px solid #eee;
}

.navbar-fixed-top {
  border: 0;
}

.sidebar {
  display: none;
}
@media (min-width: 768px) {
  .sidebar {
    position: fixed;
    top: 51px;
    bottom: 0;
    left: 0;
    z-index: 1000;
    display: block;
    padding: 20px;
    overflow-x: hidden;
    overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
    background-color: #f5f5f5;
    border-right: 1px solid #eee;
  }
}

/* Sidebar navigation */
.nav-sidebar {
  margin-right: -21px; /* 20px padding + 1px border */
  margin-bottom: 20px;
  margin-left: -20px;
}
.nav-sidebar > li > a {
  padding-right: 20px;
  padding-left: 20px;
}
.nav-sidebar > .active > a,
.nav-sidebar > .active > a:hover,
.nav-sidebar > .active > a:focus {
  color: #fff;
  background-color: #428bca;
}

.main {
  padding: 20px;
}
@media (min-width: 768px) {
  .main {
    padding-right: 40px;
    padding-left: 40px;
  }
}


.placeholders {
  margin-bottom: 30px;
  text-align: center;
}
.placeholders h4 {
  margin-bottom: 0;
}
.placeholder {
  margin-bottom: 20px;
}
.placeholder img {
  display: inline-block;
  border-radius: 50%;
}</style>
  </head>

  <body>

    <nav class="navbar navbar-dark navbar-fixed-top bg-inverse">
      <button type="button" class="navbar-toggler hidden-sm-up" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar" aria-label="Toggle navigation"></button>
      <a class="navbar-brand" href="#">Favorites Management</a>
      <div id="navbar">
        <nav class="nav navbar-nav float-xs-left">
          <a class="nav-item nav-link" href="home">Manage My Favorites</a>
          <c:if test="${sessionScope.user == null}">
          <a class="nav-item nav-link" href="register">Register</a>
          <a class="nav-item nav-link" href="login">Login</a>
          </c:if>
              
        </nav>
<c:if test="${sessionScope.user != null}">
		       <nav class="nav navbar-nav float-xs-right">
		       <a class="nav-item nav-link" href="changepass">Change Password</a>
          <a class="nav-item nav-link" href="logout">Logout</a>
          
          
        </nav>
</c:if>
  
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
           
            <li>List of Users</li>
           
          </ul>
           <ul class="nav nav-sidebar">
           
           <c:if test="${userid != null}">
           			 <c:forEach items="${requestScope.userid}" var="record">
           			  <li><a href="Unauth?id=${record.id }"> ${record.fName} ${record.lName} 
            </a></li>
            
           			 </c:forEach>
        
          </c:if>
          </ul>
         
        </div>
        <div class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 main">
      