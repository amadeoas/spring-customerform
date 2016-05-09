<!DOCTYPE html>

<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="datatables" uri="http://github.com/dandelion/datatables" %>
<%@ taglib prefix="customerform" tagdir="/WEB-INF/tags" %>

<html lang="${language}">
	<fmt:setLocale value="${language}"/>
	<fmt:bundle basename="messages.messages">
	<c:set var="msg_firstname" scope="request">
		<fmt:message key="tbFirstName"/>
	</c:set>
	<c:set var="msg_lastname" scope="request">
		<fmt:message key="tbLastName"/>
	</c:set>
	<c:set var="msg_actions" scope="request">
		<fmt:message key="tbActions"/>
	</c:set>
	<c:set var="msg_viewElement" scope="request">
		<fmt:message key="viewElement"/>
	</c:set>
	<c:set var="msg_changeElement" scope="request">
		<fmt:message key="changeElement"/>
	</c:set>
	<c:set var="msg_deleteElement" scope="request">
		<fmt:message key="deleteElement"/>
	</c:set>
	<c:set var="msg_addElement" scope="request">
		<fmt:message key="addElement"/>
	</c:set>
	<c:set var="msg_multiAddElement" scope="request">
		<fmt:message key="multiAddElement"/>
	</c:set>
	<c:set var="msg_search" scope="request">
		<fmt:message key="search"/>
	</c:set>
	<jsp:include page="../fragments/htmlHeader.jsp"/>
	
	<body onload="setLanguage('${language}', '${msg_search}', 'customers');">
		<customerform:bodyHeader menuName="customers"/>

		<div class="container-fluid">
		    <div class="container xd-container">
		        <h2><fmt:message key="customers"/></h2>
		
		        <datatables:table id="customers" data="${customers}" row="customer"
		                          cssClass="table table-striped" pageable="false" info="false">
		            <datatables:column title="${msg_firstname}">
		                <c:out value="${customer.firstName}"/>
		            </datatables:column>
		            <datatables:column title="${msg_lastname}">
		                <c:out value="${customer.lastName}"/>
		            </datatables:column>
		            <datatables:column title="${msg_actions}">
		            	<a href="/customerform/customers/view/${customer.id}?lang=${language}" title="${msg_viewElement}"><span class="glyphicon glyphicon-th-list icon-blue"></span></a> <a href="/customerform/customers/edit/${customer.id}?lang=${language}" title="${msg_changeElement}"><span class="glyphicon glyphicon-pencil icon-blue"></span></a> <a href="/customerform/customers/delete/${customer.id}?lang=${language}" title="${msg_deleteElement}"><span class="glyphicon glyphicon-trash icon-blue"></span></a> - 
		            	<a href="/customerform/customers/addView/${customer.id}?lang=${language}" title="${msg_addElement}"><span class="glyphicon glyphicon-plus icon-blue"></span></a> <a href="/customerform/customers/multiAddView?lang=${language}" title="${msg_multiAddElement}"><span class="glyphicon glyphicon-plus-sign icon-blue"></span></a>
		            </datatables:column>
		        </datatables:table>
		
		        <customerform:footer/>
		    </div>
		</div>
		
		<jsp:include page="../fragments/footer.jsp"/>
	</body>
	</fmt:bundle>
</html>
