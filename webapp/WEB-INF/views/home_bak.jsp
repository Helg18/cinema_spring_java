<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources" var="urlPublic" />
<meta charset="UTF-8">
<title>Cinema App</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.css" >
</head>
<body>
	<table class="table table-hover table-striped table-condensed">
		<thead>
			<tr>
				<th colspan="8">Listado de peliculas</th>
			</tr>
			<tr>
				<th>ID</th>
				<th>Titulo</th>
				<th>Duracion</th>
				<th>Genero</th>
				<th>Clasificacion</th>
				<th>Imagen</th>
				<th>Fecha de estreno</th>
				<th>Estatus</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${peliculas}" var="pelicula">
				<tr>
					<td>${ pelicula.id }</td>
					<td>${ pelicula.titulo }</td>
					<td>${ pelicula.duracion }</td>
					<td>${ pelicula.genero }</td>
					<td>${ pelicula.clasificacion }</td>
					<td><img src="${ urlPublic }/images/${pelicula.image}" width="80" height="100" /></td>
					<td><fmt:formatDate value="${ pelicula.fechaEstreno }" pattern="dd-MM-yyyy"/></td>
					<td>
						<c:choose>
							<c:when test="${ pelicula.status == 'Activa' }">
								<span class="badge badge-success">${ pelicula.status }</span>
							</c:when>
							<c:otherwise>
								<span class="badge badge-danger">${ pelicula.status }</span>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<script src="${urlPublic}/bootstrap/js/bootstrap.js"></script>
</body>
</html>