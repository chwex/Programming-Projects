$(document).ready(function () {

    //incializar menu
    $('#menu').slicknav({
        prependTo: '#slick'
    });

    $('#menu').remove();
    function showNotificationBar(message, duration, bgColor, txtColor, height) {

        //asignar valores a las variables
        duration = typeof duration !== 'undefined' ? duration : 10000;
        bgColor = typeof bgColor !== 'undefined' ? bgColor : "#E6E600";
        txtColor = typeof txtColor !== 'undefined' ? txtColor : "#1919FF";
        height = typeof height !== 'undefined' ? height : 35;

        //Crear el div de la barra del mensaje si aun no existe
        if ($('#notification-bar').size() == 0) {
            var HTMLmessage = "<div class='notification-message' style='text-align:center; line-height: " + height + "px;'> " +
                message + " <Button id=\"activar\">Activar</Button></div>";

            $('head').after("<div id='notification-bar' style='display:none; width:100%; height:" + height + "px; background-color: " +
                bgColor + "; position: absolute; z-index: 100; color: " + txtColor + ";border-bottom: 1px solid " + txtColor + ";'>" +
                HTMLmessage + "</div> <br class=\"notification-messagebr\"><br class=\"notification-messagebr\">");
        }

        //animar la barra con el mensaje
        $('#notification-bar').slideDown(function () {
            $(".notification-messagebr").slideDown();
            setTimeout(function () {
                $('#notification-bar').slideUp(function () { });
                $('.notification-messagebr').slideUp();
            }, duration);
        });
    }

    //iniciar metodo para activar la barra de mensaje
    showNotificationBar("Activar iconos de ayuda");

    //boton para activar la ayuda
    $('#activar').on('click', function () {
        setTimeout(function () { }, 0);
        $(".ayuda").remove();
        $("#btnLlenar").remove();

        $("input").not('input[value="male"]').after('<img class="masterTooltip" src="Help.png" alt="Mountain View" '
            + '><br class= \"ayuda\">');

        $('#notification-bar').slideUp(function () { });
        $('.notification-messagebr').slideUp();
        $('form').before('<button id="btnLlenar" class="btnLlenar">Llenar Campos</button>');
        $('body').append('<a class="js-open-modal" href="#" data-modal-id="popup">Click aqui para una ayuda mas a fondo.</a>');
        agregarDescripciones();

        $('#btnLlenar').on('click', function () {
            llenarCampos();
        });
        modalPopup();
    });

    //funcion para mostrar el popup modal
    var modalPopup = function () {
        $(function () {
            var appendthis = ("<div class='modal-overlay js-modal-close'></div>");
            $('a[data-modal-id]').click(function (e) {
                e.preventDefault();
                $("body").append(appendthis);
                $(".modal-overlay").fadeTo(500, 0.7);
                $(".js-modalbox").fadeIn(500);
                var modalBox = $(this).attr('data-modal-id');
                $('#' + modalBox).fadeIn($(this).data());
            });
            
            $('.modal-body').append('<form class="modal-ayuda"></form>');
            $('#forma1').clone().appendTo('.modal-ayuda');
            

            $(".js-modal-close, .modal-overlay").click(function () {
                $(".modal-box, .modal-overlay").fadeOut(500, function () {
                    $(".modal-overlay").remove();
                });
            });

            $(window).resize(function () {
                $(".modal-box").css({
                    top: ($(window).height() - $(".modal-box").outerHeight()) / 2,
                    left: ($(window).width() - $(".modal-box").outerWidth()) / 2
                });
            });

            $(window).resize();
        });
    }

    //Metodo para agregar las descripciones de los campos y componentes dento de la forma
    var agregarDescripciones = function () {
        var descNom = 'A este campo se le proporciona el primer y segundo nombre' +
            'de la persona en cuestion';
        var descApe = 'A este campo se le proporciona el primer y segundo apellido' +
            'de la persona en cuestion';
        var descSex = 'Aqui se selecciona el sexo de la persona en cuestion';
        var descDom = 'A este campo se le proporcionará el domicilio de la persona' +
            'en cuestion';

        $('#inpNom').next().attr('title', descDom);
        $('#inpApe').next().attr('title', descApe);
        $('input[value="female"]').next().attr('title', descSex);
        $('#inpDom').next().attr('title', descDom);

        // Tooltip de solo texto
        $('.masterTooltip').hover(function ()
        {
            // Hover al entrar al icono
            var title = $(this).attr('title');
            $(this).data('tipText', title).removeAttr('title');
            $('<p class="tooltip"></p>')
            .text(title)
            .appendTo('body')
            .fadeIn('slow');
        }, function () {

            // Hover al salir del icono
            $(this).attr('title', $(this).data('tipText'));
            $('.tooltip').remove();
        }).mousemove(function (e) {
            var mousex = e.pageX + 20; //Get X coordinates
            var mousey = e.pageY + 10; //Get Y coordinates
            $('.tooltip')
            .css({ top: mousey, left: mousex })
        });
    }

    //metodo para llenar campos mediante ajax
    llenarCampos = function () {
        $.ajax({
            async: true,
            type: 'POST',
            url: 'api/Default/obtenerDefault',
            cache: false,
            dataType: 'json',
            data: JSON.stringify(),
            contentType: 'application/json; charset=utf-8',
            success: function (d) {


                var domicilio = d[0].domicilios[0].Calle + ' ' + d[0].domicilios[0].Numero +
                    ' ' + d[0].domicilios[0].Colonia + ' ' + d[0].domicilios[0].Ciudad;

                $('#inpNom').attr("value", d[0].Nombre);
                $('#inpApe').attr("value", d[0].Apellido);
                if (d[0].Sexo == "male")
                    $('input:radio[name=sex]')[0].checked = true;
                else
                    $('input:radio[name=sex]')[1].checked = true;
                $('#inpDom').attr("value", domicilio);
                ;
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log('Error en la operacion');
            }
        });
    };  
});