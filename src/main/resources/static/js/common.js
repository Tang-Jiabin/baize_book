function setCookies(cookieName, cookieValue, minutes) {
    let today = new Date();
    let expire = new Date();
    let exp = minutes * 1000 * 60 || 1000 * 3600 * 24 * 365;
    expire.setTime(today.getTime() + exp);
    document.cookie = cookieName + '=' + escape(cookieValue) + ';expires=' + expire.toGMTString() + '; path=/'
}

function readCookies(cookieName) {
    let theCookie = '' + document.cookie;
    let ind = theCookie.indexOf(cookieName);
    if (ind == -1 || cookieName === '') return '';
    let ind1 = theCookie.indexOf(';', ind);
    if (ind1 == -1) ind1 = theCookie.length;
    let rico_ret = theCookie.substring(ind + cookieName.length + 1, ind1).replace(/%/g, '%25');
    return unescape(decodeURI(rico_ret))
}

if (readCookies('ss_userid') && readCookies('PHPSESSID') != -1) {
    $("#header-login").html("<li><a href='/bookcase/' title='我的书架'>会员书架</a></li><li><a href='/logout/' title='退出登录'>退出</a></li>")
} else {
    $("#header-login").html("<li><a href='/login/'>登录</a></li><li><a href='/register/'>注册</a></li>")
}

function ReadKeyEvent() {
    var index_page = $("#linkIndex").attr("href");
    var prev_page = $("#linkPrev").attr("href");
    var next_page = $("#linkNext").attr("href");

    function jumpPage() {
        var event = document.all ? window.event : arguments[0];
        if (event.keyCode == 37) document.location = prev_page;
        if (event.keyCode == 39) document.location = next_page;
        if (event.keyCode == 13) document.location = index_page
    }

    document.onkeydown = jumpPage
}

function is_mobile() {
    var regex_match = /(nokia|iphone|android|motorola|^mot-|softbank|foma|docomo|kddi|up.browser|up.link|htc|dopod|blazer|netfront|helio|hosin|huawei|novarra|CoolPad|webos|techfaith|palmsource|blackberry|alcatel|amoi|ktouch|nexian|samsung|^sam-|s[cg]h|^lge|ericsson|philips|sagem|wellcom|bunjalloo|maui|symbian|smartphone|midp|wap|phone|windows ce|iemobile|^spice|^bird|^zte-|longcos|pantech|gionee|^sie-|portalmmm|jigs browser|hiptop|^benq|haier|^lct|operas*mobi|opera*mini|320x320|240x320|176x220)/i;
    var u = navigator.userAgent;
    if (null === u) {
        return true
    }
    var result = regex_match.exec(u);
    if (null === result) {
        return false
    } else {
        return true
    }
}

function go_page(url) {
    window.location.href = url;
    $(this).href = url;
    return false
}

$("#back-to-top").css({right: 10, bottom: "10%"});
var isie6 = window.XMLHttpRequest ? false : true;

function newtoponload() {
    var c = $("#back-to-top");

    function b() {
        var a = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
        if (a > 100) {
            if (isie6) {
                c.hide();
                clearTimeout(window.show);
                window.show = setTimeout(function () {
                    var d = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
                    if (d > 0) {
                        c.fadeIn(100)
                    }
                }, 300)
            } else {
                c.fadeIn(100)
            }
        } else {
            c.fadeOut(100)
        }
    }

    if (isie6) {
        c.style.position = "absolute"
    }
    window.onscroll = b;
    b()
}

if (window.attachEvent) {
    window.attachEvent("onload", newtoponload)
} else {
    window.addEventListener("load", newtoponload, false)
}
document.getElementById("back-to-top").onclick = function () {
    window.scrollTo(0, 0)
}