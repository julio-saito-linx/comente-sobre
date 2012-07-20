<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- saved from url=(0066)http://twitter.github.com/bootstrap/examples/starter-template.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <title>Comente-sobre (saitodisse)</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="projeto para estudar vRaptor e Java">
    <meta name="author" content="Julio Makdisse Saito (saitodisse)">

    <!-- Le styles -->
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
    <style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
      }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  <body>

    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="<c:url value="/discussao/ultimas"/>">comente-sobre</a>
          <div class="nav-collapse">
            <ul class="nav">
              <li>               <a href="<c:url value="/usuario"/>">Usuários</a></li>
              <li>               <a href="<c:url value="/index/logout"/>">Sair</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">