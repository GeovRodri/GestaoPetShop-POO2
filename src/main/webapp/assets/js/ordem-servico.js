var buscarAnimais = function (cliente) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/buscar-animais-cliente/" + cliente,
        success: function (results) {
            $('#selectAnimal').empty();
            var sel = document.getElementById("selectAnimal");

            results.forEach(function (result, index) {
                var opt = document.createElement("option");
                opt.value = result.id;
                opt.text = result.nome;

                sel.add(opt, null);
                if (index === 0) {
                    sel.value = result.id;
                }
            });
        }
    });
};

(function($) {
    "use strict"; // Start of use strict

    var options = {

        url: function(phrase) {
            return "/filtrar-animais-no-Ordem-Servico";
        },

        getValue: function(element) {
            return element.nome;
        },

        ajaxSettings: {
            dataType: "json",
            method: "POST",
            data: {
                dataType: "json"
            }
        },

        preparePostData: function(data) {
            data.cliente = $("#animalInput").val();
            return data;
        },

        requestDelay: 400
    };

    $("#animalInput").easyAutocomplete(options);

})(jQuery); // End of use strict