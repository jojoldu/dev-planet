<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <meta name="description" content="User login page" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <meta name="author" content="jojoldu@gmail.com">
    <title>Dev Planet</title>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="/components/bootstrap/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/ace/font-awesome.css" />

    <!-- text fonts -->
    <link rel="stylesheet" href="/css/ace/ace-fonts.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="/css/ace/ace.css" />

</head>

<body class="login-layout light-login">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <span class="grey" id="id-text2">Dev Planet</span>
                        </h1>
                    </div>

                    <div class="space-6"></div>

                    <div class="position-relative">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="space-6"></div>

                                    <div class="space-6"></div>

                                    <div class="social-login center">
                                        <a href="https://github.com/login/oauth/authorize?client_id=917614cfb633b397de81&redirect_uri=http://localhost:8080/oauth/auth&scope=user,repo" class="btn btn-info">
                                            <img src="/img/GitHub-Mark-32px.png">
                                        </a>
                                    </div>
                                    <h4 class="blue" id="id-company-text">&copy; jojoldu@gmail.com</h4>
                                </div><!-- /.widget-main -->
                            </div><!-- /.widget-body -->
                        </div><!-- /.login-box -->
                    </div><!-- /.position-relative -->
                </div>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.main-content -->
</div><!-- /.main-container -->


</body>
</html>
