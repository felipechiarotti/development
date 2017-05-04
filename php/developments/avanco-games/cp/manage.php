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
        
        
            <footer class="container bg-lightgray ">
                <section class="content main_games " style="padding-bottom:10px;">
                    
                    <h1 >Confira os nossos Jogos!</h1>
                    
                   <?php  if(isset($_GET['id'])){
                    $id = $_GET['id'];
                    $deleta = mysql_query("DELETE FROM games WHERE id = '$id'");
                    if($deleta = ''){ echo '<div class="wrong">NÃO FOI POSSIVEL EXCLUIR</div>';}
                    else{ echo '<div class="trigger trigger-accept">NOTICIA EXCLUIDA</div>';}
                    }
                    
                    $in = 0;
                    $read = read('games','ORDER BY id DESC');

                    if($read){
                        foreach($read as $res){
                            
                        $in++;
                        $last = ($in%4==0 ? 'last' : null);?>
                    
                        <article class="box box-small <?=$last;?>">
                      
                        <div class="thumb">
                        <a href="<?= $res['category'];?>/<?= $res['slug'];?>"><div class="plata font-light al-center"><?= $res['plataforma'];?></div>
                        
                        <img title="Baixar <?= $res['nome'];?>" alt="Baixar <?= $res['nome'];?>" src="<?= HOME.'/cp/uploads/'.$res['capa'];?>"/></a>
                        </div>
                        <h1 class="sectiontitle fontsize1 font-light al-center"><?= $res['nome'];?></h1>

                        <a href="editar.php?id=<?php echo $res['id']; ?>" class="btn btn-green radius">Editar</a>
                        <a href="manage.php?id=<?php echo $res['id']; ?>" class="btn btn-red radius">Excluir</a>
                       
                        
                        </article>
                    <?php    }
                    }?>



                    <div class="clear"></div>
                </section>
            </footer>


   
  
    </body>
</html>


