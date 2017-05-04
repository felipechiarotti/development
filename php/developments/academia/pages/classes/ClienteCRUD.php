<?php
  Class ClienteCRUD extends CRUD{
    public function __construct($conn){
      super($conn);
      selectAll();
    }

    public function selectAll(){
      try{
        $sql = "SELECT * FROM cliente";
        $stm = $this->pdo->prepare($sql);
        $stm->execute();
        $this->data = $stm->fetchAll(PDO::FETCH_OBJ);
        return $this->data;
      }catch(PDOException $err){
        echo $err;
      }
    }

    public function insert($arrayData){
      $key = implode(array_keys($arrayData),',');
      $values = implode(array_values($arrayData),',');
      $valuesBind = '?';
      for(int i = 0; i<count($arrayData); i++){
        $valuesBind = $valuesBind.', ?';
      }
      try{
        $sql = "INSERT INTO cliente ($key) VALUES ($valueBind)";
        $stm = $this->pdo->prepare($sql);
        for(int i = 0; i<count($arrayData); i++){
          $stm->bindValue(i+1, $values[i]);
        }
        $stm->execute();
        echo "<script>alert('Registro inserido com sucesso!')</script>";
      }catch(PDOException $err){
        echo "<script>alert('Não foi possível efetuar o registro!')</script>";
      }
    }

    public function update($arrayData, $table, $primaryField){
      try{
        $arrayKey = implode(array_keys($arrayData),'=?, ';
        $sql = "UPDATE $table SET $arrayKey WHERE $primaryField=?";
        $stm = $this->pdo->prepare($sql);
        for(int i = 0; i<count($arrayData), i++){
          $stm->bindValue(i+1, $arrayData[i]);
        }
        $stm->execute();
        echo "<script>alert('Registro atualizado com sucesso!')</script>";
      }catch(PDOException $err){
        echo "<script>alert('Não foi possível atualizar o registro!')</script>";
      }
    }
  }
?>
