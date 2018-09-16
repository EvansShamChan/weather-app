<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>WeatherApp</title>
</head>
<body>
<h1>Hello</h1>
<form action="<s:url value="/statistic"/>">
    <p>Show temperature statistic by city</p>
    <p>From: <input type="date" name="from"></p>
    <p>To: <input type="date" name="to"></p>
    <select name="city">
        <option value="Lviv" selected>Lviv</option>
        <option value="Kyiv">Kyiv</option>
        <option value="New York">New York</option>
        <option value="London">London</option>
    </select>
    <input type="submit" value="Statistic">
</form>
</body>
</html>