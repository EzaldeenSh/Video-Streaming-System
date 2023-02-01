<html>
<head>
<title>Login</title>
</head>
<body>

    <p><font color="red">${errorMessage}</font></p>
    <form action="/login" method="POST">
            Username : <input name="username" type="text" placeholder = "Username" required = "true"/>
             Password : <input placeholder = "Password" name="password" type="password" required = "true"/>
             <input type="submit" />
    </form>
</body>
</html>