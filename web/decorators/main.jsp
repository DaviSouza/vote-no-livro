<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xml:lang="pt-br">
    <%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
    <%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
    <%@taglib prefix="s" uri="/struts-tags" %>

    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css" media="screen" />
        <link rel="stylesheet" href="css/bootswatch.less" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
            <title>JSP Page</title>
    </head>
    <body>
        <!--<div class="navbar navbar-default navbar-fixed-top">-->
        <%--<page:applyDecorator name="panel" page="/pages/header.jsp"/>--%>
        <!--</div>-->
        <div class="navbar navbar-default">
            <ul class="nav navbar-nav">
                <li>
                    <a class="navbar-brand" href="<s:url action="voting"/>"><s:text name="label.link.menu.votacao"/> </a>
                </li>
                <li>
                    <a class="navbar-brand" href="<s:url action="listLivros"/>"><s:text name="label.link.menu.livros" /> </a>
                </li>
                <li>
                    <a class="navbar-brand" href="<s:url action="listUsuars"/>"><s:text name="label.link.menu.usuarios"/></a>
                </li>
                <li>
                    <a class="navbar-brand" href="<s:url action="ranking"/>"><s:text name="label.link.menu.ranking"/></a>
                </li>
            </ul>  
        </div>
        <div class="container"> 
            <decorator:body/>
            <div  class="container">
                <nav class="navbar-fixed-bottom">
                    <div class="navbar-inner navbar-content-center">
                        <style>
                            #centered {
                                background-color: #ecf0f1;
                                text-align: center;
                            }
                        </style>
                        <div id="centered">
                            <s:text name="©Copyright 2014 - Adáoce Davi Dias de Souza" />
                        </div>

                    </div>
                </nav>
            </div>

        </div>

    </body>
</html>
