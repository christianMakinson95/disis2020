console.log("Jscript funcionando")

function validar(e){
	var a = document.forms["form"]["identificadorDoc"].value;
    var b = document.forms["form"]["importeDoc"].value;
    var c = document.forms["form"]["detalle"].value;
    var d = document.forms["form"]["fechaEmision"].value;
    var e = document.forms["form"]["medio"].value;
    var f = document.forms["form"]["identificador"].value;
    
    if (a == null || a == "", b == null || b == "", c == null || c == "", d == null || d == "", e == "Seleccione Medio de Pago...", f == null || f == "") {
      alert("Por favor llene todos los campos");
      return false;
    }
 
}