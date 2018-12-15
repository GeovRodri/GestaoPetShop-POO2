(function($) {
    "use strict"; // Start of use strict

    var options = {

        url: function(phrase) {
            return "/filtrar-clientes";
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
            data.cliente = $("#clienteInput").val();
            return data;
        },

        requestDelay: 400
    };

    $("#clienteInput").easyAutocomplete(options);

})(jQuery); // End of use strict