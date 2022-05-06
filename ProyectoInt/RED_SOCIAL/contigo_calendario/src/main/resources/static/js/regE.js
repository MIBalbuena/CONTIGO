console.log("esta conectado el js");
//let fecha = new Date(); fecha del día 
let date = new Date();
//console.log("Toda la cadena del date ="+ date);
let fecha = String(date.getDate()).padStart(2, '0') + '/' + String(date.getMonth() + 1).padStart(2, '0') + '/' + date.getFullYear();
//console.log("Fecha completa ="+fecha);
let dia =String(date.getDate()).padStart(2, '0') ;
//console.log("Dia =" + dia);
var dia1=dia
console.log("día1=",dia1);
const día1=("#S"+dia1);
console.log(typeof(dia1));
console.log(día1);
console.log('#S'+`${dia1}`);

//seleccion de estrella
let SeleccionEstrella=()=> {
    console.log("Entro al cambiar color 1");
    console.log("Dia para acmbiar de color =" + dia);
  Estrella(`#S${dia1}`);
  
    /*  switch(parseInt(dia)){
                       
        
    case 1 :
 //aqui empieza la seleccion de color 
 Estrella();
//aqui termina el selector de color         
    console.log("Primera estrella");
    break;
    
    case 2 :
        Estrella("#S02");
       
    break;
    
    case 3 :Estrella();
    
    break;
    
    case 4 :Estrella();
    
    break;
    
    case 5 :Estrella();
    
    break;
    
    case 6 :Estrella();
    
    break;

    case 7 :Estrella();
    
    break;
    
    
    case 8 :Estrella();
    
    break;
    
    case 9 :Estrella();
    
    break;
    
    case 10 :Estrella();
    
    break;
    
    case 11 :Estrella();
    
    break;
    
    case 12 :Estrella();
    
    break;

    case 13 :Estrella();
    
    break;
    
    
    case 14 :Estrella();
    
    break;
    
    case 15 :Estrella();
    
    break;
    
    case 16 :Estrella();
    
    break;
    
    case 17 :Estrella();
    
    break;
    
    case 18 :Estrella();
    
    break;

    case 19 :Estrella();
    
    break;
    
    
    case 20 :Estrella();
    
    break;
    
    case 21 :Estrella();
    
    break;
    
    case 22 :Estrella();
    
    break;
    
    case 23 :Estrella();
    
    break;
    
    case 24 :Estrella();
    
    break;

    case 25 :Estrella();
    
    break;
    
    
    case 26 :Estrella();
    
    break;
    
    case 27 :Estrella();
    
    break;
    
    case 28 :Estrella();
    
    break;
    
    case 29 :Estrella();
    
    break;
    
    case 30 :
        console.log("Caso 30");
      //return var color1 =document.querySelector('#S30');
    Estrella("#S30");
    
    break;

    case 31 :Estrella();
    
    break;  
}
*/

}
//funcion radio fuera inicio 
function validarRadio(formulario, idEstrella){
    console.log(formulario);
    console.log(idEstrella);
    console.log("estralla coloreada en validar radio");
    //guradando en las variables Ira,Felicidad,etc.. el acceso a formulario,emoción y entrando a su valor, comparandolo con true:. capturo los valores true en las las emociones
    let Ira=(formulario.Emocion[0].checked == true);
    let Felicidad=(formulario.Emocion[1].checked == true);
    let Tristeza=(formulario.Emocion[2].checked == true);
    let Sorpresa=(formulario.Emocion[3].checked == true);
    let Miedo=(formulario.Emocion[4].checked == true);
    let Disgusto=(formulario.Emocion[5].checked == true);
   
        //PRUEBAS 
        //const color1 =document.querySelector('#S30');
        //let color2=document.querySelector(color1) 
        
        let color1 =document.querySelector(idEstrella);
        console.log(color1);
        //let color2=document.querySelector('.fa fa-star yellow-color');
        //FINAL DE PRUEBAS
    //En este switch comparo con un or, cual de ellos es el verdadero para acceder a los casos
    switch (Ira || Felicidad ||Tristeza || Sorpresa || Miedo || Disgusto) {
        case Ira:
        console.log("Emocion rojo")
        color1.classList.add('colorRojo');
           
            
            break;
        case Felicidad:
            let color=document.querySelector('.fa fa-star 30');
            color.classList.add('colorAmarillo');
            console.log("Emocion amarillo");    
            break;
        case Tristeza:
            console.log("Emocion verde");
            break;
        case Sorpresa:
            console.log("Emocion azul");
            break;
        case Miedo:
            console.log("Emocion morado");
            break;
        case Disgusto:
            console.log("Emocion naranja");
            break;

        default:
        window.alert("Selecciona una emoción por favor");
        e.preventDefault();
            break;
    }//switch cierra seleccion

 }

//funcion radio fuera final 


//Funcion autoinvocada (function(){})
//La función Estrella valida el color y lo modifica
function Estrella(idEstrella){
    console.log(idEstrella);

    console.log("estralla coloreada");
    //Crear variable formulario donde accede al primer formulario por eso [0], si hay mas formularios en la pagina se enumeran apartir del 0
    var formulario = document.getElementsByName('formulario')[0],
         elementos = formulario.elements,
         buton = document.getElementById('btn');
         validarRadio(formulario,idEstrella);

         //Funcion validar radio es cuando entra a la ventana modal y selecciona su color, se ejecuta cuando se presiona el sumit guardar 
    
/*      
     validar(e);
    function validar(e){
        validarRadio(e);
        console.log("estralla coloreada en validar radio 2");
    }
*/
    console.log("estralla coloreada en validar radio 3");
         formulario.addEventListener("submit", validar);
}//cierra funcion flecha 