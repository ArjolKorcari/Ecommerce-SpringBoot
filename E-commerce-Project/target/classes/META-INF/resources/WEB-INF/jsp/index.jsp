<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/nav.jsp" %>



<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
	<c:url value="//jsp/img.jpeg" var="logo"/>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
          <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <title>Home</title>

    
</head >

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <style>
    body {
      
    }
     .card-body {
          height: 260px; 
        }

        .card-img-top {
          max-height: 100px; 
          object-fit: contain;
        }
        
        .carousel-item img {
            
		    margin: 0 auto; 
		    display: block;
		    backround-color:black;
		}
         .center{
		  text-align: center;
		  
		  }
		  .h5-text{
		  color:#102C57;
		   font-weight: bold;
		  }
		  .carousel-control-next,
		  .carousel-control-prev{
		  color:black;
		  border: none;
		   background: transparent;}
		  
		  
		
        

  </style>
</head>
<body  style=" background-color: #C3CBD6">
  <section class="wrapper">
        <div class="container-fostrap">
  <main>

    <div class="container">
   <style>
  .text-center {
    background-color: #CBD0D8; 
    padding: 20px; 
  }
  
 
  
  
 
  
  
</style>

<figure class="text-center">
  <blockquote class="blockquote">
    <p>Empower your clicks to unlock limitless aisles.</p>
  </blockquote>
  <figcaption class="blockquote-footer">
    This is more than just an app<cite title="Source Title"> Your digital gateway</cite>
  </figcaption>
</figure>
<div class="dropdown" style="margin: 10px;">
  <button class="btn btn-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false" style=" background-color: white">
  <i class="fa-solid fa-list"></i>
    Category
  </button>
  <ul class="dropdown-menu">
    <li><c:forEach items="${categories}" var="category">
    		<a class="dropdown-item" href="category?id=${category.id}">${category.name }</a>
    	</c:forEach>	
    </li>
    
  </ul>
  
</div>

<c:if test="${showProductCarousel}">
<div class="center"> <h5 class="h5-text">
<i class="fa-solid fa-fire"></i>
Trending Products:</h5></div>
  <hr>
		  <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
			    <div class="carousel-inner">
			        <c:forEach items="${popularProducts}" var="product" varStatus="loop">
			            <div class="carousel-item ${loop.first ? 'active' : ''}">
			                <img src="${product.image}" class="d-block w-50" alt="...">
			                 <div class="carousel-caption d-none d-md-block">
						        <h5>${product.name }</h5>
						        <p>${product.description }</p>
			      		     </div>
			            </div>
			        </c:forEach>
			    </div>
			    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
				  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				  <span class="visually-hidden">Previous</span>
				</button>
			
			
			  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			    <span class="visually-hidden">Next</span>
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			  </button>
			</div>
	<hr>

</c:if>


   
    
<br>


      
   

      <div class="row">
    <c:forEach var="product" items="${products}">
        <div class="col-md-3">
            <div class="card mb-4" style="background-color: #CBD0D8">
                <img class="card-img-top" src="${product.image}" alt="Product 1">
                <div class="card-body">
                    <div>
                        <b><h4 class="card-title">${product.name}</h4></b>
                        <h5 class="card-text">Category: ${product.category.name}</h5>
                        <h5 class="card-text">Price: &euro;${product.price}</h5>
                        <p class="card-text" style="margin-bottom: 40px;">${product.description}</p>
                    </div>
                </div>
                <form action="add-to-cart" method="post">
                    <input type="hidden" name="id" value="${product.id}">
                    <input type="hidden" name="quantity" value=1>
                    <div style="position: absolute; bottom: 0; left: 0; right: 0;">
                        <button type="submit" class="btn btn-primary" style="background-color: #013328;">
                        <i class="fa-solid fa-cart-plus"></i>
                        Add to Cart</button>
                    </div>
                </form>
            </div>
        </div>
    </c:forEach>
</div>



    </div>
  </main>
  <%@ include file="common/footer.jsp" %>
  

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>