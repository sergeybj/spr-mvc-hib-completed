<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setBundle basename="messages" var="language" scope="session"/>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="container">
			<form:form method="POST" commandName="team"
				action="${pageContext.request.contextPath}/team/add.html">

			<h3><fmt:message key="add.team.page" bundle="${language}"/></h3>
			<p><fmt:message key="add.team.page.text" bundle="${language}"/></p>
				<p>${message}</p>
				<div class="form-group">
					<label for="usr"><fmt:message key="add.team.page.name" bundle="${language}"/></label>
					<form:input path="name" class="form-control" />
				</div>
				<div class="form-group">
					<label for="pwd"><fmt:message key="add.team.page.rating" bundle="${language}"/></label>
					<form:input path="rating" class="form-control" />
				</div>
				<div class="form-group">
					<label for="pwd"><fmt:message key="add.team.page.org" bundle="${language}"/></label>
					<form:select path="organizationId" class="form-control">
						<c:forEach var="organization" items="${organizationList}">
							<form:option value="${organization.id}">${organization.orgName}</form:option>
						</c:forEach>
					</form:select>


				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary"  value="Add Team"/>
				</div>

			</form:form>
			<p>
				<a href="${pageContext.request.contextPath}/index.html" class="btn btn-primary"><fmt:message key="button.home.page" bundle="${language}"/></a>
			</p>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>