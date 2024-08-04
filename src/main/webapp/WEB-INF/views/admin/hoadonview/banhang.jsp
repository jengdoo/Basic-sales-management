<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Bán hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 30px;
        }
        .border-custom {
            border: 1px solid #e0e0e0;
            border-radius: 10px;
            padding: 20px;
            background-color: #ffffff;
        }
        .form-control, .form-select {
            height: 45px;
        }
        .btn-custom {
            margin-left: 10px;
        }
        .d-flex-justify-between {
            display: flex;
            justify-content: space-between;
        }
        .action-buttons {
            margin-top: 20px;
        }
        .mt-3-custom {
            margin-top: 30px;
        }
        .btn {
            border-radius: 20px;
        }
        .table thead th {
            background-color: #007bff;
            color: white;
        }
        .table tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .table tbody tr:hover {
            background-color: #e9ecef;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center mb-4">Bán hàng</h1>
    <div class="row">
        <div class="col-md-12">
            <!-- Invoice Management Section -->
            <div class="border-custom mb-4">
                <h5 class="mb-4">Hóa đơn chờ</h5>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Mã hóa đơn</th>
                        <th>Ngày mua</th>
                        <th>Người nhận</th>
                        <th>Nhân viên</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="hdbh" items="${lsthd}">
                        <tr>
                            <td>${hdbh.id}</td>
                            <td>${hdbh.ngaymuahang}</td>
                            <td>${hdbh.khachhang.tenkh}</td>
                            <td>${hdbh.nhanvien.ten}</td>
                            <td>
                                <a href="/admin/hoadonview/huyhoadon?id=${hdbh.id}" class="btn btn-warning btn-sm">Hủy</a>
                                <a href="/admin/hoadonview/choose/${hdbh.id}" class="btn btn-primary btn-sm">Chọn</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <!-- Tạo hóa đơn -->
            <div class="border-custom mb-4">
                <h5 class="mb-3">Tạo hóa đơn</h5>
                <form:form action="/admin/hoadonview/taoHD" method="post" modelAttribute="hoaDon">
                    <div class="text-success mb-3">${messagehd}</div>
                    <div class="text-danger">${errors}</div>
                    <div class="mb-3">
                        <label for="nhanvien" class="form-label">Nhân viên</label>
                        <select id="nhanvien" name="nhanvien" class="form-select">
                            <c:forEach var="nv" items="${lstNhanVien}">
                                <option value="${nv.id}">${nv.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="khachhang" class="form-label">Khách hàng</label>
                        <select id="khachhang" name="khachhang" class="form-select">
                            <c:forEach var="kh" items="${lstKhachHang}">
                                <option value="${kh.id}">${kh.tenkh}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="ngaymuahang" class="form-label">Ngày mua</label>
                        <input type="date" id="ngaymuahang" name="ngaymuahang" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success w-100">Tạo hóa đơn</button>
                </form:form>
            </div>

            <!-- Giỏ hàng -->
            <div class="border-custom mt-3-custom">
                <h5 class="mb-3">Giỏ hàng</h5>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên SP</th>
                        <th>Mã SP</th>
                        <th>Số lượng</th>
                        <th>Đơn giá</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="gh" items="${gioHang}" varStatus="stt">
                        <tr>
                            <td>${stt.index + 1}</td>
                            <td>${gh.sanpham.tensp}</td>
                            <td>${gh.sanpham.masp}</td>
                            <td>${gh.soluong}</td>
                            <td>${gh.dongia}</td>
                            <td>
                                <a href="/admin/hoadonview/updategiohang?id=${gh.id}&action=decrease" class="btn btn-danger btn-sm">-</a>
                                <a href="/admin/hoadonview/updategiohang?id=${gh.id}&action=increase" class="btn btn-primary btn-sm">+</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!-- Purchase Form -->
                <div class="row mt-4">
                    <div class="col-md-6">
                        <form action="/admin/hoadonview/muaSPCT" method="post">
                            <div class="mb-3">
                                <label for="hoadonId" class="form-label">Mã HD:</label>
                                <input type="text" id="hoadonId" name="hoadon" value="${hoadon.id}" readonly class="form-control">
                            </div>
                            <div class="text-danger">${info}</div>
                            <div class="mb-3">
                                <label for="soluong" class="form-label">Số lượng:</label>
                                <input type="text" id="soluong" name="soluong" value="${hoadonchitiet.soluong}" readonly class="form-control">
                                <small class="form-text text-muted">VNĐ</small>
                            </div>
                            <div class="mb-3">
                                <label for="dongia" class="form-label">Tổng tiền:</label>
                                <input type="text" id="dongia" name="dongia" value="${hoadonchitiet.dongia}" readonly class="form-control">
                                <small class="form-text text-muted">VNĐ</small>
                            </div>
                            <div class="mb-3">
                                <label for="tienKhachDua" class="form-label">Tiền khách đưa:</label>
                                <input type="text" id="tienKhachDua" name="tienKhachDua" value="${tienKhachDua}" class="form-control">
                                <small class="form-text text-muted">VNĐ</small>
                            </div>
                            <div class="mb-3">
                                <span class="text-danger">${errorMessage}</span>
                            </div>
                            <div class="mb-3">
                                <strong>Tiền thừa: ${tienThua} VNĐ</strong>
                            </div>
                            <button type="submit" class="btn btn-success w-100">Thanh toán</button>
                        </form>
                    </div>
                </div>
            </div>

            <!-- Product List -->
            <div class="border-custom mt-3-custom">
                <h5 class="mb-3">Danh sách sản phẩm</h5>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Tên sản phẩm</th>
                        <th>Màu sắc</th>
                        <th>Kích thước</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Hành động</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="spct" items="${lstspct.content}">
                        <tr>
                            <td>${spct.sanpham.tensp}</td>
                            <td>${spct.mausac.tenmau}</td>
                            <td>${spct.kichthuoc.tenkt}</td>
                            <td>${spct.dongia}</td>
                            <td>${spct.soluong}</td>
                            <td>
                                <a href="<c:url value='/admin/hoadonview/muahang?id=${spct.id}'/>" class="btn btn-info btn-sm">Thêm vào giỏ</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-pH5bLg02y4vOQ6hKojYbT62bdXIb0sm3FdFToQ6S37cHFF7fpp46LMEcFwFDC6cE" crossorigin="anonymous"></script>
</body>
</html>
