<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>WeatherApp</title>
</head>
<body>
<h1>Statistic in ${statistic.city}</h1>
<p>Minimum temperature: ${statistic.min}</p>
<p>Maximum temperature: ${statistic.max}</p>
<p>Average temperature: ${statistic.avg}</p>
<c:if test="${weatherInfo != null}">
    <table>
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
