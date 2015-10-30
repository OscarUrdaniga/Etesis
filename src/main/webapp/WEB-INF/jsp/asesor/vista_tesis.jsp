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
        <div class="col-xs-4">
         <label>Juan Perez </label></div>
        <div class="col-xs-8" style="text-align:left">
         <label>Diseño de redes rurales</label></div>
     </div>
     
     <div class="row" style="text-align:left">
     <label>    Marco teorico</label></div>
     <form>
     <fieldset>
         <div class="row">
         <div class="col-xs-4"></div>
         <div class="col-xs-4" style="text-align:left">
         <label>Estado de entrega </label></div>
        <div class="col-xs-4" style="text-align:left">
         <label>Enviado</label></div>
     </div>
         
         <div class="row">
         <div class="col-xs-4"></div>
         <div class="col-xs-4" style="text-align:left">
         <label>Estado de calificación </label></div>
        <div class="col-xs-4" style="text-align:left">
         <label>--------</label></div>
     </div>

         <div class="row">
         <div class="col-xs-4"></div>
         <div class="col-xs-4" style="text-align:left">
         <label>Fecha de entrega </label></div>
        <div class="col-xs-2" style="text-align:left">
         <label>Viernes 18/09/15</label></div>
             <div class="col-xs-2" style="text-align:left">
        <button id="editar">Editar</button> </div>    
         </div>
         
         <div class="row">
         <div class="col-xs-4"></div>
         <div class="col-xs-4" style="text-align:left">
         <label>Tiempo restante:</label></div>
        <div class="col-xs-4" style="text-align:left">
         <label>La tarea fue enviada 7 minutos antes </label></div>
         </div>
         
         <div class="row">
         <div class="col-xs-4"></div>
         <div class="col-xs-4" style="text-align:left">
         <label>Última modificación:</label></div>
        <div class="col-xs-4" style="text-align:left">
         <label>Viernes 18/09/15 , 11:58 pm </label></div>
         </div>

         <div class="row">
         <div class="col-xs-4"></div>
         <div class="col-xs-4" style="text-align:left">
         <label>Archivos enviados:</label></div>
         </div>
         
         <div class="row">
         <div class="col-xs-5"></div>
         <div class="col-xs-7" style="text-align:left">
         <a href="#">Link fuente</a></div>
         </div>
         
         <div class="row">
         <div class="col-xs-5"></div>
         <div class="col-xs-7" style="text-align:left">
         <a href="#">Imagen de red</a></div>
         </div>
         
          <div class="row">
         <div class="col-xs-5"></div>
         <div class="col-xs-7" style="text-align:left">
         <a href="#">Marco teorico</a></div>
         </div>
         
         </fieldset>
     </form>
    </div>

    </body>
</html>