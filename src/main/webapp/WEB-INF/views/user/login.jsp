<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
        <div class="container d-flex justify-content-center">
            <div class="border" style="width: 600px;margin-top: 100px">
                <h1 class="text-center fs-3 mt-3">LOGIN</h1>
                <div style="margin-left: 90px;margin-right: 90px;margin-bottom: 90px" class="mt-3">
                    <form action="/user/logins" method="post">
                        <div class="mb-3">
                            <label class="form-label">User name:</label>
                            <input name="tendangnhap"  type="text" class="form-control" placeholder="tên đăng nhập...">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Pass word:</label>
                            <input id="matkhau" name="matkhau" type="password" class="form-control" placeholder="Mật khẩu...">
                            <div>
                                <input type="checkbox" class="form-check-input" onclick="showPassword()">Hiển thị mật khẩu
                            </div>
                        </div>
                        <div class="mt-3 d-flex">
                            <label class="form-label me-3">Vai trò:</label>
                            <div class="form-check me-3">
                                <input class="form-check-input" type="radio" value="true" name="trangthai">
                                <label class="form-check-label">Admin</label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" value="false" name="trangthai">
                                <label class="form-check-label">Nhân viên</label>
                            </div>
                        </div>
                        <div class="mb-3">
                            <a href="/user/forgot">Forgot pass word?</a>
                        </div>
                        <div class="d-flex justify-content-center">
                            <button class="btn btn-success me-5" style="width: 150px" type="submit">Login</button>
                            <a href="/user/register" class="btn btn-primary" style="width: 150px">Register</a>
                        </div>
                        <div class="text-danger">${messagelogin}</div>
                    </form>
                </div>
            </div>
        </div>
</body>
<script>
    function showPassword(){
        var pw = document.getElementById("matkhau");
        if(pw.type==="password"){
            pw.type="text";
        }
        else {
            pw.type="password";
        }
    }
</script>
</html>