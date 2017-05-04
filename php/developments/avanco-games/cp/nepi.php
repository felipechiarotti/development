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
                    <h1 >Novo Episódio!</h1>
                                        <?php
                   
                    
                    
                   
                    if(isset($_POST['postar'])){
                    $f['nome'] =        $_POST['nome'];
                    $f['sinopse'] =     $_POST['sinopse'];
                    $f['tamanho'] =     $_POST['tamanho'];
                    $f['formato'] =     $_POST['formato'];
                    $f['legenda'] =     $_POST['legenda'];
                    $f['linklow'] =        $_POST['linklow'];
                    $f['linkhd'] =        $_POST['linkhd'];
                    $f['linkfullhd'] =        $_POST['linkfullhd'];
                    $f['temp_id'] =    $_POST['temp_id'];

                            echo '<br /><pre>';
                            print_r($f);
                            echo '</pre>';
                           //uploadImage($img['tmp_name'], $f['capa'], '1280', '720', $pasta);
                           create("episodio",$f);

                        
                        
                    }
                                             
                    ?>
                    <form name="form" action="" enctype="multipart/form-data" method="post">
                      
                    <label>
                    <input required name="nome" placeholder="Nome do Episódio / Numero" type="text">
                    </label>
                    <label>
                    <input required name="tamanho" placeholder="Tamanho" type="text">
                    </label>
                    <label>
                    <input  name="linklow" placeholder="Link HDTV" type="text">
                    </label>
                    <label>
                    <input name="linkhd" placeholder="Link 720p" type="text">
                    </label>
                    <label>
                    <input  name="linkfullhd" placeholder="Link 1080p" type="text">
                    </label>
                    <label>
                    <input  name="legenda" placeholder="Legenda" type="text">
                    </label>
                    <label>
                        <select required name="temp_id">
                            <option value="">Selecione a Temporada:</option>
                            <?= $read = read('temporada',"ORDER BY id DESC");
                            foreach($read as $select):?>
                            <option value="<?= $select['id'];?>"><?= $select['nome'];?></option>
                            <?php  endforeach;?>
                        </select>
                    </label>
                        <label>
                       <select required name="formato">
                            <option value="">Selecione o Formato:</option>
                            <option value="KMP">KMP</option>
                            <option value="mp4">MP4</option>
                            <option value="mkv">MKV</option>
                            <option value="mkv">AVI</option>
                        </select>
                    </label>
  
                        <label>
                    <textarea name="sinopse" rows="15" placeholder="Siniopse do Episódio"></textarea>
                        </label>
                        <input type="submit" class="btn btn-green radius" value="Postar Episódio" name="postar">
                    </form>

                    <div class="clear"></div>
                </section>
            </footer>


   
  
    </body>
</html>


