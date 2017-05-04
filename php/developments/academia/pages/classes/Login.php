
<?php
require_once 'Connection.php';
require_once 'Crud.php';
session_start();

Class Login{
  private $objConnection;
   function __construct(){
      $objConnection = Connection::getInstance();
   }

   static function verificarLogado(){
      if(!isset($_SESSION['user'])){
         self::deslogar();
      }
   }

   function Logar($email, $senha){
     try{
       $q_usuario = new Crud('cliente');
       $q_password = $q_usuario->select($senha,'password');
       $q_usuario = $q_usuario->select($email,'email');
       if(($q_usuario && $q_password)&& ($q_usuario->id == $q_password->id)){
         $_SESSION['user'] = $email;
         $_SESSION['password'] = $senha;
         return true;
       }
       return false;
     }catch(PDOException $ex){
       echo "Ocorreu um erro!";
     }
  }

  function getIdUsuario(){
     return $_SESSION["id_usuario"];
  }

  static function deslogar(){
     session_destroy();
     header("Location: dirname(__FILE__)/../index.php");
  }
}
?>
