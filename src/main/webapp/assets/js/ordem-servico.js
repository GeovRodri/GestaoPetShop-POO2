(function($) {
    "use strict"; // Start of use strict
    document.getElementById('datePicker').valueAsDate=new Date();

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
            data.cliente = $("#clienteInput").val();
            data.animal = $("#animalInput").val();
            return data;
        },

        requestDelay: 400
    };

    $("#animalInput").easyAutocomplete(options);

    var optionsClientes = {

        url: function(phrase) {
            return "/filtrar-clientes-no-Ordem-Servico";
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

    $("#clienteInput").easyAutocomplete(optionsClientes);

})(jQuery); // End of use strict