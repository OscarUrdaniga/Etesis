<%-- 
    Document   : Editar_matricula
    Created on : 04/11/2015, 08:43:14 PM
    Author     : Marcelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row">
	<div class="col-md-offset-2 col-md-8" id="">
   <h3>Editar Matricula</h3>   
    <div class="row"> 
    	<div>
            <div class="espacio col-md-4 col-md-offset-1">Curso</div>
            <div class="col-md-6"><input class="form-control" type="text" name="curso" id="curso" /></div> 
            <div class="col-md-2"></div>  
       </div>
     </div>
     <div class="row"> 
    	<div>
            <div class="espacio col-md-4 col-md-offset-1">Ciclo</div>
            <div class="col-md-6"><input class="form-control" type="text" name="ciclo" id="ciclo" /></div> 
            <div class="col-md-2"></div>  
       </div>
     </div>
     <div class="row"> 
    	<div>
            <div class="espacio col-md-4 col-md-offset-1">Asesor</div>
            <div class="col-md-6"><input class="form-control" type="text" name="asesor" id="asesor" /></div> 
            <div class="col-md-2"></div>  
       </div>
       
     </div>
     <div class="row"> 
    	<div>
            <div class="espacio col-md-4 col-md-offset-1">Alumno</div>
            <div class="col-md-6"><input class="form-control" type="text" name="alumno" id="alumno" /></div> 
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
    </body>
</html>
