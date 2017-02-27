<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="base-top.jsp" />
<div class="container">
<%


	if (request.getSession().getAttribute("user")==null){
	
		response.sendRedirect("login.jsp");
	}
%>
<h1>Welcome ${sessionScope.fname} ${sessionScope.lname}</h1>


<div class="form-signin">

<h3><font color="red">${error!=null ? error : '' }</font></h3>
<form action="addurl" method="post">

<div class="form-group">
  <label for="url" >Enter URL</label>
  
    <input class="form-control" type="text"  name="url" id="url" value="${url!=null ? url : '' }">
  
</div>


<div class="form-group">
  <label for="fname" >Enter Comment</label>
  
    <input class="form-control" type="text"  name="cmnt" id="cmnt" value="${cmnt!=null ? cmnt : '' }">
  
</div>

<button type="submit" class="btn btn-primary">Submit</button>

</form>
</div>



<hr>

<div class="form-signin">
    <table  class="table table-bordered">
     <thead class="thead-inverse">
    		<th>URL</th>
        	<th>Comment</th>
        	<th>Total Click</th>
        	
        	<th>Delete</th>
        	  </thead> <tbody>
        <c:forEach items="${list}" var="record">
        	
            <tr>
               <td><a href="click?fid=${record.hashid }&url=${record.url }" target="_blank" onclick="demo()">${record.url }</a></td>
                <td>${record.comment }</td>
                <td>${record.click }</td>
                
              <td><a href="delfav?fid=${record.hashid }" target="_blank" onclick="window.location.reload()">Click Here</a></td>
            </tr>
        </c:forEach>
         </tbody>
    </table>

</div>

</div>
  
<jsp:include page="base-bottom.jsp" />