<!DOCTYPE html>
<html>
<body>

<h2>HTML Forms</h2>
<a href="index.jsp">Back to Home</a>

<form method="post" action="create">
  <label for="fname">First name:</label><br>
  <input type="text" id="fname" name="fname" ><br>

  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lname" ><br><br>

  <label for="mobile number">Mobile Number:</label><br>
  <input type="tell"  name="mobileNumber" ><br><br>

   <label for="email">Email ID:</label><br>
   <input type="email" name="emailID" ><br><br>

  <label for="password">Password:</label><br>
  <input type="password"  name="Password" ><br><br>




  <input type="submit" value="Submit">
</form>

<p>If you click the "Submit" button, the form-data will be sent to a page called "/action_page.php".</p>


</body>
</html>

