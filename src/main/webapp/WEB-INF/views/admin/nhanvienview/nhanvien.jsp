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
    <title>Nhân viên</title>
</head>
<body>
    <div class="">
        <h1 class="text-center">Nhân Viên</h1>
        <form action="/admin/nhanvienview/search" method="get">
            <div class="d-flex mt-3">
                Tên: <input type="text" name="ten" class="form-control" style="width: 350px">
                <button type="submit" class="btn btn-secondary ms-3">Search</button>
            </div>
        </form>
        <h3>Lọc nhân viên</h3>
        <div class="border mt-3">
            <h5 style="margin: 28px" class="text-center">Chưa update...</h5>
        </div>
        <div class="mt-3">
            <form:form action="/admin/nhanvienview/nhanvienadd" method="post" modelAttribute="nhanvien">
                <div class="d-flex">
                    <div style="margin-left: 90px">
<%--                        ID: <form:input path="id" cssClass="form-control" cssStyle="width: 500px;"/>--%>
<%--                        <form:errors path="id" cssClass="text-danger"/> <br>--%>
                        Tên nhân viên: <form:input path="ten" cssClass="form-control" cssStyle="width: 500px;"/>
                        <form:errors path="tendangnhap" cssClass="text-danger"/> <br>
                        Mã nhân viên: <form:input path="manv" cssClass="form-control"/>
                        <form:errors path="manv" cssClass="text-danger"/> <br>
                        Trạng thái:
                        <form:radiobutton path="trangthai" cssClass="form-check-input ms-3" value="true"/>Còn hoạt động
                        <form:radiobutton path="trangthai" cssClass="form-check-input ms-3" value="false"/>Dừng hoạt động
                    </div>
                    <div class="" style="margin-left: 90px">
                        Tên đăng nhập: <form:input path="tendangnhap" cssClass="form-control" cssStyle="width: 500px;"/>
                        <form:errors path="tendangnhap" cssClass="text-danger"/> <br>
                        Mật khẩu: <form:input path="matkhau" type="password" cssClass="form-control"/>
                        <form:errors path="matkhau" cssClass="text-danger"/> <br>
                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-success mt-3">Thêm nhân viên</button>
                </div>
            </form:form>
        </div>
        <div class="mt-3">
            <table class="table">
                <thead>
                    <th>STT</th>
                    <th>Mã nhân viên</th>
                    <th>Tên nhân viên</th>
                    <th>Tên đăng nhập</th>
                    <th>Mật khẩu</th>
                    <th>Trạng thái</th>
                    <th>Action</th>
                </thead>
                <tbody>
                    <c:forEach items="${lstnv.content}" var="nv" varStatus="d">
                        <tr>
                            <td>${d.index + 1}</td>
                            <td>${nv.manv}</td>
                            <td>${nv.ten}</td>
                            <td>${nv.tendangnhap}</td>
                            <td>
                                <input type="password" value="${nv.matkhau}" id="password${d.index}" style="width: 100px">
                                <input type="checkbox" onclick="show(${d.index})" class="form-check-input" id="showid${d.index}">Show
                            </td>
                            <td>${nv.trangthai?"Hoạt động":"Ngưng hoạt động"}</td>
                            <td>
                                <a href="/admin/nhanvienview/delete?id=${nv.id}" class="btn btn-danger">Delete</a>
                                <a href="/admin/nhanvienview/detail/${nv.id}" class="btn btn-warning">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="mt-3 text-center">
                <a href="/admin/nhanvienview/nhanvien" class="btn btn-secondary">First</a>
                <a href="/admin/nhanvienview/nhanvien?p=${lstnv.first?lstnv.totalPages-1:lstnv.number-1}" class="btn btn-secondary">Prev</a>
                <a href="/admin/nhanvienview/nhanvien?p=${lstnv.last?0:lstnv.number+1}" class="btn btn-secondary">Next</a>
                <a href="/admin/nhanvienview/nhanvien?p=${lstnv.totalPages-1}" class="btn btn-secondary">Last</a>
            </div>
        </div>
    </div>
</body>
<script>
    function show(index){
        var pass = document.getElementById("password"+index);
        var checkbox = document.getElementById("showid"+index);
        if(checkbox.checked){
            pass.type = "text";
        }
        else {
            pass.type = "password";
        }
    }
</script>
</html>