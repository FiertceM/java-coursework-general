<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="/resources/css/basic.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>

    <title>${title}</title>
</head>
<body>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${action} brand <small>using ${title}</small></h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form:form method="POST" modelAttribute="carBrand" class="form-horizontal">
                        <form:hidden path="idGame"/>
                        <div class="form-group">
                            <label for="name" class="col-sm-3 control-label">Game name:</label>
                            <div class="col-sm-9">
                                <form:input path="name" class="form-control" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="fond_year" class="col-sm-3 control-label">Founded year:</label>
                            <div class="col-sm-9">
                                <form:input path="fond_year" class="form-control" type="number" min="1800" max="2050"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="jenre" class="col-sm-3 control-label">Jenre:</label>
                            <div class="col-sm-9">
                                <form:input path="jenre" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="developer" class="col-sm-3 control-label">Developer:</label>
                            <div class="col-sm-9">
                                <form:input path="developer" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="platforms" class="col-sm-3 control-label">Platforms:</label>
                            <div class="col-sm-9">
                                <form:input path="platforms" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-primary">Save</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>