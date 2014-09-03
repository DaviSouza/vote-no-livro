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
        <display:table id="table" name="livroList" pagesize="5" class="table table-striped table-hover "  >
            <display:column property="cdLivro" titleKey="url.image.book.add" headerClass="active" />
            <display:column property="nmLivro" titleKey="label.name" headerClass="active" />
            <display:column titleKey="label.consult" headerClass="active">
                <a href="<s:url action="selectLivro">
                       <s:param name="cdLivro" value="%{#attr.table.cdLivro}" >    
                       </s:param></s:url>">
                    <img src="<s:url value="/img/lupa.png"/>"/>
                </a>
            </display:column>
            <display:column  titleKey="label.delete" headerClass="active">
                <a href="<s:url action="deletaLivro">
                       <s:param name="cdLivro" value="%{#attr.table.cdLivro}" >    
                       </s:param></s:url>">
                    <img src="<s:url value="/img/delete.png"/>"/>
                </a>
            </display:column>
        </display:table>
                
<!--        
<br>
        <table class="table table-striped table-hover " >
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
                        <td><s:text name="%{#attr.table.cdLivro}" /></td>
                        <td><s:text name="%{nmLivro}" /></td>
                        <td>
                            <a href="<s:url action="selectLivro">
                                   <s:param name="cdLivro" value="%{#attr.table.cdLivro}" >    
                                   </s:param></s:url>">
                                <img src="<s:url value="/img/lupa.png"/>"/>
                            </a>
                        </td>
                        <td>
                            <a href="<s:url action="deletaLivro">
                                   <s:param name="cdLivro" value="%{#attr.table.cdLivro}" >    
                                   </s:param></s:url>">
                                <img src="<s:url value="/img/delete.png"/>"/>
                            </a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table> 
       -->

    </body>
</html>
