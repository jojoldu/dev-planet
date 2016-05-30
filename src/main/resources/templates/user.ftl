<!DOCTYPE html>
<html lang="ko">
<head>
<#include '/layout/header.ftl'>
</head>

<body ng-app="user">
<#include '/layout/gnb.ftl'>
<#if streak?has_content>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <p class="lead">Shop Name</p>
            <div class="list-group">
                <a href="#" class="list-group-item active">Category 1</a>
                <a href="#" class="list-group-item">Category 2</a>
                <a href="#" class="list-group-item">Category 3</a>
            </div>
        </div>

        <div class="col-md-9">
                <span class="">최근 커밋 일자<br>
                    <a class="" href="#">${streak.lastCheckDate}</a>
                </span>
                <span class="">현재 연속 커밋<br>
                    <<a class="red-text text-darken-1" href="#">${streak.current}</a>
                </span>
        </div>

    </div>

</div>
<!-- /.container -->

</#if>
<#include '/layout/footer.ftl'>
</body>
</html>