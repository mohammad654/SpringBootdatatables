var api = "http://localhost:8080/api/reservation" ;
var reservationTable;

function init(){

    console.log('inside init' );

    // Add click event to button
    $("#create-reservation").click(function (){
        createReservation();
    });

    initReservationTable();
    // Get reservations from backend and and update table
    getReservationData();

}

function initReservationTable() {

    console.log('inside initReservationTable' );

    // Create columns (with titles) for datatable: id, name, address, age
    columns = [
        { "title":  "Reservation ID",
            "data": "id",
            "visible": false },
        { "title":  "Date",
            "data": "date" },  // 2022-06-08T08:09:18.922
        { "title":  "Room ID",
            "data": "roomId" },
        { "title":  "Table ID",
            "data": "tableId" },
        { "title": "Seaview",
            "data": "seaView",
            "render": function(seaView) {
                if (seaView == true) {
                    return "with sea view"
                } else {
                    return "without sea view"
                }
            }},
        { "title": "Seaview",
            "data": "seaView",
            "render": function(seaView) {
                return seaViewRenderer(seaView);
            }}
    ];

    function seaViewRenderer( seaView){
        if (seaView == true) {
            return "with sea view"
        } else {
            return "without sea view"
        }
    }


    // Define new table with above columns
    reservationTable = $("#reservationTable").DataTable( {
        "order": [[ 0, "asc" ]],

        "columns": columns
    });

    getReservationData();

}

function getReservationData(){

    console.log('inside getReservationData' );
    // http:/localhost:9090/api/reservation
    // json list of reservations
    $.ajax({
        url: api,
        type: "get",
        dataType: "json",
        // success: function(reservations, textStatus, jqXHR){
        success: function(reservations){

            console.log('Data: ' + reservations );

            if (reservations) {
                reservationTable.clear();
                reservationTable.rows.add(reservations);
                reservationTable.columns.adjust().draw();
            }
        },

        fail: function (error) {
            console.log('Error: ' + error);
        }

    });

}

function createReservation(){

    console.log('inside createReservation' );

    // Put reservation data from page in Javascript object --- SIMILAR TO JSON
    var reservationData = {
            id: $("#id").val(),
            date: $("#date").val(),
            tableId: $("#tableid").val(),
            roomId: $("#roomid").val(),
            seaView: $("#seaview").val()
    }

    // Transform Javascript object to json
    var reservationJson = JSON.stringify(reservationData);

    console.log(reservationJson);

    $.ajax({
        url: api,
        type: "post",
        data: reservationJson,    // json for request body
        contentType:"application/json; charset=utf-8",   // What we send to frontend
        dataType: "json",  // get back from frontend
        // success: function(reservation, textStatus, jqXHR){
        success: function(reservation){

          console.log(reservation);

          // Clear fields in page
          $("#id").val('');
          $("#date").val('');
          $("#tableid").val('');
          $("#roomid").val('');
          $("#seaview").val('');

          // Refresh table data
          getReservationData();

        },

        fail: function (error) {
          console.log('Error: ' + error);
        }

    });

}
