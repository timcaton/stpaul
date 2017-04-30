<!DOCTYPE HTML>
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
    }
</style>
</head>
<body>
<?php

$servername = "localhost";
$username = "stpuser";
$password = "dbpassword";
$dbname = "STPAULDB";



// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);


// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
	}

	

$sql = "SELECT NAME, DATE_FORMAT(DOB, '%M') AS Month, DATE_FORMAT(DOB, '%D') as Day FROM MEMBER WHERE NOT Member_Type = 'Deceased'";
$result = $conn->query($sql);


if ($result->num_rows > 0) {
   
	//Header for the table for the report
	echo "<table><tr><th>Name</th><th>Birthday Date</th></tr>";
	
	// output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>" . $row["NAME"] . "</td><td>" . $row["Month"] . " " . $row["Day"] . "</td></tr>";
    }
} else {
    echo "0 results";
}

$conn->close();

?>