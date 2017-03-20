	<!-- Header 
		<jsp:include page="header.jsp" />  -->
		
				<link rel="stylesheet" type="text/css" href="mystyles.css"/>
				
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header id ="all" >
<div class="container">


  
  <a href="addTicket.jsp" class="btn btn-info" role="button">Add a Ticket</a>
  <a href="login.jsp" class="btn btn-info" role="button">Logout</a>

	 
		<h1>RevTronic <small>All Tickets for: </small></h1>
		<hr>

		  <table width="100%" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr>
					<td>R-Id:</td>
					<td>Amount:</td>
					<td>Submitted:</td>
					<td>Resolved:</td>
					<td>Description:</td>
					<td>Employee Id</td>
					<td>Resolver</td>
					<td>Status Id</td>
					<td>Type</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="t" items="${reimbs}">
					<tr>
						<td><c:out value="${t.reimbId}" /></td>
						
						<td><c:out value="${t.reimbAmount}" /></td>
						<td><c:out value="${t.reimbSubmitted}" /></td>
						<td><c:out value="${t.reimbResolved}" /></td>
						<td><c:out value="${t.description}" /></td>
						<td><c:out value="${t.reimbAuthor.ersUserId}" /></td>
						<td><c:out value="${t.reimbResolver.ersUserId}" /></td>
						<td><c:out value="${t.reimbStatusId.reimbStatus}" /></td>
						<td><c:out value="${t.reimbType.reimbType}" /></td>
						
						
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
<!-- ------------------------------------------------------------- -->

		
		
<!-- ------------------------------------------------------------- -->>		

</div>
	</header>
	<!-- Footer -->
