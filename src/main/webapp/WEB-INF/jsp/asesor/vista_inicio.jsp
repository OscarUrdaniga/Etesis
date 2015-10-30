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
	  <div class="col-xs-6">Bienvenido: Angelo Velarde</div>
	  <div class="col-xs-4"></div>
         <div class="col-xs-2" style="text-align:right"><a href="#">Volver</a></div></div>
     
     <div class="row"><br><br>
         <div class="col-xs-4" style="text-align:center"><label>Filtrar por:</label></div>
         <div class="col-xs-2">
	        <select name="menu1" >
              <option>Curso</option>
			  <option>Especialidad</option>
			  <option>Ciclo</option>  
            </select>
             </form></div>
             <div class="col-xs-2">
	        <select name="menu2">
              <option>Tesis 1</option>
			  <option>Tesis 2</option>
            </select>
          </form>
         </div>
             <div class="col-xs-4">
	        <select name="menu2">
              <option>Telecomunicaciones</option>
			  <option>Electronica</option>
            </select>
          </form>
         </div>
    </div></br>
</div>
</div>

<div class="container-fluid" >
<div class ="row">
    <div class="col-xs-8" align ="right">
<table border="">
  <thead>
    <tr>
    <th>Codigo</th>
    <th>Nombre y apellido</th>
    <th>Correo</th>
    <th>Notificaciones</th>
  </tr>
  </thead>
   <tbody>     
    <tr>
    <td align ="center">20043205</td>  
    <td align ="center">Juan Perez Quiñones</td>  
    <td align ="center">a20043205@pucp.edu.pe</td>  
    <td align ="center"><a id="mas"><img src="noti3.png" width="30%"/></a></td>   
    </tr>
    
    <tr>
    <td align ="center">20074011</td>  
    <td align ="center">Carlos Gonzales Prietto</td>  
    <td align ="center">a20074011@pucp.edu.pe</td>  
    <td align ="center"><a id="mas"><img src="noti1.png" width="30%"/></a></td>   
    </tr>
        
    <tr>
    <td align ="center">20061133</td>  
    <td align ="center">Pamela Paredes Maza</td>  
    <td align ="center">a20061133@pucp.edu.pe</td>  
    <td align ="center"><a id="mas"><img src="noti2.png" width="30%"/></a></td>   
    </tr>
        
    <tr>
    <td align ="center">20082442</td>  
    <td align ="center">Gabriela Miranda Díaz</td>  
    <td align ="center">a20082442@pucp.edu.pe</td>  
    <td align ="center"><a id="mas"><img src="noti4.png" width="30%"/></a></td>   
    </tr>
    
    <tr>
    <td align ="center">20090023</td>  
    <td align ="center">Manuel Rojas Rios</td>  
    <td align ="center">a20090023@pucp.edu.pe</td>  
    <td align ="center"><a id="mas"><img src="noti4.png" width="30%"/></a></td>   
    </tr>
    
    </tbody>
    </table>    
    </div>
    <div class="col-xs-4" align="left"><br><br><a id="arriba"><img src="arriba.png" width="10%"/></a>
        <br><a id="arriba"><img src="abajo.png" width="10%"/></a>
    </div>
    </div>
</div>

    </body>
</html>