<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 28/11/2019
  Time: 00:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fform" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Cadastrar Produtos</title>
</head>
<body>



<form:form action="${s:mvcUrl('PC#cadastrarProduto').build()}" method="POST" modelAttribute="produto" enctype="multipart/form-data">


        <div>
            <label>Título</label>
            <form:input  path="titulo"/>
            <form:errors path="titulo"/>
        </div>

        <div>
            <label>Quantidade de Páginas</label>
            <form:input path = "quantidadeDePaginas"/>
            <form:errors path="quantidadeDePaginas"/>
        </div>

        <div>
            <label>Data de Lançamento</label>
            <fform:input path="dataLancamento"/>
            <form:errors path="dataLancamento"/>
        </div>

        <div>
            <label>Descrição</label>
            <form:textarea rows="10" cols="50" path="descricao" />
            <form:errors path="descricao"/>
        </div>

        <div>
            <label>Preco</label>

            <c:forEach  var="tipo" items="${tipos}" varStatus="status">
                <label>${tipo}</label>
                <form:input type="text" path="precos[${status.index}].valor" />
                <input type="hidden" name="precos[${status.index}].tipo" value="${tipo}" />
            </c:forEach>

        </div>

    <div>
        <label>Sumário</label>
        <input name="sumario" type="file">
    </div>

        <button type="submit">Cadastrar</button>


    </form:form>


</body>
</html>
