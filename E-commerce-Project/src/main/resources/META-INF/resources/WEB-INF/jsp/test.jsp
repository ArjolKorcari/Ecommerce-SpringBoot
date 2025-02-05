<%@ include file="common/nav.jsp" %>
<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Checkout</title>
</head>
<div class="container">
	<hr>
	<h1>Your Economists are:</h1>
	<table class="table">
		<thead>
			<tr>

				<th>Name</th>
				<th>Surname</th>
				<th>salary</th>
				<th>Years of Employee</th>

			</tr>

		</thead>
		<tbody>
			<c:forEach items="${cartProducts}" var="cartProduct">
				<tr>
					<td>${cartProduct.product.name}</td>
					<td>${economist.surname }</td>
					<td>${economist.salary }</td>
					<td>${economist.yearsOfEmployee}<c:choose>
							<c:when test="${economist.yearsOfEmployee == 1}">
                        year
                    </c:when>
							<c:otherwise>
                        years
                    </c:otherwise>
						</c:choose>
					</td>
					<td><a href="delete-economist?id=${economist.id}"
						class="btn btn-warning">Delete </a></td>
					<td><a href="update-economist?id=${economist.id}"
						class="btn btn-success">Update </a></td>
					<td><a href="calculate-economist-bonus?id=${economist.id}"
						class="btn btn-success">Calculate Bonus </a></td>





				</tr>



			</c:forEach>

		</tbody>

	</table>
	<a href="add-economist" class="btn btn-success">Add Economist</a>
</div>
<%@ include file="common/footer.jsp"%>