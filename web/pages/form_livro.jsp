<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Livros</title>
    </head>
    <body>
        <script language="javascript" type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#btCancel").click(function() {
//                    var IE = (navigator.userAgent.indexOf('MSIE') != -1);
//                    if ($.browser.msie) {
//                        if (parseInt($.browser.version) == 8) {
//                            document.getElementById('header').firstChild.innerText = gup('chartTitle');
//                            document.getElementById('footer').firstChild.innerText = gup('axesLeftTitleText');
//                        } else if (parseInt($.browser.version) > 8) {
//                            document.getElementById('header').firstElementChild.textContent = gup('chartTitle');
//                            document.getElementById('footer').firstElementChild.textContent = gup('axesLeftTitleText');
//                        }
//                    } else {
//                        document.getElementById('header').firstElementChild.textContent = gup('chartTitle');
//                        document.getElementById('footer').firstElementChild.textContent = gup('axesLeftTitleText');
//                    }
                    document.getElementById('inputTexto').value = "";
                    document.getElementById('inputNome').value = "";
                });
            });
        </script>
        <s:form id="form" cssClass="form-horizontal" action="updateOrSaveLivro" method="POST" enctype="multipart/form-data">
            <s:hidden name="livro.cdLivro" />
            <fieldset>
                <legend>Usuário</legend>
                <div class="form-group">
                    <label  class="col-lg-2 control-label"><s:text name="label.name"/></label>
                    <div class="col-lg-10">
                        <s:fielderror  fieldName="nameBooke" />
                        <s:textfield id="inputNome" name="livro.nmLivro" maxLength="30" size="31" cssClass="form-control" />
                    </div>
                </div>

                <div class="form-group">
                    <label  class="col-lg-2 control-label">Texto</label>
                    <div class="col-lg-10">
                        <s:fielderror fieldName="textBook"/>
                        <s:textarea id="inputTexto" name="livro.txLivro" rows="3" cssClass="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputImagem" class="col-lg-2 control-label"></label>
                    <div class="col-lg-10">
                        <s:fielderror fieldName="imagesBook"/>
                        <s:file size="30" name="livroImage" var="livro.nlLivro" /><br>
                    </div>
                </div>

                <div class="form-group">                 
                    <div class="col-lg-10 col-lg-offset-2">
                        <input type="button" id="btCancel" class="btn btn-default" value="<s:text name="label.clean" />"/>
                        <s:submit cssClass="btn btn-primary" label="Submit" />
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-lg-2 control-label">Imagem</label>
                    <div class="col-lg-10">  
                        <img src="<s:property value="livro.urlImage"/>" width="200px" height="200px">
                    </div>
                </div>    
            </fieldset>
        </s:form>
    </body>
</html>
