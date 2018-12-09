<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="/resources/css/basic.css" rel="stylesheet">

    <script src="<c:url value="${pageContext.request.contextPath}/webjars/jquery/1.9.0/jquery.min.js"  />"></script>
    <script src="<c:url value="${pageContext.request.contextPath}/webjars/bootstrap/3.1.0/js/bootstrap.js"  />"></script>

    <title>CRUD - ${title}</title>
</head>
</tab>
<c:import url="page_components/header.jsp"></c:import>
<div class="container" >
    <div class="row">
        <div class="col-lg-10 col-lg-offset-1">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="text-center">
                        <h1>${title}<small> crud operations</small></h1>
                    </div>
                </div>
                <div class="alert alert-info" role="alert">
                    <a class="btn btn-primary" role="button" href="/${instrument}/pdfReport?view=pdfView" target="_blank">Download PDF report</a>
                    <a class="btn btn-primary" role="button" href="/${instrument}/xlsxReport.xlsx?view=excelView" target="_blank">Download Excel report</a>
                </div>
                <div class="panel-body">
                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Brands</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="car-brands">
                            <thead>
                            <th><button class="sort" data-sort="brand-name">brand</button></th>
                            <th><button class="sort" data-sort="founded-year">founded</button></th>
                            <th><button class="sort" data-sort="headquarter">headquarter</button></th>
                            <th>action</th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="brand" items="${listCarBrand}" varStatus="status">
                                <tr>
                                    <td class="brand-name">${brand.name}</td>
                                    <td class="founded-year">${brand.fond_year}</td>
                                    <td class="headquarter">${brand.jenre}</td>
                                    <td class="headquarter">${brand.developer}</td>
                                    <td class="headquarter">${brand.platforms}</td>
                                    <td class="action">
                                        <a href="/${instrument}/edit-brand/${brand.idGame}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="/${instrument}/delete-brand/${brand.idGame}">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button" href="/${instrument}/newBrand">Add new game &raquo</a></div>
                    </div>

                    <div class="panel panel-info">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            <div class="text-center"><h3>Models</h3></div>
                        </div>
                        <table class="table table-striped table-condensed" id="car-models">
                            <thead>
                            <th><button class="sort" data-sort="brand-name">brand</button></th>
                            <th><button class="sort" data-sort="os">os</button></th>
                            <th><button class="sort" data-sort="processor">processor</button></th>
                            <th><button class="sort" data-sort="ram">ram</button></th>
                            <th><button class="sort" data-sort="hdd">hdd</button></th>
                            <th><button class="sort" data-sort="video-card">video card</button></th>
                            <th>action</th>
                            </thead>
                            <tbody align="center" class="list">
                            <c:forEach var="model" items="${listCarModel}" varStatus="status">
                                <tr>
                                    <td class="brand-name">${model.carBrand.name}</td>
                                    <td class="os">${model.os}</td>
                                    <td class="processor">${model.processor}</td>
                                    <td class="ram">${model.ram}</td>
                                    <td class="hdd">${model.hdd}</td>
                                    <td class="video-card">${model.video_card}</td>
                                    <td>
                                        <a href="/${instrument}/edit-model/${model.idModel}">Edit</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="/${instrument}/delete-model/${model.idModel}">Delete</a>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="panel-footer"><a class="btn btn-info" role="button" href="/${instrument}/newModel">Add new model &raquo</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/resources/js/list.min.js"></script>
<script src="/resources/js/content-list.js"></script>
</body>
</html>
