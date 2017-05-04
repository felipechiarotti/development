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
                    $nome = $_POST['nome'];

                    $trailer = $_POST['trailer'];
                    $ano = $_POST['ano'];
                    $tamanho = $_POST['tamanho'];
                    $link = $_POST['link'];
                    $plataforma = $_POST['plataforma'];
                    $plataformaSlug = slug($plataforma);
                    $nomeSlug = slug('-'.$nome.'-', $plataformaSlug.'-', 'torrent-completo-gratis');
                    $description = $_POST['description'];
                    $category = $_POST['category'];
                    
                    

                    $ext = ($capa['type'] == 'image/jpeg' ? '.jpg' : '.png');
                    $capanome = md5(time()).$ext;
                    $pasta = 'uploads/';

                            
                    if(isset($_POST['postar'])){
                        if(!$nome){
                            echo 'Preencha o campo de Nome';
                        }elseif(!$trailer){
                            echo 'Preencha o campo de Trailer';
                        }elseif(!$ano){
                            echo 'Preencha o campo de Ano';
                        }elseif(!$tamanho){
                            echo 'Preencha o tamanho do Jogo';
                        }elseif(!$link){
                            echo 'Preencha o campo de Magnetic Link';
                        }elseif($plataforma == ''){
                            echo 'Selecione uma Plataforma';
                        }elseif(!$description){
                            echo 'Adicione uma Descrição';
                        }else{
                            move_uploaded_file($_FILES['capa']['tmp_name'],$pasta.$capanome);
                           
                            echo 'Movido para ' . $pasta;

                            $insert = mysql_query("INSERT INTO games (nome, trailer, capa, lancamento, tamanho, link, plataforma, description, category, slug) VALUES ('$nome','$trailer','$capanome','$ano','$tamanho','$link','$plataforma','$description','$plataformaSlug','$nomeSlug')") or die(mysql_error());
                        echo '<span class="trigger trigger-accept">JOGO POSTADO COM SUCESSO</span>';

                        }
                        
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
                    <input required name="ano" placeholder="ANO DE LANÇAMENTO" type="text">
                    </label>
                    <label>
                    <input required name="tamanho" placeholder="TAMANHO DO JOGO" type="text">
                    </label>
                    <label>
                    <input required name="link" placeholder="MAGNETIC LINK" type="text">
                    </label>
                    <label>
                        <select required name="plataforma">
                            <option value="">Selecione a Plataforma:</option>
                            <option value="PC">Computador</option>
                            <option value="Xbox 360">Xbox 360</option>
                            <option value="PS3 ">Playstation 3</option>
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


