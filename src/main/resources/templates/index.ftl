<!DOCTYPE html>
<html lang="ko">
<head>
    <#include '/layout/header.ftl'>
    <!-- custom styles -->
    <link rel="stylesheet" href="/css/custom.css" />

</head>

<body>
<#include '/layout/gnb.ftl'>

<!-- Page Content -->
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
            <#if loginUser?has_content>
                <h3 class="header blue lighter smaller">
                    <i class="ace-icon fa fa-spinner"></i>
                    Your Contribution
                </h3>
                <div id="progressbar" class="ui-progressbar ui-widget ui-widget-content ui-corner-all progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="${loginUser.currentStreak}">
                    <div class="ui-progressbar-value ui-widget-header ui-corner-left progress-bar progress-bar-success" style="width: ${loginUser.currentStreak}%;"></div>
                </div>
            </#if>

            <div class="thumbnail">
                <table class="table table-striped table-responsive table-hover">
                    <thead>
                        <tr>
                            <th>순위</th>
                            <th>사용자</th>
                            <th>Point</th>
                            <th>현재 연속커밋</th>
                            <th>최근 커밋일자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <#list userList as user>
                            <tr>
                                <th scope="row">${user_index+1}</th>
                                <td>${user.userName}</td>
                                <td>${user.point}</td>
                                <td>${user.currentStreak}</td>
                                <td>${user.lastCheckDate}</td>
                            </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <nav>
                    <ul class="pagination pull-right">
                        <li class="disabled"><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">Previous</span></a></li>
                        <li class="active"><a href="javascript:;">1 <span class="sr-only">(current)</span></a></li>
                        <li class="disabled"><a href="javascript:;" aria-label="Next"><span aria-hidden="true">Next</span></a></li>
                    </ul>
                </nav>
            </div>
            <div class="well">
                <div class="text-right">
                    <a class="btn btn-success">Leave a Review</a>
                </div>

                <hr>

                <div class="row">
                    <div class="col-md-12">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        Anonymous
                        <span class="pull-right">10 days ago</span>
                        <p>This product was great in terms of quality. I would definitely buy another!</p>
                    </div>
                </div>

                <hr>

                <div class="row">
                    <div class="col-md-12">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        Anonymous
                        <span class="pull-right">12 days ago</span>
                        <p>I've alredy ordered another one!</p>
                    </div>
                </div>

                <hr>

                <div class="row">
                    <div class="col-md-12">
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star"></span>
                        <span class="glyphicon glyphicon-star-empty"></span>
                        Anonymous
                        <span class="pull-right">15 days ago</span>
                        <p>I've seen some better than this, but not at this price. I definitely recommend this item.</p>
                    </div>
                </div>

            </div>

        </div>

    </div>

</div>
<!-- /.container -->

<#include '/layout/footer.ftl'>

</body>
</html>
