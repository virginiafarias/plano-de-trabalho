<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<meta charset="UTF-8"/>
	<jsp:include page="../fragmentos/header.jsp" />
	<title>Inicio</title>
</head>
<body>
	<jsp:include page="../fragmentos/css.jsp" />
	<div class="container">
		<input id="current-periodicidade" type="hidden"/>
		<input id="current-data" type="hidden"/>
		<div>
			<select id="periodicidade" name="periodicidade" class="selectpicker">
				<option value="dia">DIA</option>
				<option value="semana">SEMANA</option>
				<option value="mes">MÊS</option>
			</select>
		</div>
		<div class="form" align="center">
			<h1>Minhas Atividades</h1>
		</div>
		<div id="periodo-dia" class="periodo">
			<span id="before" class="glyphicon glyphicon-chevron-left"></span>
				<label id="periodo-dia"></label>
			<span id="after" class="glyphicon glyphicon-chevron-right"></span>
		</div>
		<div id="periodo-semana"  class="periodo" style="display: none;">
			<span id="before" class="glyphicon glyphicon-chevron-left"></span>
				<label id="periodo-semana"></label>
			<span id="after" class="glyphicon glyphicon-chevron-right"></span>
		</div>
		<div id="periodo-mes"  class="periodo" style="display: none;">
			<span id="before" class="glyphicon glyphicon-chevron-left"></span>
				<label id="periodo-mes"></label>
			<span id="after" class="glyphicon glyphicon-chevron-right"></span>
		</div>
		<table id="atividades">
			<thead>
				<tr>
					<th data-column-id="inicio" data-formatter="dia" data-order="asc">Dia</th>
					<th data-column-id="descricao">Descrição</th>
					<th data-column-id="status" data-order="asc">Status</th>
					<th data-column-id="acoes" data-formatter="acoes" data-sortable="false" data-searchable="false">Ações</th>
					
				</tr>
			</thead>
		</table>


	</div>
	<jsp:include page="../fragmentos/footer.jsp" />

</body>
</html>