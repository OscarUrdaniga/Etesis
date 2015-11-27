<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etesis</title>
        <link rel="shortcut icon" href="<spring:url value="/jsp/img/etesis.png"/>">
        <link rel="stylesheet"
              href='<spring:url value="/resources/css/bootstrap.css"/>' />
        <script type='text/javascript' src='<spring:url value="/resources/js/jquery-1.11.1.min.js"/>'></script>
    </head>
    <body>
        <%-- Navbar superior--%>
        <div class="navbar navbar-fixed-top" style="position: relative">
            <div class="navbar-inner">
                <div class="container" style="width: auto; padding: 0 20px;">
                    <ul class="nav">
                        <li class="active">
                            <a href="#">${personaBean.nombre} ${personaBean.apellidos} (${personaBean.correo}) - 
                                <sec:authorize access="hasRole('ROLE_ASESOR')"> Asesor </sec:authorize>
                            </a>
                        </li>
                    </ul>
                    <a href="<spring:url value='/logout.do'/>" class="btn pull-right">Cerrar Sessión</a>
                </div>
            </div>
        </div>
        <%-- Panel Superior--%>        
        <div>  
            <div class="carousel slide">
                <div class="carousel-inner">
                    <div class="item active">
                        <header class="unit hero-unit">
                            <h1>Etesis</h1><br>
                            <p>Home Page - Asesor</p>
                        </header>
                    </div>
                </div>
            </div>
        </div> 
        <br>

        <div class="row-fluid" style=" width: 80%; padding:0 10%;">

            <%-- Lista de opciones --%> 
            <div class="span2">
                <ul class="nav nav-list well">
                    <li><a href="<spring:url value='/home.do'/>"><i class="icon-home"></i>Inicio</a></li>
                    <li class="active"><a href="#"><i class="icon-chevron-right icon-white"></i>Alumnos</a></li>

                </ul>
            </div>
            <%-- Tabla con los datos --%>             
            <div class="span10">                
                <table class="items table table-bordered">
                    <thead>
                        <tr>
                            <th>Apellidos</th>
                            <th>Nombre</th>
                            <th>Codigo</th>
                            <th>DNI</th>
                            <th>Correo</th>
                            <th>Telefono</th>                           
                    </thead>
                    <tbody>

                        <c:forEach var="alumno" items="${listaUsuariosCompleto}">  
                            <tr>
                                <td>${alumno.apellidos}</td>
                                <td>${alumno.nombre}</td>
                                <td>${alumno.codigo}</td>
                                <td>${alumno.DNI}</td>
                                <td>${alumno.correo}</td>
                                <td>${alumno.telefono}</td>                    
                            </tr>
                        </c:forEach>                         
                    </tbody>
                </table>
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
