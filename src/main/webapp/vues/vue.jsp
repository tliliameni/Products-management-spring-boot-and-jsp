<%@page import="com.springboot.gestionproduit.gestionproduit.entity.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Des Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>

<%@ include file="navbar.html" %>

<br>
<br>
<br>

<div class="container">
<c:if test="${msg!=null}">
<div class="alert alert-danger" role="alert">${msg}</div>
</c:if>
<c:if test="${msg==null}">

<table  class="table">
<thead class="table-dark">
<tr><th >Photo</th><th >Id</th><th>nom</th><th>prix</th><th>quantite</th><th>Categorie</th><th>actions</th></tr></thead>

<c:forEach items="${listeProduit}" var="p">
<tr>
<td><c:choose>
<c:when test="${p.photo==''}">
 <img src="/image/i.png" width=50 height="50">
 </c:when>
 <c:when test="${p.photo!=''}">
 <img src="image/${p.photo}" width=50 height="50">
 </c:when>
 </c:choose></td>
<td>${p.id }</td>
<td>${p.nom }</td>
<td>${p.prix }</td>
<td>${p.quantite }</td>
<td>${p.categorie.nom }</td>
<td><a href="/apiproduit/supprimerproduit/${p.id}" onclick="return confirm('voulez vous supprimer ce produit?')"class="btn btn-danger" ><span class="fa fa-trash"></span></a>
<a href="/apiproduit/modifierproduit/${p.id}" class="btn btn-warning"><span class="fa fa-edit"></a></td>

</tr>
</c:forEach>
</table>
</c:if>
</div>
</body>
</html>