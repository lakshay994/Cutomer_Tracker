<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - CUSTOMER RELATION MANAGEMENT</h2>
        </div>
    </div>

    <div id="container">
        <div id="content">

            <input type="button" value="Add Customer" class="add-button"
                   onclick="window.location.href='addCustomer'; return false;"/>

            <table>

                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th></th>
                </tr>

                <c:forEach var="tempCustomer" items="${customers}">

                    <c:url var="updateLink" value="/customer/updateCustomer">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <c:url var="deleteLink" value="/customer/deleteCustomer">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <tr>
                        <td>${tempCustomer.firstName}</td>
                        <td>${tempCustomer.lastName}</td>
                        <td>${tempCustomer.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>|
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete the customer?'))) return false ">
                                Delete</a>
                        </td>
                    </tr>

                </c:forEach>


            </table>

        </div>
    </div>

</body>
</html>
