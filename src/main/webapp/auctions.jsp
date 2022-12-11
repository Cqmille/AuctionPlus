<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Liste des enchères</title>
  <!-- CSS only -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<h1>Liste des enchères</h1>
<table class="table">
  <thead>
  <tr>
    <th>Nom de l'objet</th>
    <th>Description de l'objet</th>
    <th>Prix de départ</th>
    <th>Prix actuel</th>
    <th>Fin de l'enchère</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${auctions}" var="auction">
    <tr>
      <td>${auction.itemName}</td>
      <td>${auction.itemDescription}</td>
      <td>${auction.startingBid}</td>
      <td>${auction.currentBid}</td>
      <td>${auction.endTime}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
