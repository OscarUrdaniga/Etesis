<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etesis - Logueo</title>
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
                            <h1>Bienvenido a Etesis</h1><br>
                            <p class="intro" style="padding-right: 30%;">
                                Etesis es el futuro para los trabajos de Tesis
                            </p>
                        </header>
                    </div>
                </div>
            </div>
        </div>

        <%-- Logueo--%>
        <div class="row-fluid" style=" width: 80%; padding:0 10%;">
            <div class="span4">
                <div class="thumbnail">
                    <div class="modal-header">
                        <h3>Ingresar</h3>
                    </div>
                    <div class="modal-body">
                        <spring:url value="/dologin.do" var="url" />
                        <form class="well form-inline" role="form" action="${url}" method="POST">
                            <% if (request.getParameter("error") != null) {%><div class="alert alert-error">Los datos ingresados son incorrectos</div> <% }%>
                            <div class="control-group">
                                <label class="control-label">C&oacutedigo</label>
                                <div class="controls">
                                    <input type="text" name="codigo" placeholder="20159648">
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">Password</label>
                                <div class="controls">
                                    <input type="password" name="password">
                                </div>
                            </div>
                            <div class="control-group">
                                <div class="controls">
                                    &nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-success">Ingresar</button>
                                </div>
                            </div>
                        </form> 
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
