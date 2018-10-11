<%-- 
    Document   : formulaireCompte
    Created on : 11 oct. 2018, 14:51:04
    Author     : yoelb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="icon" href="../../../../favicon.ico">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <title>Bank Manager</title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/editor.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="narrow-jumbotron.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills float-right">
            <li class="nav-item">
                <a class="nav-link" href="./index.html">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="./listeClients.jsp">Liste Clients</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="./listeComptes.jsp">Liste Comptes</a>
            </li>
          </ul>
        </nav>
        <h3 class="text-muted">Bank Manager</h3>
      </div>

        
      <div class="jumbotron">
          
          <form class="form-horizontal" method="POST" action="compteServlet">
<fieldset>

<!-- Form Name -->
<legend>Créer un nouveau Compte</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Libelle">Libelle</label>  
  <div class="col-md-4">
  <input id="libelle" name="libelle" type="text" placeholder="Libelle" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Iban">Iban</label>  
  <div class="col-md-4">
  <input id="iban" name="iban" type="text" placeholder="Iban" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Solde">Solde</label>  
  <div class="col-md-4">
  <input id="solde" name="solde" type="text" placeholder="Solde Initial" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Valider"></label>
  <div class="col-md-4">
    <button id="Valider" name="Valider" class="btn btn-success">Valider</button>
  </div>
</div>

</fieldset>
</form>
        
      </div>

      <footer class="footer">
        <p>© BENABOU - GUENEGO Copyright 2018</p>
      </footer>

    </div> <!-- /container -->
  

</body>
</html>

