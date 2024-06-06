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
    <title>Bán hàng</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Bán hàng</h1>
            <div class="d-flex">
                <div style="width: 100%">
                    <div class="border">
                        <div style="margin: 28px">
                            <div class="d-flex">
                                <div>
                                    <h5>Hóa đơn chờ</h5>
                                    <table class="table">
                                        <thead>
                                        <th>Mã hóa đơn</th>
                                        <th>Ngày mua</th>
                                        <th>Người nhận</th>
                                        <th>Nhân viên</th>
                                        <th>Action</th>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="hdbh" items="${lsthd}">
                                            <tr>
                                                <td>${hdbh.id}</td>
                                                <td>${hdbh.ngaymuahang}</td>
                                                <td>${hdbh.khachhang.tenkh}</td>
                                                <td>${hdbh.nhanvien.ten}</td>
                                                <td>
                                                    <a href="/admin/hoadonview/huyhoadon?id=${hdbh.id}" class="btn btn-warning">Hủy</a>
                                                    <a href="/admin/hoadonview/choose/${hdbh.id}" class="btn btn-primary">Chọn</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div style="margin-left: 100px;">
                                    <h5>Hóa đơn</h5>
                                    <form action="/admin/hoadonview/taoHD" method="post">
                                        <div class="text-success">${messagehd}</div>
                                        <div class="d-flex">
                                            <div class="border">
                                                <div class="d-flex mt-2 ms-2">
                                                    <p>Nhân viên</p>
                                                    <select name="nhanvien" class="form-select" style="width: 150px;height: 38px">
                                                        <c:forEach var="nv" items="${lstNhanVien}">
                                                            <option value="${nv.id}" label="${nv.ten}"></option>
                                                        </c:forEach>
                                                    </select>
                                                    <a href="/admin/nhanvienview/nhanvien" class="btn btn-success mb-3" style="margin-left: 88px">Cập nhật</a>
                                                </div>
                                                <div class="d-flex mt-2 ms-2">
                                                    <p>Khách hàng</p>
                                                    <select name="khachhang" class="form-select" style="width: 150px;height: 38px">
                                                        <c:forEach var="kh" items="${lstKhachHang}">
                                                            <option value="${kh.id}" label="${kh.tenkh}"></option>
                                                        </c:forEach>
                                                    </select>
                                                    <a href="/admin/khachhangview/khachhang" class="btn btn-success mb-3" style="margin-left: 88px">Cập nhật</a>
                                                </div>
                                            </div>
                                            <div class="border ms-3">
                                                <div class="mt-2 ms-2 me-3">
                                                    <div>
                                                        <label class="form-label">
                                                            Mã hóa đơn
                                                        </label>
                                                    </div>
                                                    <div class="mt-3 mb-3">
                                                        <button class="btn btn-success" style="width: 100%">Tạo hóa đơn</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div style="margin-top: 84px">
                        <div class="border">
                            <div style="margin: 28px">
                                <div class="d-flex">
                                    <div>
                                        <h5>Giỏ hàng</h5>
                                        <table class="table">
                                            <thead>
                                            <th>STT</th>
                                            <th>Tên SP</th>
                                            <th>Mã SP</th>
                                            <th>Số lượng</th>
                                            <th>Đơn giá</th>
                                            <th>Action</th>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="gh" items="${gioHang}" varStatus="stt">
                                                <tr>
                                                    <td>${stt.index+1}</td>
                                                    <td>${gh.id}</td>
                                                    <td>${gh.sanpham.tensp}</td>
                                                    <td>${gh.soluong}</td>
                                                    <td>${gh.dongia}</td>
                                                    <td>
                                                    <td>
                                                        <a href="/admin/hoadonview/updategiohang?id=${gh.id}&action=decrease" class="btn btn-danger">-</a>
                                                        <a href="/admin/hoadonview/updategiohang?id=${gh.id}&action=increase" class="btn btn-primary">+</a>
                                                    </td>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div style="margin-left: 150px">
                                        <form action="/admin/hoadonview/muaSPCT" method="post" name="hoadonchitiet">
                                            <div class="d-flex">
                                                    <div>
                                                        <div class="d-flex">
                                                            <strong>Ma HD:</strong>
                                                            <form name="hoadon" method="post" action="/admin/hoadon/choose">
                                                                <input type="text" name="hoadon" value="${hoadon.id}" readonly class="form-control" style="height: 28px;width: 155px">
                                                            </form>
                                                        </div>
                                                        <div class="d-flex mt-3">
                                                            <strong>Số lượng:</strong>
                                                            <input type="text" id="tongSoLuong" class="form-control" name="soluong" value="${hoadonchitiet.soluong}" style="height: 28px;width: 128px" readonly><strong class="ms-3">VNĐ</strong>
                                                        </div>
                                                        <div class="d-flex mt-3">
                                                            <strong>Tổng tiền:</strong>
                                                            <input type="text" id="tongGia" name="dongia" class="form-control" value="${hoadonchitiet.dongia}" style="height: 28px;width: 128px" readonly>
                                                            <strong class="ms-3">VNĐ</strong>
                                                        </div>
                                                    </div>
                                                    <div style="margin-left: 55px">
                                                        <div class="d-flex">
                                                            <strong>SPCT:</strong>
                                                            <select name="spct" id="sanphamchitietId" class="form-select ms-3" style="height: 32px;width: 250px;">
                                                                <c:forEach var="gh" items="${gioHang}">
                                                                    <option value="${gh.id}" label="${gh.id}"></option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="d-flex mt-3">
                                                            <strong>Tiền khách đưa:</strong>
                                                            <input type="text" class="form-control ms-3" style="width: 150px;height: 28px" name="tienKhachDua" value="${tienKhachDua}">
                                                            <strong class="ms-3">VNĐ</strong>
                                                        </div>
                                                        <div>${errorMessage}</div>
                                                        <div class="mt-3">
                                                            <strong>Tiền thừa:</strong> ${tienThua}
                                                        </div>
                                                        <div class="mt-3">
                                                            <button class="btn btn-danger">Mua</button>
                                                        </div>
                                                    </div>
                                            </div>
                                        </form>
                                        <form action="/admin/hoadonview/muahang" method="get" name="hoadonchitiet">
                                            <div class="d-flex justify-content-center mt-3">
                                                <a href="" class="btn btn-success" style="width: 120px">Hủy</a>
                                                <a href="/admin/hoadonview/thanhtoan?id=${hoadon.id}" class="btn btn-success" style="width: 120px;margin-left: 55px">Thanh toán</a>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div style="margin-top: 55px;width: 100%">
                <div>
                    <div class="text-danger">${messagesoluong}</div>
                    <table class="table">
                        <thead>
                        <th>STT</th>
                        <th>Mã SPCT</th>
                        <th>Tên sản phẩm</th>
                        <th>Màu</th>
                        <th>Kích thước</th>
                        <th>số lượng</th>
                        <th>đơn giá</th>
                        <th>trạng thái</th>
                        <th>Action</th>
                        </thead>
                        <tbody>
                        <c:forEach var="spct" items="${lstspct.content}" varStatus="ct">
                            <tr>
                                <td>${ct.index + 1}</td>
                                <td>${spct.maspct}</td>
                                <td>${spct.sanpham.tensp}</td>
                                <td>${spct.mausac.tenmau}</td>
                                <td>${spct.kichthuoc.tenkt}</td>
                                <td>${spct.soluong}</td>
                                <td>${spct.dongia}</td>
                                <td>${spct.trangthai?"Còn hàng":"Hết hàng"}</td>
                                <td>
                                    <a href="/admin/hoadonview/muahang?id=${spct.id}" class="btn btn-primary">Mua</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="mt-3 text-center">
                        <a href="/admin/hoadonview/banhang" class="btn btn-secondary">First</a>
                        <a href="/admin/hoadonview/banhang?p=${lstspct.first?lstspct.totalPages-1:lstspct.number-1}" class="btn btn-secondary">Prev</a>
                        <a href="/admin/hoadonview/banhang?p=${lstspct.last?0:lstspct.number+1}" class="btn btn-secondary">Next</a>
                        <a href="/admin/hoadonview/banhang?p=${lstspct.totalPages-1}" class="btn btn-secondary">Last</a>
                    </div>
                </div>
            </div>
    </div>
</body>
</html>