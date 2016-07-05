<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Celsius To Fahrenheit</title>
</head>
<body>
<?php
$convertToFahrenheit = "";
if (isset($_GET['cel'])) {
    $cel = floatval($_GET['cel']);
    $fah = celToFahr($cel);
    $convertToFahrenheit = "$cel &deg;C = $fah &deg;F";
}
$convertToCelsius = "";
if (isset($_GET['fah'])) {
    $fah = floatval($_GET['fah']);
    $cel = fahrToCel($fah);
    $convertToCelsius = "$fah &deg;F = $cel &deg;C";
}


function celToFahr(float $celsius) : float
{
    return $celsius * 1.8 + 32;
}

function fahrToCel(float $fahrenheit) :float
{
    return ($fahrenheit - 32) / 1.8;
}

?>
<form>
    Celsius: <input type="text" name="cel">
    <input type="submit" value="Convert">
    <?php if(isset($convertToFahrenheit)) echo $convertToFahrenheit ?>
</form>

<form>
    Fahrenheit: <input type="text" name="far">
    <input type="submit" value="Convert">
    <?php if(isset($convertToCelsius)) echo $convertToCelsius ?>
</form>

</body>
</html>