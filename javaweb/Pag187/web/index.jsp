<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversor de Moedas</title>
    </head>
    <body>
        <h1>Conversor de Moedas</h1>
        <hr />
        <form action="ConversorServlet" method="post">
            Valor: <input type="text" name="valor" />
            Moeda: <select name="tipo">
                <option>Real</option>
                <option>Dolar</option>
                <option>Euro</option>
            </select>
            <input type="submit" value="Converter" />
        </form>
        <c:if test="${not empty moeda}">
        <h3>Real: ${moeda.real}</h3>
        <h3>Dolar: ${moeda.dolar}</h3>
        <h3>Euro: ${moeda.euro}</h3>
        </c:if>
    </body>
</html>
