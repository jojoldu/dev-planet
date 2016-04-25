<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <meta name="description" content="Start Page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <meta name="author" content="jojoldu@gmail.com">
    <title>Dev Planet</title>

    <!-- materialize -->
    <link rel="stylesheet" href="/components/Materialize/dist/css/materialize.min.css" />

    <!-- text fonts -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- custom styles -->
    <link rel="stylesheet" href="/css/index.css" />

</head>

<body ng-app="index">
<nav class="white" role="navigation">
    <div class="nav-wrapper container">
        <a id="logo-container" href="/" class="brand-logo">Daily Commit Group</a>
        <ul class="right hide-on-med-and-down">
            <gnb></gnb>
        </ul>

        <ul id="nav-mobile" class="side-nav" style="transform: translateX(-100%);">
            <gnb></gnb>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>
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

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/components/Materialize/dist/js/materialize.min.js"></script>
<script type="text/javascript" src="/components/angular/angular.min.js"></script>
<script type="text/javascript" src="/js/index/controller.js"></script>
<script type="text/javascript" src="/js/index/directive.js"></script>
</body>
</html>
