<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>杨鹏会员注册页面</title>

		<%@ include file="/pages/common/head.jsp"%>

	<script type="text/javascript">

		$(function () {

			$("#sub_btn").click(function () {

				var regUsername = /^\w{3,7}$/;
				if (!regUsername.test($("#username").val())) {
					$("span.errorMsg").text("用户名输入错误");
					return false;
				}

				var regPassword = /^\w{6,20}$/;
				if (!regPassword.test($("#password").val())) {
					$("span.errorMsg").text("密码输入错误");
					return false;
				}

				var rePassword = $("#repwd").val();
				if (rePassword != $("#password").val()) {
					$("span.errorMsg").text("密码输入不一致");
					return false;
				}


				var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if (!regEmail.test($("#email").val())) {
					$("span.errorMsg").text("邮箱格式错误");
					return false;
				}

				if ($("#code") == null) {
					$("span.errorMsg").text("验证码不能为空");
					return false;
				}


				$("span.errorMsg").text("");
			});

			$("#kaptcha").click(function () {

				this.src = "katpcha.jpg?d=" + new Date();

			});


		});


	</script>


<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}

</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册杨鹏会员</h1>
								<span class="errorMsg">${ requestScope.msg }</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
										   value="${ requestScope.username }"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password"
										   value="${ requestScope.password }" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd"
										   value="${ requestScope.password }" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
										   value="${ requestScope.email }" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 80px;" name="code" id="code"/>
									<img alt="" src="katpcha.jpg" id="kaptcha" style="float: right; margin-right: 40px" width="100px" height="28px">
									<br />
									<br />
									<input type="hidden" name="action" value="regist">
									<input type="submit" value="注册" id="sub_btn" />

								</form>
							</div>

						</div>
					</div>
				</div>
			</div>

		<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>