<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Login</title>
</head>

<body>
<div class="container">
    <div class="panel panel-default panel-login">
        <div class="panel-body">
            <div class="row">
                <form class="form-signin" action="${postUrl}" method="POST" autocomplete="off">
                    <div class="login col-md-8 col-md-offset-2">
                        <g:if test='${flash.message}'>
                            <div class="alert alert-dismissable">
                                <p>${flash.message}</p>
                            </div>
                        </g:if>

                            <h4>Please sign in.</h4>
                            <fieldset>
                                <div class=form-group>
                                    <input type="text" class="form-control input-lg" name="j_username"
                                           placeholder="Email" autofocus>
                                </div>

                                <div class=form-group>
                                    <input type="password" class="form-control input-lg" name="j_password"
                                           placeholder="Password">
                                </div>

                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"
                                               name="${rememberMeParameter}" ${hasCookie ? 'checked="checked"' : ''}>
                                        Remember me
                                    </label>
                                </div>
                            </fieldset>
                    </div>
                    <button class="btn btn-lg btn-primary login-button" type="submit">Sign in</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
