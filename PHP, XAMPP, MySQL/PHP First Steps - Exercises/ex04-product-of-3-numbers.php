<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product of 3 numbers</title>

</head>
<body>
<form>
    X: <input type="text" name="num1"/>
    Y: <input type="text" name="num2"/>
    Z: <input type="text" name="num3"/>
    <input type="submit"/>
</form>
<?php
if (isset($_GET['num1']) && isset($_GET['num2']) && isset($_GET['num3'])) {
    $n1 = intval($_GET['num1']);
    $n2 = intval($_GET['num2']);
    $n3 = intval($_GET['num3']);
    $result = "";
    $negativeCount = 0;
    $allNums = array($n1, $n2, $n3);
    foreach ($allNums as $num) {
        if ($num == 0) {
            $result = "Positive";
            break;
        } else if ($num < 0) {
            $negativeCount++;
        }
    }
    if ($result == "Positive") {
        echo $result;
    } else {
        if ($negativeCount % 2 != 0) {
            $result = "Negative";
            echo $result;
        } else {
            $result = "Positive";
            echo $result;
        }
    }
}
?>
</body>
</html>