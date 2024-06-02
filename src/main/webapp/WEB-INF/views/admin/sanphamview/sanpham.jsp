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
    <script>
        function changeStatus(){
            document.getElementById('formStatus').submit();
        }
    </script>
    <title>Sản phẩm</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Danh sách sản phẩm</h1>
        <form action="/admin/sanphamview/search" method="post" class="d-flex mt-3">
            <label class="form-label fs-3">Tên:</label>
            <input type="text" placeholder="Nhập tên sản phẩm..." class="form-control" style="width:550px" name="tensp">
            <button type="submit" class="btn btn-secondary">Search</button>
        </form>
        <h3 class="mt-3">Lọc sản phẩm</h3>
        <div class="border">
            <form id="formStatus" class="form-check" style="margin: 28px"  action="/admin/sanphamview/loc" method="post">
                        <h5>Trạng thái:</h5>
                <input class="form-check-input" type="radio" name="trangthai" value="true" onchange="changeStatus()"> Còn hàng <br>
                <input class="form-check-input" type="radio" name="trangthai" value="false" onchange="changeStatus()"> Hết hàng
            </form>
        </div>
        <div class="mt-3 text-end">
            <a href="/admin/sanphamview/add" class="btn btn-success">Thêm sản phẩm</a>
        </div>
        <div class="mt-3">
            <table class="table">
                <thead >
                    <th>ID</th>
                    <th>Mã sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Trạng thái</th>
                    <th>Action</th>
                </thead>
                <tbody>
                    <c:forEach var="sp" items="${lstsp.content}">
                        <tr>
                            <td>${sp.id}</td>
                            <td>${sp.masp}</td>
                            <td>${sp.tensp}</td>
                            <td>${sp.trangthai?"Còn hàng":"Hết hàng"}</td>
                            <td>
                                <a href="/admin/sanphamview/delete/${sp.id}" class="btn btn-danger">Xóa</a>
                                <a href="/admin/sanphamview/sanphamchitiet?id=${sp.id}" class="btn btn-warning">Sản phẩm chi tiết</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="text-center mt-3">
                <a href="/admin/sanphamview/sanpham" class="btn btn-secondary">First</a>
                <a href="/admin/sanphamview/sanpham?p=${lstsp.number-1}" class="btn btn-secondary">Prev</a>
                <a href="/admin/sanphamview/sanpham?p=${lstsp.number+1}" class="btn btn-secondary">Next</a>
                <a href="/admin/sanphamview/sanpham?p=${lstsp.totalPages-1}" class="btn btn-secondary">Last</a>
            </div>
        </div>
    </div>
</body>
</html>