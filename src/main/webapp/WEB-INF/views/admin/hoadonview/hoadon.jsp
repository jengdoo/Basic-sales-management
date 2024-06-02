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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
    <title>Hóa đơn</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Hóa đơn</h1>
        <div class="d-flex justify-content-center mt-3">
           <div class="rounded-pill" style="background-color: lightgrey;width: 228px">
               <div class="text-center m-3">
                   <h5>Tổng số hóa đơn</h5>
                   <div>7</div>
               </div>
           </div>
            <div class="rounded-pill" style="background-color:  lightgrey;width: 228px;margin-left: 190px">
                <div class="text-center m-3">
                    <h5>Tổng số tiền</h5>
                    <div>12.2323 $</div>
                </div>
            </div>
            <div class="rounded-pill" style="background-color:  lightgrey;width: 228px;margin-left: 190px">
                <div class="text-center m-3">
                    <h5>Chưa thanh toán</h5>
                    <div>${hoadoncho}</div>
                </div>
            </div>
        </div>
        <div class="mt-3">
            <form action="">
                <div class="d-flex justify-content-center">
                    <div class="input-group"  style="width: 428px">
                        <input type="text" name="" class="form-control" placeholder="Nhập số hóa đơn">
                        <button class="btn btn-secondary" type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </div>
            </form>
        </div>
        <div style="margin-top: 55px">
            <table class="table table-striped">
                <thead>
                    <th>Mã hóa đơn</th>
                    <th>Trạng thái</th>
                    <th>Người nhận</th>
                    <th>Nhân viên</th>
                    <th>Ngày mua</th>
                    <th>Action</th>
                </thead>
                <tbody>
                    <c:forEach var="hd" items="${lsthd.content}" >
                        <tr>
                            <td>${hd.id}</td>
                            <td>
                                <c:if test="${hd.trangthai==0}">Chờ thanh toán</c:if>
                                <c:if test="${hd.trangthai==1}">Hóa đơn bị hủy</c:if>
                                <c:if test="${hd.trangthai==2}">Đã thanh toán</c:if>
                            </td>
                            <td>${hd.khachhang.tenkh}</td>
                            <td>${hd.nhanvien.ten}</td>
                            <td>${hd.ngaymuahang}</td>
                            <td>
                                <a href="" class="btn btn-primary">Xem</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-center mt-3">
                <a href="/admin/hoadonview/hoadon" class="btn btn-secondary">First</a>
                <a href="/admin/hoadonview/hoadon?p=${lsthd.first?lsthd.totalPages-1:lsthd.number-1}" class="btn btn-secondary">Prev</a>
                <a href="/admin/hoadonview/hoadon?p=${lsthd.last?0:lsthd.number+1}" class="btn btn-secondary">Next</a>
                <a href="/admin/hoadonview/hoadon?p=${lsthd.totalPages-1}" class="btn btn-secondary">Last</a>
            </div>
        </div>
    </div>
</body>
</html>