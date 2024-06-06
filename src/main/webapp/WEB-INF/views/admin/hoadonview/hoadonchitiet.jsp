<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form action="/admin/hoadon/hoadonchitiet" name="hoadonchitiet" method="post">
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
                        <h5>HÓA ĐƠN #<%-- ${hoadonchitiet.hoadon.id}--%></h5>
                        <p><%-- ${hoadonchitiet.hoadon.ngaymuahang}--%></p>
                    </div>
                </div>
                <h2 style="margin-top: 28px">HÓA ĐƠN</h2>
                <div style="margin-top: 28px">
                    <h5>Tên khách hàng-<%-- ${hoadonchitiet.hoadon.khachhang.tenkh}--%></h5>
                    <p>Số điện thoại khách hàng: <%-- ${hoadonchitiet.hoadon.khachhang.sodt}--%> <br>
                        Địa chỉ khách hàng: chưa cập nhật
                    </p>
                </div>
                <div style="margin-top: 28px">
<%--                        Mã hóa đơn: <input type="text" value="${hoadonchitiet.hoadon.id}" class="form-control"> <br>--%>
                        <div style="margin-top: 28px">
                        <table class="table table-striped">
                            <thead>
                            <th>STT</th>
                            <th>Mã hóa đơn chi tiết</th>
                            <th>Mã SPCT</th>
                            <th>Ten san pham</th>
                            <th>Giá sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Tiền</th>
                            </thead>
                            <tbody>
                            <c:forEach var="hdct" items="${hoadonchitiet}" varStatus="stt">
                                <tr>
                                    <td>${stt.index+1}</td>
                                    <td>${hdct.id}</td>
                                    <td>${hdct.spct.maspct}</td>
                                    <td>${hdct.spct.sanpham.tensp}</td>
                                    <td>${hdct.spct.dongia}</td>
                                    <td>${hdct.soluong}</td>
                                    <td>${hdct.dongia}</td>
                                </tr>
<%--                                <tr>Trạng thái: <c:if test="${hoadonchitiet.trangthai==2}">Đã thanh toán</c:if></tr>--%>
                            </c:forEach>
                            </tbody>

                        </table>
                        </div>
                </div>
            </div>
                <a href="/admin/hoadonview/hoadon" class="btn btn-secondary">Quay lại</a>
            </form>
        </div>
    </div>
</body>
</html>