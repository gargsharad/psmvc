<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<div class="header">
	<c:url value="/web/index.jsp" var="homeUrl" />
	<div class="logo">
		<a href="${homeUrl}"><img
			src="<c:url value="/assets/images/logo.gif" context="/psmvc"/>" alt=""
			title="" border="0" /></a>
	</div>
	<div class="nav">
		<ul style="float: left;">
			<li class="selected"><a href="${homeUrl}"><spring:message
						code="nav.home" /></a></li>
			<li><a href="<c:url value="/web/book/search" context="/psmvc"/>"><spring:message
						code="nav.books" /></a></li>
			<li><a href="<c:url value="/web/customer/account" context="/psmvc"/>"><spring:message
						code="nav.account" /></a></li>
			<li><a href="<c:url value="/web/cart/checkout" context="/psmvc"/>"><spring:message
						code="nav.checkout" /></a></li>
			<c:if test="${sessionScope.account eq null}">
				<li><a href="<c:url value="/web/customer/register" context="/psmvc"/>"><spring:message
							code="nav.register" /></a></li>
				<li><a href="<c:url value="/web/login" context="/psmvc"/>"><spring:message
							code="nav.login" /></a></li>
			</c:if>
			<c:if test="${sessionScope.account ne null}">
				<li><a href="<c:url value="/web/logout" context="/psmvc"/>"><spring:message
							code="nav.logout" /></a></li>
			</c:if>

		</ul>
		<ul style="float: right;">
			<li><a href="?lang=en" class="selected"><img
					src="<c:url value="/assets/images/gb.gif" context="/psmvc"/>" alt=""
					title="" border="0" /></a></li>
			<li><a href="?lang=nl"><img
					src="<c:url value="/assets/images/nl.gif" context="/psmvc"/>" alt=""
					title="" border="0" /></a></li>
		</ul>
	</div>
</div>