<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setLocale value="en_US" />
<fmt:setBundle basename="messages" var="language" scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="${language}">
<head>
<title>Organization manager</title>
<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"/> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://bootswatch.com/spacelab/bootstrap.css" />

</head>

<div class="container">
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Organization Manager: </a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"><fmt:message
							key="header.organization" bundle="${language}" /> <span
						class="caret"></span> </a>
					<ul class="dropdown-menu" role="menu">
						<li><a
							href="${pageContext.request.contextPath}/organization/list.html"><fmt:message key="header.organization.list" bundle="${language}" /></a></li>
						<li class="divider"></li>
						<li><a
							href="${pageContext.request.contextPath}/organization/add.html"><fmt:message
									key="header.organization.add" bundle="${language}" /></a></li>
					</ul></li>


				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"><fmt:message
							key="header.team" bundle="${language}" /> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a
							href="${pageContext.request.contextPath}/team/list.html"><fmt:message
									key="header.team.list" bundle="${language}" /></a></li>
						<li class="divider"></li>
						<li><a
							href="${pageContext.request.contextPath}/team/add.html"><fmt:message
									key="header.team.add" bundle="${language}" /></a></li>
					</ul></li>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"><fmt:message
							key="header.member" bundle="${language}" /> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a
							href="${pageContext.request.contextPath}/member/list.html"><fmt:message
									key="header.member.list" bundle="${language}" /></a></li>
						<li class="divider"></li>
						<li><a
							href="${pageContext.request.contextPath}/member/add.html"><fmt:message
									key="header.member.add" bundle="${language}" /></a></li>
					</ul></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
</div>




</html>