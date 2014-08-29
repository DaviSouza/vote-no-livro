<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuários</title>
    </head>
    <body>
        <script language="javascript" type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $("#btCancel").click(function() {
                    document.getElementById('inputTexto').value = "";
                    document.getElementById('inputNome').value = "";
                });
            });
        </script>
       
        <s:form id="form" cssClass="form-horizontal" action="updateOrSaveUsuar" method="POST">
            <s:hidden name="usuar.cdUsuar" />
            <fieldset>
                <legend>Usuário</legend>
                <div class="form-group">
                    <label for="inputNome" class="col-lg-2 control-label"><s:text name="label.name"/></label>
                    <div class="col-lg-10">
                         <s:fielderror fieldName="nameUser"/>
                        <s:textfield id="inputNome" name="usuar.nmUsuar" maxLength="30" size="31" cssClass="form-control" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                    <div class="col-lg-10">
                        <s:fielderror fieldName="emailUser"/>
                        <s:textfield id="inputEmail" name="usuar.emUsuar" maxLength="30" size="31" cssClass="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                         <input type="button" id="btCancel" class="btn btn-default" value="<s:text name="label.clean" />"/>
                        <s:submit cssClass="btn btn-primary" label="Submit" />
                    </div>
                </div>
            </fieldset>
        </s:form>
    </body>
</html>
