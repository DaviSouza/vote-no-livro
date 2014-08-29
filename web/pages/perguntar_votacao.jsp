<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Deseja Continuar a votação?</h3>
                </div>
                <div class="panel-body">
                    <div class="modal-body">
                        <p>Livros votados</p>
                    </div>
                    <div class="modal-footer">   
                        <s:a cssClass="btn btn-default" action="finishVoting" >Não</s:a>
                        <s:a cssClass="btn btn-primary" action="continueVoting" >Sim</s:a>
                    </div>
                </div>
            </div>       
    </body>
</html>
