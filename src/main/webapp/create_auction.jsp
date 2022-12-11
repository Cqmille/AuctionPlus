<%--
  Created by IntelliJ IDEA.
  User: camil
  Date: 12/10/2022
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Create Auction</title>
</head>
<body>
<h1>Create Auction</h1>
<form action="/auctions" method="post">
  <label for="itemName">Item Name:</label><br>
  <input type="text" id="itemName" name="itemName"><br>
  <label for="itemDescription">Item Description:</label><br>
  <textarea id="itemDescription" name="itemDescription"></textarea><br>
  <label for="startingBid">Starting Bid:</label><br>
  <input type="number" id="startingBid" name="startingBid"><br>
  <label for="endTime">End Time:</label><br>
  <input type="datetime-local" id="endTime" name="endTime"><br><br>
  <input type="submit" value="Create Auction">
</form>
</body>
</html>
