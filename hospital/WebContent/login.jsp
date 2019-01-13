<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital Management System</title>
<link rel="stylesheet" href="index.css" type="text/css" />
</head>
<body background="backgd.jpeg">
	
	<div id="wrapper">
    	<div id="header"><h1>Hospital Management System</h1></div>
    </div>
    </br>
    </br>
    </br>
   <div align="center">
			<form  action="login" method="post">
				</br>
				<input type="text" placeholder="LoginID" name="LoginID" /></br></br> 
				</br>
				<input type="password" placeholder="password" name="password"/></br></br>
				<button>login</button>

			</form>
			</div>

</body>
</html>
<style>

form {border: 3px solid #f1f1f1;
	}

input[type=text], input[type=password] {
    width: 25%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
button {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 25%;
}

button:hover {
    opacity: 0.8;
}
</style>