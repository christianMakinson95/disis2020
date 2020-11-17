function validateForm() {
  var x = document.forms["crearCateg"]["descripcion"].value;
  var table = document.getElementById('tabcat');
  var y;
  if (x == "" || x == null) {
    alert("No se puede crear una categoría vacía");
    return false;
  }

   for (var r = 0, n = table.rows.length; r < n; r++) {
              y = table.rows[r].cells[0].innerText;
              if (x == y){
              alert("La categoría ya existe");
              return false;
              }
          }
   }



let cerrar = document.querySelectorAll(".close")[0];
let cerrar2 = document.querySelectorAll(".close2")[0];
let abrir = document.querySelectorAll(".cta")[0];
let modal = document.querySelectorAll(".modal")[0];
let modalC = document.querySelectorAll(".modal-container")[0];
let eliminar = document.querySelectorAll(".ct2")[0];

abrir.addEventListener("click", function(e){
    e.preventDefault();
    modalC.style.opacity = "1";
    modalC.style.visibility = "visible";
    modal.classList.toggle("modal-close");
});

cerrar.addEventListener("click", function(){
    modal.classList.toggle("modal-close");
        setTimeout(function(){
                modalC.style.opacity = "0";
                modalC.style.visibility = "hidden";
            },600)

})

cerrar2.addEventListener("click", function(){
    modal.classList.toggle("modal-close");
        setTimeout(function(){
                modalC.style.opacity = "0";
                modalC.style.visibility = "hidden";
            },600)

})

window.addEventListener("click", function(e){
    this.console.log(e.target)
    if(e.target == modalC){
        modal.classList.toggle("modal-close");
            setTimeout(function(){
                    modalC.style.opacity = "0";
                    modalC.style.visibility = "hidden";
                },600)
    }
})


function eliminarCategoria(){
    var desc = document.getElementById("u26_input").value;
    // verificarCriterio(desc);
    $.ajax({
        type: "DELETE",
        url: "crear_categoria/"+desc,
        success: function(result){
            location.reload(true);
        }
    });
}


ct2.addEventListener("click", function(){
    eliminarCategoria();
})


function verificarCriterio(desc){
    var criterioSeleccionado = document.getElementById("crits").value;
        // si el id de la desc de la categoria está
        // en el criterio>categoriaID entonces t0do bien (?)

}

function validarCrit(){
     var criterioSeleccionado = document.getElementById("crits").value;
     // BUSCAR criterioSeleccionado en BD criterios.criterio
     // TOMAR dato criterios.id_categoria del criterio encontrado
     // COMPARAR id_categoria con id_categoria de las categorias de la lista de bd de categorias
     // ????????????????????????????????????? no entiendo que poronga hacer
}