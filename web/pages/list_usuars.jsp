<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>

        <fmt:setBundle basename="bundle"/>
        <display:table id="table" name="usuarList" pagesize="5" class="table table-striped table-hover " requestURI="listUsuars">
            <display:column property="cdUsuar" titleKey="url.image.user.add" headerClass="active" />
            <display:column property="nmUsuar" titleKey="label.name" headerClass="active" />        
            <display:column titleKey="label.consult" headerClass="active">
                <a href="<s:url action="cadUsuars">
                       <s:param name="cdUsuar" value="%{cdUsuar}" >    
                       </s:param></s:url>">
                    <img src="<s:url value="/img/lupa.png"/>"/>
                </a>
            </display:column>
            <display:column  titleKey="label.delete" headerClass="active">
                <a href="<s:url action="deletaUsuar">
                       <s:param name="cdUsuar" value="%{#attr.table.cdUsuar}" >    
                       </s:param></s:url>">
                    <img src="<s:url value="/img/delete.png"/>"/>
                </a>
            </display:column>
        </display:table>

    </body>
</html>
