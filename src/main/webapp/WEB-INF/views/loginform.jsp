<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
<html>    
        <head>
        <meta charset="utf-8">

        <title>AppUI - Web App Bootstrap Admin Template</title>

        <meta name="description" content="AppUI is a Web App Bootstrap Admin Template created by pixelcave and published on Themeforest">
        <meta name="author" content="pixelcave">
        <meta name="robots" content="noindex, nofollow">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0">

        <!-- Icons -->
        <!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
        <link rel="shortcut icon" href="/resources/img/favicon.png">
        <link rel="apple-touch-icon" href="/resources/img/icon57.png" sizes="57x57">
        <link rel="apple-touch-icon" href="/resources/img/icon72.png" sizes="72x72">
        <link rel="apple-touch-icon" href="/resources/img/icon76.png" sizes="76x76">
        <link rel="apple-touch-icon" href="/resources/img/icon114.png" sizes="114x114">
        <link rel="apple-touch-icon" href="/resources/img/icon120.png" sizes="120x120">
        <link rel="apple-touch-icon" href="/resources/img/icon144.png" sizes="144x144">
        <link rel="apple-touch-icon" href="/resources/img/icon152.png" sizes="152x152">
        <link rel="apple-touch-icon" href="/resources/img/icon180.png" sizes="180x180">
        <!-- END Icons -->

        <!-- Stylesheets -->
        <!-- Bootstrap is included in its original form, unaltered -->
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

        <!-- Related styles of various icon packs and plugins -->
        <link rel="stylesheet" href="/resources/css/plugins.css">

        <!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
        <link rel="stylesheet" href="/resources/css/main.css">
        
        
<script type="text/javascript"  src="/resources/js/pages/login.js"> </script>

        <!-- Include a specific file here from css/themes/ folder to alter the default theme of the template -->

        <!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
        <link rel="stylesheet" href="/resources/css/themes.css">
        <!-- END Stylesheets -->

        <!-- Modernizr (browser feature detection library) -->
        <script src="/resources/js/vendor/modernizr-3.3.1.min.js"></script>
    </head>
    <body>
        <!-- Login Container -->
        <div id="login-container">
            <!-- Login Header -->
            <h1 class="h2 text-light text-center push-top-bottom animation-slideDown">
               <img src="/resources/img/colabare_white.png" width=50px height=40px>
                                            <strong>Welcome to Colabare</strong>
            </h1>
            <!-- END Login Header -->

            <!-- Login Block -->
            <div class="block animation-fadeInQuickInv">
                <!-- Login Title -->
                <div class="block-title">
                    
                    <h2>Please Login</h2>
                </div>
                <!-- END Login Title -->

                <!-- Login Form -->
                <form action="/login" method="post" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <input type="text" id="username" name="username" class="form-control" placeholder="Your ID..">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12">
                            <input type="password" id="password" name="password" class="form-control" placeholder="Your password..">
                        </div>
                    </div>
                    <div class="form-group form-actions">
                        <div class="col-xs-8">
                            
                        </div>
                        <div class="col-xs-4 text-right">
                            <button type="submit" class="btn btn-effect-ripple btn-sm btn-primary"><i class="fa fa-check"></i> Let's Go</button>
                        </div>
                        
                    <input type="hidden" name=${_csrf.parameterName } value="${_csrf.token }"/>
                    </div>
                    
                </form>
                <!-- END Login Form -->
             
            <!-- END Footer -->
            </div>
            <!-- END Login Block -->

           <!-- Footer -->
            <footer class="text-muted text-center animation-pullUp">
                <small><span id="year-copy"></span> &copy; <a href="https://1.envato.market/DXa" target="_blank">AppUI 2.9</a></small>
            </footer>
        </div>
        <!-- END Login Container -->

        <!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
        <script src="/resources/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="/resources/js/vendor/bootstrap.min.js"></script>
        <script src="/resources/js/plugins.js"></script>
        <script src="/resources/js/app.js"></script>

        <!-- Load and execute javascript code used only in this page -->
    </body>
</html>


<%-- 
<html>


<script type="text/javascript" src="/resources/js/vendor/jquery-3.3.1.min.js"></script>
<script type="text/javascript"  src="/resources/js/pages/login.js"> </script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3><c:out value="${error }"/></h3>
<h3><c:out value="${logout }"/></h3>
	<form action="/login" method="post">
	<div>
	아이디 : <input type="text" name="username" ><br></div><div>
	비밀번호 : <input type="password" name="password" ><br></div>
	<Div>
	<input type="submit" value="로그인">
	</Div>
	<input type="hidden" name=${_csrf.parameterName } value="${_csrf.token }"/>
</form>

</body>
</html> --%>