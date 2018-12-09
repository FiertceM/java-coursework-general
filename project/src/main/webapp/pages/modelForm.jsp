<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
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
                        <h1>${action} model <small>using ${title}</small></h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form:form method="POST" modelAttribute="carModel" class="form-horizontal">
                        <form:hidden path="idModel"/>
                        <div class="form-group">
                            <label for="idGame" class="col-sm-3 control-label" >Game:</label>
                            <div class="col-sm-9">
                                <form:select path="idGame" multiple="false" class="form-control">
                                    <c:forEach var="brand" items="${listCarBrand}" varStatus="status">
                                        <c:choose>
                                            <c:when test="${brand.idGame == carModel.idGame}">
                                                <option selected value="${brand.idGame}">${brand.name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${brand.idGame}">${brand.name}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="os" class="col-sm-3 control-label">OS:</label>
                            <div class="col-sm-9">
                                <form:input path="os" class="form-control" required="required"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="processor" class="col-sm-3 control-label">Processor:</label>
                            <div class="col-sm-9">
                                <form:input path="processor" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="ram" class="col-sm-3 control-label">RAM:</label>
                            <div class="col-sm-9">
                                <form:input path="ram" class="form-control" type="number" min="1800" max="2050"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="hdd" class="col-sm-3 control-label">HDD:</label>
                            <div class="col-sm-9">
                                <form:input path="hdd" class="form-control" type="number" min="0" max="10"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="video_card" class="col-sm-3 control-label">Video card:</label>
                            <div class="col-sm-9">
                                <form:input path="video_card" class="form-control" type="number" min="0" max="50"  />
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