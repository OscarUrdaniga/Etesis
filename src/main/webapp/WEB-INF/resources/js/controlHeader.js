/*permite el retorno a la pagina de inicio al dar click en el nombre de la aplicacion*/


$(function(){
    
    $('.cabecera h1').click(function(){
       document.location = App.contextPath; 
    });
});