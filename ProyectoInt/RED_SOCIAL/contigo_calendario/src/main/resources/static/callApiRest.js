
const emociones = [];
var map = new Map();



$(document).ready(function() {

	$.ajax({
		type: 'GET',
		url: "http://localhost:8080/emociones",
		async: false,
		beforeSend: function() {

		},
		success: function(data) {
			console.log(data.emociones);

			for (var key in data.emociones) {
				for (var keyName in data.emociones[key]) {
					//alert((data.emociones[key])["dia"]);
					//alert((data.emociones[key])["colorEmocion"]);
					//emociones.push((data.emociones[key])[keyName]);
					// map.set(3, 'red');
				}
				map.set((data.emociones[key])["dia"], (data.emociones[key])["colorEmocion"]);
			}
		},
		error: function(xhr) {
			alert("Error occured.please try again");

		},
		complete: function() {

		}

	});

  


});

