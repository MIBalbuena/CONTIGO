var grocerias = ["suicidio",
    "depresión",
    "depresion",
    "Cortar me",
    "desesperanza",
    "muerete",
    "crisis",
    "quisiera estar muerto",
    "drogas",
    "droga",
    "duelo",
    "odio la vida",
    "nada mejorará"]

function filtro(){  
    var nodo = document.getElementById("post").elements["input-diary"]
    var textarea = nodo.value;
    for(var i = 0; i < grocerias.length;i++){
        regex = new RegExp("(^|\\s)"+grocerias[i]+"($|(?=\\s))","gi")
        textarea = textarea.replace(regex, function(_$0, $1){return $1 + "gatito"});
    }
    nodo.value = textarea;
    console.log(textarea);
}