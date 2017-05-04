<?php
Class Crud {
    private $pdo;
    private $data;
    private $table;
    private $cols;

    function __construct($tabela){
      $this->pdo = Connection::getInstance();
      $this->table = $tabela;
    }
    public function setTable($table){
      $this->table = $table;
    }
    public function selectAll(){
      try{
        $sql = "SELECT * FROM $this->table";
        $stm = $this->pdo->prepare($sql);
        $stm->execute();
        $this->data = $stm->fetchAll(PDO::FETCH_ASSOC);
        $this->cols = array_keys($this->data[0]);
        return $this->data;
      }catch(PDOException $err){
        echo $err;
      }
    }

    public function select($data, $primaryField){
      try{
        $sql = "SELECT * FROM $this->table WHERE $primaryField='$data'";
        $stm = $this->pdo->prepare($sql);
        $stm->execute();
        $this->data = $stm->fetch(PDO::FETCH_OBJ);
        return $this->data;
      }catch(PDOException $ex){
        echo "<script>alert('Erro ao encontrar registro!')</script>";
      }
    }
    public function insert($arrayData){
      $key = implode(array_keys($arrayData),',');
      $values = implode(array_values($arrayData),',');

      $valuesBind = ":".implode(array_keys($arrayData),", :");

      try{
        $sql = "INSERT INTO $this->table ($key) VALUES ($valuesBind)";
        $stm = $this->pdo->prepare($sql);
        foreach($arrayData as $key => $value){
          $key = ":".$key;
          $stm->bindParam($key, $value);
        }

        $stm->execute();
        echo "<script>alert('Registro inserido com sucesso!')</script>";
      }catch(PDOException $err){
        echo "<script>alert('Não foi possível efetuar o registro!')</script>";
      }
    }

    public function update($arrayData, $primaryField){
      try{
        $arrayKey = implode(array_keys($arrayData),'=?, ');
        $sql = "UPDATE $table SET $arrayKey WHERE $primaryField=?";
        $stm = $this->pdo->prepare($sql);
        for($i = 0; $i<count($arrayData); $i++){
          $stm->bindValue($i+1, $arrayData[$i]);
        }
        $stm->execute();
        echo "<script>alert('Registro atualizado com sucesso!')</script>";
      }catch(PDOException $err){
        echo "<script>alert('Não foi possível atualizar o registro!')</script>";
      }
    }

    public function delete($id, $primaryField){
      if (!empty($id)):
     try{
      $sql = "DELETE FROM $table WHERE $primaryField=?";
      $stm = $this->pdo->prepare($sql);
      $stm->bindValue(1, $id);
      $stm->execute();
      echo "<script>alert('Registro excluido com sucesso')</script>";
     }catch(PDOException $erro){
      echo "<script>alert('Erro na linha: {$erro->getLine()}')</script>";
     }
     endif;
    }

    public function getCols(){
      return $this->cols;
    }
    public function getData(){
      return $this->data;
    }

    public function getConn(){
      return self::$data;
    }
  }

?>
