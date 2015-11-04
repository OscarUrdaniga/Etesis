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
          <div   class="container-fluid">
         <div  class="row">
            <div class="col-xs-6" ALIGN=left >
              <h1 id="logo"><img src="img/e-tesis.png"  height="100" width="250"></h1>
                
             
            </div>
             <div class="col-xs-6" ALIGN=right >
                 <br>
                  <br>bienvenido
                  <br>Carlos Rubin de Celis
                  <br>
                <br>
                <input type="button" class="btn btn-primary btn-md" id="logout" value="cerrar sesion">
             </div>
             
    </div>
 

    </head>

    <body>
        <%@include file = "/WEB-INF/jsp/comun/cabecera.jsp" %>

        <div   class="container-fluid">
         <div  class="row">
            <div class="col-xs-6" ALIGN=left >
              <h1 id="logo"><img src="img/e-tesis.png"  height="100" width="250"></h1>
                
             
            </div>
             <div class="col-xs-6" ALIGN=right >
                 <br>
                  <br>bienvenido
                  <br>Carlos Rubin de Celis
                  <br>
                <br>
                <input type="button" class="btn btn-primary btn-md" id="logout" value="cerrar sesion">
             </div>
             
    </div>
        
        <div  class="row" >
             <div  id="aviso" class="col-xs-3">
                 25 de septiembre del 2015  
                 ultimo aviso del asesor:
                 <br>
                 <br>
                 <br>
                 
            </div>
            
             <!-- aqui empiezan las semanas -->
             <div id="sem" class="col-xs-9">
                <h3>17 de agosto - 23 de agosto </h3> 
                   <img src="img/icon.png"  >
                <a href=paperss1.html>papers</a>
                
            
                 <br>
                  <input type="checkbox" name="tesis" value="1">
                   <img src="img/doclogo.png" width="20" >
                
                
                 <a href=img/TESIS.docx>tesis.docx</a> 
                 <DIV ALIGN=right>
                     <input type="button" class="btn btn-primary btn-md" id="addfil" value="sube archivo" >
                  <input type="button" class="btn btn-primary btn-md" id="addfil" value="eliminar archivo" align="right">
                 </DIV>
                 <!-- comentarios -->
                    Agrega un comentario:<br>
                 <br>
                 <textarea id="mitexto" name="mitexto" rows="4" cols="50" ></textarea>
                                  <br>
                 <input type="button" id="enviar" name="enviar"  class="btn btn-primary btn-md" value="enviar comentario" >
                  <input type="button" id="edit" name="edit"  class="btn btn-primary btn-md" value="editar comentario" >
                 <br>
                 <br>
                 
            
            </div>
         
        </div>
        
        
            <div id="aviso" class="col-xs-3">
                Usuarios y alumnos
                     <br>
                 <br>
                 <br>             

                 
            </div>
            
             <div id="sem" class="col-xs-9">
                <h3> 24 de agosto - 30 de agosto</h3> 
                 <br> 
                 <img src="img/icon.png"  ><a href=paperss2.html>papers</a>
                 <br> 
                 <img src="img/icon.png"  ><a href=present.html>primera presentacion</a>
                 <br>
                  <input type="checkbox" name="tesis" value="1">
                 <img src="img/doclogo.png" width="20" >
                <a href=img/TESIS.docx>tesis_primeravance.docx</a>
                   <br>
                   <DIV ALIGN=right>
                     <input type="button" class="btn btn-primary btn-md" id="addfil" value="sube archivo" >
                  <input type="button" class="btn btn-primary btn-md" id="addfil" value="eliminar archivo" align="right">
                 </DIV>
                 
                 
                 
                     <!-- comentarios -->
                          Agrega un comentario:<br>
                 <br>
                 <textarea id="mitexto" name="mitexto" rows="4" cols="50" ></textarea>
                                  <br>
                 <input type="button" id="enviar" name="enviar"  class="btn btn-primary btn-md" value="enviar comentario" >
                  <input type="button" id="edit" name="edit"  class="btn btn-primary btn-md" value="editar comentario" >
                 <br>
                 <br>
                 
        

            </div>
             
            
        </div>
            
        <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3> 31 de agosto - 6 de septiembre</h3> 
            
            </div>
            
        </div>
        
             <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3> 7 de septiembre - 13 de septiembre</h3> 
            
            </div>
            
        </div>
        
        <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>14 de septiembre - 20 de septiembre</h3> 
            
            </div>
            
        </div>
              <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>21 de septiembre - 27 de septiembre</h3> 
            
            </div>
            
        </div>
            
          <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>28 de septiembre - 4 de octubre</h3> 
            
            </div>
            
        </div>
 <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>28 de septiembre - 4 de octubre</h3> 
            
            </div>
            
        </div>
        
         <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>5 de octubre - 11 de octubre</h3> 
            
            </div>
            
        </div>
        
          <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>12 de octubre - 18 de octubre</h3> 
            
            </div>
            
        </div>
        
          <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>19 de octubre - 25 de octubre</h3> 
            
            </div>
            
        </div>
        
         <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>26 de octubre - 1 de noviembre</h3> 
            
            </div>
            
        </div>
         <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>2 de noviembre - 8 de noviembre</h3> 
            
            </div>
            
        </div>
         <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>9 de noviembre - 15 de noviembre</h3> 
            
            </div>
            
        </div>
        
        <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>16 de noviembre - 22 de noviembre</h3> 
            
            </div>
            
        </div>
        
        <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>23 de noviembre - 29 de noviembre</h3> 
            
            </div>
            
        </div>
        
         <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>30 de noviembre - 6 de diciembre </h3> 
            
            </div>
            
        </div>
        
         <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>7 de diciembre - 13 de diciembre</h3> 
            
            </div>
            
        </div>
        
        
         <div class="row">
             <div  class="col-xs-3">
                 
            </div>
            <div id="sem" class="col-xs-9">
            <h3>14 de diciembre - 20 de diciembre</h3> 
            
            </div>
            
        </div>
        
        
         
            
        </div>

    </body>
</html>
