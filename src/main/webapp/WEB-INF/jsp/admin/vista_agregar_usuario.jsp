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
<div class="row">
	<div class="col-md-offset-2 col-md-8" id="">
    <h3>Agregar Persona</h3>   
    <div class="row"> 
    	<div>
            <div class="espacio col-md-4 col-md-offset-1">Nombre</div>
            <div class="col-md-6"><input class="form-control" type="text" name="nombre" id="nombre" /></div> 
            <div class="col-md-2"></div>  
       </div>
     </div>
     <div class="row"> 
    	<div>
            <div class="espacio col-md-4 col-md-offset-1">Apellidos</div>
            <div class="col-md-6"><input class="form-control" type="text" name="apellidos" id="apellidos" /></div> 
            <div class="col-md-2"></div>  
       </div>
     </div>
     <div class="row"> 
    	<div>
            <div class="espacio col-md-4 col-md-offset-1">Código</div>
            <div class="col-md-6"><input class="form-control" type="text" name="codigo" id="codigo" /></div> 
            <div class="col-md-2"></div>  
       </div>
       
     </div>
     <div class="row"> 
    	<div>
            <div class="espacio col-md-4 col-md-offset-1">Password</div>
            <div class="col-md-6"><input class="form-control" type="text" name="password" id="password" /></div> 
            <div class="col-md-2"></div>  
       </div>
     </div>
     
 
 		<div class="row"> 
            <div>
                <div class="espacio col-md-4 col-md-offset-1">DNI</div>
                <div class="col-md-6"><input class="form-control" type="text" name="dni" id="dni" /></div>
                <div class="col-md-2"></div>  
            </div>
          </div>
        
        <div class="row"> 
        <div>
            <div class="espacio col-md-4 col-md-offset-1">Correo</div>
            <div class="col-md-6"><input class="form-control" type="text" name="correo" id="correo" /></div>
            <div class="col-md-2"></div>  
        </div>
        </div>
        
        <div class="row"> 
            <div>
                <div class="espacio col-md-4 col-md-offset-1">Telefono</div>
                <div class="col-md-6"><textarea class="form-control" name="telefono" id="telefono" ></textarea></div>
                <div class="col-md-2"></div>  
            </div>
        </div>
        
        <div class="row"> 
            <div>
                <div class="espacio col-md-4 col-md-offset-1">Estado</div>
                <div class="col-md-6"><textarea class="form-control" name="estado" id="estado" ></textarea></div>
                <div class="col-md-2"></div>  
            </div>
        </div>
        
         <div class="row"> 
            <div>
                <div class="espacio col-md-4 col-md-offset-1"></div>
                <div class="col-md-6"></div> 
                <div class="col-md-2"><input type="submit" name="guardar" id="guardar" value="Guardar" class="btn btn-default" ></div>  
            </div>
        </div>
        
    </div>
</div>    
  


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    
</body>

  
</html>