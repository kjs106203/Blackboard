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
    var uri = "";
    if (addr != null) {
        var params = addr.split("&");
        params.forEach(function (param) {
            if (!param.includes("page")) {
                uri += (param + "&");
            }
        })
    }

    uri = "/?" + uri + "page=" + page;
    console.log(uri);
    window.location.href = uri;
}