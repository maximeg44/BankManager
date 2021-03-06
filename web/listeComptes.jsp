<%-- 
    Document   : listeClients
    Created on : 11 oct. 2018, 12:54:51
    Author     : yoelb
--%>

<%@page import="models.Client"%>
<%@page import="models.Compte"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="icon" href="../../../../favicon.ico">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <title>Bank Manager</title>

  </head>

  <body>

    <div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills float-right">
            <li class="nav-item">
                <a class="nav-link" href="./index.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="./clientServlet?action=list">Liste Clients</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="#">Liste Comptes<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="./bankBranchServlet?action=list">Liste Branches</a>
            </li>
          </ul>
        </nav>
        <h3 class="text-muted">Bank Manager</h3>
      </div>

        
      <div class="jumbotron">
          
          <div class="container">
    <div class="row">
    
    
    
        <div class="col-md-10 col-md-offset-1">

            <div class="panel panel-default panel-table">
              <div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <h3 class="panel-title">Liste des Comptes</h3>
                  </div>
                  <div class="col col-xs-6 text-right">
                      <a href="./compteServlet?action=create" class="btn btn-sm btn-primary btn-create">
                          <span class="fas fa-piggy-bank"></span> Nouveau Compte 
                      </a>
                  </div>
                </div>
              </div>
                
            <div class="panel-body">
              
            <%
            if(request.getAttribute("listComptes") != null) {
                List<Compte> listComptes = (List<Compte>) request.getAttribute("listComptes"); 
            %>
                
                
                <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>
                        <th><em class="fa fa-cog"></em></th>
                        <th class="hidden-xs">ID</th>
                        <th>Iban</th>
                        <th>Libelle</th>
                        <th>Solde</th>
                        <th>Client lié</th>
                        <th>Branche liée</th>
                    </tr> 
                  </thead>
                  <tbody>
                      <%
                for (Compte compte : listComptes) {
                %>
                          <tr>
                            <td align="center">
                              <a class="btn btn-danger" href="./compteServlet?action=delete&id=<%=compte.getAccount_id()%>"><em class="fa fa-trash"></em></a>
                            </td>
                            <td class="hidden-xs"><%=compte.getAccount_id()%></td>
                            <td><%=compte.getIban()%></td>
                            <td><%=compte.getLibelle()%></td>
                            <td><%=compte.getSolde()%></td>
                            
                            <td>   
                                <select tyle="border-radius: 5px;">
                                    <%
                                    for (Client client : compte.getMesClients()) {
                                        String ClientNom = client.getNom();
                                        String ClientPrenom = client.getPrenom();
                                    %>
        
                                        <option><%=ClientNom%> - <%=ClientPrenom%></option>
                                    <%
                                    }
                                    %>
                                </select>
                            </td>
                            <td><%=compte.getBankbranch().getCodeAgence()%> - <%=compte.getBankbranch().getAdresse()%></td>
                          </tr>
                          <% } %>
                  </tbody>
                </table>
                <% } %>
            
              </div>
            </div>

</div></div></div>
          
      </div>

      <footer class="footer">
        <p>© BENABOU - GUENEGO Copyright 2018</p>
      </footer>

    </div> <!-- /container -->
  

</body>
</html>
