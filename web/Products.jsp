<%@ page import="java.util.List" %>
<%@ page import="dto.ProductDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>

<body>
        <table>
            <tr>
            <th>id</th>
            <th>name</th>
            <th>price</th>
            <th>quantity</th>
            </tr>
<%
    List<ProductDTO> productDTOs = (List<ProductDTO>) session.getAttribute("products");
    for (ProductDTO productDTO:productDTOs) {
%>


            <tr>
                <td><%=productDTO.getId()%></td>
                <td><a href="product/<%=productDTO.getId()%>"><%=productDTO.getName()%></a></td>
                <td><%=productDTO.getPrice()%></td>
                <td><%=productDTO.getQuantity()%></td>
                <td><a href="add/<%=productDTO.getId()%>">Заказать</a> </td>
            </tr>


            <%  }
%>
        </table>
</body>
</html>
