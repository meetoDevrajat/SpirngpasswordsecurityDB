<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script> --%>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Book Management</h2>                                     <%-- <a href="<c:url value='/logout' />">Click here to logout</a> --%>  
   	
   <hr />

   <input type="button" value="Add Book"
    onclick="window.location.href='showForm'; return false;" class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Book List</div>
    </div>
   
    
					<!-- ---Added for security -->
				<c:url value="/logout" var="logoutUrl" />
						<form action="${logoutUrl}" method="post" id="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
				</form>
				<script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script>
			
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h6>
						Welcome : ${pageContext.request.userPrincipal.name} +${pageContext.request.authType}<a
							href="javascript:formSubmit()"> Logout</a>
					</h6>
				</c:if>
				<!-- ******* -->
	 <div class="panel-body">			  
     <table class="table table-striped table-bordered">
      <tr>
       <th>ID</th>
       <th>Title</th>
       <th>Author</th>
       <th>Price</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempbook" items="${books}">  <!-- Attribute returned by controller method public String listAllBooks(Model model) -->

       <!-- construct an "update" link with book id -->
       <c:url var="updateLink" value="/book/updateForm">
        <c:param name="bookId" value="${tempbook.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/book/delete">
        <c:param name="bookId" value="${tempbook.id}" />
       </c:url>

       <tr>
        <td>${tempbook.title}</td>
        <td>${tempbook.author}</td>
        <td>${tempbook.price}</td>

        <td>
         <!-- display the update link --> <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">Delete</a>
        </td>
       </tr>
      </c:forEach>
     </table>
    </div>
   </div>
  </div>
  </div>
  
  
</body>
</html>