/* Prueba de enlace */
console.log ("hola");


/* Hover de icono de apartado Enfoque */
let card = document.getElementById("#Enfoque1");
let icono = document.getElementById("#iconoEnfoque1");

// This handler will be executed only once when the cursor
// moves over the unordered list
card.addEventListener("mouseover",iconoColor)
function iconoColor (){
    icono.target.style.color = "purple";
}