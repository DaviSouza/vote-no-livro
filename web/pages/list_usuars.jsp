<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <table class="table table-striped table-hover ">
            <thead>
                <tr class="active">
                    <th> 
                        <a href="<s:url action="cadUsuars"/>"> 
                            <img src="<s:url value="/img/add.png"/>"/>
                        </a>
                    </th>
                    <th><s:text name="label.name"/></th>
                    <th><s:text name="label.consult"/></th>
                    <th><s:text name="label.delete"/></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="usuarList">
                    <tr>
                        <td><s:text name="%{cdUsuar}" /></td>
                        <td><s:text name="%{nmUsuar}" /></td>
                        <td>
                            <a href="<s:url action="cadUsuars">
                                   <s:param name="cdUsuar" value="%{cdUsuar}" >    
                                   </s:param></s:url>">
                                <img src="<s:url value="/img/lupa.png"/>"/>
                            </a>
                        </td>
                        <td>
                            <a href="<s:url action="deletaUsuar">
                                   <s:param name="cdUsuar" value="%{cdUsuar}" >    
                                   </s:param></s:url>">
                                <img src="<s:url value="/img/delete.png"/>"/>
                            </a>
                        </td>
                    </tr>
                </s:iterator>
        </table> 

    </body>
</html>
