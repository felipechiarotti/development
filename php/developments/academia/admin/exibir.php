<?php
  $crud = new Crud($_GET['exibir']);
  $crud->selectAll();

  $data = $crud->getData();
  $cols = array_keys($data[0]);

  echo "<ul>";
    // echo "<li>";
    //
    // foreach($cols as $col){
    //   $col = strtoupper($col);
    //   echo "<h1>$col</h1>";
    // }
    //
    // echo "</li>";
    // echo '<div class="clear"></div>';
    foreach($data as  $value){
      echo "<li>";
        echo "<ul>";

        foreach($value as $view){
          echo "<li>$view</li>";
          echo '<div class="clear"></div>';
        }
        echo "</ul>";
        echo '<a href="#">Atualizar</a>';
        echo '<a href="#">Excluir</a>';
      echo "</li>";
    }
              echo '<div class="clear"></div>';
  echo "</ul>";
?>
