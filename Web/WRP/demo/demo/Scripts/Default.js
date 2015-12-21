$(document).ready(function () {

    //JSON
    c1 = {
        contactName: "William Jones",
        phoneNumber: "555-2941",
        emailAddress: "william@testing.com",
        company: {
            code: 123,
            name: "ABC Incorporated"
        },
        notes: null,
        lastContacted: new Date()
    }

    o = {
        studentName: 'Wiliam Jones',
        school: 'Middletown High School',
        grades: [
            {
                subject: 'English',
                grade: 'A'
            },
            {
                subject: 'Algebra',
                grade: 'B+'
            },
            {
                subject: 'Geomety',
                grade: 'C'
            },
        ]
    }

    $("#hello").hover(function () {
        $(this).css("font-size", "200%");
    }, function () {
        $(this).css("font-size", "initial");
    });

    $('#btndemo').on("click", function () {
        $('#test').html("");
        var currentAjax = $.ajax({
            async: true,
            type: 'POST',
            url: 'api/Default/ObtenerLista',
            cache: false, 
            dataType: 'json',
            data: JSON.stringify({ Total:9}),
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

    $('#btnGet').on("click", function () {
        $('.txttest').html("");
        var currentAjax = $.ajax({
            async: true,
            type: 'POST',
            url: 'api/Default/GetInfo',
            cache: false,
            dataType: 'json',
            data: JSON.stringify({Total:3}),
            contentType: 'application/json; charset=utf-8',
            success: function (d) {
                $(d).each(function (item) { 
                    $('#par').append('</br><input class="txttest" type="text" id="Text' + d[item].ID + '" value="' + d[item].Demo + '"><span title = "ID del nombre: ' + d[item].ID+'">.</input>')
                });
            },
            error: function (d) {
                alert(JSON.stringify(d));
            }
        });
    });

    String.prototype.format = String.prototype.f = function () {
        var s = this,
            i = arguments.length;

        while (i--) {
            s = s.replace(new RegExp('\\{' + i + '\\}', 'gm'), arguments[i]);
        }
        return s;
    };

    $('#Guardar').on("click", function () {
        var o = ObtenerValores();
        var s = {};
        s.Lista = o;

        var currentAjax = $.ajax({
            async: true,
            type: 'POST',
            url: 'api/Default/GuardarLista',
            cache: false,
            dataType: 'json',
            data: JSON.stringify(s),
            contentType: 'application/json; charset=utf-8',
            success: function (d) {
                alert(d);

                //('<input class="txttest" type="text"  />');
                ////$('.txttest').val(d.Demo);
                //alert(JSON.stringify(d));
            },
            error: function (d) {
                alert(JSON.stringify(d));
            }
        });
    });

    $('#Mensaje').on("click", function () {
        var btn = $("button");
        btn.prop("disabled", true);
        btn.pro
        var o = ObtenerValores();
        var s = {};
        s.Lista = o;

        var currentAjax = $.ajax({
            async: true,
            type: 'POST',
            url: 'api/Default/Mensaje',
            cache: false,
            dataType: 'json',
            data: JSON.stringify(s),
            contentType: 'application/json; charset=utf-8',
            success: function (d) {
                //var palabra = Reverse('hello');
                //alert(palabra);

                //var suma = Suma(1, 2, 3, 4, 5);
                //alert(suma);

                //var o = s1.getFullName();
                //s1.increasePay(10);
                //var salary = s1.salary;
                //alert(salary);

                //var o = s2.getFullName();
                //s2.increasePay(20);
                //var salario = s2.salary;
                //alert(salario);

                //JSON
                //var contactString = JSON.stringify(c1);
                //var fecha = new Date().toJSON();

                var str = clone(o);
                var nombre = str.studentName;
                var escuela = str.school;
                alert(nombre+' '+escuela);

                btn.prop("disabled", false);
                //('<input class="txttest" type="text"  />');
                ////$('.txttest').val(d.Demo);
                //alert(JSON.stringify(d));
            },
            error: function (d) {
                alert(JSON.stringify(d));
            }
        });
    });

    $('#Generar').on("click", function () {
        $('#test').html("");
        var currentAjax = $.ajax({
            async: true,
            type: 'POST',
            url: 'api/Default/Generar',
            cache: false,
            dataType: 'json',
            data: JSON.stringify({ Total: 9 }),
            contentType: 'application/json; charset=utf-8',
            success: function (d) {

                $(d).each(function (item) {
                    $('#test').append('<br/><label>Empleado #' + d[item].ID + ' </label><input id="' + d[item].ID + '" type="text" class="Item"  value="' + d[item].Demo + '" /><br/><br/>');
                });
            },

            error: function (d) {
                alert(JSON.stringify(d));
            }
        });
    });

    $('#northwind').on("click", function () {
        $('#test').html("");
        var currentAjax = $.ajax({
            async: true,
            type: 'GET',
            url: 'api/Default/Northwind',
            cache: false,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: function (d) {
                var numero = 1;
                var str = JSON.stringify(d, null, 4);
                alert(str);
                $(d).each(function (item) {
                    $('#test').append('<br><label>Empleado # ' + (numero++) + ' ' + d[item].FirstName +' '+ d[item].LastName+ ' '+d[item].EmployeeID+'</label>');
                });
            },

            error: function (d) {
                alert(JSON.stringify(d));
            }
        });
    });

    //Prototipos
    staffPrototype = {
        increasePay: function (percentage) {
            this.salary = this.salary+((this.salary*percentage)/100)
        },
        getFullName: function () {
            return this.firstName + ' ' + this.lastName + ' (' + this.profession + ')';
        }
    }

    function extend(obj) {
        function T() { };
        T.prototype = obj;
        return new T();
    }


    //Objetos
    s1 = extend(staffPrototype);
    s1.firstName = 'Morgan';
    s1.lastName = 'Thomas';
    s1.salary = 50000;
    s1.profession = 'Graphic Designer';

    s2 = extend(staffPrototype);
    s2.firstName = "Carlos";
    s2.lastName = "Valdez";
    s2.salary = 30000;
    s2.profession = "Programmer";


    //Funciones
    ObtenerValores = function () {
        var a = new Array();
        $('.Item').each(function () {
            var e = {};
            e.ID = $(this).id;
            e.Demo = $(this).val();
            a.push(e);
        });
        return a;
    };

    Reverse = function (str) {
        if (typeof (str) == 'string') {
            var resultado = '';
            var contador = 0;
            while (contador < str.length) {
                resultado = resultado + (str.charAt(str.length - contador - 1));
                contador++;
            }
            return resultado;
        }
        else {
            throw 'La parabra tiene que ser de tipo string';
        }
    };

    Suma = function () {
        var resultado = 0;
        for (var i = 0; i < arguments.length; i++) {
            resultado = resultado + arguments[i];
        }
        return resultado;
    };

    map = function (a, func) {
        var b = [];
        for (var i = 0; i < a.length; i++) {

        }
    };

    clone = function (obj) {
        var str = JSON.stringify(obj);
        var nStr = JSON.parse(str);
        nStr.studentName = 'Carlos'
        nStr.school = o.school;
        return nStr;
    };

});
