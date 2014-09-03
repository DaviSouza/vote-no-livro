<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="row">      
            <div style="text-align: center;">
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-0"> 
                            <h4>  <s:property value="livro1.nmLivro" /></h4>
                        </div>
                    </div>
                    <div class="row">
                        <s:url id="choose1" action="chosenBook" >
                            <s:param name="cdLivro" value="livro1.cdLivro" />
                        </s:url> 
                        <s:a href="%{choose1}" >
                            <img src="/img/<s:property value="livro1.nlLivro" />" width="200px" height="200px">
                        </s:a>
                    </div>  
                    <div class="row">  
                        <h5> <s:text name="livro1.txLivro" /></h5>
                    </div> 
                </div>
            </div>
            <div class="col-md-5 col-md-offset-2">
                <div style="text-align: center;">
                    <div class="row">
                        <div class="col-md-0"> 
                            <h4>  <s:property value="livro2.nmLivro" /></h4>
                        </div>
                    </div>
                    <div class="row">
                        <s:url id="choose2" action="chosenBook" >
                            <s:param name="cdLivro" value="livro2.cdLivro" />
                        </s:url> 
                        <div style="text-align: center;">
                            <s:a href="%{choose2}" >
                                <img src="/img/<s:property value="livro2.nlLivro" />" width="200px" height="200px">
                            </s:a>
                        </div>
                    </div>  
                    <div class="row">  
                        <h5><s:text name="livro2.txLivro" /></h5>
                    </div>  
                </div>  
            </div>
        </div>

    </body>
</html>
