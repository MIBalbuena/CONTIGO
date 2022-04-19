console.log("esta conectado el js");
let nEmo="";
//Funcion cambio de color a la estrella 
let CambioColorStrella = ()=>{
    //variable donde guardo numero de emoción
    let nEmo = document.getElementById("Ira").value
console.log(nEmo);
    //document.getElementById("nombre").innerHTML = "Hola " + nuevoNombre;
}

function verificarEmocion(){
    if(document.getElementById('Ira').checked){
        document.getElementById('1').style.color="red";
    }else if (document.getElementById('Felicidad').checked){

    }else if(document.getElementById('Tristeza').checked){

    }else if (document.getElementById('Sorpresa').checked){
        
    }else if(document.getElementById('Miedo').checked){

    }else if (document.getElementById('Disgusto').checked){
        
    }
}
