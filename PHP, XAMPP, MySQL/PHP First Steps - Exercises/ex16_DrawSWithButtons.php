<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
</head>
<div
<body>
<?php
$rows = 9;
$cols = 5;
for ($r = 0; $r < $rows; $r++) {
    for ($c = 0; $c < $cols; $c++) {
        if ($r == 0 || $r == 4 || $r == 8) {
            echo "<button style='background-color: blue'>1</button>";
        } else if ($r > 0 && $r < 4) {
            if ($c == 0) {
                echo "<button style='background-color: blue'>1</button>";
            } else {
                echo "<button>0</button>";
            }
        } else if ($r > 4 && $r < 8) {
            if ($c == 4) {
                echo "<button style='background-color: blue'>1</button>";
            } else {
                echo "<button>0</button>";
            }
        }
    }
    echo "<br>";
}
?>
</body>
</html>