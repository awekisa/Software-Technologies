<html>
<head>

</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Input: <textarea name="lines"></textarea>
    <input type="submit">
</form>
<?php
if (isset($_GET['delimiter']) && isset($_GET['lines'])){
    $delimiter = $_GET['delimiter'];
    $lines = array_map('trim', explode($delimiter, $_GET['lines']));
    foreach ($lines as $line) {
        if ($line != "Stop") {
            echo $line . "<br>";
        }
        else{
            break;
        }
    }
}
?>
</body>
</html>

