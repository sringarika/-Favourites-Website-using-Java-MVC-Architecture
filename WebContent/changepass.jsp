<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="base-top.jsp" />
<div class="container">



<font color="red">${error!=null ? error : '' }</font>




<form class="form-signin" action="changepass" method="post">

<h2 class="form-signin-heading">Change Password</h2>
	<div class="form-group">
    <label for="opass">Old Password</label>
    <input type="password" class="form-control" id="opass" name="opass" placeholder="Password">
  </div>

 <div class="form-group">
    <label for="pass">New Password</label>
    <input type="password" class="form-control" id="pass" name="pass" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="rpass">Confirm New Password</label>
    <input type="password" class="form-control" id="rpass" name="rpass" placeholder="Confirm Password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</div>
  
<jsp:include page="base-bottom.jsp" />