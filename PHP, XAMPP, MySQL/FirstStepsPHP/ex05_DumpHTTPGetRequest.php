<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dump HTTP Dump Request</title>
</head>
<body>
<form>
    Name: <input type="text" name="personName"/>
    Age: <input type="number" name="age"/>
    Town:
    <select name="townID">
        <option value="10">Sofia</option>
        <option value="20">Varna</option>
        <option value="30">Plovdiv</option>
    </select>
    <input type="submit"/>
</form>
<?php
var_dump($_GET);
?>
</body>
</html>