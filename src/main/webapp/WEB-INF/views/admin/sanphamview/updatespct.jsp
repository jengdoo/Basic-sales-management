<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Chỉnh sửa</h1>
        <div class="mt-3">
            <form:form action="/admin/sanphamview/updatespct" modelAttribute="sanphamchitiet" method="post">
                ID: <form:input path="id" cssClass="form-control" readonly="true"/> <br>
                Mã spct: <form:input path="maspct" cssClass="form-control"/> <br>
                Sản phẩm ID: <form:input path="sanpham" cssClass="form-control" readonly="true"/> <br>
                <div>
                    Màu:
                    <form:select path="mausac" cssClass="form-select">
                            <form:options items="${lstmau}" itemValue="id" itemLabel="tenmau"/>
                    </form:select>
                </div>
                <br>
                <div>
                    Kích thước:
                    <form:select path="kichthuoc" cssClass="form-select">
                        <form:options items="${lstkt}" itemLabel="tenkt" itemValue="id"/>
                    </form:select>
                </div>
                <br>
                Số lượng: <form:input path="soluong" type="number" cssClass="form-control"/> <br>
                Giá: <form:input path="dongia" cssClass="form-control"/>
                <br>
                Trạng thái:
                <form:radiobutton path="trangthai" label="Còn hàng" value="true" cssClass="form-check-input ms-3" />
                <form:radiobutton path="trangthai" label="Hết hàng" value="false" cssClass="form-check-input ms-3"  />
                <div class="mt-3">
                    <button class="btn btn-warning">Update</button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>