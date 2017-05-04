<?php
require '../_app/Config.inc.php';

if(!isset($_SESSION['user'])) session_start();

if(!isset($_SESSION['user'])){
header("Location: index.php");
session_destroy();
}

$id = $_GET['id'];

?>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Entrar no Painel de Controle</title>
        
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
                    <h1 >Editar Jogo!</h1>
                                        <?php
                    $nome = $_POST['nome'];
                    $slug = $_POST['slug'];
                    $trailer = $_POST['trailer'];
                    $capa = $_POST['capa'];
                    $ano = $_POST['ano'];
                    $tamanho = $_POST['tamanho'];
                    $link = $_POST['link'];
                    $category = $_POST['category'];
                    $description = $_POST['description'];
                    
                    $selectall = mysql_query("SELECT * FROM games WHERE id='$id'");
                    $selectal = mysql_fetch_array($selectall);

                    if(isset($_POST['postar'])){
                        if(!$nome){
                            echo 'Preencha o campo de Nome';
                        }elseif(!$trailer){
                            echo 'Preencha o campo de Trailer';
                        }elseif(!$capa){
                            echo 'Preencha o campo de Capa';
                        }elseif(!$ano){
                            echo 'Preencha o campo de Ano';
                        }elseif(!$tamanho){
                            echo 'Preencha o tamanho do Jogo';
                        }elseif(!$link){
                            echo 'Preencha o campo de Magnetic Link';
                        }elseif(!$description){
                            echo 'Adicione uma Descrição';
                        }else{
                            $insert = 
       mysql_query("UPDATE games SET category='$category', slug='$slug', nome='$nome', trailer='$trailer', capa='$capa', lancamento='$ano', tamanho='$tamanho', link='$link', description='$description' WHERE id = '$id'") or die(mysql_error());
                        echo '<span class="trigger trigger-accept">JOGO ATUALIZADO COM SUCESSO</span>';

                        }
                        
                    }
                                             
                    ?>
                    <form name="form" action="" method="post">
                        <!--Hidden-->

                        
                        
                    <label>
                    <input required name="nome" placeholder="NOME DO JOGO" value="<?= $selectal['nome'];?>" type="text">
                    </label>
                    <label>
                    <input required name="slug" placeholder="SLUG" value="<?= $selectal['slug'];?>" type="text">
                    </label>
                    <label>
                    <input required name="trailer" placeholder="TRAILER" value="<?= $selectal['trailer'];?>" type="text">
                    </label>
                    <label>
                    <input required name="capa" placeholder="CAPA" value="<?= $selectal['capa'];?>" type="text">
                    </label>
                    <label>
                    <input required name="ano" placeholder="ANO DE LANÇAMENTO" value="<?= $selectal['lancamento'];?>" type="text">
                    </label>
                    <label>
                    <input required name="tamanho" placeholder="TAMANHO DO JOGO" value="<?= $selectal['tamanho'];?>" type="text">
                    </label>
                    <label>
                    <input required name="link" placeholder="MAGNETIC LINK" value="<?= $selectal['link'];?>" type="text">
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
                    <textarea name="description" required rows="10"  placeholder="Descrição do Jogo"><?= $selectal['description'];?></textarea>
                        </label>
                        <input type="submit" class="btn btn-green radius" value="Atualizar Jogo" name="postar">
                    </form>

                    <div class="clear"></div>
                </section>
            </footer>


   
  
    </body>
</html>


