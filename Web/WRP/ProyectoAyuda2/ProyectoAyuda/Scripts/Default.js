$(document).ready(function () 
{
    //Prueba JSON

     datosPrueba = {
        IDExtension: 1,
        descExtension: "Descripcion de la extension",
        IDNegocio: 5,
        descNegocio: "Informacion del negocio",
        IDModulo: 2,
        descModulo: "Descripcion del modulo",
        IDForma: 1,
        descForma: "Descripcion de la forma",
        iconoForma: "URL del icono dentro del proyecto",
        extraForma: "Algun screenshot o informacion de la forma",
        identificadorURL: "URL de la forma",
        IDComponente: 4,
        descComponente: "descripcion del componente",
        iconoComponente: "URL del icono",
        extraComponente: "Descripcion extra del componente"
     }

     datosPrueba = JSON.stringify(datosPrueba);

     $('#listas').on("click", function () {
         $('#test').html("");
         var currentAjax = $.ajax({
             async: true,
             type: 'POST',
             url: 'api/Default/AgregarLista',
             cache: false,
             dataType: 'json',
             data: JSON.stringify({ Total: 9 }),
             contentType: 'application/json; charset=utf-8',
             success: function (d) {
                 $(d).each(function (item) {
                     $('#test').append('<br/><label>Empleado #' + d[item].ID + ' </label><input id="' + d[item].ID + '" type="text" class="Item"  value="' + d[item].Demo + '" /><br/><br/>');
                 });

                 //('<input class="txttest" type="text"  />');
                 ////$('.txttest').val(d.Demo);
                 //alert(JSON.stringify(d));
             },
             error: function (d) {
                 alert(JSON.stringify(d));
             }
         });
     });

});