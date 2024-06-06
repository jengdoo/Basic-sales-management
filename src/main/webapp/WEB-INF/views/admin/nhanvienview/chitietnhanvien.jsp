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
    <title>Document</title>
</head>
<body>
<div class="container">
    <form:form action="/admin/nhanvienview/detail" method="post" modelAttribute="nhanvien">
        ID: <form:input path="id" cssClass="form-control" cssStyle="width: 500px;"/>
        <form:errors path="id" cssClass="text-danger"/> <br>
        Mã nhân viên: <form:input path="manv" cssClass="form-control"/>
        <form:errors path="manv" cssClass="text-danger"/> <br>
        Tên nhân viên: <form:input path="ten" cssClass="form-control" cssStyle="width: 500px;"/>
        <form:errors path="tendangnhap" cssClass="text-danger"/> <br>
        Tên đăng nhập: <form:input path="tendangnhap" cssClass="form-control" cssStyle="width: 500px;"/>
        <form:errors path="tendangnhap" cssClass="text-danger"/> <br>
        Mật khẩu: <form:input path="matkhau" type="password" id="inputPassword" cssClass="form-control"/>
        <input type="checkbox" onclick="showPassword()" class="form-check-input">Hiển thị mật khẩu</input>
        <form:errors path="matkhau" cssClass="text-danger"/> <br>
        Trạng thái:
        <form:radiobutton path="trangthai" cssClass="form-check-input ms-3" value="true"/>Còn hoạt động
        <form:radiobutton path="trangthai" cssClass="form-check-input ms-3" value="false"/>Dừng hoạt động
        <div class="text-center">
            <a href="/admin/nhanvienview/nhanvien" class="btn btn-secondary">Quay lại</a>
            <button class="btn btn-warning ms-3">Update</button></div>
    </form:form>
</div>
</body>
<script>
    function showPassword(){
        var passwordInput = document.getElementById("inputPassword");
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
        } else {
            passwordInput.type = "password";
        }
    }
</script>
</html>