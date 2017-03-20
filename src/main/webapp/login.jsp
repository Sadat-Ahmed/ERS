	<!-- Header
		<jsp:include page="header.jsp" />  -->
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

				<link rel="stylesheet" type="text/css" href="mystyles.css"/>

	
<!-- 	Just some stuff you need -->
	<header id ="all"> 

    
<div class="container">
      <form action="FrontController" method="get" class="form-signin">
        <h2 class="form-signin-heading">Please Sign In</h2>
        	<label for="username" class="sr-only">Username</label>
        		<input type="text" id="username" name="username" class="form-control" placeholder="Username" required="required" >
       		 <label for="password" class="sr-only">Password</label>
        		<input type="password" id="password" name="password" class="form-control" placeholder="Password" required="required">
     
        <button class="btn btn-lg btn-primary btn-block" type="submit" value = "submit">Sign In</button>
      </form>
    </div>
    </header>
