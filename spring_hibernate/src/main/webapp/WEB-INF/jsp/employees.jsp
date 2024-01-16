<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>


    <div class="container-fluid">
        <div class="text-page">
            <p style="font-size: 22px;">
                <span style="font-weight: bold;">Пройдите регистрацию!</span>
         </p>
        </div>

        <div class="row">
            <div class="col-lg-6 col-md-12"
                 style="background: linear-gradient(80deg, rgb(160, 220, 255) 50%, #61ffa5 100%);">

<form method="post" action="/web/employees" enctype="multipart/form-data">
<div class="mb-3">
    <label for="FirstName" class="form-label">First Name</label>
    <input type="text" name="first_name" class="form-control" id="firstName" >
</div>
<div class="mb-3">
    <label for="lastName" class="form-label">Last Name</label>
    <input type="text" name="last_name" class="form-control" id="lastName" >

</div>
<div class="mb-3">
    <label for="salary" class="form-label">Salary</label>
    <input type="text" name="salary" class="form-control" id="salary" >

</div>
<div class="mb-3">
    <label for="name" class="form-label">Company Name</label>
    <input type="text" name="name" class="form-control" id="name">

</div>
<div class="mb-3">
    <label for="createdDate" class="form-label">Created Date</label>
    <input type="date" name="created_date" class="form-control" id="createdDate">



<div th:if="${errors}">
    <ul>
        <li th:each="error : ${errors}" th:text="${error.defaultMessage}"></li>
    </ul>
</div>
<button class="btn btn-primary" type="submit">Add</button>
</form>
</div>

            <div class="col-lg-6 col-md-12"
                 style="background: linear-gradient(80deg, rgb(160, 220, 255) 50%, #61ffa5 100%);">
    <p style="font-size: 22px;">
                <span style="font-weight: bold;">Вас приветствует компания APPLE!</span>
         </p>

<div> <img width="500px" height="500px" src="/web/static/img/apple1.png" alt="no image"/></div>
</div>

</div>
</div>
  <%@include file="footer.jsp"%>