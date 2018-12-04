<%@ page isErrorPage="true" import="java.io.*" contentType="text/html"%>
<!doctype html>

<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<h1>Fehler</h1> <br>
		Die Operation konnte nicht ausgeführt werden. <br>
		Ursache:
		<%=exception.getMessage()%> <br>
		<a href="/TicketSale/index">Zurück zur Hauptseite</a>
	</body>
</html>


