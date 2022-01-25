<#import "parts/login.ftlh" as l>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="/css/index.css"/>
</head>
<body>
<@l.logout/>

<div>
    <form method="post">

        <input type="text" name="tag" placeholder="Тэг"><br><br>
        <textarea name="description" placeholder="Введите заметку" rows="3"></textarea><br><br>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Добавить заметку</button>

    </form>
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