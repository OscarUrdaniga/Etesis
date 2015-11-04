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
        
                    <div class="row" id="formulariologin">
        <div id="error" class="alert alert-danger" style="<%= request.getAttribute("error")!=null ? "display:block;" : "display:none;" %>" >Datos Incorrectos</div>     
    <form method="post" action="<%=request.getContextPath()%>/ServletCuenta?action=login">
    <div id="login" class="form-group col-md-7">
    	
       	<label for="correo">Correo-Electrónico </label><input class="form-control" placeholder="micorreo@correo.com" id="correo" name="correo" /><br/>
        <label for="password">Password </label><input  type="password" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group col-md-5" id="otros">
    		<p class="derecha"><a href="#">Recuperar Contraseña</a></p>
            <p class="derecha"><a href="#">Registrarse</a></p>
    	    <p><input type="submit" value="Ingresar" class="btn btn-default misubmit" /></p>
             
    </div>
     </form>
     </div>     


    </body>
</html>