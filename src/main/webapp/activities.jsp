	<!-- Header
		<jsp:include page="header.jsp" />  -->
		<link rel="stylesheet" type="text/css" href="mystyles.css"/>
		

	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

	
<!-- 	Just some stuff you need 
	<header  id ="all" >-->
	<header id = "all">
<div class="container">
	  
		<h1>RevTronic <small id = "all	">All Tickets</small></h1>
		<hr>

		<!-- <table class="table table-striped table-hover table-responsive pubhub-datatable"> -->
		<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search by status..">
		  <table id = "myTable" width="100%">
		
			<thead>
				<tr class = "header">
					<td>R-Id:</td>
					<td>Amount:</td>
					<td>Submitted:</td>
					<td>Resolved:</td>
					<td>Description:</td>
					<td>Employee Id</td>
					<td>Resolver</td>
					<td>Status Id</td>
					<td>Type</td>
					<td></td>
					<td></td>
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
						<td><c:out value="${t.reimbResolver.userFirstName}" /></td>
						<td><c:out value="${t.reimbStatusId.reimbStatus}" /></td>
						<td><c:out value="${t.reimbType.reimbType}" /></td>
						
						
						<td><form action="UpdateTicket" id = "updatedstat" method="post">
								<input type="hidden" name="rid" value="${t.reimbId}">
								<input type="hidden" name="updatedstat" value="2">
								
								<button class="btn btn-success" value = "2">APPROVE</button>
							</form></td>
						<td><form action="UpdateTicket"  id = "updatedstat" method="post">
								<input type="hidden" name="rid" value="${t.reimbId}">
								<input type="hidden" name="updatedstat" value="3">
								<button class="btn btn-primary" value = "3">DENY</button>
							</form></td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
<!-- ------------------------------------------------------------- -->

		
		
<!-- ------------------------------------------------------------- -->>		

</div>
	</header>
	
	<script>
function myFunction() {
  // Declare variables 
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[7];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
</script>
	

	<!-- Footer -->
