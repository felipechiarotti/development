<form name="add" method=post action="#" enctype="multipart/form-data">

<?php
  $crud = new Crud($_GET['adicionar']);
  $crud->selectAll();
  $cols = $crud->getCols();
  unset($cols[0]);

  foreach($cols as $col){
    $originalCol = $col;
    $col = ucfirst($col);
    $col = explode('_',$col);
    $col = implode(' ',$col);
    echo "$col:";
    echo "<input type=text name=$originalCol>";
  }
  if(isset($_POST['send'])){
    $array = array();
    foreach($cols as $col){
      $array[$col] = $_POST[$col];
    }
    $crud->insert($array);
  }
?>
  <input type="submit" name="send" value="Enviar">
</form>

<?php

?>
