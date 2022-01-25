<#macro login path>
    <form action="/login" method="post" id="login">
        <fieldset id="inputs">
            <h1>Вход в систему</h1>
            <div><label> Логин: <input type="text" name="username" id="username" placeholder="Username" autofocus required/></label></div>
            <div><label> Пароль: <input type="password" name="password" id="password" placeholder="Password" required/> </label></div>
        </fieldset>
        <fieldset id="actions">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div><input type="submit" value="Вход" id="submit"/></div>
            <a href="/registration">Регистрация</a></fieldset>

    </form>
</#macro>

<#macro logout>
    <div style="float: right; margin-left: 10px">
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Sign Out"/>
        </form>
    </div>
</#macro>