
<!-- Header 
		<jsp:include page="header.jsp" />
	-->
	
	

<!DOCTYPE html>
<html>

			<link rel="stylesheet" type="text/css" href="mystyles.css"/>

<!-- JSTL includes -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<head>

</head>


<!-- 	Just some stuff you need -->

<body>

	<br />
	<br />
	<h1 align="center">Submit Request</h1>
	<div style="text-align:center">
	
	 <a  href="empactivities.jsp" class="btn btn-info" role="button">Home</a>
 	 <a href="login.jsp" class="btn btn-info" role="button">Logout</a>
	</div>

	<br />
	<br />
	<br />

		


	<form action="add.do" method="post" id="reimbursementform"
		class="form-horizontal">
	
		<div class="form-group">
			

			<label for="name2" class="col-sm-4 control-label">Amount</label>
			<div class="col-sm-5">
				<input type="number" min="0.01" step="0.01" max="10000"
					class="form-control" id="name2" name="name2" placeholder="name2"
					required="required" />
			</div>
		</div>

		<div class="form-group">
			<label for="rdescription" class="col-sm-4 control-label">Description</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="rdescription"
					name="rdescription" placeholder="rdesciption" required="required" />
			</div>
		</div>


		<div class="form-group">
			<label for="rtype" class="col-sm-4 control-label">Type</label>
			<div class="col-sm-1">
				<select name="rtype" form="reimbursementform">
					<option value="1">Lodging</option>
					<option value="2">Travel</option>
					<option value="3">Food</option>
					<option value="4">Other</option>
				</select>

			</div>
		</div>

		<div class="form-group" style = "text-align:center">
			<div class="col-sm-offset-4 col-sm-1">
				<input type="submit" class="btn btn-info" value="Submit">
			</div>
		</div>
	</form>








</body>
</html>