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
                        <a href="<s:url action="cadLivros"/>"> 
                            <img src="<s:url value="/img/add.png"/>"/>
                        </a>
                    </th>
                    <th><s:text name="label.name"/></th>
                    <th><s:text name="label.consult"/></th>
                    <th><s:text name="label.delete"/></th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="livroList">
                    <tr>
                        <td><s:text name="%{cdLivro}" /></td>
                        <td><s:text name="%{nmLivro}" /></td>
                        <td>
                            <a href="<s:url action="selectLivro">
                                   <s:param name="cdLivro" value="%{cdLivro}" >    
                                   </s:param></s:url>">
                                <img src="<s:url value="/img/lupa.png"/>"/>
                            </a>
                        </td>
                        <td>
                            <a href="<s:url action="deletaLivro">
                                   <s:param name="cdLivro" value="%{cdLivro}" >    
                                   </s:param></s:url>">
                                <img src="<s:url value="/img/delete.png"/>"/>
                            </a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table> 

    </body>
</html>
