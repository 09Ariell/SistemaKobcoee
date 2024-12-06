<%-- 
    Document   : registro
    Created on : 26 nov 2024, 12:45:44
    Author     : labICI01
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
  <link rel="stylesheet" href="css/login.css" />
  <title>Registro de Usuario</title>
</head>
<body>
    <div class="login-container">
        <h1>Crear una Cuenta</h1>
        <form action="RegistrarUsuarioServlet" method="post">
            <div class="input-group">
                <label for="name">Nombre Completo:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="input-group">
                <label for="email">Correo Electrónico:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="input-group">
                <label for="phoneNumber">Número de Teléfono:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" required>
            </div>
            <div class="input-group">
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn-submit">Registrarse</button>
        </form>
        <p class="register-link">¿Ya tienes una cuenta? <a href="login.jsp">Inicia sesión aquí</a></p>
    </div>
    <div class="login-container">
    <button class="btn-submit" onclick="window.location.href='index.jsp'">Volver al Inicio</button>
    </div>
</body>
</html>
    