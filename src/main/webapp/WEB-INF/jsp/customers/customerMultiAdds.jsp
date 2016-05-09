<!DOCTYPE html>

<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="customerform" tagdir="/WEB-INF/tags" %>

<html lang="${language}">
	<fmt:setLocale value="${language}"/>
	<fmt:bundle basename="messages.messages">
	<jsp:include page="../fragments/htmlHeader.jsp"/>
	<c:set var="msg_addElement" scope="request">
		<fmt:message key="addElement"/>
	</c:set>
	<c:set var="msg_rmvElement" scope="request">
		<fmt:message key="rmvElement"/>
	</c:set>
	<c:set var="msg_add" scope="request">
		<fmt:message key="add"/>
	</c:set>
	
	<!-- This need angular -->
	<body  ng-app="myApp" onload="setLanguage('${language}', '${msg_search}', 'customers');">
		<customerform:bodyHeader menuName="customersMultiAdd"/>

		<div id="multiAddController" ng-controller="multiAddController" class="container xd-container" ng-init="initAdds()">
		    <div class="container xd-container">
		        <h2><fmt:message key="customerView"/></h2>
		
				<div>
					<table>
				       	<tr>
				       		<th><fmt:message key="tbFirstName"/></th>
				       		<th><fmt:message key="tbLastName"/></th>
				       		<th><fmt:message key="tbActions"/></th>
			        	</tr>
			        	<tr ng-repeat="customer in customers">
			        		<td class="field_data"><input type="text" ng-model="customer.firstName" required/></td>
			        		<td class="field_data"><input type="text" ng-model="customer.lastName" required/></td>
			        		<td class="field_data">
			        			<a href ng-click="removeEntry($index)" title="${msg_rmvElement}" ng-class="{disabled: removedDisabled()}"><span class="glyphicon glyphicon-minus icon-blue"></span></a> - 
			        			<a href ng-click="addEntry()" title="${msg_addElement}"><span class="glyphicon glyphicon-plus icon-blue"></span></a>
			        		</td>
			        	</tr>
			        </table>
		            <div id="footer" class="footer">
						<button type="submit" form="" value="${msg_add}" ng-click="sendMultiAddPost(); $event.stopPropagation();" class="btn_bottom" ng-disabled="isButtonDisable();"><fmt:message key="add"/></button>
	               	</div>
		        </div>
		
		        <customerform:footer/>
		    </div>
		</div>
		
		<jsp:include page="../fragments/footer.jsp"/>
	</body>
	</fmt:bundle>
</html>
