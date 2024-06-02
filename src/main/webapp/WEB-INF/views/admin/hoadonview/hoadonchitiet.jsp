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
    <title>Hóa đơn chi tiết</title>
</head>
<body>
    <div class="container">
        <div class="border mt-3">
            <div style="margin-left: 55px">
                <div class="d-flex justify-content-between">
                    <div class="d-flex" style="margin-top: 28px">
                        <div><a href=""><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqHALeOVCwWJS1twz5knDoThfoFEyLH40j_w&s" style="width: 100px"></a></div>
                        <div>
                            <h5>Fashion store</h5>
                            <p>webthoitrang.com</p>
                        </div>
                    </div>
                    <div style="margin-top: 28px;margin-right: 55px">
                        <h5>HÓA ĐƠN #123</h5>
                        <p>ngày...tháng...năm</p>
                    </div>
                </div>
                <h2 style="margin-top: 28px">HÓA ĐƠN</h2>
                <div style="margin-top: 28px">
                    <h5>Tên khách hàng</h5>
                    <p>Số điện thoại khách hàng:0000 <br>
                        Địa chỉ khách hàng: abcc
                    </p>
                </div>
                <div style="margin-top: 28px">
                    <table class="table">
                        <thead>
                            <th>Số hóa đơn</th>
                            <th>Sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Đơn giá</th>
                        </thead>
                        <tbody>
                            <tr></tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    </div>
</body>
</html>