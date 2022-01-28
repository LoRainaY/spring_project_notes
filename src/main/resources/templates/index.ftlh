<#import "parts/login.ftlh" as l>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Main</title>
    <link rel='stylesheet' href='/css/index.css'>
</head>
<body>
<@l.logout/>
<div style="float: right; margin-left: 30px">
    <form action="/user" method="get">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Просмотр пользователей"/>
    </form>
</div>

<div>
    <details>
        <summary>Добавить закладку</summary>
    <form method="post">

        <input type="text" name="tag" placeholder="Тэг"><br><br>
        <textarea name="description" placeholder="Введите заметку" rows="3"></textarea><br><br>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Добавить заметку</button>

    </form></details>
</div>
<div>Поиск по тегу:</div>
<form method="get" action="/index">
    <input type="text" name="filter" value="${filter!}">
    <button type="submit">Найти</button>
</form>

<#list messages as massage>
    <div id="item">
        <span style="display: none">${massage.id}</span><br>
        ${massage.description}<br>
        #${massage.tag}<br>
        <div id="getAuthor">Пользователь: <strong>${massage.authorName}</strong></div>
    </div>
<#else>
    На данный момент заметок нет
</#list>
</body>

</html>