<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="ru">

<body>

<div>Здравствуйте, дорогая ${secretaryName}</div>
<br>
<div> За последние сутки во ввреенных Вам сайтах произошли следующие изменения:</div>
<br>
<br>
<div> Исчезли следующие страницы: ${deletedHtmlInfo}</div>
<br>
<br>
<div> Появились следующие новые страницы: ${newHtmlInfo}</div>
<br>
<br>
<div> Изменились следующие страницы: ${changedHtmlInfo}</div>
<br>
<br>
<div>С уважением,</div>
<br>
<div>автоматизированная система мониторинга.</div>
</body>

</html>