/*obtiene el nombre del contexto de la aplicacion*/
App = {};
App.contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf('/', 1));