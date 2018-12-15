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