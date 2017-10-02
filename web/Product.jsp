<%@ page import="dto.ProductDTO" %><%--
  Created by IntelliJ IDEA.
  User: aleksandrdolmatov
  Date: 06.02.17
  Time: 02:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ProductDTO productDTO = (ProductDTO) request.getAttribute("product");

%>
<p align="center">Product id =<%=productDTO.getId()%> </p>
<p align="center">Product name =<%=productDTO.getName()%> </p>
<p align="center">Product price =<%=productDTO.getPrice()%> </p>
<p align="center">Product quantity =<%=productDTO.getQuantity()%> </p>

</body>
</html>
