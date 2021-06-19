<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<!DOCTYPE html>
<html>
<head>
	<title>truYum</title>
		<link rel="icon" type="image/ico" href="truyum-logo-dark.png" />
		<link rel="stylesheet" type="text/css" href="style.css">
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
			<h2 class="article-heading">Menu Items</h2>
			<table>
				<thead>
					<tr>
						<th class="col-left">Name</th>
						<th class="col-right">Price</th>
						<th>Active</th>
						<th>Date of Launch</th>
						<th>Category</th>
						<th>Free Delivery</th>
						<th>Action</th>
					</tr>	
				</thead>
				<tbody>
					<c:forEach items="${menu_list}" var="todo">
						<tr>
							<td class="col-left">${todo.name }</td>
							<td class="col-right">Rs. ${todo.price}</td>
							<c:choose>
								  <c:when test="${todo.active==true}">
								    <td>Yes</td>
								  </c:when>
								  <c:otherwise>
								    <td>No</td>
								  </c:otherwise>
							</c:choose>	
							<td><fm:formatDate value="${todo.dateOfLaunch}" pattern="dd/MM/yyyy"/></td>
							<td>${todo.category}</td>
							<c:choose>
								  <c:when test="${todo.freeDelivery==true}">
								    <td>Yes</td>
								  </c:when>
								  <c:otherwise>
								    <td>No</td>
								  </c:otherwise>
							</c:choose>
							<td>
								<a class="action-link" href="./editOrder?id=${todo.id}">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</article>
		<footer>
			<p>Copyright &copy; 2019</p>
		</footer>
</body>
</html>