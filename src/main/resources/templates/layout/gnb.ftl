<nav ng-app="gnb" ng-controller="GnbController" class="white" role="navigation">
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
