$(document).ready(function () {
    $("tr #btnDelete").click(function () {
        var id = $(this).parent().find("#id").val();
        swal({
            title: "Está seguro de eliminar el producto?",
            text: "Una vez eliminado, no se podrá deshacer!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(id);
                swal("El producto ha sido eliminado!", {
                    icon: "success",
                }).then((willDelete) => {
                    if (willDelete) {
                        parent.location.href = "ControladorCU?action=Carrito";
                    }
                });
            } else {
                swal("Producto no eliminado! :(");
            }
        });

    });
    function eliminar(id) {
        var url = "ControladorCU?action=Borrar";
        $.ajax({
            type: 'POST',
            url: url,
            data: "id=" + id,
            success: function (data, textStatus, jqXHR) {
            }
        });
    }

    $("tr #cantidad").click(function () {
        var id = $(this).parent().find("#idp").val();
        var cantidad = $(this).parent().find("#cantidad").val();
        var url = "ControladorCU?action=ActualizarCant";
        $.ajax({
            type: 'POST',
            url: url,
            data: "id=" + id + "&cantidad=" + cantidad,
            sucess: function (data, textStatus, jqXHR){
                location.href="ControladorCC?action=Carrito";
            }
        });
    });
});
