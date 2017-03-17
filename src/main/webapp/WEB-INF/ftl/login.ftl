<html>
<head>
	<#include "./part/head.ftl"/>
	<title>登录</title>
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>

	<div class="container">
		<div class="header-logo">
            <a href="/">
            	<img src="/img/logo.jpg" alt="logo">
            </a>
		</div>
		<div id="login" class="auth-form">
			<div class="auth-form-header">
				<h1>Sign in to DimHat</h1>
				<#if msg??>
				<div class="flash-error">
					<button class="flash-close" type="button" aria-label="Dismiss this message">
						<span class="glyphicon glyphicon-remove"></span>
					</button>
					用户名或密码错误。
				</div>
				</#if>
			</div>
            <form action="/login" class="form" method="post">
				<div class="auth-form-body">
                    <div class="form-group">
                        <label for="username" class="control-label">用户名</label>
                        <input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名">
                    </div>
                    <div class="form-group">
                        <label for="password" class="control-label">
							密码
                            <a class="label-link pull-right" href="/password_reset">忘记密码？</a>
						</label>
                        <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
                    </div>
					<#--错误多次需要验证码-->
					<#if needVericode>
					<div class="form-group vericode">
                        <label for="username" class="control-label">验证码</label>
                        <input type="text" class="form-control vericode-input" name="j_captcha_response"><!--
						--><img src="vericode.jpg" class="vericode-img" alt="验证码">
					</div>
					</#if>
                    <div class="form-group">
                        <button class="btn btn-block btn-success" type="submit"><b>登录</b></button>
                    </div>
				</div>
            </form>
			<p class="join">新用户？<a href="/register">注册账号</a></p>
		</div>
	</div>

    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="/js/index.js"></script>
</body>
</html>