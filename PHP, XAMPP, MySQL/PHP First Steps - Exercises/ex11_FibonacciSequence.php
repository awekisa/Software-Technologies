<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N: <input type="text" name="num"/>
    <input type="submit"/>
</form>
<?php if (isset($_GET['num'])) {
    $n = intval($_GET['num']);
    $list = array();
    $first = 1;
    $second = 1;
    for ($i = 1; $i <= $n; $i++) {
        if ($i == 1 || $i == 2) {
            $list[] = $first;
        } else {
            $first = $list[$i - 3];
            $second = $list[$i - 2];
            $fibNum = $first + $second;
            $list[] = $fibNum;
        }
    }
    echo join(" ", $list);
}
?>

</body>
</html>