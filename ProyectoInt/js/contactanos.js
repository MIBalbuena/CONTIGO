/* Prueba de enlace */
console.log ("hola");

/* Validación teléfono */
const $input = document.querySelector("#InputPhone");

$input.addEventListener("keyup",()=>{
    if($input.value.length >=12){
        console.log($input.value.slice(0,12))
        $input.value = $input.value.slice(0,12)
    }
})