$(document).ready(function(){
    $(function () {
        $("#receiverName").autocomplete({
            source:"/usernameautocomplete",
            minLenght: 3
        });
    });
});