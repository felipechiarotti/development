<?php
require '../_app/Config.inc.php';
?>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Entrar no Painel de Controle</title>
        
        <link rel="stylesheet" href="<?= INCLUDE_PATH; ?>css/boot.css"/>
        <link rel="stylesheet" href="cp.css"/>

        <link rel="shortcut icon" href="<?= INCLUDE_PATH;?>img/favicon.png"/>
    </head>
    <body>

        <div class="container radius boxshadow" style="position:absolute; background-color:rgba(3,3,3,0.6); color:#fff; width:50%; top:50%; margin-top:-130px; left:50%; margin-left:-25%;">
            <div class="content"  >
                <h1 class="fontsize1b text-shadow">Acesso ao Painel</h1>
                <form name="login" action="" method="post">
                   <input required class="box box-full radius boxshadow" name="user" style="margin-top:10px;"type="text" placeholder="Usuário">
                   <input required class="box box-full radius boxshadow" name="password" style="margin-top:10px;"type="password" placeholder="Senha">
                 <input class="btn btn-blue radius box boxshadow " style="margin-top:10px; margin-bottom:10px;" type="submit" name="login">
                </form>       
                
                    
                                    <?php 

                    $user = $_POST['user'];
                    $pass = $_POST['password'];     
                    
                    if(isset($_POST['login'])){

                            $veri = mysql_query("SELECT * FROM account WHERE user = '$user' AND password = '$pass'") or die("erro ao direcionar");
                             
                            if (mysql_num_rows($veri)<=0){
                             ;
                            echo '<div class="trigger-error box box-full  al-center " style="padding:10px;">Login ou Senha Incorreto!</div>';
                             }else{
                while($pegar = mysql_fetch_assoc($veri)){                 
                session_start();
		$_SESSION['user']       = $_POST['user'];
		$_SESSION['password']   = $_POST['password'];     
                $_SESSION['dados']       = $pegar;           
                }
                
                print_r($_SESSION);
                            
                echo '<div class="trigger-accept box box-full al-center " style="padding:10px;" >Bem-Vindo ao Painel '.$_SESSION['user'].'</div>';

                    ?>
                    <script type="text/javascript">
                    window.setTimeout("location.href='http://www.avancogames.com.br/cp/manage.php';", 1000);
                    </script>
                    <?php        
                    }
                        
                        
                    
                    }
                    ?>    

                <div class="clear"></div>
            </div>

        </div>
   
  
    </body>
</html>


