<?php
require '../_app/Config.inc.php';

if(!isset($_SESSION['user'])) session_start();

if(!isset($_SESSION['user'])){
header("Location: index.php");
session_destroy();
}


?>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Adicionar Serie</title>
        
        <link rel="stylesheet" href="<?= INCLUDE_PATH; ?>css/boot.css"/>
        <link rel="stylesheet" href="<?= INCLUDE_PATH; ?>css/style.css"/>

        <link rel="shortcut icon" href="<?= INCLUDE_PATH;?>img/favicon.png"/>
    </head>
    <body>

        <div class="container bg-lightred" style="padding-bottom:30px;">
            <div class="content">
                
                    <ul class="main_nav fl-left">
                        <li><a target="_blank" href="http://www.avancogames.com.br">Site</a></li>
                        <li><a href="manage.php">Gerenciar Jogos</a></li>
                        <li><a target="_blank" href="new.php">Novo Jogo</a></li>
                        <li><a href="#">Sair</a></li>

                    </ul>
            </div>
                          

                <div class="clear"></div>
            </div>
        
        
            <footer class="container ">
                <section class="content main_games " style="padding-bottom:10px;">
                    <h1 >Nova Série!</h1>
                                        <?php
                   
                    
                    
                   
                    if(isset($_POST['postar'])){
                    $f['nome'] =        $_POST['nome'];
                    $f['sinopse'] =     $_POST['sinopse'];
                    $generos = $_POST['genero1'].', '.$_POST['genero2'];
                    $f['slug'] =        slug($f['nome']);
                    $f['imdb'] =     $_POST['imdb'];

                    
                    $pasta       = "uploads/";
                    $img         = $_FILES['capa'];
                    $ext         = substr($img['name'],-3);
                    $f['capa']  = md5(time($img['tmp_name'])).'.'.$ext;
                    
                            echo '<br /><pre>';
                            print_r($f);
                            echo '</pre>';
                           uploadImage($img['tmp_name'], $f['capa'], '730', '944', $pasta);
                           create("serie",$f);

                        
                        
                    }
                                             
                    ?>
                    <form name="form" action="" enctype="multipart/form-data" method="post">
                      
                    <label>
                    <input required name="nome" placeholder="Nome da Série" type="text">
                    </label>
                        <label>
                    <input type="file" name="capa" />
                        </label>
                    <label>
                    <input required name="imdb" placeholder="Nota iMDB" type="text">
                    </label>

                        <label>
                    <textarea name="sinopse" required rows="15" placeholder="Sinopse da Serie"></textarea>
                        </label>
                        <input type="submit" class="btn btn-green radius" value="Cadastrar Serie" name="postar">
                    </form>

                    <div class="clear"></div>
                </section>
            </footer>


   
  
    </body>
</html>


