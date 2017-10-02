<%@ page import="dto.OrderDTO" %>
<%@ page import="dto.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: aleksandrdolmatov
  Date: 20.01.17
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; utf-8"
         pageEncoding="utf-8"

%>

<!DOCTYPE html>

<html>

<head>
    <meta http-equiv="Content-Type"
          content="text/html; utf-8">
    <title>   User Logged Successfully   </title>
</head>

<body>
<center>
<% UserDTO userDTO = (UserDTO)session.getAttribute("currentSessionUser");
    String name = userDTO.getName();
%>
    <p>Hello, dear <%=name%></p>
    <p>Here is your order list:</p>

    <table>
        <tr>
            <th>id</th>
            <th>userId</th>
            <th>summaryPrice</th>
        </tr>
        <%for (OrderDTO orderDTO:userDTO.getOrders()) {%>
            <tr>
                <td><%=orderDTO.getId()%></td>
                <td><%=orderDTO.getUserID()%></td>
                <td><%=orderDTO.getSummaryPrice()%></td>
            </tr>
        <%}
        %>
    </table>
    <p><a href="/products">Чтобы посмотреть наш список товаров нажмите сюда</a></p>

</center>
</body>

</html>