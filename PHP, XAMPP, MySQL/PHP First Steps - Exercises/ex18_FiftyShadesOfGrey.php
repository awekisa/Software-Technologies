<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
    <style>
        div {
            display: inline-block;
            margin: 5px;
            width: 20px;
            height: 20px;
        }
    </style>
</head>
<body>
<?php
for ($r = 0; $r <= 204; $r+= 51){
    for ($c = $r; $c <= $r + 5*9; $c+=5){
        $grey = "rgb($c, $c, $c)";
        echo "<div style=\"background-color: $grey;\"></div>";
    }
    echo '<br>';
}
?>
</body>
</html>
