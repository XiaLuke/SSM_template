<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生信息</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <script type="text/javascript"
            src="${APP_PATH}/static/js/jquery-3.6.0.min.js"></script>
    <link
            href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <link href="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js">
</head>
<body>
<!-- 显示页面 -->
<div class="container">
    <!-- title -->
    <div class="row">
        <div class="col-md-12">
            <h1>SSM_Template</h1>
        </div>
    </div>
    <!-- button -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <!-- dataContext -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover">
                <tr>
                    <th>姓名</th>
                    <th>邮箱</th>
                    <th>电话</th>
                    <th>所属</th>
                    <th>学号</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="student">
                    <tr>
                        <th>${student.realName}</th>
                        <th>${student.email}</th>
                        <th>${student.phone}</th>
                        <th>${student.collegeProfessionalClass}</th>
                        <th>${student.studentId}</th>
                        <th>
                            <button class="glyphicon glyphicon-pencil btn-sm">编辑</button>
                            <button class="glyphicon glyphicon-trash btn-sm">删除</button>
                        </th>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
    <!-- pageInfo -->
    <div class="row">
        <%-- 分页文字 --%>
        <div class="col-md-6">
            当前页：${pageInfo.pageNum},共有${pageInfo.pages}页,共有数据：${pageInfo.total}
        </div>
        <%-- 分页条--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination pagination-sm">
                    <li><a href="${APP_PATH}/student/list?page=1&size=10">首页</a></li>
                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${APP_PATH}/student/list?page=${pageInfo.pageNum-1}&size=10"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                        <c:if test="${page_num == pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_num}</a></li>
                        </c:if>
                        <c:if test="${page_num != pageInfo.pageNum}">
                            <li><a href="${APP_PATH}/student/list?page=${page_num}&size=10">${page_num}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <li><a href="${APP_PATH}/student/list?page=${pageInfo.pages}&size=10">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</body>
</html>