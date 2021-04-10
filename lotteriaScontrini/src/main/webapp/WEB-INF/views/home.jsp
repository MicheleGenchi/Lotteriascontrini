<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/custom.css">
</head>
<body>

	<div class="container-fluid">

		<div class="row">
			<img src="/resources/img/lotteriaScontrini.png"
				alt="risorsa non trovata" />

			<div class="col-m">
				<h2>Lotteria scontrini</h2>
				<h3>data : ${dataCorrente}</h3>
				<h4>programmatore : ${mioNome}</h4>
				<h4>Lingua : ${lingua}</h4>
			</div>
		</div>

		<div style="padding-top: 50px" class="row">
			<div class="btn-toolbar btn-primary" role="toolbar"
				aria-label="Toolbar with button groups">
				<div class="btn-group p-3" role="group" aria-label="First group">
					<a
						href="http://localhost:8080/lotteriascontrini/scaricaEstrazioniPDF"
						class="btn btn-light"> <!-- <svg class="icon"><use xlink:href="/bootstrap-italia/dist/svg/sprite.svg#it-comment"></use></svg>-->
						<span class="toolbar-label">SCARICA ESTRAZIONE</span>
					</a>
				</div>
				<div class="btn-group p-3" role="group" aria-label="second group">
					<a
						href="https://servizi.lotteriadegliscontrini.gov.it/areariservata/dist/js/vendors.bundle.c8b7eaae3be89abfc83d.js"
						class="btn btn-light"> <!-- <svg class="icon"><use xlink:href="/bootstrap-italia/dist/svg/sprite.svg#it-comment"></use></svg>-->
						<span class="toolbar-label">MIEI SCONTRINI</span>
					</a>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>