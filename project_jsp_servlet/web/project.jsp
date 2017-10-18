<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 10/11/2017
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>

<jsp:useBean id="holderBean" class="com.synergy.training.entities.DataBean"/>

<c:set var="id" value="${param.id}"/>

<c:set var="currency" value="${holderBean.currencies}"/>
<c:set var="sector" value="${holderBean.sectors}"/>
<c:set var="subSector" value="${holderBean.subSectors}"/>

<c:if test="${id != null}">
    <c:forEach var="project" items="${holderBean.projects}">
        <c:if test="${project.id == param.id}">
            <c:set var="pr" value="${project}"/>
        </c:if>
    </c:forEach>
</c:if>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${id == null ? 'Add Project' : pr.title}</title>

    <script>
        function setSubSectorsField() {
            var subSectors = document.getElementById('subSectors');
            var sectors = document.getElementById('sectors');
            subSectors.innerHTML = '';
            var selected = sectors.value;

            <c:forEach var="subSec" items="${subSector}">
            if ("${subSec.sectorId}" == selected) {
                var option = document.createElement('option');
                option.value = ${subSec.id};
                option.innerHTML = "${subSec.name}";
                subSectors.appendChild(option);
            }
            </c:forEach>
        }
    </script>
    <style>
        input, select {
            width: 50%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid grey;
            border-radius: 4px;
            box-sizing: border-box;
        }
        #edit{
            margin-left: 30%;
        }
        input[type=submit], button {
            width: 50%;
            background-color: #D5DBDB;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 15px;
            color: black;
        }

        input[type=submit]:hover {
            background-color: #EAEDED;

        }
        button:hover {
            background-color: #EAEDED;
        }
        a {
            text-decoration: none;
            color: black;
            font-size: 15px;
        }
        button{
            margin-left: 30%;
            width: 35%;
        }

    </style>

</head>
<body>

<form action="/Add" method="post" id="edit">
    Project Id <br/>
    <input required name="id" readonly="readonly" hidden value="${id == null ? -1 : id }"/> <br/> Title <br/>
    <input required name="title" type="text" value="${id == null ? '' : pr.title}"/> <br/> Description <br/>
    <input required name="description" type="text" value="${id == null ? '' : pr.description}"/> <br/> Total Amount <br/>
    <input required name="totalAmount" type="number" value="${id == null ? '' : pr.totalAmount}"/><br/> Currency <br/>
    <select required name="currencies">
        <c:forEach var="cur" items="${currency}">
            <c:choose>
                <c:when test="${cur.id == pr.currencyId}">
                    <option selected value="${cur.id}">${cur.name}</option>
                </c:when>
                <c:when test="${cur.id != pr.currencyId}">
                    <option value="${cur.id}">${cur.name}</option>
                </c:when>
            </c:choose>
        </c:forEach>
    </select>

    <c:forEach var="subSec" items="${subSector}">
        <c:if test="${id != null && subSec.id == pr.subSectorId}">
            <c:set var="sectorId" value="${subSec.sectorId}"/>
        </c:if>
    </c:forEach>
    <br/> Sector <br/>
    <select required name="sectors" onchange="setSubSectorsField()" id="sectors">
        <c:choose>
        <c:when test="${id == null}">
            <option selected disabled value="">Select Sector</option>
        </c:when>
        </c:choose>
        <c:forEach var="sec" items="${sector}">
            <c:choose>
                <c:when test="${id != null && sec.id == sectorId}">
                    <option selected value="${sec.id}">${sec.name}</option>
                </c:when>
                <c:when test="${id == null || sec.id != sectorId}">
                    <option value="${sec.id}">${sec.name}</option>
                </c:when>
            </c:choose>
        </c:forEach>
    </select>
    <br/> SubSector <br/>
    <select required name="subSectors" id="subSectors">
        <c:choose>
            <c:when test="${id == null}">
                <option selected disabled value="">Select SubSector</option>
            </c:when>
            <c:when test="${id != null}">
                <c:forEach var="subSec" items="${subSector}">
                    <c:choose>
                        <c:when test="${id != null && subSec.id == pr.subSectorId}">
                            <option selected value="${subSec.id}">${subSec.name}</option>
                        </c:when>
                        <c:when test="${id == null || subSec.id != pr.subSectorId && subSec.sectorId == sectorId}">
                            <option value="${subSec.id}">${subSec.name}</option>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </c:when>
        </c:choose>
    </select>
    <input type="submit" value="Save and Close"/>
</form>
    <button><a href="ProjectList.jsp">Cancel</a></button>
</body>
</html>
