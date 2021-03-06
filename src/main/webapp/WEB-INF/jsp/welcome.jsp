<!DOCTYPE html>

<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="customerform" tagdir="/WEB-INF/tags" %>

<html lang="${language}">
	<jsp:include page="fragments/htmlHeader.jsp"/>
	
	<body onload="setLanguage('${language}');">
		<fmt:setLocale value="${language}"/>
		<fmt:bundle basename="messages.messages">
		<customerform:bodyHeader menuName="home"/>
		
		<div class="container-fluid">
		    <div class="container xd-container">
		        <h2><fmt:message key="welcome"/></h2>
		        <div class="row">
		            <div class="col-md-12 left">
		                <spring:url value="/resources/images/customerform.png" htmlEscape="true" var="petsImage"/>
		                <img class="img-responsive" src="${petsImage}"/>
		            </div>
		
					<div class="right">
				        <p><fmt:message key="homeSummary"/></p>
				        <br />
				        <h2>How to use this simple tool</h2>
				        <ul>
				        	<li>Press the 'Customers' from the menu above, which will show the list of all the customers available.</li>
				        	<li>Click in one of the actions to execute it. Available actions:
					        	<ul>
					        		<li><span class="glyphicon glyphicon-list icon-blue"></span> To view the customer's details.</li>
					        		<li><span class="glyphicon glyphicon-pencil icon-blue"></span> To edit the customer's details.</li>
					        		<li><span class="glyphicon glyphicon-trash icon-blue"></span> To delete the customer's details.</li>
					        		<li>The general actions have been also added in each row and are
					        			<ul>
					        				<li><span class="glyphicon glyphicon-plus icon-blue"></span> to add a new customer.</li>
					        				<li><span class="glyphicon glyphicon-plus-sign icon-blue"></span> to go to the multi-add view.</li>
					        			</ul>
					        		</li>
					        	</ul>
				        	</li>
				        </ul>
				        You can see this project on <a href="https://github.com/amadeoas/spring-customerform">here</a>.
				  	</div>
		        </div>
		    </div>
			<customerform:footer/>
		</div>

		<jsp:include page="fragments/footer.jsp"/>
		</fmt:bundle>
	</body>
</html>
