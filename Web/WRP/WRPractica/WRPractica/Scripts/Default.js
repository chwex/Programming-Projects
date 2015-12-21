$(document).ready(function () { 

    $('#boton').on("click", function () {
        var a = [1,2,3,-4,-5];
        alert(calculateSums(a));
    });

    $('#map').on("click", function () {
        var a = [1, 2, 3, 4, 5, 6, 7, 8, 9];

       alert(map(a, segunda));
    });

    $('#aggregate').on("click", function () {
        var a = [1, 2, 3, 4, 5, 6, 7, 8, 9];

        alert();
    });

    $('#closure').on('click', function () {
        function foo(x) {
            var tmp = 3;

            function bar(y) {
                alert(x + y + (++tmp)); // will alert 16
            }

            bar(10);
        }

        foo(2);
    });

    $('#practica').on('click', function () {
        var data = { users: [
            {
                firstName: 'Carlos',
                lastName: 'Valdez',
                joined: {
                    month: 'January',
                    day: 13,
                    year: 2012
                }
            },
            {
                firstName : 'Ray',
                lastName: 'Villalobos',
                joined: {
                    month: 'March',
                    day: 23,
                    year: 2002
                }
            }
        ]};

        //recorre el arreglo de objetos hasta los atributos del joined dentro de una lista
        var valores = [];
        var agre = [];
        $.each(data, function (name, value) {
            $.each(this, function () {
                $.each(this, function () { 
                    agre.push(this.month + ' ' + this.day + ' ' + this.year);
                });

                valores.push('<li>'+this.firstName + ' ' + this.lastName + '&ensp;' + agre.pop()+'</li>' );
            });

        });

        //recorre la variable data hasta los nombres
        //var valores = [];
        //$.each(data, function (name, value) {
        //    $.each(this, function () {
        //        valores.push(this.firstName+' '+this.lastName+' '+this.joined +'<br />');
        //    });

        //});

        $('#placeholder').append('<ul>'+valores.join('')+'</ul>');

        //$('#placeholder').text(data.firstName+' '+data.lastName+' '+data.joined);
        //alert(data.firstName);
    });

    calculateSums = function (a) {
        var pos = 0;
        var neg = 0;
        var counter = 0;
        while(counter < a.length){
            if(a[counter] >= 0){
                pos = pos + a[counter];
            }
            else{
                neg = neg + Math.abs(a[counter]);
            }
            counter++;
        }
        return pos >= neg;
    };


    map = function(a,b){ 
        var result = [];
        for (var i = 0; i < a.length; i++) {
            var value = a[i];
            var final = b(value);
            result.push(final);
        }
        return result;
    };

    segunda = function (a) {
        if (a % 2 == 0) {
            return a;
        }
        else {
            a = a + 1;
            return a;
        }
    };

    addTotal = function (currentTotal, newValue) {
        console.log("");
        return currentTotal + newValue;
    };
});