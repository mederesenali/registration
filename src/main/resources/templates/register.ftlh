<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="center">Registration</h1>
<form class="mt-5" action="/registration" method="post">
    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'CSRF-TOKEN'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>
    <div class="form-group">
        <label for="fullName">full name</label>
        <input type="text" class="form-control" name="fullName" id="fullName" placeholder="full name">
    </div>
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Password">
    </div>


    <button type="submit" class="btn btn-primary">registration</button>
    <a href="/login" class="btn btn-primary">login</a>
</form>
</div>
</body>
</html>