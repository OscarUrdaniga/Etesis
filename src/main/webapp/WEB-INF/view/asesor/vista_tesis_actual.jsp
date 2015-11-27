<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etesis - Asesor</title>
        <link rel="shortcut icon" href="<spring:url value="/view/img/etesis.png"/>">
        <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.css"/>' />
        <script type='text/javascript' src='<spring:url value="/resources/js/jquery-1.11.1.min.js"/>'></script>
    </head>
    <body>
        <%-- Navbar superior--%>
        <div class="navbar navbar-fixed-top" style="position: relative">
            <div class="navbar-inner">
                <div class="container" style="width: auto; padding: 0 20px;">
                    <ul class="nav">
                        <li class="active">
                            <a href="#">
                                <sec:authorize access="hasRole('ROLE_ASESOR')"> Asesor:  </sec:authorize>
                                ${personaBean.nombre} ${personaBean.apellidos} (${personaBean.correo})
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

        <table width="100%" border="0" cellspacing="0" cellpadding="1">
            <tr bgcolor="blue" align="center"> 
                <td><b><font color="#FFFFFF">Semana ${semana}</font></b></td> 
            </tr> 
            <tr bgcolor="blue"> 
                <td> 
                    <table width="100%" border="0" cellspacing="0" cellpadding="4"> 
                        <tr bgcolor="#FFFFFF"> 
                            <td>
                                <div class="row-fluid" style=" width: 100%; padding:0 10%;">
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="modal-header">
                                                <div class="span4"><br>

                                                    <table class="items table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>Archivos y Documentos</th>
                                                                <th>Eliminar</th>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td><img src="resources/img/pdf.jpg" width="20"><a href="">${nombreArchivo}</a></td>
                                                                <td><input type="button" class="btn btn-primary btn-md" id="addfil" value="Eliminar archivo" align="rigth"></td>
                                                            </tr>
                                                            <tr>
                                                                <td><img src="resources/img/doclogo.jpg" width="20" ><a href="">Marco Teorico</a></td>
                                                                <td><input type="button" class="btn btn-primary btn-md" id="addfil" value="Eliminar archivo" align="right"></td>
                                                            </tr>
                                                        </tbody>                    
                                                    </table>
                                                    <input type="button" class="btn btn-primary btn-md" id="addfil" value="Agregar archivo">
                                                </div>
                                                <div class="span4">
                                                    <div class="modal-header"><br>
                                                        <h3>Agrega un comentario</h3>
                                                    </div>
                                                    <div class="modal-body">
                                                        <textarea id="mitexto" name="mitexto" rows="4" cols="50" ></textarea>
                                                        <br>
                                                        <input type="button" id="enviar" name="enviar"  class="btn btn-primary btn-md" value="Enviar comentario" >
                                                        <input type="button" id="edit" name="edit"  class="btn btn-primary btn-md" value="Editar comentario" >
                                                    </div>
                                                </div>
                                                <div class="span3">
                                                    <div class="modal-header"><br>
                                                        <h3>Descripcion</h3>
                                                    </div>
                                                    <div class="modal-body">
                                                        <text id="mitexto" name="mitexto" rows="4" cols="50" >En esta semana ve avanzando el Marco Teorico</text>
                                                    </div>
                                                </div>
                                                <div class="span3">
                                                    <div class="modal-header">
                                                        <h3>Comentarios Asesor</h3>
                                                    </div>
                                                    <div class="modal-body">
                                                        <text id="mitexto" name="mitexto" rows="4" cols="50" >Buen avance, sigue asi!</text>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div><br><br>
                                </div>


                            </td> 
                        </tr> 
                    </table> 
                </td> 
            </tr> 
        </table> 

    </body>
</html>
