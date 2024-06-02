<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" />
    <title>Document</title>
</head>
<body>
    <div>
        <h1>Sản phẩm chi tiết</h1>
        <div class="mt-3">
            <h3>Lọc sản phẩm chi tiết</h3>
           <div class="d-flex border">
              <div style="margin: 28px">
                  <h5>Màu</h5>
                  <form action="">
                      <select name="mausac" id="lstmau" class="form-select">
                          <option value="">---Chọn kích thước---</option>
                          <c:forEach var="mau" items="${lstmau}">
                              <option value="mau.id" label="${mau.tenmau}"></option>
                          </c:forEach>
                      </select>
                  </form>
              </div>
               <div style="margin: 28px">
                   <h5>Kích thước</h5>
                   <form action="">
                       <select name="kichthuoc" id="lstkt" class="form-select">
                           <option value="">---Chọn kích thước---</option>
                           <c:forEach var="kt" items="${lstkt}">
                                <option value="kt" label="${kt.tenkt}"></option>
                           </c:forEach>
                       </select>
                   </form>
               </div>
           </div>
        </div>
        <div class="d-flex ">
            <div style="width: calc(100% - 400px);" class="mt-3">
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
                        <th>action</th>
                    </thead>
                    <tbody>
                        <c:forEach var="spct" items="${lstspct.content}" varStatus="ct">
                            <tr>
                                <td> ${ct.index + 1}</td>
                                <td>${spct.maspct}</td>
                                <td>${spct.sanpham.tensp}</td>
                                <td>${spct.mausac.tenmau}</td>
                                <td>${spct.kichthuoc.tenkt}</td>
                                <td>${spct.soluong}</td>
                                <td>${spct.dongia}</td>
                                <td>${spct.trangthai?"Còn hàng":"Hết hàng"}</td>
                                <td>
                                    <a href="/admin/sanphamview/deletespct?id=${spct.id}" class="btn btn-danger">Delete</a>
                                    <a href="/admin/sanphamview/updatespct/${spct.id}" class="btn btn-warning">Update</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="mt-3 text-center">
                    <a href="/admin/sanphamview/sanphamchitiet" class="btn btn-secondary">First</a>
                    <a href="/admin/sanphamview/sanphamchitiet?p=${lstspct.number-1}" class="btn btn-secondary">Prev</a>
                    <a href="/admin/sanphamview/sanphamchitiet?p=${lstspct.number+1}" class="btn btn-secondary">Next</a>
                    <a href="/admin/sanphamview/sanphamchitiet?p=${lstspct.totalPages-1}" class="btn btn-secondary">Last</a>
                </div>
            </div>
            <div style="width: 400px;background-color: coral;min-height: 700px">
                <h5 class="text-center mt-3">Thêm sản phẩm</h5>
                <form:form method="post" action="/admin/sanphamview/sanphamchitiet?id=${sanphamid.id}" modelAttribute="sanphamchitiet" cssClass="m-3">

                    Mã sản phẩm ct: <form:input path="maspct" cssClass="form-control" />
                    <form:errors path="maspct" cssClass="text-danger"/><br>

                    Tên sản phẩm:
                    <form:input path="sanpham" value="${sanphamid.id}" type="text" cssClass="form-control" readonly="true" />
                    Màu sắc:
                    <div class="d-flex">
                        <form:select path="mausac" cssClass="form-select" cssStyle="width: 300px">
                            <option selected disabled hidden>---Chọn màu---</option>
                            <form:options items="${lstmau}" itemValue="id" itemLabel="tenmau"/>
                        </form:select>
                        <a href="/admin/sanphamview/mau" class="btn btn-light ms-3" style="width: 50px"><i class="fa-solid fa-plus"></i></a>
                    </div>
                    <form:errors path="mausac" cssClass="text-danger"/> <br>

                    Kích thước:
                    <div class="d-flex">
                        <form:select path="kichthuoc" cssClass="form-select" cssStyle="width: 300px">
                            <option selected disabled hidden>---Chọn kích thước---</option>
                            <form:options items="${lstkt}" itemValue="id" itemLabel="tenkt"/>
                        </form:select>
                        <a href="/admin/sanphamview/kichthuoc" class="btn btn-light ms-3" style="width: 50px"><i class="fa-solid fa-plus"></i></a>
                    </div>
                    <form:errors path="kichthuoc" cssClass="text-danger"/> <br>

                    Số lượng: <form:input path="soluong" type="number" cssClass="form-control" min="0"/>
                    <form:errors path="soluong" cssClass="text-danger"/> <br>
                    Đơn giá: <form:input path="dongia" type="number" cssClass="form-control" min="0"/>
                    <form:errors path="dongia" cssClass="text-danger"/>

                    <div class="mt-3 text-center">
                        <a href="/admin/sanphamview/sanpham" class="btn btn-secondary">Quay lại</a>
                        <button type="submit" class="btn btn-success">Thêm</button>
                    </div>

                    <div class="text-danger">${message}</div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>