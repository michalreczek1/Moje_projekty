<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edycja danych klienta</title>
<link rel="stylesheet" type="text/css" href="/styl.css"/>
</head>
<body>
<h1>Edycja danych klienta</h1>

<f:form id="product-form" method="post" modelAttribute="customer">
    <table class="form-tab">
        <tr>
            <td><f:label path="customerEmail">Email:</f:label></td>
            <td><f:input path="customerEmail" type="email"/>
                <f:errors path="customerEmail" cssClass="form-error" element="div"/>
            </td>
        </tr>
        <tr>
            <td><f:label path="customerName">Nazwa / imię i nazwisko:</f:label></td>
            <td><f:input path="customerName" placeholder="Ala Kowalska" type="text"/>
                <f:errors path="customerName" cssClass="form-error" element="div"/>
            </td>
        </tr>
        <tr>
            <td><f:label path="phone">Telefon:</f:label></td>
            <td><f:input path="phone" placeholder="123123123" type="text"/>
                <f:errors path="phone" cssClass="form-error" element="div"/>
            </td>
        </tr>
        <tr>
            <td><f:label path="address">Adres:</f:label></td>
            <td><f:textarea path="address" rows="2" cols="120"/></td>
        </tr>
        <tr>
            <td><f:label path="postalCode">Kod pocztowy:</f:label></td>
            <td><f:input path="postalCode" placeholder="12-345" type="text"/>
                <f:errors path="postalCode" cssClass="form-error" element="div"/>
            </td>
        </tr>
                <tr>
            <td><f:label path="city">Miasto:</f:label></td>
            <td><f:input path="city" placeholder="123123123" type="text"/>
                <f:errors path="city" cssClass="form-error" element="div"/>
            </td>
        </tr>
        <tr>
            <td><f:button>Zapisz</f:button></td>
        </tr>
    </table>
</f:form>

</body>
</html>



