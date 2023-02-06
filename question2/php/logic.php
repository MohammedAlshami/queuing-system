<?php

$id = $_POST["id"];
$action = $_POST["action"];

$conn = new mysqli("localhost", "id20255504_root", "x@r7tHdV^Sk&|oxD", "id20255504_shami");

$query = "SELECT status, cur FROM job WHERE id=$id";
$result = $conn->query($query)->fetch_assoc();

if ($action == 1){
    if ($result['status'] == "Green"){

        $conn->query("UPDATE job SET status = 'Grey' WHERE id = $id");
    } elseif ($result['status'] == "Red"){

        $ticketID = $result['cur'];
        $conn->query("UPDATE que SET status = 'wait' WHERE id = $ticketID");
        $conn->query("UPDATE job SET status = 'Grey', cur = 0 WHERE id = $id");
    } else {

        $conn->query("UPDATE job SET status = 'Green' WHERE id = $id");
    }
}
elseif ($action == 2){
    $ticketID = $result['cur'];
    if ($ticketID != 0){
        $conn->query("UPDATE que SET status = 'completed' WHERE id = $ticketID");
        $conn->query("UPDATE job SET status = 'Green', cur = 0 WHERE id = $id");
    }
    else{
        echo "Error";
    }

}
elseif ($action == 3){

    if ($result['status'] == "Green"){
        // Getting the ticket id if it's in the wait list
        $ticketID  = $conn->query("SELECT id FROM que WHERE status = 'wait';")->fetch_assoc()['id'];
        // updating the status of the ticket
        $conn->query("UPDATE que SET status = 'serving' WHERE id = $ticketID");

        // Assigning the ticket to the counter
        $conn->query("UPDATE job SET status = 'Red', cur = $ticketID  WHERE id = $id");
    }
    else {
        echo "Do something";
    }
}
?>