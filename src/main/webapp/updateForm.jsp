<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Update Registration Details</title>
</head>
<body>
    <h2>Update Registration Details</h2>

    <form action="update" method="POST">

        <input readonly name="id" value="${getform.id}" />
        <br>

        <label>First Name:</label><br/>
        <input type="text" name="fname" value="${getform.fname}" required /><br/><br/>

        <label>Last Name:</label><br/>
        <input type="text" name="lname" value="${getform.lname}" required /><br/><br/>

        <label>Mobile Number:</label><br/>
        <input type="text" name="mobileNumber" value="${getform.mobileNumber}" required /><br/><br/>

        <label>Email ID:</label><br/>
        <input type="email" name="emailID" value="${getform.emailID}" required /><br/><br/>



        <input type="submit" value="Submit changes">
    </form>

</body>
</html>
