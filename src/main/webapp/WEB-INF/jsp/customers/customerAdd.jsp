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
	
	<body onload="setLanguage('${language}', '${msg_search}', 'customers');">
		<customerform:bodyHeader menuName="customersAdd"/>
		<c:set var="msg_add" scope="request">
			<fmt:message key="add"/>
		</c:set>

		<div class="container-fluid">
		    <div class="container xd-container">
		        <h2><fmt:message key="customerView"/></h2>
		
				<div>
					<form id="add" action="/customerform/customers/add" enctype="application/json" method="post">
				        <table>
				        	<tr>
				        		<th><fmt:message key="tbFirstName"/></th>
				        		<td class="field_data"><input id="firstName" name="firstName" type="text" value="" required/></td>
				        	</tr>
				        	<tr>
				        		<th><fmt:message key="tbLastName"/></th>
				        		<td class="field_data"><input id="lastName" name="lastName" type="text" value="" required/></td>
				        	</tr>
				        </table>
		                <div id="footer" class="footer">
							<button type="submit" form="add" value="${msg_add}" class="btn_bottom"><fmt:message key="add"/></button>
		               	</div>
		        	</form>
		        </div>
		
		        <customerform:footer/>
		    </div>
		</div>
		
		<jsp:include page="../fragments/footer.jsp"/>
	</body>
	</fmt:bundle>
</html>
