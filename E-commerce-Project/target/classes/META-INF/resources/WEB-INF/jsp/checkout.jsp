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
<body style=" background-color: #C3CBD6">

<br>
    <div class="container rounded bg-white mt-7 mb-7" >
        <div class="row" >
        
            <div class="col-md-7 border-right">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Billing address</h4>
                    </div>
                    
                    
        <br>
        <form action="confirmed" method="post">
        
            <div class="row">
				    <div class="col">
				        <label for="firstName">First Name</label>
				        <input type="text" class="form-control" id="firstName" aria-label="First name">
				    </div>
				    <div class="col">
				        <label for="lastName">Last Name</label>
				        <input type="text" class="form-control" id="lastName" aria-label="Last name">
				    </div>
			</div>
			<br>
			    <div class="input-group">
			      <span class="input-group-text" id="basic-addon1">@</span>
			      <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
			    </div>
			    
			  <br>
			    <div class="mb-3">
					  <label for="formGroupExampleInput" class="form-label">Email</label>
					  <input type="text" class="form-control" id="formGroupExampleInput" placeholder="info@email.com">
				</div>

             <div class="row">
					  <div class="col-12">
					    <label for="inputAddress" class="form-label">Address</label>
					    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
					  </div>
				  </div>
				  <div class="row">
					  <div class="col-12">
					    <label for="inputAddress2" class="form-label">Address 2 </label>
					    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
					  </div>
				  </div>
				  <div class="row">
					  <div class="col-md-6">
					    <label for="inputCity" class="form-label">City</label>
					    <input type="text" class="form-control" id="inputCity">
					  </div>
					  <div class="col-md-2">
					    <label for="inputState" class="form-label">State</label>
					    <select id="inputState" class="form-select">
					      <option selected>Choose...</option>
					      <option>Albania</option>
					      <option>Italy</option>
					      <option>Germany</option>
					    </select>
					  </div>
				  
					  <div class="col-md-2">
					    <label for="inputZip" class="form-label">Zip</label>
					    <input type="text" class="form-control" id="inputZip">
					  </div>
				  </div>

          <div class="row">
				  <div class="col-12">
				    <div class="form-check">
				      <input class="form-check-input" type="checkbox" id="gridCheck">
				      <label class="form-check-label" for="gridCheck">
				        Check me out
				      </label>
				    </div>
				  </div>
		        </div>
		        <hr>
		        <h3>Payment</h3>
        
				  
				    <div class="form-check">
				        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
				        <label class="form-check-label" for="gridRadios1">
				          Credit cart
				        </label>
				      </div>
				      <div class="form-check">
				        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
				        <label class="form-check-label" for="gridRadios2">
				          Debit cart
				        </label>
				      </div>
				      <div class="form-check">
				        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="option2">
				        <label class="form-check-label" for="gridRadios2">
				          Paypal 
				        </label>
				      </div>
				      <br>
				      
				       <div class="row">
						  <div class="col-md-6">
						    <label for="inputCity" class="form-label">Name on card</label>
						    <input type="text" class="form-control" id="inputCity">
						    <small id="nameHelp" class="form-text text-muted">Full name as displayed on card</small>
						  </div>
						  <div class="col-md-6">
						    <label for="inputCity" class="form-label">Credit card number</label>
						    <input type="text" class="form-control" id="inputCity">
						  </div>
						</div>
						<br>
						<div class="row">
						<div class="col-md-4">
						    <label for="inputCity" class="form-label">Expiration</label>
						    <input type="text" class="form-control" id="inputCity">
						  </div>
						  <div class="col-md-4">
						    <label for="inputCity" class="form-label">CVV</label>
						    <input type="text" class="form-control" id="inputCity">
						  </div>
						  
						</div>
						
						<br>
						
						  <input type="submit" value="Pay &euro;${subtotal}" class="btn btn-primary btn-block"><br>
						
		      </div>
		    </form>
          </div>
          
          <div class="col-md-4">
			    <div class="p-3 py-5">
			        <div class="d-flex justify-content-between align-items-center mb-3">
			            <h4 class="text-right">Your Cart</h4>
			        </div>
			        <div class="col-md-15" style="position: sticky; top: 10px; right: 0; margin-left 90px;">
			            <div class="card" style="margin-top: 20px; ">
			                <div class="card-body">
			                    <h5 class="card-title">Subtotal</h5>
			                    <h6 class="card-subtitle mb-2 text-muted">Items: ${quantity}</h6>
			                    <h6 class="card-subtitle mb-2 text-muted">Total: &euro;${subtotal}</h6>
			                   <div class="input-group mb-3">
								  <input type="text" class="form-control" placeholder="Promo Code" aria-label="Recipient's username" aria-describedby="basic-addon2">
								 <form id="redeemForm" >
								    <input type="hidden" name="code" value="code" required>
								    <button type="submit" class="btn btn-secondary">Redeem</button>
								</form>

							   </div>
			                </div>
			            </div>
			        </div>
			        
			        
			      <table class="table">
    <thead>
        <tr>
            <th>Products</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Subtotal</th>
        </tr>
    </thead>
    <tbody>
       <c:forEach var="cartProduct" items="${cartProducts}">
            <tr>
                <td>${cartProduct.product.name}</td>
                <td>${cartProduct.quantity}</td>
                <td>${cartProduct.product.price}</td>
                <td>${cartProduct.product.price * cartProduct.quantity}</td>
            </tr> 
       </c:forEach>
    </tbody>
</table>


			            
			            
			            
			    </div>
			    
			</div>
        </div>
        </div>
        
        
        
        
        
        

				 
			
<%@ include file="common/footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>