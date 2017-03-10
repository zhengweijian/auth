<html>
<head>
<#include "./part/head.ftl"/>
    <title>注册</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container">
    <div style="height:80px;">
        <noscript>
            DimHat does not support browsers with JavaScript disabled.<br>
            We promise we’ll behave.
        </noscript>
    </div>
    <div id="register" class="auth-form">
        <div class="auth-form-header">
            <h1>创建你的个人账户</h1>
        </div>
        <form action="/register" method="post" class="form">
            <div class="auth-form-body">
                <div class="form-group">
                    <label for="username" class="control-label">用户名</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="请输入用户名">
                    <p class="note">这将会是你的用户名——接下来你能够输入你的单位用户名</p>
                </div>
                <div class="form-group">
                    <label for="email" class="control-label">
                        邮箱
                    </label>
                    <input type="email" id="email" class="form-control" placeholder="请输入邮箱">
                    <p class="note">您偶尔会收到帐户相关的电子邮件。 我们承诺不会与任何人分享您的电子邮件。</p>
                </div>
                <div class="form-group">
                    <label for="password" class="control-label">
                        密码
                    </label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
                    <p class="note">至少使用一个小写字母，一个数字和七个字符。</p>
                </div>
                <div class="form-group">
                    <button class="btn btn-block btn-success" type="submit"><b>注册</b></button>
                </div>
            </div>
        </form>
        <p class="join">已有账号？<a href="/login">登录</a></p>
    </div>
</div>

</body>
</html>