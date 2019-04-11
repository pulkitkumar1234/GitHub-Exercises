function allbadgesapi() {
    $.ajax({
        url: "/badges",
        type: "GET",
        success: function (data) {
            console.log("GET DATA API RESPONSE - ID::"+data.id);
            console.log("GET DATA API RESPONSE - NAME::"+data.name);
        }, error: function (jqXHR, textStatus, errorThrown) {
        }
    });
}

function receivedbadgesapi() {
    $.ajax({
        url: "/getdata",
        type: "GET",
        success: function (data) {
            console.log("GET DATA API RESPONSE - ID::"+data.id);
            console.log("GET DATA API RESPONSE - NAME::"+data.name);
        }, error: function (jqXHR, textStatus, errorThrown) {
        }
    });
}
function sharedbadgesapi() {
    $.ajax({
        url: "/shared",
        type: "GET",
        success: function (data) {
            console.log("GET DATA API RESPONSE - ID::"+data.id);
            console.log("GET DATA API RESPONSE - NAME::"+data.name);
        }, error: function (jqXHR, textStatus, errorThrown) {
        }
    });
}
function badgespointsapi() {
    $.ajax({
        url: "/received",
        type: "GET",
        success: function (data) {
            console.log("GET DATA API RESPONSE - ID::"+data.id);
            console.log("GET DATA API RESPONSE - NAME::"+data.name);
        }, error: function (jqXHR, textStatus, errorThrown) {
        }
    });
}

function redeempointsapi() {
    $.ajax({
        url: "/redeem",
        type: "GET",
        success: function (data) {
            console.log("GET DATA API RESPONSE - ID::"+data.id);
            console.log("GET DATA API RESPONSE - NAME::"+data.name);
        }, error: function (jqXHR, textStatus, errorThrown) {
        }
    });
}

function postDataFromAPI() {

    var modelObj = {
        id: $("#demo_id").val(),
        name: $("#demo_name").val()
    };

    console.log("post data:"+modelObj);

    $.ajax({
        type: "POST",
        url: "/postdata",
        headers: {
            "Content-Type": "application/json"
        },
        data: JSON.stringify(modelObj),
        success: function (data) {
            console.log("POST API RESPONSE::"+data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
        }
    });
}
</script>
</body>
</html>