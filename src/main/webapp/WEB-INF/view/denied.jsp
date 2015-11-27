<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etesis</title>
        <link rel="shortcut icon" href="<spring:url value="/view/img/etesis.png"/>">
        <link rel="stylesheet"
              href='<spring:url value="/resources/css/bootstrap.css"/>' />
        <script type='text/javascript' src='<spring:url value="/resources/js/jquery-1.11.1.min.js"/>'></script>
    </head>

    <body>
        <%-- Navbar superior--%>
        <div style="width: 100%;">
            <div class="carousel slide">
                <div class="carousel-inner">
                    <div class="item active">
                        <header class="unit hero-unit">
                            <h1>ACCESO DENEGADO</h1><br>
                            <p class="intro" style="padding-right: 30%;">
                                Usted no tiene permiso de acceder al contenido seleccionado.
                            </p>
                        </header>
                    </div>
                </div>
            </div>
        </div>
    
      
        
        
        <%-- Footer --%>             
        <div class="container"  style="padding-top: 50px;"><hr>
            <footer class="footer">
                <p style="text-align: center;">
                    &copy; 2015 Software para Telecomunicaciones 2 - Pontificia Universidad Católica del Perú<br> 
                    Comentarios y/o sugerencias: <a href="etesis0891@pucp.pe">etesis0891@pucp.pe</a></p>

            </footer></div>
    </body>
</html>