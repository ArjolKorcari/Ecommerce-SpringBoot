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
    <title>Cart</title>

    
</head >
<body style=" background-color: #C3CBD6">	
<div class="container">
    <div class="row">
        <div class="col-md-7" style="margin-top: 10px; margin-right:95px;"> <!-- Ndryshimi kryesor është këtu -->
            <div class="column">
                <c:forEach var="cartProduct" items="${cartProducts}">
                    <div class="col-md-12" style=" margin:10px; display: flex; align-items: center; margin-bottom: 20px; background-color: #CBD0D8"> <!-- Ndryshimi kryesor është këtu -->
                        <div style="flex: 1;" >
                            <img class="card-img-top" src="${cartProduct.product.image}" alt="Product 1" style="width: 100%;">
                        </div>
                        <div style="flex: 1; padding-left: 20px;">
                            <div class="card-body">
                                <div>
                                    <b><h4 class="card-title">${cartProduct.product.name}</h4></b>
                                    <h5 class="card-text">Category: ${cartProduct.product.category.name}</h5>
                                    <h5 class="card-text">Price: &euro;${cartProduct.product.price}</h5>
                                    <p class="card-text" style="margin-bottom: 40px;"> ${cartProduct.product.description}</p>
                                    
                        <form id="updateCartForm" action="update-quantity" method="post">
                       
		               <div  style="margin: 10px;">
		             
						           <input type="hidden" name="id" value="${cartProduct.product.id}">
						           <input class="btn-sm" type="number" id="numri" name="quantity" style="width: 50px;" placeholder=" ${cartProduct.quantity}">
						          
        					
					        <a href="delete-products?id=${cartProduct.id}">
					            <button type="button" class="btn btn-outline-success btn-sm">Delete</button>
					        </a>
					        <a >
					            <button type="button" class="btn btn-outline-success btn-sm">Save for Later</button>
					        </a>
					         <div style="padding: 10px; ">
					        
					        <a href="whatsapp://send?text=Hello%20World!">
					            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/WhatsApp.svg/2044px-WhatsApp.svg.png" alt="WhatsApp" width="24" height="24">
					        </a>
					        <a href="https://www.instagram.com/share?url=https://www.example.com">
					            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e7/Instagram_logo_2016.svg/768px-Instagram_logo_2016.svg.png" alt="Instagram" width="24" height="24">
					        </a>
					        <a href="https://www.facebook.com/sharer/sharer.php?u=https://www.example.com">
					            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Logo_of_Twitter.svg/512px-Logo_of_Twitter.svg.png" alt="Facebook" width="24" height="24">
					        </a>
					        <a href="https://www.facebook.com/sharer/sharer.php?u=https://www.example.com">
					            <img src="https://i.pinimg.com/736x/7c/cb/40/7ccb40e2fa23d39346cc9dc8691d68b3.jpg" alt="Facebook" width="24" height="24">
					        </a>
					       
                  </div>
        
    </div>
    
</form>

                                    	
                                    		
                                	
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-4" style="position: sticky; top: 10px; right: 0; margin-left 90px;">
            <div class="card" style="margin-top: 20px; ">
                <div class="card-body">
                    <h5 class="card-title">Subtotal</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Items: ${quantity}</h6>
                    <h6 class="card-subtitle mb-2 text-muted">Total: &euro;${subtotal}</h6>
                    <a href="checkout" class="card-link"><button type="button" class="btn btn-warning">Proceed to Checkout</button></a>
                </div>
            </div>
        </div>
    </div>
</div>










  </main>
  <%@ include file="common/footer.jsp" %>
    <div class="container">
      <p>&copy; 2024 Ecommerce Shop. All rights reserved
      
      <script>
    function setNewQuantity(quantity) {
        document.getElementById('newQuantity').value = quantity;
        document.getElementById('updateCartForm').submit();
    }
</script>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script>
//Krijo funksionin për të bërë kërkesën DELETE
function deleteProduct(productId) {
    // Përcakto rrugën e kërkesës
    const url = `/delete-products?id=${productId}`;

    // Përcakto opsionet e kërkesës
    const options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json' // mund të nevojitet të ndryshohet sipas nevojës
        }
    };

    // Bëj kërkesën DELETE përmes fetch
    fetch(url, options)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            // Mund të shtosh kodin për t'u ekzekutuar pas fshirjes së suksesshme
            // për shembull, rifresko faqen ose ndrysho përmbajtjen
            console.log('Product deleted successfully');
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

</script>


<script type="text/javascript">
document.querySelectorAll('.dropdown-menu a').forEach(item => {
    item.addEventListener('click', event => {
        // Merr vlerën e numrit nga opsioni i klikuar
        var selectedNumber = parseInt(event.target.innerText.substring(1));
        
        // Gjej butonin e "+1" dhe ndrysho tekstin e tij
        document.querySelector('.btn.btn-outline-success.btn-sm.dropdown-toggle').innerText = '+' + selectedNumber;
    })
});


</script>

</body>
</html>




</body>