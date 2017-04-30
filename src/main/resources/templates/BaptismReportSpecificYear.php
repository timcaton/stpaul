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

//Year for report being generated
$year = $_POST['baptism_year'];

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);


// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
	}

	

$sql = "SELECT NAME, DATE_FORMAT(BAPTISM.BAPTISM_DATE, '%M') AS Month, DATE_FORMAT(BAPTISM.BAPTISM_DATE, '%D') as Day FROM MEMBER JOIN BAPTISM ON MEMBER.CHURCHMEMBER_ID = BAPTISM.CHURCHMEMBER_ID WHERE DATE_FORMAT(BAPTISM.BAPTISM_DATE, '%Y') = $year";
$result = $conn->query($sql);


if ($result->num_rows > 0) {
   
	//Header for the table for the report
	echo "<table><tr><th>Name</th><th>Baptism Date</th></tr>";
	
	// output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr><td>" . $row["NAME"] . "</td><td>" . $row["Month"] . " " . $row["Day"] . "</td></tr>";
    }
} else {
    echo "0 results";
}

$conn->close();

?>