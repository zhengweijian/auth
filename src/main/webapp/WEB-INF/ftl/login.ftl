<html>
<head>
	<#include "./part/head.ftl"/>
	<title>登录</title>
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>

	<div class="container">
		<div style="height:80px;"></div>
		<div id="login" class="auth-form">
			<div class="auth-form-header">
				<h1>Sign in to DimHat</h1>

			<#noescape>${msg+'<script>alert("haha")</script>'}</#noescape>
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
                    <div class="form-group">
                        <button class="btn btn-block btn-success" type="submit"><b>登录</b></button>
                    </div>
				</div>
            </form>
			<p class="join">新用户？<a href="/register">注册账号</a></p>
		</div>
	</div>

</body>
</html>