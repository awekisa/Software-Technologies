<html>
<head>

</head>
<body>
<form>
    Input: <textarea name="lines"></textarea>
    <input type="submit">
</form>
<?php
if (isset($_GET['lines'])){
    $lines = ($_GET['lines']);
    $lines = array_filter(array_map('trim', explode("\n", $lines)));
}
foreach ($lines as $line) {
    if ($line != "Stop"){
        echo $line . "<br>";
    }
    else{
        break;
    }
}
?>
</body>
</html>
