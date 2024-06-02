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
    <h1 class="text-center">Màu sắc</h1>
    <div class="d-flex justify-content-center mt-3">
        <form action="/admin/sanphamview/searchmau" method="get">
            <div class="input-group" style="width: 555px">
                <input type="text" class="form-control" name="tenmau" placeholder="Tìm kiếm tên">
                <button class="btn btn-secondary" type="submit">Search</button>
            </div>
        </form>
    </div>
    <div style="margin-top: 55px">
        <form:form action="/admin/sanphamview/mau" method="post" modelAttribute="mausac">
            <div class="d-flex justify-content-center">
                <div>
                    ID:<form:input path="id" cssClass="form-control" cssStyle="width: 400px"/>
                    <div class="mt-3">
                        Mã màu:<form:input path="mamau" cssClass="form-control" cssStyle="width: 400px"/>
                        <form:errors path="mamau" cssClass="text-danger"/>
                    </div>
                </div>
                <div style="margin-left: 128px">
                    Tên màu: <from:input path="tenmau" cssClass="form-control" cssStyle="width: 400px"/>
                    <form:errors path="tenmau" cssClass="text-danger"/>
                    <div class="mt-3">
                        Trạng thái:
                        <form:radiobutton path="trangthai" value="true" cssClass="form-check-input ms-3"/> Còn
                        <form:radiobutton path="trangthai" value="false" cssClass="form-check-input ms-3"/> Hết
                    </div>
                </div>
            </div>
            <div class="text-center mt-3">
                <button class="btn btn-success">Thêm màu</button>

            </div>
        </form:form>
    </div>
    <div style="margin-top: 55px">
        <table class="table table-striped">
            <thead>
            <th>Mã màu</th>
            <th>Tên màu</th>
            <th>Trạng thái</th>
            <th>Action</th>
            </thead>
            <tbody>
            <c:forEach var="mau" items="${lstmau.content}">
                <tr>
                    <td>${mau.mamau}</td>
                    <td>${mau.tenmau}</td>
                    <td>${mau.trangthai?"Còn":"Hết"}</td>
                    <td>
                        <a href="/admin/sanphamview/updateMau/${mau.id}" class="btn btn-primary">Chi tiết</a>
                        <a href="/admin/sanphamview/deleteMau?id=${mau.id}" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="mt-3 text-center">
            <a href="/admin/sanphamview/mau" class="btn btn-secondary">First</a>
            <a href="/admin/sanphamview/mau?p=${lstmau.first?lstmau.totalPages-1:lstmau.number-1}" class="btn btn-secondary">Prev</a>
            <a href="/admin/sanphamview/mau?p=${lstmau.last?0:lstmau.number+1}" class="btn btn-secondary">Next</a>
            <a href="/admin/sanphamview/mau?p=${lstmau.totalPages-1}" class="btn btn-secondary">Last</a>
        </div>
    </div>
</div>
</body>
</html>