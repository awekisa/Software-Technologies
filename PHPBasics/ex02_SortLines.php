<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sort Lines</title>
</head>
<body>
<?php
    //$sortedLines = "";
if (isset($_GET['lines'])) {
    $lines = explode("\n", $_GET['lines']);
    var_dump($lines);
    $lines = array_map('trim', $lines);
    var_dump($lines);
    sort($lines, SORT_STRING);
    var_dump($lines);
    $sortedLines = implode("\n", $lines);
    var_dump($lines);
}
?>
<form>
    <textarea rows="10" name="lines"><?php if (isset($sortedLines)) echo $sortedLines ?></textarea><br>
    <input type="submit" value="Sort">
</form>
</body>
</html>