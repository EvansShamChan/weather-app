<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>WeatherApp</title>
    <style>
        <%@include file="../css/styles.css"%>
    </style>
</head>
<body>
<div class="statistic" align="center">
    <h1>Statistic in ${statistic.city}</h1>
    <p>Minimum temperature: ${statistic.min} K</p>
    <p>Maximum temperature: ${statistic.max} K</p>
    <p>Average temperature: ${statistic.avg} K</p>
</div>
<hr>
<h3 align="center">Full weather data in ${statistic.city}</h3>
<c:if test="${weatherInfo != null}">
    <table align="center">
        <tr>
            <th>Date</th>
            <th>Temperature</th>
            <th>Humidity</th>
            <th>Pressure</th>
            <th>Wind degrees</th>
            <th>Wind speed</th>
        </tr>
        <c:forEach var="info" items="${weatherInfo}">
            <tr>
                <th>${info.date}</th>
                <th>${info.temp} K</th>
                <th>${info.humidity} %</th>
                <th>${info.pressure}</th>
                <th>${info.wind_deg}</th>
                <th>${info.wind_speed}</th>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
