<%@ page import="com.synergy.training.entities.Holder" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10/11/2017
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project List</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){
            background-color: #EAEDED;
        }
        input[type=submit], button {
            width: 10%;
            background-color: #EAEDED;
            color: white;
            margin-top: 20px;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 15px;
            color: black;
        }

        button:hover {
            background-color: #D5DBDB;
        }
        a {
            text-decoration: none;
            color: black;
            font-size: larger;
        }

    </style>
</head>
<body>

<jsp:useBean id="holderBean" class="com.synergy.training.entities.DataBean"/>

<table>
    <c:forEach var="project" items="${holderBean.projects}">
        <tr id="${project.id}">
            <td><a href="/DeleteServlet?id=${project.id}">X</a></td>
            <td><a href="project.jsp?id=${project.id}"><c:out value="${project.title}"/></a></td>
        </tr>
    </c:forEach>
</table>

<button><a href="/project.jsp">Add</a></button>

</body>
</html>
