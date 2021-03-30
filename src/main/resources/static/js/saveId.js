$(function () {
    $("#inputId").val(sessionStorage.getItem("id"));
    var checked = (sessionStorage.getItem("checked") === "true");
    $("#chkSaveId").prop("checked", checked);
});

function saveId() {
    var isSaveChecked = $("#chkSaveId").prop("checked");

    if (isSaveChecked) {
        sessionStorage.setItem("id", $("#inputId").val());
        sessionStorage.setItem("checked", $("#chkSaveId").prop("checked"));
    } else {
        sessionStorage.removeItem("id");
        sessionStorage.removeItem("checked");
    }
}