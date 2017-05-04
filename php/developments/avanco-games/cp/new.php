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
        <title>Adicionar Jogo</title>
        
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
                    <h1 >Novo Jogo!</h1>
                                        <?php
                   
                    
                    
                   
                    if(isset($_POST['postar'])){
                    $f['nome'] =        $_POST['nome'];
                    $f['trailer'] =     $_POST['trailer'];
                    $f['lancamento'] =  $_POST['lancamento'];
                    $f['tamanho'] =     $_POST['tamanho'];
                    $f['link'] =        $_POST['link'];
                    $f['category'] =    $_POST['category'];
                    $f['slug'] =        slug($f['nome'],'-'.getCat("$f[category]",'url').'-'.$f['lancamento'].'-torrent-download');
                    $f['description'] = $_POST['description'];
                    $f['autor']       = $_SESSION['dados']['user_id'];
                    $tags      = array(
                        'tag1' => 'Download '. $f['nome'] .' '. getCat("$f[category]",'nome').' '.$f['lancamento'].' Torrent',                        
                        'tag2' => 'Baixar '. $f['nome'] .' '. getCat("$f[category]",'nome').' '.$f['lancamento'].' Torrent',                        
                        'tag3' => $f['nome'] .' '. getCat("$f[category]",'nome').' '.$f['lancamento'].' Torrent',                        
                    );
                    $f['tags'] = implode(", ",$tags);
  
                    $pasta       = "uploads/";
                    $img         = $_FILES['capa'];
                    $ext         = substr($img['name'],-3);
                    $f['capa']  = md5(time($img['tmp_name'])).'.'.$ext;

                            echo '<br /><pre>';
                            print_r($f);
                            print_r($img);
                            echo '</pre>';
                           //uploadImage($img['tmp_name'], $f['capa'], '1280', '720', $pasta);
                           create("games",$f);

                        
                        
                    }
                                             
                    ?>
                    <form name="form" action="" enctype="multipart/form-data" method="post">
                      
                    <label>
                    <input required name="nome" placeholder="NOME DO JOGO" type="text">
                    </label>
                    <label>
                    <input required name="trailer" placeholder="TRAILER" type="text">
                    </label>
                    <label>
                    <input type="file" name="capa" />
                    </label>
                    <label>
                    <input required name="lancamento" placeholder="ANO DE LANÇAMENTO" type="text">
                    </label>
                    <label>
                    <input required name="tamanho" placeholder="TAMANHO DO JOGO" type="text">
                    </label>
                    <label>
                    <input required name="link" placeholder="MAGNETIC LINK" type="text">
                    </label>
                    <label>
                        <select required name="category">
                            <option value="">Selecione a Plataforma:</option>
                            <option value="1">Computador</option>
                            <option value="2">Xbox 360</option>
                            <option value="3">Playstation 3</option>
                        </select>
                    </label>
                    <label>
                    </label>    
                        <label>
                    <textarea name="description" required rows="15" placeholder="Descrição do Jogo"></textarea>
                        </label>
                        <input type="submit" class="btn btn-green radius" value="Postar Jogo" name="postar">
                    </form>

                    <div class="clear"></div>
                </section>
            </footer>


   
  
    </body>
</html>


