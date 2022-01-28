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
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</body>
</html>