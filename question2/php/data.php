<?php
header("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");
header("Cache-Control: post-check=0, pre-check=0", false);
header("Pragma: no-cache");
$output[0]["id"] = "0";

// Get last number in ticket table
$conn = new mysqli("localhost", "id20255504_root", "x@r7tHdV^Sk&|oxD", "id20255504_shami");
$query = "SELECT id FROM que ORDER BY id DESC LIMIT 1;";
$value2 = $conn->query($query)->fetch_row()[0];


// get first number to be taken from wait list
$query = "SELECT id
FROM que
WHERE status = 'wait'
LIMIT 1;";
$value1 = $conn->query($query)->fetch_row()[0];


$output[1]["id"] = "<div class='item'>
<h6>Now Servering: ".$value1."</h6>
<h6>Last Number: ".$value2."</h6>
<button class ='button' onclick='myFunction()''>Take a Number</button>
</div><br>";


$conn = new mysqli("localhost", "id20255504_root", "x@r7tHdV^Sk&|oxD", "id20255504_shami");
$query = "SELECT * FROM job;";
$result = $conn->query($query);

while ($row = $result->fetch_row()) {
    $output[1]["id"] = 
    $output[1]["id"] .
        "<div class='item".$row[0]."'>
    <div class='circle' style='background-color:".$row[2].";'></div>
    <h6>Counter ".$row[0]."</h6>
    <h6 id='c".$row[0]."'>Current Number: ".$row[1]."</h6>
    </div>"
    ."<br>";

}



echo json_encode($output);
