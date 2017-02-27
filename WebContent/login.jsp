<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="base-top.jsp" />

<div class="container">
		<h3><font color="red">${error!=null ? error : '' }</font></h3>
      <form class="form-signin" method="post" action="login">
        <h2 class="form-signin-heading">Please sign in</h2>
      <div class="form-group">
    <label for="emailinput">Email address</label>
    <input type="email" class="form-control" id="emailinput" name="username" aria-describedby="emailHelp" placeholder="Enter email" value="${email!=null ? email : '' }">
    
  </div>
 <div class="form-group">
    <label for="pass">Password</label>
    <input type="password" class="form-control" id="pass" name="pass" placeholder="Password">
  </div>
        <button class="btn btn-primary" type="submit">Sign in</button>
      </form>
   

    </div>
    
    
    
<jsp:include page="base-bottom.jsp" />