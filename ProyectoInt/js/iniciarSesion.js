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

        // Evitar el envio del formulario---> quitar más adelante
        const form = document.querySelector("form");
        form.addEventListener('submit', function (e) {
            e.preventDefault();
        });