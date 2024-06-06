<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
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
    <title>Document</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Khách hàng</h1>
        <div class="d-flex justify-content-center mt-3">
            <form action="/admin/khachhangview/search" method="get">
                <div class="input-group" style="width: 555px">
                    <input type="text" class="form-control" name="tenkh" placeholder="Tìm kiếm tên">
                    <button class="btn btn-secondary" type="submit">Search</button>
                </div>
            </form>
        </div>
        <div style="margin-top: 55px">
            <form:form action="/admin/khachhangview/khachhang" method="post" modelAttribute="khachhang">
                <div class="d-flex justify-content-center">
                    <div>
                        ID:<form:input path="id" cssClass="form-control" cssStyle="width: 400px" readonly="true" />
                       <div class="mt-3">
                           Mã khách hàng:<form:input path="makh" cssClass="form-control" cssStyle="width: 400px"/>
                           <form:errors path="makh" cssClass="text-danger"/>
                       </div>
                        <div class="mt-3">
                            Trạng thái:
                            <form:radiobutton path="trangthai" value="true" cssClass="form-check-input ms-3"/> Hoạt động
                            <form:radiobutton path="trangthai" value="false" cssClass="form-check-input ms-3"/> Không hoạt động
                        </div>
                    </div>
                    <div style="margin-left: 128px">
                        Tên: <from:input path="tenkh" cssClass="form-control" cssStyle="width: 400px"/>
                        <form:errors path="tenkh" cssClass="text-danger"/>
                        <div class="mt-3">
                            Số điện thoại: <form:input path="sodt" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="text-center mt-3">
                    <button class="btn btn-success">Thêm khách hàng</button>
                </div>
            </form:form>
        </div>
        <div style="margin-top: 55px">
            <table class="table table-striped">
                <thead>
                    <th>Mã khách hàng</th>
                    <th>Tên khách hàng</th>
                    <th>Số điện thoại</th>
                    <th>Trạng thái</th>
                    <th>Action</th>
                </thead>
                <tbody>
                    <c:forEach var="kh" items="${lstkh.content}">
                        <tr>
                            <td>${kh.makh}</td>
                            <td>${kh.tenkh}</td>
                            <td>${kh.sodt}</td>
                            <td>${kh.trangthai?"Hoạt động":"Ngưng hoạt động"}</td>
                            <td>
                                <a href="/admin/khachhangview/update/${kh.id}" class="btn btn-primary">Xem</a>
                                <a href="/admin/khachhangview/delete/${kh.id}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="mt-3 text-center">
                <a href="/admin/khachhangview/khachhang" class="btn btn-secondary">First</a>
                <a href="/admin/khachhangview/khachhang?p=${lstkh.first?lstkh.totalPages-1:lstkh.number-1}" class="btn btn-secondary">Prev</a>
                <a href="/admin/khachhangview/khachhang?p=${lstkh.last?0:lstkh.number+1}" class="btn btn-secondary">Next</a>
                <a href="/admin/khachhangview/khachhang?p=${lstkh.totalPages-1}" class="btn btn-secondary">Last</a>
            </div>
        </div>
    </div>
</body>
</html>