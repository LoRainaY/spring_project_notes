<#import "parts/login.ftlh" as l>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="/css/table.css"/>
</head>
<body>


    <table>
        <caption>Список пользователей</caption>
        <thead>
        <tr>
            <th>Логин</th>
            <th>Роль</th>
            <th class="col3">Операция</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><form action="/user/${user.id}">
                        <button type="submit">Редактировать</button></form>
                    <form action="/user/remove/${user.id}">
                        <button type="submit">Удалить</button>
                    </form></td>
            </tr>
        </#list>
        </tbody>
    </table>
</body>
</html>