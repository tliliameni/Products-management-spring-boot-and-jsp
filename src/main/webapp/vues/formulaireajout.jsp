<%@page import="com.springboot.gestionproduit.gestionproduit.entity.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Produit</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="navbar.html" %>
<br>
<br>
<br>
<c:if test="${message!=null}">
<div class="alert alert-success" role="alert">
<c:out value="${message}"></c:out>
${produit=null}
</div>
</c:if>
<div class=container>
<div class="card m-5 p-2">
  <div class="card-header">
  <c:if test="${produit != null}">
<h2>Edit Product</h2>
</c:if>
<c:if test="${produit == null}">
<h2>Add Product</h2>
</c:if>
</div>
 <div class="card-body"> 
<form action="/apiproduit/ajouterproduit" method=post enctype="multipart/form-data">
   
  <div class="mb-3 mt-3">
    <label for="nom" class="form-label">Nom:</label>
    <input type=text class="form-control" id="nom"  name="nom" value="${produit.nom }">
  </div>
  <div class="mb-3">
    <label for="prix" class="form-label">Prix:</label>
    <input type="number" class="form-control" id="prix"  name="prix" value="${produit.prix }" >
  </div>
  <div class="mb-3">
    <label for="quantite" class="form-label">Quantite:</label>
    <input type="number" class="form-control" id="quantite"  name="quantite" value="${produit.quantite }">
  </div>
  <div>
    <label for="quantite" class="form-label  mb-3">Categorie:</label>
  <select name="categorie">
  <option selected hidden>Choose here</option>
  <c:forEach items="${categories}" var="cc">
  <option value="${cc.id }"<c:if test="${produit.categorie.id==cc.id }">selected="true"</c:if>>${cc.nom}</option>
   </c:forEach>
</select></div> 
  <div class="mb-3">
  <input type=hidden name=photo value="${produit.photo}">
  <label class="form-label">Photos:</label>
  <input type='file' name="file" accept="image/png,image/jpg,image/jpeg" class="form-control"/>
  </div>

  
        <input type="hidden" class="form-control" id="idp" name="id" value="${produit.id}">

     <c:if test="${liste != null}">
		<button type="submit" class="btn btn-outline-dark mt-2" >Modifier</button>
		</c:if>
	<c:if test="${liste == null}">
		<button type="submit" class="btn btn-outline-dark mt-2" >Ajouter</button>
	</c:if>
	
</form>
</div>
  
</div>
</div>


</body>
</html>