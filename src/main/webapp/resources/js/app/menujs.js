$(document).ready(function () {
            $("button").click(function (event) {
                event.preventDefault();                
                $.ajax({
                 url : '../MenuServlet',
                 success : function(result){
                     $("#respuesta").html(result);
                 },
                 error : function(){
                     
                   alert("error");  
                 }
                });
            });            
        });