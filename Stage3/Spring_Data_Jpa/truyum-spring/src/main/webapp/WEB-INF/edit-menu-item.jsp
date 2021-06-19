<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<title>truYum</title>
	<link rel="icon" type="image/ico" href="truyum-logo-dark.png" />
	<link rel="stylesheet" type="text/css" href="style.css">
	<script src="script.js"></script>
</head>
<body>
		<header>
			<span class="header-title">truYum</span>
			<img class="header-logo" src="truyum-logo-light.png" alt="truYum Logo"></img>
			<nav>
				<a class="nav-link" href="./menuAdmin">Menu</a>
			</nav>
		</header>
		<article>
			<h2 class="article-heading">Edit Menu Item</h2>
			<form:form name="editMenuItemForm" onsubmit="return validateForm();" method="post" modelAttribute="menuItem">
				<table class="form-table">
					<tr>
						<td colspan="4">
							<form:label class="form-item" path="name" for="field-title">Title</form:label>
							<form:input class="form-input" type="text" path="name" name="title" id="field-title" value="${item.name }"></form:input>
						</td>
					</tr>
					<tr>
						<td>
							<form:label class="form-item" path="price" for="field-price">Price (Rs.)</form:label>
							<form:input class="form-input form-input-right" type="text" path="price" name="price" id="field-price" value="${item.price }"></form:input>
						</td>
						<th>
							<form:label class="form-item" path="active" for="field-yes">Active</form:label><br>
									<form:radiobutton path="active" value="true" /><label class="form-item" for="field-yes">Yes</label>
									<form:radiobutton path="active" value="false"/><label class="form-item" for="field-no">No</label>
								
						</th>
						<td>
							<form:label class="form-item" path="dateOfLaunch" for="field-dateOfLaunch">Date of Launch</form:label>
							<fm:formatDate value="${item.dateOfLaunch}" pattern="dd/MM/yyyy" var="date"/>
							<form:input class="form-input" type="text" path="dateOfLaunch" name="dateOfLaunch" id="field-dateOfLaunch" placeholder="dd/mm/yyyy" value="${date}"></form:input>
						</td>
						<td>
							<form:label class="form-item" path="category" for="field-category">Category</form:label>
							<form:select class="form-input" path="category" name="category" id="field-category">
								<option value="select">--Select--</option>
								<option value="Starters">Starters</option>
								<option value="Main Course" selected>Main Course</option>
								<option value="Desert">Desert</option>
								<option value="Drinks">Drinks</option>
							</form:select>
						</td>
					</tr>
					<tr colspan=4>
						<td>
							<form:label class="form-item" path="freeDelivery" for="field-freeDelivery">
								<c:choose>
									  <c:when test="${item.freeDelivery==true}">
									    <form:checkbox path="freeDelivery" value="true"/> Free Delivery
										<span class="form-checkbox"></span>
									  </c:when>
									  <c:otherwise>
									    <form:checkbox path="freeDelivery"/> Free Delivery
										<span class="form-checkbox"></span><td>No</td>
									  </c:otherwise>
								</c:choose>
							</form:label>
						</td>
					</tr>
					<tr colspan=4>
						<td>
							<input class="form-button" type="submit" name="submit" value="Save"></input>
						</td>
					</tr>
				</table>
			</form:form>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
</body>
</html>