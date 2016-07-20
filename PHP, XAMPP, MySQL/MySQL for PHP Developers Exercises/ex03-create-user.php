<?php
$hostname = 'localhost';
$username = 'root';
$password = '';
$dbname = 'blog';

$mysqli = new mysqli($hostname, $username, $password, $dbname);

if ($mysqli->connect_errno) {
    die("Error! Failed to connect to MySQL");
}

$query = $mysqli->prepare("INSERT INTO users (username, password_hash, full_name) VALUES (?, ?, ?)");
$username = "Grera";
$password = md5("sgfdshdfhrhrth");
$full_name = "Greta Bugfre";
$query->bind_param("sss", $username, $password, $full_name);
$query->execute();
if ($query->affected_rows == 1){
    echo "User successfully created!";
}
else{
    die("Inserting user failed");
}