<?php
Class Cliente{
  private $id;
  private $nome;
  private $nascimento;
  private $rg;
  private $cpf;
  private $id_treino;
  private $last_verified;

  public function __construct(){

  }

  public function select($id){
    try{
      $dataArray = new CRUD(Connection::getInstance(), 'cliente');
    }
  }
}
?>
