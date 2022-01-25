<#macro reg>
    <form action="/registration" method="post" id="reg">
        <fieldset id="inputs">
            <h1>Регистрация</h1>
            <div><label> User Name : <input type="text" name="username" id="username"/> </label></div>
            <div id="errors" style="color: red">

            </div>
            <div><label> Password: <input type="password" name="password" id="password"/> </label></div>
            <input type="hidden" name="_csrf" value="{{_csrf.token}}"></fieldset>
        <fieldset id="actions">
            <div><input type="submit" value="Зарегистрировать" id="submit"/></div>
        </fieldset>
    </form>



</#macro>