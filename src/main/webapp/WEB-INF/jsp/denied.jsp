<%-- 
    Document   : denied
    Created on : 03/11/2015, 07:26:05 PM
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <%@include file="/WEB-INF/jsp/comun/recursos.jsp" %>
        <title>etesis</title>

    </head>

    <body>
        <%@include file = "/WEB-INF/jsp/comun/cabecera.jsp" %>
<div class="container-fluid">
        <div class="row">
            <div class="col-xs-2"><a id="logo"><img src="e-Tesis.png" width="100%"/></a></div>
            <div class="col-xs-10" style="text-align:right">
                <label>e-Tesis</label><br><br>
                <label>Angelo Velarde</label><br>
                <button id="cerrarSesion">Cerrar Sesion</button>
            </div></div><hr/><br><br>
     
     <div class="row">
	  <div class="col-xs-6">Bienvenido: Administrador </div>
	  <div class="col-xs-4"></div>
         <div class="col-xs-2" style="text-align:right"><a href="#">Volver</a></div></div>
     
     <div class="row"><br><br>
         
         <div class="col-xs-2">
	        
        </div>
        <div class="col-xs-8">
	        <h1>
            ACCESO DENEGADO
            </h1></br>
         
            <h4>
            Usted no tiene permiso de acceder al contenido seleccionado.
            </h4></br>
          
        </div>
        <div class="col-xs-2">
	        
         </div>
    </div>
    </br>
</div>
</div>



    </body>
</html>