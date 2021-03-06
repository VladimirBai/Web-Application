<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.03.2019
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style/style.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            background-color: #fdeeff;
        }
    </style>
</head>
<body>
<main class="m-3">
    <div class="row">
        <div class="col">

        </div>
        <div class="col text-center">
            <h1><c:out value="${operation}"/> artist</h1>
        </div>
        <div class="col">

        </div>
    </div>
    <hr>
    <div class="container-fluid">
        <div class="row">
            <div class="col text-right">
                <div class="btn-group-vertical mr-3">
                    <a href="/artists" class="btn btn-light mb-2">Back</a>
                    <a href="/" class="btn btn-light mb-2">Home</a>
                    <a href="/tracks" class="btn btn-light mb-2">Songs</a>
                    <a href="/genres" class="btn btn-light mb-2">Genres</a>
                </div>
            </div>
            <div class="col text-center">
                <form method="post">
                    <div class="form-row">
                        <div class="form-group col">
                            <label for="artistNameId">Name</label>
                            <input type="text" placeholder="Name" name="name" id="artistNameId" class="form-control" value="<c:out value="${artist.name}" default=""/>"/>
                        </div>
                        <div class="form-group col">
                            <label for="artistAgeId">Age</label>
                            <input type="text" placeholder="Age" name="age" id="artistAgeId" class="form-control" value="<c:out value="${artist.age}" default=""/>"/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-success">Confirm</button>
                </form>
            </div>
            <div class="col">

            </div>
        </div>
    </div>
</main>
</body>
</html>
