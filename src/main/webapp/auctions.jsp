<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Enchères</title>
</head>
<body>
<h1>Liste des enchères</h1>

<table>
  <thead>
  <tr>
    <th>Nom</th>
    <th>Description</th>
    <th>Prix de départ</th>
    <th>Prix actuel</th>
    <th>Date de fin</th>
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