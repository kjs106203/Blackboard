$(window).on("load", function() {
    if ($(window).width() > 1280){
        $("body").css("margin-left", "calc(50% - 640px)");
    }
    else {
        $("body").css("margin-left", "0px");
    }
});

$(window).on("resize", function() {
    if ($(window).width() > 1280){
        $("body").css("margin-left", "calc(50% - 640px)");
    }
    else {
        $("body").css("margin-left", "0px");
    }
});


function changePage(page) {
    var addr = window.location.href.split("?")[1];
    var params = addr.split("&");
    var uri = "";
    params.forEach(function (param) {
        if (!param.includes("page")) {
            uri += (param + "&");
        }
    })

    uri = "/?" + uri + "page=" + page;
    window.location.href = uri;
}