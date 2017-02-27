<jsp:include page="base-top.jsp" />
<div class="container">

<font color="red">${error!=null ? error : '' }</font>

<form class="form-signin" action="register" method="post">

<h2 class="form-signin-heading">Please Register</h2>

<div class="form-group">
  <label for="fname" >First Name</label>
  
    <input class="form-control" type="text"  name="fname" id="fname" placeholder="Enter First Name" value="${fname!=null ? fname : '' }">
  
</div>

<div class="form-group">
  <label for="lname" >Last Name</label>
  
    <input class="form-control" type="text"  name="lname" id="lname" placeholder="Enter Last Name" value="${lname!=null ? lname : '' }">
  
</div>


  <div class="form-group">
    <label for="emailinput">Email address</label>
    <input type="email" class="form-control" id="emailinput" name="email" aria-describedby="emailHelp" placeholder="Enter email" value="${email!=null ? email : '' }">
    
  </div>
 <div class="form-group">
    <label for="pass">Password</label>
    <input type="password" class="form-control" id="pass" name="pass" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="rpass">Confirm Password</label>
    <input type="password" class="form-control" id="rpass" name="rpass" placeholder="Confirm Password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


    </div>


<jsp:include page="base-bottom.jsp" />