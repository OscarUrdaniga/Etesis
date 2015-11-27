<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etesis - Admin</title>
        <link rel="shortcut icon" href="<spring:url value="/view/img/etesis.png"/>">
        <link rel="stylesheet"
              href='<spring:url value="/resources/css/bootstrap.css"/>' />
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
                                <sec:authorize access="hasRole('ROLE_ADMIN')"> Administrador : </sec:authorize>
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
                            <p>Home Page - Administrador</p>
                        </header>
                    </div>
                </div>
            </div>
        </div> 
        <br>
        <div class="span2">
            <ul class="nav nav-list well">
                <li><a href="<spring:url value='/home.do'/>"><i class="icon-home"></i>Inicio</a></li>
                <li class="active"><a href="#"><i class="icon-chevron-right icon-white"></i>Usuarios</a></li>
            </ul>
        </div>
        <div class="row-fluid" style=" width: 80%; padding:0 10%;">
            <div class="span10"><br>

                <form:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/save_persona" method="post" modelAttribute="usuarioDTO">
                    <h2> Editar Usuario </h2><br><hr>
                    <form:hidden path="idpersona"/>
                    <div class="control-group">
                        <label class="control-label">Nombre</label>
                        <div class="controls">
                            <form:input class="span4" path="nombre" />
                            <form:errors path="nombre" cssStyle="color:red" element="p" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Apellidos</label>
                        <div class="controls">
                            <form:input class="span4" path="apellidos" />
                            <form:errors path="apellidos" cssStyle="color:red" element="p" />
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">Codigo</label>
                        <div class="controls">
                            <form:input class="span4" path="codigo" />
                            <form:errors path="codigo" cssStyle="color:red" element="p" />
                        </div>
                    </div>  

                    <div class="control-group">
                        <label class="control-label">DNI</label>
                        <div class="controls">
                            <form:input class="span4" path="dni" />
                            <form:errors path="dni" cssStyle="color:red" element="p" />
                        </div>
                    </div>    

                    <div class="control-group">
                        <label class="control-label">Correo</label>
                        <div class="controls">
                            <form:input class="span4" path="correo" />
                            <form:errors path="correo" cssStyle="color:red" element="p" /> 
                        </div>
                    </div>   

                    <div class="control-group">
                        <label class="control-label">Telefono</label>
                        <div class="controls">
                            <form:input class="span4" path="telefono" />
                            <form:errors path="telefono" cssStyle="color:red" element="p" />
                        </div>
                    </div>

                    <c:if test="${idrol==3}" >
                        <div class="control-group">
                            <label class="control-label">Asesor</label>
                            <div class="controls">
                                <form:select path="idAsesor" class="span4">
                                    <option value="">Seleccione</option>
                                    <c:forEach items="${lstAsesores}" var="p">
                                        <option value="${p.idpersona}" ${p.idpersona==usuarioDTO.idAsesor?"selected":""}>${p.apellidos}, ${p.nombre}</option>
                                    </c:forEach>
                                </form:select>
                                <form:errors path="asesor" cssStyle="color:red" element="p" />
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${idrol==3}" >
                        <div class="control-group">
                            <label class="control-label">Curso</label>
                            <div class="controls">
                                <form:select path="curso" class="span4">
                                    <option value="">Seleccione</option>
                                    <option value="IEE308">IEE308</option>
                                    <option value="IEE309">IEE309</option>
                                </form:select>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${idrol==3}" >
                        <div class="control-group">
                            <label class="control-label">Ciclo</label>
                            <div class="controls">
                                <form:select path="ciclo" class="span4">
                                    <option value="">Seleccione</option>
                                    <option value="2015-2">2015-2</option>
                                    <option value="2016-1">2016-2</option>
                                </form:select>
                            </div>
                        </div>
                    </c:if>

                    <div class="control-group">
                        <label class="control-label">Estado</label>
                        <div class="controls">
                            <form:select path="estado" class="span4">
                                <option value="">Seleccione</option>
                                <c:forEach items="${lstEstados}" var="p">
                                    <option value="${p}" ${p==usuarioDTO.estado?"selected":""}>${p} </option>
                                </c:forEach>
                            </form:select>
                            <form:errors path="estado" cssStyle="color:red" element="p" />                                    
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">Rol</label>
                        <div class="controls">
                            <form:select path="rol" class="span4">
                                <option value="">Seleccione</option>
                                <c:forEach items="${lstRoles}" var="p">
                                    <option value="${p}" ${p.nombre==usuarioDTO.estado?"selected":""}>${p.nombre} </option>
                                </c:forEach>
                            </form:select>
                            <form:errors path="rol" cssStyle="color:red" element="p" />                                    
                        </div>
                    </div>                                                

                    <div class="control-group">
                        <div class="controls">
                            <a class="btn btn-primary" href="<spring:url value="/admin/listaractivos"/>">Regresar</a>&nbsp;&nbsp;&nbsp;                            
                            <input class="btn btn-success" type="submit" value="Guardar"/>                            
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <%-- Footer --%>             
        <div class="container"  style="padding-top: 50px;"><hr>
            <footer class="footer">
                <p style="text-align: center;">
                    &copy; 2015 Software para Telecomunicaciones 2 - Pontificia Universidad Católica del Perú<br> 
                    Comentarios y/o sugerencias: <a href="etesis0891@pucp.pe">etesis0891@pucp.pe</a></p>

            </footer></div>
    </body>
</html>
