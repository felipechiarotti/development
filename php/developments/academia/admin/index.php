<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Entrar no Painel de Controle</title>

        <link rel="stylesheet" href="boot.css"/>
        <link rel="stylesheet" href="cp.css"/>
    </head>
    <body>

        <div class="container radius boxshadow" style="position:absolute; background-color:rgba(3,3,3,0.6); color:#fff; width:50%; top:50%; margin-top:-130px; left:50%; margin-left:-25%;">
            <div class="content"  >
                <h1 class="fontsize1b text-shadow">Acesso ao Painel</h1>
                <form name="login" action="" method="post">
                   <input required class="box box-full radius boxshadow" name="user" style="margin-top:10px;"type="text" placeholder="Usuário">
                   <input required class="box box-full radius boxshadow" name="password" style="margin-top:10px;"type="password" placeholder="Senha">
                 <input class="btn btn-green radius box boxshadow " style="margin-top:10px; margin-bottom:10px;" type="submit" name="login">
                </form>


                  <?php
                    require_once './../pages/classes/Connection.php';
                    require_once './../pages/classes/Login.php';

                    if(isset($_POST['login'])){
                      $login = new Login();
                      if($login->logar($_POST['user'],$_POST['password'])){
                        header("Location:dashboard.php");
                      }else{
                        echo '<div class="trigger-accept box box-full al-center " style="padding:10px;" >Erro ao conectar: '.$_POST['user'].'</div>';
                      }

                    }
                  ?>


                    <!-- <script type="text/javascript">
                    window.setTimeout("location.href='http://www.avancogames.com.br/cp/manage.php';", 1000);
                    </script> -->

                <div class="clear"></div>
            </div>
        </div>
    </body>
</html>
