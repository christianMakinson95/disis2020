$(document).ready(function(){
function includeHTML() {
  var z, i, elmnt, file, xhttp;
  /* Loop through a collection of all HTML elements: */
  z = document.getElementsByTagName("*");
  for (i = 0; i < z.length; i++) {
    elmnt = z[i];
    /*search for elements with a certain atrribute:*/
    file = elmnt.getAttribute("w3-include-html");
    if (file) {
      /* Make an HTTP request using the attribute value as the file name: */
      xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
          if (this.status == 200) {elmnt.innerHTML = this.responseText;}
          if (this.status == 404) {elmnt.innerHTML = "Page not found.";}
          /* Remove the attribute, and call this function once more: */
          elmnt.removeAttribute("w3-include-html");
          includeHTML();
        }
      }
      xhttp.open("GET", file, true);
      xhttp.send();
      /* Exit the function: */
      return;
    }
  }
}


$('#formulario').submit(function(e){
		const postData = { //creamos un objeto para enviar los datos del formulario
			nombreProducto: $('#nombreProducto').val(), //tomo del campo text name
			descripcion: $('#descripcion').val(), //tomo del campo textarea
			cantidad: $('#cantidad').val(),
			precio: $('#precio').val()
		};

		let url = document.getElementById("formulario").action;
		e.preventDefault();//Evita que se ejecute el comportamiento por defecto, en este caso, submit refresca la página por que ejecuta el metodo post o get, lo evitamos con esto
		
		$.post(url, postData, function(response) { //método abreviado para enviar datos y recibir la respuesta del server
			location.reload(true);
		});
	});

});


	function validar(e){
	var a = document.forms["form"]["nombreProducto"].value;
    var b = document.forms["form"]["descripcion"].value;
    var c = document.forms["form"]["cantidad"].value;
    var d = document.forms["form"]["precio"].value;
    
    
    if (a == null || a == "", b == null || b == "", c == null || c == "", d == null || d == "") {
      alert("Por favor llene todos los campos");
      return false;
    }

}

function calcularTotal(){
	var cantidad = document.getElementById("cantidad").value;
	var precio = document.getElementById("precio").value;

	cantidad = parseFloat(cantidad);
	precio = parseFloat(precio);

	var total = cantidad * precio

	document.getElementById("importeTotal").value = total;
}