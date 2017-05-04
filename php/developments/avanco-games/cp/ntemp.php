<?php
require '../_app/Config.inc.php';

if(!isset($_SESSION['user'])) session_start();

if(!isset($_SESSION['user'])){
header("Location: index.php");
session_destroy();
}
$read = read('serie',"ORDER BY id");

?>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Nova Temporada   </title>
        
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
                    <h1 >Nova Temporada!</h1>
                                        <?php
                   
                    
                    
                   
                    if(isset($_POST['postar'])){
                     $qualidade = implode(" ",$_POST['qualidade']);

                    $f['sinopse'] =     $_POST['sinopse'];
                    $f['dur_epi'] =     $_POST['dur_epi'];
                    $f['qualidade'] =     $qualidade;
                    $f['lancamento'] =     $_POST['lancamento'];
                    $f['temporada'] =     $_POST['temporada'];
                    $f['serie'] =     $_POST['serie'];
                    $f['audio'] = $_POST['audio'];
                    $f['servidor']  = 'Torrent';
                    $f['nome'] = getSerie("$f[serie]",'nome').' '.$f['temporada'].'º Temporada '.$f['servidor'].' - '.$f['qualidade'].' '.$f['audio'].' '.$f['lancamento'];  
                    $f['slug'] =        slug($f['nome']);
                    $f['autor']       = $_SESSION['dados']['user_id'];
                    $f['generoum'] = $_POST['generoum'];
                    $f['generodois'] = $_POST['generodois'];
                    $f['generotres'] = $_POST['generotres'];
                    $f['pin']       = $_POST['pin'];
                    $pin_img     = $_FILES['pin_img'];

                    $img         = $_FILES['capa'];
                    $ext         = substr($img['name'],-3);
                    $pasta       = "uploads/";
                    
                    if(!empty($pin_img['name'])):
                    $extpin         = substr($pin_img['name'],-3);
                    $f['pin_img']  = time($pin_img['tmp_name']).'.'.$extpin;
                    uploadImage($pin_img['tmp_name'], $f['pin_img'], '1920', '300', $pasta, '40');                   
                    endif;





                    $f['capa']  = md5(time($img['tmp_name'])).'.'.$ext;

                            echo '<br /><pre>';
                            print_r($f);
                            echo '</pre>';
                           uploadImage($img['tmp_name'], $f['capa'], '730', '944', $pasta, '10');

                           create("temporada",$f);

                        
                        
                    }
                                             
                    ?>
                    <form name="form" action="" enctype="multipart/form-data" method="post">
                        
                        <label>
                        <select required name="serie">
                            <option value="">Selecione a Série!</option>
                            
                            <?php foreach($read as $select): ?>
                            <option value="<?= $select['id'];?>"><?= $select['nome'];?></option>
                             <?php endforeach;?>
                        </select>
                    </label>  
                    <label>
                    <input required name="temporada" placeholder="Número da Temporada" type="text">
                    </label>    
                        <label>
                    <input type="file" name="capa" />
                        </label>
                    <label>
                    <input required name="dur_epi" placeholder="Duração do Episódio" type="text">
                    </label>
   
                        <label>  <input type="checkbox" name="qualidade[]" class="checkbox" value="HDTV">480p<br/> </label>
                        <label>  <input type="checkbox" name="qualidade[]" class="checkbox" value="720p">720p<br/> </label>
                        <label>  <input type="checkbox" name="qualidade[]" class="checkbox" value="1080p">1080p<br/> </label>
                        <label>  <input type="checkbox" name="qualidade[]" class="checkbox" value="Dual Audio">Dual Audio<br/> </label>
                        <label>  <input type="checkbox" name="qualidade[]" class="checkbox" value="BluRay Rip">BluRay<br/> </label>
   
                    <label>
                        <select name="audio">
                            <option value="">Selecione a forma:</option>
                            <option value="Legendado">Legendado</option>
                            <option value="Dublado">Dublado</option>
                        </select>
                    </label>
                        <label>
                        <select required name="generoum">
                            <option value="">Selecione o Primeiro Gênero:</option>
                            <?= $read = read('genero',"ORDER BY id");
                            foreach($read as $select): ?>
                            <option value="<?= $select['id'];?>"><?= $select['nome'];?></option>
                             <?php endforeach;?>
                        </select>
                    </label>    
                        <label>
                        <select required name="generodois">
                            <option value="">Selecione o Segundo Gênero:</option>
                            <?= $read = read('genero',"ORDER BY id");
                            foreach($read as $select): ?>
                            <option value="<?= $select['id'];?>"><?= $select['nome'];?></option>
                             <?php endforeach;?>
                        </select>
                    </label>  
                        <label>
                        <select name="generotres">
                            <option value="">Selecione o Terceiro Gênero:</option>
                            <?= $read = read('genero',"ORDER BY id");
                            foreach($read as $select): ?>
                            <option value="<?= $select['id'];?>"><?= $select['nome'];?></option>
                             <?php endforeach;?>
                        </select>
                    </label>  
                        <label>
                           <input required name="lancamento" placeholder="Ano da Temporada" type="text"> 
                        </label>
                        <label>
                    <textarea name="sinopse" required rows="15" placeholder="Sinopse do Episódio"></textarea>
                        </label>
                        <label>
                            <label> <input type="checkbox" name="pin" class="checkbox" value="1">Fixar Série</label>
                        </label>
                    <label>
                    <input type="file" name="pin_img" />
                        </label>
                        <input type="submit" class="btn btn-green radius" value="Postar Episódio" name="postar">
                    </form>

                    <div class="clear"></div>
                </section>
            </footer>


   
  
    </body>
</html>


