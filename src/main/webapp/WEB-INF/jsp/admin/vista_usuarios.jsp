<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <%@include file="/WEB-INF/jsp/comun/recursos.jsp" %>
       <title>Etesis- listar Personas</title>
        <script>
            $(function(){
                   $('#salir').click(function(){
                       document.location = App.contextPath;
                   });                   
            });
        </script>

    </head>

    <body>
        <%@include file = "/WEB-INF/jsp/comun/cabecera.jsp" %>
<div class="container">
                       
            <div class="panel panel-default">
                
                <div class="panel-heading">Listado de Personas</div>                  
               
                    <table id="example2" class="ALUMNO">
                        <thead>
                            <th>Nombre </th>
                            <th>Apellidos</th>  
                            <th>codigo</th> 
                             <th>contraseña</th> 
                              <th>DNI</th> 
                               <th>Telefono</th> 
                               <th>estado</th> 
                               <th>idRol</th> 
                               <th>ROL</th> 
                            <!--<th>Acciones</th>-->
                        </thead>    
                        <tbody>
                            <c:forEach items="${lstPersonas}" var="p">
                            <tr>
                                <td>${p.nombres}</td>
                                <td>${p.apellidos}</td>
                                <td>${p.codigo}</td>                                
                                <td>${p.password}</td>    
                                <td>${p.dni}</td>    
                                
                                <td>${p.telefono}</td>    
                                <td>${p.estado}</td>  
                                <td>${p.idRol}</td> 
                                <td>${p.ROL}</td>    
<!--                                <td>

                                </td>-->
                            </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                
            </div>
            <div class="col-sm-offset-11">
                <a id="salir" href="javascript:void(0);" class="btn btn-default">Salir</a>
            </div>    
        </div> 

            <script src="js/jQuery-2.1.4.min.js"></script>
  
  
    <!-- DataTables -->
    <script src="js/jquery.dataTables.min.js"></script>
   
    <script src="js/dataTables.bootstrap.min.js"></script>
     <!-- page script -->
    <script>
      $(function () {
        
        $('#example2').DataTable({
          "paging": false,
          "lengthChange": true,
          "searching": true,
          "ordering": false,
          "info": false,
          "autoWidth": true
        });
      });
    </script>
        
        
    </body>
</html>