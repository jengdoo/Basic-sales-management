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
    <title>Chi tiết khách hàng</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Chi tiết khách hàng</h1>
        <div style="margin-top: 55px">
            <form:form action="/admin/khachhangview/update" method="post" modelAttribute="khachhang">
                ID:<form:input path="id" readonly="true" cssClass="form-control"/>
                <div class="mt-3">
                    Mã khách hàng: <form:input path="makh" cssClass="form-control"/>
                </div>
                <form:errors cssClass="text-danger" path="makh"/>
                <div class="mt-3">
                    Tên khách hàng: <form:input path="tenkh" cssClass="form-control"/>
                </div>
                <form:errors path="tenkh" cssClass="text-danger"/>
                <div class="mt-3">
                    Số điện thoại: <form:input path="sodt" cssClass="form-control"/>
                </div>
                <div class="mt-3">
                    Trạng thái:
                    <form:radiobutton path="trangthai" cssClass="form-check-input" value="true"/> Hoạt động
                    <form:radiobutton path="trangthai" cssClass="form-check-input" value="false"/> Ngưng hoạt động
                </div>
                <div class="mt-3 text-center">
                    <a href="/admin/khachhangview/khachhang" class="btn btn-secondary">Quay lại</a>
                    <button class="btn btn-warning" type="submit">Update</button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>