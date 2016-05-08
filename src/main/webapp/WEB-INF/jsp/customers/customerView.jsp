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
		<customerform:bodyHeader menuName="customersView"/>

		<div class="container-fluid">
		    <div class="container xd-container">
		        <h2><fmt:message key="customerView"/></h2>
		
		        <table>
		        	<tr>
		        		<th><fmt:message key="tbFirstName"/></th>
		        		<td class="field_data"> <c:out value="${customer.firstName}"/></td>
		        	</tr>
		        	<tr>
		        		<th><fmt:message key="tbLastName"/></th>
		        		<td class="field_data"> <c:out value="${customer.lastName}"/></td>
		        	</tr>
		        </table>
		
		        <customerform:footer/>
		    </div>
		</div>
		
		<jsp:include page="../fragments/footer.jsp"/>
	</body>
	</fmt:bundle>
</html>
