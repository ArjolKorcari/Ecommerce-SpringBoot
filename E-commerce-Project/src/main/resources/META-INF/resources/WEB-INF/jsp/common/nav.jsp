<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css  " />
    

<nav class="navbar navbar-expand-lg navbar-light " style=" background-color: #013328">
    <div class="container-fluid">
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
		
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        
            <h4 style="color: #FFE3CA">Welcome ${user.username}</h4>
           
            <ul class="navbar-nav mr-auto">
                   <li class="nav-item active">
	                    <a class="nav-link" th:href="@{/}" href="products" style="color:white;  " >
	                    
	                    Home</a>
	             </li>
	        </ul>
                 
            <ul class="navbar-nav">
            

            
            
            	
                
                <li class="nav-item">
				    <form class="d-flex" role="search" action="search" method="GET">
				        <input name="keyword" id="search-input" class="form-control me-2" type="search" placeholder="Search by name, category" aria-label="Search" style="width: 400px;">
				        <button class="btn btn-outline-success custom-button" type="submit"><i class="fa-solid fa-magnifying-glass" style="color:white;"></i></button>
				    </form>
				</li>

                
              
            

                <li class="nav-item active">
	                    <a class="nav-link" th:href="@{/}" href="getCarts" style="color:white;  " ><i class="fa-solid fa-cart-shopping"></i> Cart</a>
	            </li>
	            
	            
	             
	             
	             
	             
	             
                <li class="nav-item active">
                    <a class="nav-link" href="profileDisplay?id=${user.id}" style="color:white;"><i class="fa-solid fa-user"></i> Profile</a>
                </li>
                
            </ul>
        </div>
    </div>
</nav>