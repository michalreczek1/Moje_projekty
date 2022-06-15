<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informacje o dacie i czasie</title>
</head>
<body>
<p>Teraz jest: ${dt}</p>
<p>Wybrane pola:</p>
<ul>
<li>rok: ${dt.year}</li>
<li>miesiąc: ${dt.month}</li>
<li>dzień: ${dt.dayOfMonth}</li>
</ul>
</body>
</html>
