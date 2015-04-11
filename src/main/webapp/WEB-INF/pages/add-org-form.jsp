<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setBundle basename="messages" var="language" scope="session"/>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<form:form method="POST" commandName="organization"
				action="${pageContext.request.contextPath}/organization/add.html">

			<h3><fmt:message key="add.org.page" bundle="${language}"/></h3>
			<p><fmt:message key="add.org.page.text" bundle="${language}"/></p>
				<p>${message}</p>
				<div class="form-group">
					<label for="usr"><fmt:message key="add.org.page.name" bundle="${language}"/></label>
					<form:input path="orgName" class="form-control" />
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary"  value="Add Organization"/>
				</div>

			</form:form>
			<p>
				<a href="${pageContext.request.contextPath}/index.html" class="btn btn-primary"><fmt:message key="button.home.page" bundle="${language}"/></a>
			</p>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>