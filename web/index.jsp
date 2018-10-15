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
              <a class="nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="./clientServlet?action=list">Liste Clients</a>
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
        <div class="row">
            <div class="col text-center"><a href="./formulaireClient.jsp" class="btn btn-success"><span class="fa fa-users"></span> Nouveau Client </a></div>
            <div class="col text-center"><a href="./formulaireCompte.jsp" class="btn btn-success"><span class="fas fa-piggy-bank"></span> Nouveau Compte </a></div>
            <div class="col text-center"><a href="./formulaireBranche.jsp" class="btn btn-success"><span class="fas fa-university"></span> Nouvelle Agence Bancaire </a></div>
        </div>
      </div>

      <footer class="footer">
        <p>© BENABOU - GUENEGO Copyright 2018</p>
      </footer>

    </div> <!-- /container -->
  

</body>
</html>