<%@page import="com.springboot.gestionproduit.gestionproduit.entity.Produit"%>
<%@page import="com.springboot.gestionproduit.gestionproduit.entity.Categorie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<%@ include file="navbarCat.html" %>
<br>

<div class=container>
<div class="card m-5 p-2">
  <div class="card-header"><h2>Ajouter Categorie</h2></div>
 <div class="card-body"> 
<form action="/apicategorie/ajoutercategorie" method=post>
   
  <div class="mb-3 mt-3">
    <label for="nom" class="form-label">Nom:</label>
    <input type=text class="form-control" id="nom"  name="nom" value="${categorie.nom }">
  </div>
 
  
       <input type="hidden"  name="idc" value="${categorie.id }">

  
  <button type="submit"  class="btn btn-primary" name=action value="ajouter">Save</button>
</form>
</div>
  
</div>
</div>


</body>
</html>