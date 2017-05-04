<?php
class Connection {
    private static $pdo;

    public static function openConnection(){
        if(empty(self::$pdo)){
          try {
          self::$pdo = new PDO("mysql:dbname=academia;host=localhost;charset=utf8;","root","21361qpo");
          self::$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch(PDOException $e) {
          echo 'Error: ' . $e->getMessage();
        }
      }
    }

    public static function getInstance(){
      if(!isset(self::$pdo)){
       self::openConnection();
     }
     return self::$pdo;
  }
}
?>
