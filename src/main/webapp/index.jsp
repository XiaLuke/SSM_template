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
    <link
            href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <%--引入js文件是`script`标签啊！！！！傻逼，内部使用`src``src``src`，不是`link`--%>
    <script type="text/javascript"
            src="${APP_PATH}/static/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript"
            src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<%-- 添加页面 --%>
<div class="modal fade" id="stuAddModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">新增</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="realName" class="col-sm-2 control-label">名字</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="realName" name="realName" placeholder="姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="email" id="email1"
                                       value="xxxx_aaaaa@163.com" checked="checked"> 邮箱1
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="email" id="email2"
                                       value="cccc_ffff@163.com"> 邮箱2
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">所属学院</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="collegeProfessionalClass" id="tclass_id"></select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="password" name="password" placeholder="密码">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" id="save_btn">Save</button>
            </div>
        </div>
    </div>
</div>

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
            <button class="btn btn-primary" id="stu_add">新增</button>
            <button class="btn btn-danger">删除</button>
        </div>
    </div>
    <!-- dataContext -->
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="stu_table">
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>邮箱</th>
                    <th>电话</th>
                    <th>所属</th>
                    <th>学号</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>


            </table>
        </div>
    </div>
    <!-- pageInfo -->
    <div class="row">
        <%-- 分页文字 --%>
        <div class="col-md-6" id="page_info_area">

        </div>
        <%-- 分页条--%>
        <div class="col-md-6" id="page_nav_area">

        </div>
    </div>
</div>
<script type="text/javascript">
    /*
    * 页面加载完成后请求数据
    * */
    $(function () {
        toPage(1, 10)
    });

    function toPage(page, size) {
        $.ajax({
            url: "${APP_PATH}/student/jsonList",
            data: "page=" + page + "&size=" + size,
            type: "GET",
            success: function (response) {
                if (response.code === 200) {
                    construct_stu_table(response)
                    build_page_info(response)
                    build_page_nav(response)
                } else {

                }
            }
        })
    }

    // 构造学生数据
    function construct_stu_table(response) {
        //清空历史数据
        $("#stu_table tbody").empty()

        let listResult = response.map.pageInfo.list
        $.each(listResult, function (index, item) {
            console.log(item)
            let realName = $("<td></td>").append(item.realName)
            let email = $("<td></td>").append(item.email)
            let phone = $("<td></td>").append(item.phone)
            let collegeProfessionalClass = $("<td></td>").append(item.collegeProfessionalClass)
            let studentId = $("<td></td>").append(item.studentId)
            let editBtn = $("<button></button>").addClass("btn btn-primary btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑")
            let delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除")
            let hollBtn = $("<td></td>").append(editBtn).append("  ").append(delBtn)

            $("<tr></tr>").append(realName).append(email).append(phone).append(collegeProfessionalClass).append(studentId).append(hollBtn).appendTo("#stu_table tbody");
        })
    }

    // 构建分页信息
    function build_page_info(response) {
        const pageInfo = response.map.pageInfo
        //清空历史数据
        $("#page_info_area").empty()
        $("#page_info_area").append("当前页：" + pageInfo.pageNum, "共有：" + pageInfo.pages + "页", "共有数据：" + pageInfo.total)
    }

    // 构建分页条
    function build_page_nav(response) {
        //清空历史数据
        $("#page_nav_area").empty()

        const result = response.map.pageInfo
        let ul = $("<ul></ul>").addClass("pagination")

        let firstPage = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"))
        let prevPage = $("<li></li>").append($("<a></a>").append("&laquo;"))
        // 没有上一页时，禁用上一页和第一页
        if (!result.hasPreviousPage) {
            firstPage.addClass("disabled")
            prevPage.addClass("disabled")
        } else {
            firstPage.click(function () {
                toPage(1, 10)
            })
            prevPage.click(function () {
                toPage(result.pageNum - 1, 10)
            })
        }


        let nextPage = $("<li></li>").append($("<a></a>").append("&raquo;"))
        let lastPage = $("<li></li>").append($("<a></a>").append("尾页").attr("href", "#"))
        if (!result.hasNextPage) {
            nextPage.addClass("disabled")
            lastPage.addClass("disabled")
        } else {
            nextPage.click(function () {
                toPage(result.pageNum + 1, 10)
            })
            lastPage.click(function () {
                toPage(result.pages, 10)
            })
        }


        ul.append(firstPage).append(prevPage)

        $.each(result.navigatepageNums, function (index, item) {
            let num = $("<li></li>").append($("<a></a>").append(item))
            if (result.pageNum === item) {
                num.addClass("active");
            }
            num.click(function () {
                toPage(item, 10)
            })
            ul.append(num)
        })
        ul.append(nextPage).append(lastPage)

        let nav = $("<nav></nav>").append(ul)
        nav.appendTo("#page_nav_area")
    }

    // 点击新增弹出模态框
    $('#stu_add').click(function () {
        //查询下拉数据并展示
        dropDown();

        $('#stuAddModel').modal({
            backdrop: "static"
        });
    });

    // 查询下拉数据并展示
    function dropDown(){
        $.ajax({
            url:'${APP_PATH}/tclass/list',
            type:'GET',
            success:function (response){
                if(response.code === 200){
                    let result = response.map.list
                    // $("#stuAddModel select")
                    // 或者：
                    // $("#tclass_id").append("")
                    $.each(result,function (){
                        var option = $("<option></option>").append(this.professionalId).attr("value",this.collegeId)
                        option.appendTo("#tclass_id")
                    })
                }
            }
        })
    }

    // 保存事件
    $("#save_btn").click(function (){
        //
    })

</script>
</body>
</html>