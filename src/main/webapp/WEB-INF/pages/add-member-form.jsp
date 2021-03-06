<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setBundle basename="messages" var="language" scope="session"/>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">

		<div class="container">
			<form:form method="POST" commandName="member"
				action="${pageContext.request.contextPath}/member/add.html">

			<h3><fmt:message key="add.member.page" bundle="${language}"/></h3>
			<p><fmt:message key="add.member.page.text" bundle="${language}"/></p>
				<p>${message}</p>
				<div class="form-group">
					<label for="usr"><fmt:message key="add.member.page.first.name" bundle="${language}"/></label>
					<form:input path="firstName" class="form-control" />
				</div>
				<div class="form-group">
					<label for="pwd"><fmt:message key="add.member.page.last.name" bundle="${language}"/></label>
					<form:input path="lastName" class="form-control" />
				</div>
				<div class="form-group">
					<label for="pwd"><fmt:message key="add.member.page.teams" bundle="${language}"/></label>
					<form:select path="teamsIds" multiple="multiple"
						class="form-control">
						 <c:forEach var="team" items="${teams}">
							<form:option value="${team.id}">${team.name}, rating = ${team.rating}</form:option>
						</c:forEach>
					</form:select>
					
					
		
				</div>
				<div class="form-group">
					<input type="submit" value="Add Member" class="btn btn-primary"  value="Add Member"/>
				</div>

			</form:form>

			<p>
				<a href="${pageContext.request.contextPath}/index.html" class="btn btn-primary"><fmt:message key="button.home.page" bundle="${language}"/></a>
			</p>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>