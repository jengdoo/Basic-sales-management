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
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <title>Forgot password</title>
</head>
<body>
    <div class="container d-flex justify-content-center">
        <div class="border" style="width: 600px">
            <div style="margin: 50px">
                <div class="mb-3">
                    <label class="form-label">Nhập email hoặc số điện thoại</label>
                    <input type="text" class="form-control" name="forgot" placeholder="nhập email hoặc số điện thoại">
                </div>
                <div class="text-end">
                    <button class="btn btn-success">Gửi</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>