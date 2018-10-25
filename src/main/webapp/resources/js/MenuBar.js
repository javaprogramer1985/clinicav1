var obj;
$(document).ready(
        function () {

            $.ajax({
                url: '../DatosMenu',
                data: {
                    userName: $('userName').val()
                },
                success: function (responseText) {
                    //$('#contenido').load("home.softwareatumedida");

                    var menuHtml = '';
                    var i;

                    var text = '{ "menus" : ' + responseText + '}';

                    obj = JSON.parse(text);
                    for (i = 0; i < obj.menus.length; i++) {
                        menuHtml = menuHtml + '<a id="' + obj.menus[i].menuCodigo + '"class="mdl-navigation__link ' + obj.menus[i].menuSeleccionado + '"  href="#" onclick=callSourceItem(' + i + ')>' +
                                '<i class="' + obj.menus[i].menuIcon + '" role="presentation" style="margin-left:10px; margin-right:5px"></i>' +
                                 '<span class="mdl-menuitem-text">'+ obj.menus[i].menuNombre +'</span>'
                                 + '</a>';
                    }

                    menuHtml = menuHtml + '<div class="mdl-layout-spacer"></div>' +
                            '<div class="mdl-grid">' +
                            '<ul class="social-network social-circle">' +
                            '<!--li><a href="#" class="icoRss" title="Rss"><i class="fa fa-rss"></i></a></li-->' +
                            '<li><a href="https://www.facebook.com/hmhm1985" target="blank" class="icoFacebook" title="Facebook"><i class="fab fa-facebook-square"></i></a></li>' +
                            '<!--li><a href="#" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li-->' +
                            '<li><a href="https://plus.google.com/+HilarioMartinHerrera" target="blank" class="icoGoogle" title="Google +"><i class="fab fa-google-plus"></i></a></li>' +
                            '<li><a href="https://www.youtube.com/channel/UC5ZvslKTguUF7_ECfqKyW1g?disable_polymer=true" target="blank" class="icoGoogle" title="YouTube"><i class="fab fa-youtube"></i></a></li>' +
                            '</ul>' +
                            '</div>';

                    document.getElementById("menubar").innerHTML = menuHtml;

                    var container = $("#menubar");
                    container.on(
                            'click',
                            'a',
                            function () {
                                $('a').removeClass('mdl-navigation__link--current');
                                $(this).addClass('mdl-navigation__link--current');
                            });
                }
            });

        });

function callSourceItem(itemId)
{
    $('#contenido').load(obj.menus[itemId].menuUrl);
}

