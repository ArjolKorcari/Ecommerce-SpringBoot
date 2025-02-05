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
    <title>Profile</title>
</head>
<style>
#hiddenDiv {
    display: none;
}




</style>
<body style=" background-color: #C3CBD6">

<br>
    <div class="container rounded bg-white mt-5 mb-5" >
        <div class="row" >
        <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                		<img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                				<span class="font-weight-bold">${user.username } ${user.surname }</span>
                				<span class="text-black-50">${user.email }</span>
                				<span class="text-black-50"><a href="logout" method=get><button type="button" class="btn btn-danger">Logout</button></a></span>
                				
                				
                </div>
            </div>
            
            <div class="col-md-5 border-right">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                    <i class="fa-solid fa-gear"> Profile Settings</i>
                        
                    </div>
                    <hr>
                    <div class="alert alert-danger" role="alert" id="alertDive">
			            ${msge}
			        </div>
                    
                    
                    
        <br>
        
        <form action="updateUser" method="post">
    <div class="form-group">
    <i class="fa-regular fa-user"></i>
        <label for="firstName">User Name</label>
        <input type="text" name="username" id="firstName" required placeholder="Your Username*" value="${user.username}" required class="form-control form-control-lg">
    </div>
   
    <div class="form-group">
        <i class="fa-regular fa-envelope"></i>
        <label for="email">Email address</label>
        <input type="email" class="form-control form-control-lg" required minlength="6" placeholder="Email*" value="${user.email}" required name="email" id="email" aria-describedby="emailHelp">
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group" id="hiddenDiv">
	    <label for="password">Password</label>
	    <input type="password" class="form-control form-control-lg" required placeholder="Password*" value="${user.password}" required name="password" id="password">
	</div>
	<div class="form-group" id="hiddenDiv">
	    <label for="id">Id</label>
	    <input type="id" class="form-control form-control-lg" required placeholder="Password*" value="${user.id}" required name="id" id="id">
	</div>
    <div class="form-group">
        <i class="fa-solid fa-address-book"></i>
        <label for="Address">Address</label>
        <textarea class="form-control form-control-lg" rows="3" placeholder="Enter Your Address" name="address">${user.address}</textarea>
    </div>

    <input type="submit" value="Update Profile" class="btn btn-primary btn-block"><br>
</form>

        
        
        
    </div>
    
    
    
</div>
<div class="col-md-4">
    <div class="p-3 py-5">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <i class="fa-solid fa-lock"> Privacy Settings</i>
        </div>
        <hr>
        <div class="alert alert-danger" role="alert" id="alertDiv">
            ${msg}
        </div>
      <form action="/changePassword" method="post">
    <div class="form-group">
    	<i class="fa-regular fa-envelope"></i>
        <label for="email">Your current email address is:</label>
        <input type="email" class="form-control form-control-lg" value="${user.email}" name="email" id="email" aria-describedby="emailHelp" readonly>
    </div>
    
    <div class="form-group">
        <input type="password" class="form-control form-control-lg" required placeholder="Enter your current password" name="currentPassword" id="currentPassword">
    </div>
    
    <div class="form-group">
        <input type="password" class="form-control form-control-lg" required placeholder="Enter new password" name="newPassword" id="newPassword">
    </div>
    
    <div class="form-group">
        <input type="password" class="form-control form-control-lg" required placeholder="Re-type new password" name="newPassword2" id="newPassword2">
    </div>
    
    <input type="submit" value="Change Password" class="btn btn-primary btn-block">
</form>
</div>
</div>
</div>
</div>
<%@ include file="common/footer.jsp" %>
<script>
    var msg = "${msg}";
    var msge="${msge}";
</script>

<script>
    document.addEventListener('DOMContentLoaded', function () {
        var msg = "${msg}";
        var msge="${msge}";

        if (msg.trim() === "") {
            document.getElementById("alertDiv").style.display = "none";
        }
        if (msge.trim() === "") {
            document.getElementById("alertDive").style.display = "none";
        }
    });
</script>




<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>