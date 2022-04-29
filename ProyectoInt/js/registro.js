/* Prueba de enlace */
console.log ("hola");

/* Función del ojo Hide and Show */
const togglePassword = document.querySelector("#togglePassword");
        const password = document.querySelector("#password");

        togglePassword.addEventListener("click", function (e) {
            // Activar el atributo type
            const type = password.getAttribute("type") === "password" ? "text" : "password";
            password.setAttribute("type", type);

            // Cambiar el Icono
            this.classList.toggle("bi-eye");
        });

/*Evitar el envio del formulario---> quitar más adelante*/
const form = document.querySelector("form");
form.addEventListener('submit', function (e) {
    e.preventDefault();
});

/*Validación mayores de edad*/
let fecha = document.getElementById("dateB").value;
let edad = calcularEdad(fecha);

/* function calcularEdad(fecha) {
    let hoy = new Date();
    let cumpleanos = new Date(fecha);
    let edad = hoy.getFullYear() - cumpleanos.getFullYear();
    let m = hoy.getMonth() - cumpleanos.getMonth();
    let d = hoy.getDay() - cumpleanos.getDay();


    if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
        edad--;
    }

    return edad;
}

let edadMayor = calcularEdad(fecha);
if(edadMayor >= 18){
    alert("Eres mayor de edad :D ");
}else{
    alert("Lo sentimos, debes ser mayor de edad para ingresar a CONTIGO ");
    const form = document.querySelector("form");
        form.addEventListener('submit', function (e) {
            e.preventDefault();
        });
} */

function calcularEdad(fecha) {
    let hoy = new Date();
    let cumpleanos = new Date(fecha);
    let edad = hoy.getFullYear() - cumpleanos.getFullYear();
    let m = hoy.getMonth() - cumpleanos.getMonth();
    if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
        edad--;
    }
    return edad;
}

function ValidarEdad(){
    let edadField = document.getElementById("dateB").value;
    let edad = calcularEdad(edadField);
    if(edad >= 18){
    }else{
        alert("Lo sentimos, debes ser mayor de edad para ingresar a CONTIGO ");
        document.getElementById("dateB").value="";
    }
}