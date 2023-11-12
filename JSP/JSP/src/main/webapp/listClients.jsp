<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>List Clients</title>
</head>
<body>
<h1>List Clients</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Last Name</th>
        <th>E-mail</th>
        <th>Document</th>
        <th>Birth Date</th>
    </tr>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${cliente.name}</td>
            <td>${cliente.surname}</td>
            <td>${cliente.email}</td>
            <td>${cliente.document}</td>
            <td>${cliente.birthDate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>