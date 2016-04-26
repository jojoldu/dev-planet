<!DOCTYPE html>
<html lang="ko">
<head>
    <#include '/layout/header.ftl'>
</head>

<body ng-app="index">
<#include '/layout/gnb.ftl'>
<div>
    <ul class="collection">
        <#list repos as repo>
            <li class="collection-item avatar">
                <input type="checkbox" class="filled-in" id="filled-in-box"/>
                <span class="title">${repo.name}</span>
                <p>${repo.description} <br>
                    ${repo.created_at}
                </p>
            </li>
        </#list>
    </ul>
</div>
<#include '/layout/footer.ftl'>
</body>
</html>
