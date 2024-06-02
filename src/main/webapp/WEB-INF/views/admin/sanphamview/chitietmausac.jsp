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
    <title>Chi tiết màu</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Chi tiết màu</h1>
        <div style="margin-top: 55px">
            <form:form action="/admin/sanphamview/updateMau" method="post" modelAttribute="mausac">
                ID:<form:input path="id" cssClass="form-control" cssStyle="width: 400px" readonly="true"/>
                <div class="mt-3">
                    Mã màu:<form:input path="mamau" cssClass="form-control" cssStyle="width: 400px"/>
                    <form:errors path="mamau" cssClass="text-danger"/>
                </div>
                <div class="mt-3">
                    Tên màu: <form:input path="tenmau" cssClass="form-control" cssStyle="width: 400px"/>
                    <form:errors path="tenmau" cssClass="text-danger"/>
                </div>
                <div class="mt-3">
                    Trạng thái:
                    <form:radiobutton path="trangthai" value="true" cssClass="form-check-input ms-3"/> Còn
                    <form:radiobutton path="trangthai" value="false" cssClass="form-check-input ms-3"/> Hết
                </div>
                <div class="text-center mt-3">
                    <a href="/admin/sanphamview/mau" class="btn btn-secondary">Quay lại</a>
                    <button class="btn btn-warning">Update mau</button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>