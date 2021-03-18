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