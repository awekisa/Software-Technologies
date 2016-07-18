<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List posts from MySQL</title>
    <link rel="stylesheet", type="text/css" href="styles.css">
</head>
<body>
<?php
$mysqli = new mysqli('localhost', 'root', '', 'blog');
$mysqli->set_charset("utf8");
if ($mysqli->connect_errno){
    die('Cannot connect to MySQL');
}
$query = "SELECT * FROM posts ORDER BY date";
$result = $mysqli->query($query);
if (!$result) {
    die('Cannot read \"posts\" table from MySQL');
}
    echo '<table>';
    echo '<tr><th>Title</th><th>Content</th><th>Date</th></tr>';
    while   ($row = $result->fetch_assoc()){
        $title = htmlspecialchars($row['title']);
        $content = htmlspecialchars($row['content']);
        $date = (new DateTime($row['date']))->format('d.m.Y');
        echo "<tr><td>$title</td><td>$content</td><td>$date</td></tr>\n";
    }
    echo '</table>';
?>
</body>
</html>