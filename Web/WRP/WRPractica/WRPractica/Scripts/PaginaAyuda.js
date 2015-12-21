$(document).ready(function () {

    var SanLuis = [{
        'Modulo': 'Facturacion',
        'Formas': [
            { 'nombre': 'forma1' },
            { 'nombre': 'forma2' },
            { 'nombre': 'forma3' }
        ]
    },
    {
        'Modulo': 'Registro',
        'Formas': [
            { 'nombre': 'forma1' },
            { 'nombre': 'forma2' },
            { 'nombre': 'forma3' }
        ]
    },
    {
        'Modulo': 'Tomas',
        'Formas': [
            { 'nombre': 'forma1' },
            { 'nombre': 'forma2' },
            { 'nombre': 'forma3' }
        ]
    }];


    //SanLuis[i].Modulo

    $(SanLuis).each(function (i) {
        $('#menu').append('<li>' + SanLuis[i].Modulo + '</li>')
        $(Modulo).each(function (i) {

        });
    });
    
});

