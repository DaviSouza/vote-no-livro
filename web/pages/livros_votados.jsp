<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="panel panel-info" style="width:80%;">
            <div class="panel-heading">
                <h3 class="panel-title"><s:text name="label.ranking" /></h3>
            </div>
            <div class="panel-body" >
                <s:iterator value="rankingListVotados">
                    <div class="row">
                        <div class="col-md-6"> 
                            <h3 class="panel-title"> <s:text name="%{nome}" /></h3>
                        </div>
                        <div class="col-md-11 col-md-offset-11">
                            <h3 class="panel-title"><s:text name="%{votos}" />%</h3>
                        </div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar" style="width:<s:text name="%{votos}" />%;"></div>
                    </div>
                </s:iterator>
            </div>
        </div>
    </body>
</html>
