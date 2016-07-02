<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
<form>
    N: <input type="text" name="num1" />
    M: <input type="text" name="num2" />
    <input type="submit" />
</form>
<ul>
    <?php
    if (isset($_GET['num1']) && isset($_GET['num2'])){
     $numLists = intval($_GET['num1']);
        $numEl = intval($_GET['num2']);
        for ($l = 1; $l <= $numLists; $l++){
            echo "\t<li>List $l<ul>";
            for ($el = 1; $el <= $numEl; $el++){
                echo "\t<li>Element $l.$el</li>";
            }
            echo "</ul></li>";
        }
    }
    ?>
</ul>
</body>
</html>