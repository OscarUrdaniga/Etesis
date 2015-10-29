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
                <input type="button" id="logout" value="cerrar sesion">
             </div>
             
    </div>
        
        <div class="row" >
             <div  id="aviso" class="col-xs-3">
                 25 de septiembre del 2015  
                 ultimo aviso del asesor:
                 
                 
            </div>
            
             <div  id="sem" class="col-xs-9">
                 <h4>Subir archivo</h4> 
          <input class="form-control" placeholder="file://" id="correo" name="correo" />

                
            
                 <br>
            
               
                  <DIV >     <input type="button"  class="btn btn-primary btn-md" id="addfil" value="subir archivo" align=""> 
                  <input type="button" id="addfil"  class="btn btn-primary btn-md" value="eliminar archivo" align="">
                       <br>
                       
                       <br>
  
                      
                      
                 </DIV>
              
        
            </div>
         
        </div>
        
        
      
        
        <div class="row">
            <div  id="aviso"  class="col-xs-3">
                Usuarios y alumnos
                 
                 
            </div>
            
           
        </div>
            
            
        
    </div>
        

    </body>
</html>