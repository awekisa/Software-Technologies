<html>
<head>

</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Array-size: <input type="text" name="array-size">
    Input: <textarea name="key-value-pairs"></textarea>
    <input type="submit">
</form>
<?php
if (isset($_GET['delimiter']) && isset($_GET['array-size']) && isset($_GET['key-value-pairs'])) {
    $size = intval($_GET['array-size']);
    $delimiter = $_GET['delimiter'];
    $tempArr = array_filter(array_map('trim', explode("\n", $_GET['key-value-pairs'])));
    $arr = emptyArray($size);
    foreach ($tempArr as $item) {
        $tokens = explode($delimiter, $item);
        $index = $tokens[0];
        $value = $tokens[1];
        $arr[$index] = $value;
    }
    foreach ($arr as $item) {
        echo $item . "<br>";
    }
}

function emptyArray($size) : array
{
    $arr = [];
    for ($i = 0; $i < $size; $i++) {
        $arr[] = "0";
    }
    return $arr;
}

?>
</body>
</html>
