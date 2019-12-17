
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Cadastrar Produtos</title>
</head>
<body>
<div>${sucesso}</div>
        <table border="1">

            <tr>
                <td>Título</td>
                <td>descricao</td>
                <td>Quantidade de Páginas</td>
            </tr>

        <c:forEach var = "produto" items = "${produtos}">

            <tr>
                <td><a href="${s:mvcUrl('PC#detalhe').arg(0,produto.id).build()}">Detalhes</a></td>
                <td>${produto.titulo}</td>
                <td>${produto.descricao}</td>
                <td>${produto.quantidadeDePaginas}</td>
            </tr>

        </c:forEach>

        </table>

    </form>
</body>
</html>
