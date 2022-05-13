var grocerias = ["suicidio",
    "depresión",
    "desesperanza",
    "crisis",
    "quisiera estar muerto",
    "drogas",
    "duelo",
    "odio la vida",
    "nada mejorará"]

function filtro(){  
    var nodo = document.getElementById("post").elements["texto"]
    var textarea = nodo.value;
    for(var i = 0; i < grocerias.length;i++){
        regex = new RegExp("(^|\\s)"+grocerias[i]+"($|(?=\\s))","gi")
        textarea = textarea.replace(regex, function($0, $1){return $1 + "gatito"});
    }
    nodo.value = textarea;
    console.log(textarea);
}