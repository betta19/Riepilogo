<%@page import="riepilogowebapp.models.Persona"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

	<br>
	<%
		String mess = (String) request.getAttribute("mess");
		if (mess != null) {
	%>
	<h4>
		<%=mess%>
	</h4>


	<%
		}
	%>
	
	<form action="aggiungiPersona">
  
  <input type="text" id="nome" name="nome" placeholder = "Nome"><br><br>

  <input type="text" id="cognome" name="cognome" placeholder = "Cogome"><br><br>
   
  <input type="text" id="numero" name="numero" placeholder = "Numero"><br><br>
  <input type="submit" value="Aggiungi">
  </form>
 <table >

          
            <tr>
        <th><h5>
            Nome
          </h5></th>
        <th><h5>
            Cognome
          </h5></th>
        <th><h5>
            Numero
          </h5></th>
        
      </tr>
            
          
          <c:forEach items="${listaPersone}" var="singolaPersona">

            <tr>
          <td><c:out value="${singolaPersona.getNome()}"/></td>
          <td><c:out value="${singolaPersona.getCognome()}"/></td>
          <td><c:out value="${singolaPersona.getNumero()}"/></td>
        </tr>
          </c:forEach>
        </table>
  
</body>
</html>