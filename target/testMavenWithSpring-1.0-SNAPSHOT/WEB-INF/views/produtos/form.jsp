<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 28/11/2019
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar Produtos</title>
</head>
<body>


    <form action="${pageContext.request.contextPath}/cadastrarProduto" method="POST">
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


        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
