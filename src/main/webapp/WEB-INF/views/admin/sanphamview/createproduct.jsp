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
    <title>Thêm sản phẩm</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Thêm sản phẩm</h1>
        <form:form cssClass="mt-3" modelAttribute="sanpham" action="/admin/sanphamview/add" method="post">
            ID:<form:input path="id" cssClass="form-control"/> <br>
            <form:errors path="id" cssClass="text-danger"/>
            Mã sản phẩm:<form:input path="masp" cssClass="form-control"/> <br>
            <form:errors path="masp" cssClass="text-danger"/>
            Tên sản phẩm:<form:input path="tensp" cssClass="form-control"/> <br>
            <form:errors path="tensp" cssClass="text-danger"/>
            <label class="form-label me-3">Trạng thái:</label>
            <form:radiobutton path="trangthai" cssClass="form-check-input" value="true"/>Còn hàng
            <form:radiobutton path="trangthai" cssClass="form-check-input ms-3" value="false"/>Hết hàng <br>
            <form:errors path="trangthai" cssClass="text-danger"/>
            <button class="btn btn-success mt-3" type="submit">Thêm</button>
        </form:form>
    </div>
</body>
</html>