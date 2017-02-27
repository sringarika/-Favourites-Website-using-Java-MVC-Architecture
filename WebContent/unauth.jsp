<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="base-top.jsp" />
<div class="form-signin">
    <table  class="table table-bordered">
     <thead class="thead-inverse">
    		<th>URL</th>
        	<th>Comment</th>
        	<th>Total Click</th>
        	
        	
        	  </thead> <tbody>
        <c:forEach items="${list}" var="record">
        	
            <tr>
               <td><a href="click?fid=${record.hashid }&url=${record.url }" target="_blank" onclick="window.location.reload()">${record.url }</a></td>
                <td>${record.comment }</td>
                <td>${record.click }</td>
                
             
            </tr>
        </c:forEach>
         </tbody>
    </table>

</div>









<jsp:include page="base-bottom.jsp" />