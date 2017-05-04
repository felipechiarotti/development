<?php
  require_once './../pages/classes/Login.php';
  Login::verificarLogado();
?>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Paínel de Controle - <?php echo $_SESSION['user'];?></title>
        <link rel="stylesheet" href="boot.css"/>
        <link rel="stylesheet" href="cp.css"/>
    </head>
    <body>
      <div class="menu bg-blue">
        <ul>
          <li><a href="?adicionar=cliente">Adicionar Cliente</a></li>
          <li><a href="?adicionar=exercicio">Adicionar Exercício</a></li>
          <li><a href="?adicionar=treino">Adicionar Treino</a></li>
          <li><a href="?adicionar=categoria">Adicionar Categoria</a></li>
        </ul>
      <div class="clear"></div>
      </div>
      <div class="submenu bg-lightgray">
          <form name="view" method=post action="#" enctype="multipart/form-data">
            <select name="show" id="show" onchange="self.location='?exibir='+this.value">
              <option value="">Visualizar</option>
              <option value="cliente">Clientes</option>
              <option value="exercicio">Exercicios</option>
              <option value="treino">Treinos</option>
              <option value="categoria">Categorias</option>
            </select>
          </form>
      <div class="clear"></div>
      </div>

      <div class="content">
        <?php
        if(isset($_GET['exibir'])){
          echo '<div class="show">';
            include_once './exibir.php';
          echo '</div>';
        }else if(isset($_GET['adicionar'])){
          echo '<div class="add">';
            include_once './adicionar.php';
          echo '</div>';
        }else if(isset($_GET['atualizar'])){
          echo '<div class="update">';
            include_once './atualizar.php';
          echo '</div>';
        }else{
          echo "<h1> 404 - Página não encontrada!</h1>";
        }
        ?>
      </div>

    </body>
</html>
