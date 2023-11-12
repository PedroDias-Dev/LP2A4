<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Client</title>
</head>
<body>
<h1>Create Client</h1>
<form action="/CreateClient" method="post">
    <label for="name">Nome:</label>
    <input type="text" name="nome" id="name" required><br>

    <label for="surname">Sobrenome:</label>
    <input type="text" name="surname" id="surname" required><br>

    <label for="email">Email:</label>
    <input type="text" name="email" id="email" required><br>

    <label for="document">CPF:</label>
    <input type="text" name="document" id="document" required><br>

    <label for="birthDate">Data de Nascimento:</label>
    <input type="date" id="birthDate" name="birthDate" required><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>