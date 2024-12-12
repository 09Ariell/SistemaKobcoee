<%-- 
    Document   : login.jsp
    Created on : 23-11-2024, 2:28:07?p. m.
    Author     : tobar
--%>
<html>
<head>
  <link rel="stylesheet" href="css/login.css" />
  <title>Iniciar Sesión</title>
</head>
<body>
    <div class="login-container">
        <h1>Iniciar Sesión</h1>
        <form action="LoginServlet" method="post">
            <div class="input-group">
                <label for="username">Usuario:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn-submit">Ingresar</button>
        </form>
    </div>
    <div class="login-container">
    <button class="btn-submit" onclick="window.location.href='index.jsp'">Volver al Inicio</button>
    </div>
</body>
</html>
