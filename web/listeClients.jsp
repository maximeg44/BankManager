<%-- 
    Document   : listeClients
    Created on : 11 oct. 2018, 12:54:51
    Author     : yoelb
--%>

<%@page import="models.Compte"%>
<%@page import="models.Client"%>
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
                <a class="nav-link active" href="#">Liste Clients<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="./compteServlet?action=list">Liste Comptes</a>
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
                    <h3 class="panel-title">Liste des Clients</h3>
                  </div>
                  <div class="col col-xs-6 text-right">
                      <a href="./formulaireClient.jsp" class="btn btn-sm btn-primary btn-create">
                          <span class="fa fa-users"></span> Nouveau Client 
                      </a>
                  </div>
                </div>
              </div>
                
            <div class="panel-body">
              
            <%
            if(request.getAttribute("listClients") != null) {
                List<Client> listClients = (List<Client>) request.getAttribute("listClients"); 
            %>
                
                
                <table class="table table-striped table-bordered table-list">
                  <thead>
                    <tr>
                        <th><em class="fa fa-cog"></em></th>
                        <th class="hidden-xs">ID</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Date de Naissance</th>
                    </tr> 
                  </thead>
                  <tbody>
                      <%
                for (Client client: listClients) {
                %>
                          <tr>
                            <td align="center">
                              <a class="btn btn-danger" href="./clientServlet?action=delete&id=<%=client.getId_client()%>"><em class="fa fa-trash"></em></a>
                            </td>
                            <td class="hidden-xs"><%=client.getId_client()%></td>
                            <td><%=client.getNom()%></td>
                            <td><%=client.getPrenom()%></td>
                            <td><%=client.getNaissance()%></td>
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
