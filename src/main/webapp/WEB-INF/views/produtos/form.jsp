<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 28/11/2019
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<html>
<head>
    <title>Cadastrar Produtos</title>
</head>
<body>


    <form action="${pageContext.request.contextPath}/produtos/cadastrarProduto" method="POST">


        <div>
            <label>Título</label>
            <input type="text" name="titulo">
        </div>

        <div>
            <label>Quantidade de Páginas</label>
            <input type="text" name = "quantidadeDePaginas">
        </div>

        <div>
            <label>Descrição</label>
            <textarea rows="10" cols="50" name="descricao" ></textarea>
        </div>

        <div>
            <label>Preco</label>

            <c:forEach  var="tipo" items="${tipos}" varStatus="status">
                <label>${tipo}</label>
                <input type="text" name="precos[${status.index}].valor" />
                <input type="hidden" name="precos[${status.index}].tipo" value="${tipo}" />
            </c:forEach>
        </div>


        <button type="submit">Cadastrar</button>


    </form>
</body>
</html>
