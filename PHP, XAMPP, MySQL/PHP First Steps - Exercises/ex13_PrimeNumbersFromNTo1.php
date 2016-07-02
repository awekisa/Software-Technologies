<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N: <input type="text" name="num" />
    <input type="submit" />
</form>
<?php if (isset($_GET['num'])) {
    $n = intval($_GET['num']);

    for ($i = $n; $i >= 1; $i--) {
        if (isPrime($i)) {
            echo $i . " ";
        }
    }
}
    function isPrime($i){
        if ($i == 1){
            return false;
        }
        else if($i == 2){
            return true;
        }
        else if($i == 3){
            return true;
        }
        else if($i % 2 == 0){
            return false;
        }
        else{
            for ($n = 3; $n <= ceil(sqrt($i)); $i+2){
                if ($i % $n == 0){
                    return false;
                }
                return true;
            }
        }
    }

    ?>
</body>
</html>