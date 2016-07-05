<html>
<head>

</head>
<body>
<form>
    Delimiter: <input type="text" name="delimiter">
    Input: <textarea name="numbers"></textarea>
    <input type="submit">
</form>
<?php
if (isset($_GET['delimiter']) && isset($_GET['numbers'])){
    $delimiter = $_GET['delimiter'];
    $numbers = $_GET['numbers'];
    $arr = array_map('trim', explode($delimiter, $numbers));
    krsort($arr);
    foreach($arr as $item){
        echo $item . "<br>";
    }
}
?>
</body>
</html>
