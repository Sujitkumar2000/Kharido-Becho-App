<%@page import="dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<center>
	<h1> <u>-:Welcome To Kharido or Becho:-</u></h1>
	<%
	Customer customer= (Customer)session.getAttribute("customer");
	if(customer == null)
	{
	%>
	<a href="Login.html"><button>Login</button> </a> <br><br> 
	<a href="Signup.html"><button>Signup</button> </a> <br><br>
	<%} %>
	<a href=""><button>Buy</button> </a> <br><br>
	<a href="sell"><button>Sell</button> </a> <br><br>
	<%if(customer  != null){ %>
	<a href="logout"><button>Logout</button> </a> <br><br>
	<%} %>
	</center>
	
	<style>
	h1{
		color: blue;
	}
	body{
	background-image: url("‪C:\Website Project\1993 Studio\Main\Image\360_F_424377748_GN58klscq6HK7UtWYVWqOLQko0CPoMAv.jpg");
	border-radius: 15px;
	border: 5px solid red;
	}
	button{
		height: 30px;
		width: 80px;
	}
	</style>
</body>
</html>