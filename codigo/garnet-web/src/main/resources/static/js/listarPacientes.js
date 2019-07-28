$(document).ready(function(){
    listarPacientes();
})

function listarPacientes(){
    $.ajax({
        url: 'http://localhost:8080/paciente/listarTodos',
        type: "GET",
        success: function(data){
            console.log("SE REALIZO BIEN EL CONSUMO" + data);
        },
        error: function(){
            console.log("EROR AL CONSUMIR EL SERVICIO");
        }
    })
}