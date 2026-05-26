<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration List</title>
</head>
<body>

    <h2>All Registrations</h2>

    <table >
        <tr>

            <th>FName</th>
            <th>LName</th>
            <th>MobileNumber</th>
            <th>Email</th>
            <th>Password</th>
        </tr>

       <c:forEach var="item" items="${listOfUsers}">
       <tr>
       <td>${item.id}</td>
       <td>${item.fname}</td>
       <td>${item.lname}</td>
       <td>${item.emailID}</td>
       <td>${item.mobileNumber}</td>
       <td>${item.password}</td>
       <td>
         <a href="id?userid=${item.id}">View</a>
         <a href="editId?userid=${item.id}">Edit</a>
         <a href="deleteID/${item.id}">Delete</a>
        </td>
       </tr>
       </c:forEach>
    </table>
</body>
</html>
