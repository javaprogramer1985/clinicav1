var obj;
$(document).ready(
        function () {

            $('#contenido').load("home.softwareatumedida");
            
            var datamenu = document.getElementById("data").innerHTML;
            var menuHtml = '';
            var i;

            var text = '{ "menus" : ' + datamenu + '}';

            obj = JSON.parse(text);
            for (i = 0; i < obj.menus.length; i++) {
                menuHtml = menuHtml + '<a id="' + obj.menus[i].menuCodigo + '"class="mdl-navigation__link ' + obj.menus[i].menuSeleccionado + '"  href="#" onclick=callSourceItem(' + i + ')>' +               
                        '<i class="'+obj.menus[i].menuIcon+'" role="presentation"></i>' +
                        obj.menus[i].menuNombre + '</a>';
            }

            menuHtml = menuHtml + '<div class="mdl-layout-spacer"></div>' +
                    '<div class="mdl-grid">' +
                    '<ul class="social-network social-circle">' +
                    '<!--li><a href="#" class="icoRss" title="Rss"><i class="fa fa-rss"></i></a></li-->' +
                    '<li><a href="https://www.facebook.com/hmhm1985" target="blank" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>' +
                    '<!--li><a href="#" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li-->' +
                    '<li><a href="https://plus.google.com/+HilarioMartinHerrera" target="blank" class="icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>' +
                    '<li><a href="https://www.youtube.com/channel/UC5ZvslKTguUF7_ECfqKyW1g?disable_polymer=true" target="blank" class="icoLinkedin" title="YouTube"><i class="fa fa-youtube"></i></a></li>' +
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
        });

function callSourceItem(itemId)
{      
    $('#contenido').load(obj.menus[itemId].menuUrl);
}

