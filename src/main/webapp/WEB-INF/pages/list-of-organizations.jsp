<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setBundle basename="messages" var="language" scope="session"/>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="container">
			<h3><fmt:message key="org.list.page.list" bundle="${language}"/></h3>
			<p><fmt:message key="org.list.page.description" bundle="${language}"/></p>
			<table class="table table-hover table-bordered">
				<thead>
					<tr class="active">
						<th width="5%"><fmt:message key="org.list.page.id" bundle="${language}"/></th>
						<th width="30%"><fmt:message key="org.list.page.name" bundle="${language}"/></th>
						<th width="10%"><fmt:message key="org.list.page.actions" bundle="${language}"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="organization" items="${organizations}">
						<tr class="active">
							<td>${organization.id}</td>
							<td>${organization.orgName}</td>
							<td><a class="btn btn-primary"
								href="${pageContext.request.contextPath}/organization/edit/${organization.id}.html"><fmt:message key="button.edit" bundle="${language}"/></a>
								<a class="btn btn-primary"
								href="${pageContext.request.contextPath}/organization/delete/${organization.id}.html"><fmt:message key="button.delete" bundle="${language}"/></a>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>
				<a href="${pageContext.request.contextPath}/index.html" class="btn btn-primary"><fmt:message key="button.home.page" bundle="${language}"/></a>
			</p>
		</div>


	</tiles:putAttribute>
</tiles:insertDefinition>
