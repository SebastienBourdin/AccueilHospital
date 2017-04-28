<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><s:text name="saisie.titre1"/></title>
  </head>
  <body>
    <h1><s:text name="saisie.titre2"/></h1>
    <s:form action="sessionstart">
      <s:textfield key="saisie.libelle" name="nom" value="%{#attr['nom']}"/>
      <s:submit key="saisie.valider" action="sessionstart"/>
    </s:form>
  </body>
</html>