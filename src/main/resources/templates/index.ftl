<!DOCTYPE html>
<html lang="ko">
<head>
    <#include '/layout/header.ftl'>
    <!-- custom styles -->
    <link rel="stylesheet" href="/css/index.css" />

</head>

<body>
<#include '/layout/gnb.ftl'>
<div id="index-banner" class="parallax-container">
    <div class="section no-pad-bot">
        <div class="container">
            <br><br>
            <h1 class="header center teal-text text-white">당신의 커밋을 공유하세요!</h1>
            <br><br>

        </div>
    </div>
    <div class="parallax"><img src="/img/github-universe.jpg" alt="Unsplashed background img 1" style="display: block; transform: translate3d(-50%, 218px, 0px);"></div>
</div>
<#include '/layout/footer.ftl'>
<script type="text/javascript" src="/js/index/controller.js"></script>
<script type="text/javascript" src="/js/index/directive.js"></script>
</body>
</html>
