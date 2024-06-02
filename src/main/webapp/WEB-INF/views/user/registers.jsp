<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Register</title>
</head>
<body>
    <div class="container d-flex justify-content-center">
        <div class="border" style="width: 600px;margin-top: 150px;margin-bottom: 150px;">
            <h1 class="text-center mt-3">REGISTER</h1>
            <form:form action="/user/register" method="post" modelAttribute="nhanvien" class="mt-3" style="margin-right: 90px;margin-left: 90px;margin-bottom: 90px">
                <div class="mb-3">
                    <label class="form-label">Id:</label>
                    <form:input path="id" class="form-control" placeholder="id..."/>
                    <form:errors path="id" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Mã nhân viên:</label>
                    <form:input path="manv"  class="form-control" placeholder="mã..."/>
                    <form:errors path="manv" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label class="form-label">Tên:</label>
                    <form:input path="tendangnhap"  class="form-control" placeholder="tên..."/>
                    <form:errors path="tendangnhap" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Mật khẩu:</label>
                    <form:input path="matkhau" type="password" class="form-control" placeholder="mật khẩu..."/>
                    <form:errors path="matkhau" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">Xác nhận mật khẩu:</label>
                    <input type="password" class="form-control" placeholder="xác nhận mật khẩu..." name="xacnhanmatkhau">
                </div>
                <div class="text-danger">
                        ${messagepass}
                </div>
                <div class="mb-3">
                    <label class="form-label">Vai trò:</label>
                    <div class="d-flex">
                        <div class="form-check me-3">
                            <form:radiobutton path="trangthai" class="form-check-input" value="true" disabled="true"/>
                            <label class="form-check-label">Admin</label>
                        </div>
                        <div class="form-check">
                            <form:radiobutton path="trangthai" class="form-check-input" value="false"/>
                            <label class="form-check-label">Nhân viên</label>
                        </div>
                    </div>
                    <form:errors path="trangthai" cssClass="text-danger"/>
                </div>
                <div class="text-center">
                    <button type="submit"  class="btn btn-success">Đăng ký</button>
                    <a href="/user/logins" class="btn btn-secondary">Đăng nhập</a>
                </div>
                <div class="text-success">
                        ${message}
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>