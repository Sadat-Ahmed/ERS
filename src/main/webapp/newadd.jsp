<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<form action="in.do" method="post" id = "reimbursementform" class="form-horizontal"
			enctype="multipart/form-data" >

			<div class="form-group">
				<label for="amount" class="col-sm-4 control-label">Amount</label>
				<div class="col-sm-5">
					<input type="number" min="0.01" step="0.01" max="10000" class="form-control" id="amount" name="amount"
						placeholder="Amount" required="required"  />
				</div>
			</div>
	
	<div class="form-group">
		<label for="rdescription" class="col-sm-4 control-label">Description</label>
		<div class="col-sm-5">
			<input type="text" class="form-control" id="rdescription"
				name="rdescription" placeholder="rdesciption" required="required"  />
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

	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-1">
			<input type="submit" class="btn btn-info" value="Submit">
		</div>
	</div>
</form>






</body>
</html>