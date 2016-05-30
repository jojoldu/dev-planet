<!DOCTYPE html>
<html lang="ko">
<head>
<#include '/layout/header.ftl'>
</head>

<body ng-app="user">
<#include '/layout/gnb.ftl'>
<#if streak?has_content>
<div class="row">
    <div class="col s12 m4">
        <div class="card card-avatar">
            <div class="waves-effect waves-block waves-light">
                <i class="material-icons large trending_up"></i>
            </div>
            <div class="card-content">
                <span class="card-title activator grey-text text-darken-4">최근 커밋 일자<br>
                    <small><em><a class="red-text text-darken-1" href="#">${streak.lastCheckDate}</a></em></small>
                </span>
            </div>
        </div>
    </div>
    <div class="col s12 m4">
        <div class="card card-avatar">
            <div class="waves-effect waves-block waves-light">
                <i class="material-icons large today"></i>
            </div>
            <div class="card-content">
                <span class="card-title activator grey-text text-darken-4">현재 연속 커밋<br>
                    <small><em><a class="red-text text-darken-1" href="#">${streak.current}</a></em></small>
                </span>
            </div>
        </div>
    </div>
</#if>
<#include '/layout/footer.ftl'>
</body>
</html>