<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Client Details</title>
</head>
<body>
<h1>Client Details</h1>
<c:if test="${not empty client}">
    <table>
        <tr>
            <th>Name</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th>Document</th>
            <th>Birth Date</th>
        </tr>
        <tr>
            <td>${cliente.name}</td>
            <td>${cliente.surname}</td>
            <td>${cliente.email}</td>
            <td>${cliente.document}</td>
            <td>${cliente.birthDate}</td>
        </tr>
    </table>
</c:if>
</body>
</html>