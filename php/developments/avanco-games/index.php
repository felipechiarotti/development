<?php
require './_app/Config.inc.php';
        $url = isset($_GET['url']) ? $_GET['url'] : 'index';
        $explode = explode('/', $url);
        session_start();
?>
<!DOCTYPE html>
<html lang="pt-br" itemscope itemtype="https://schema.org/Article">
    <head>
        <meta charset="UTF-8">
        <title><?= $pg_title;?></title>
        <meta name="description" content="<?= $pg_desc;?>"/>
        <meta name="robots" content="index, follow"/>
        <meta name="viewport" content="width-device-width, initial-scale=1">
        
        <link rel="author" href="https://plus.google.com/<?= $pg_google_author ; ?>/posts"/>
        <link rel="publisher" href="https://plus.google.com/<?= $pg_google_publisher;?>"/>
        <link rel="canonical" href="<?= $pg_url; ?>">


        <meta itemprop="name" content="<?= $pg_site;?>"/>
        <meta itemprop="description" content="<?= $pg_desc;?>"/>
        <meta itemprop="image" content="<?= $pg_image;?>"/>
        <meta itemprop="url" content="<?= $pg_url;?>"/>
        
        <meta property="og:type" content="article" />
        <meta property="og:title" content="<?= $pg_title;?>" />
        <meta property="og:description" content="<?= $pg_desc;?>" />
        <meta property="og:image" content="<?= $pg_image;?>" />
        <meta property="og:url" content="<?= $pg_url;?>" />
        <meta property="og:site_name" content="<?= $pg_site;?>" />
        <meta property="og:locale" content="pt_BR" />
        
        <meta property="og:app_id" content="<?= $pg_fb_app;?>" />
        <meta property="article:author" content="https://www.facebook.com/<?= $pg_fb_author;?>" />
        <meta property="article:publisher" content="https://www.facebook.com/<?=$pg_fb_page;?>" />
        
        <meta property="twitter:card" content="summary_large_image" />
        <meta property="twitter:site" content="<?= $pg_twitter;?>" />
        <meta property="twitter:domain" content="<?= $pg_domain;?>" />
        <meta property="twitter:title" content="<?= $pg_title;?>" />
        <meta property="twitter:description" content="<?= $pg_desc;?>" />
        <meta property="twitter:image:src" content="<?= $pg_image;?>" />
        <meta property="twitter:url" content="<?= $pg_url;?>" />
        
        <!--[if lt IE 9]>
                    <script src="js/html5shiv.js"></script>
        <![endif]-->
                <link href="<?= $pg_image;?>" rel="image_src" />
        <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="<?= INCLUDE_PATH; ?>css/boot.css"/>
        <link rel="stylesheet" href="<?= INCLUDE_PATH; ?>css/style.css"/>
        <link rel="shortcut icon" href="<?= INCLUDE_PATH;?>img/favicon.png"/>



        
        
    </head>


    <body>
        
<script>(function() {
  var _fbq = window._fbq || (window._fbq = []);
  if (!_fbq.loaded) {
    var fbds = document.createElement('script');
    fbds.async = true;
    fbds.src = '//connect.facebook.net/en_US/fbds.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(fbds, s);
    _fbq.loaded = true;
  }
  _fbq.push(['addPixelId', '789369454492662']);
})();
window._fbq = window._fbq || [];
window._fbq.push(['track', 'PixelInitialized', {}]);
</script>
<noscript><img height="1" width="1" alt="" style="display:none" src="https://www.facebook.com/tr?id=789369454492662&amp;ev=PixelInitialized" /></noscript>

<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '952783774746727',
      xfbml      : true,
      version    : 'v2.3'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>
        
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-58958308-1', 'auto');
  ga('send', 'pageview');

</script>
 
    <?php 
                if(!$_SESSION['popup']){

          
            
            
            ?><div id="popup" class="radius boxshadow al-center ">

              
            <div class="fb-page" data-href="https://www.facebook.com/avancogame" data-small-header="true" data-width="500" data-height="500" data-hide-cover="false" data-show-facepile="true" data-show-posts="false"><div class="fb-xfbml-parse-ignore"><blockquote cite="https://www.facebook.com/avancogame"><a href="https://www.facebook.com/avancogame">Avanço Games</a></blockquote></div></div>  
            <p onclick="popupoff();" class="al-center btn btn-blue radius boxshadow closepopup" style="width:100%;">FECHAR POPUP</p>
                       
            </div>
            <div id="darkness" onclick="popupoff();"></div>
            <?php
                $_SESSION['popup'] = 1;
            }

?>
<!--<script async="true" type="text/javascript" src="http://carnage1301.spider.ad?id=37597"></script>-->


        <header class="container top">
            
            <div class="content" style="padding:0;">
            <h1 class="main_logo fl-left fontzero">
                <a title="Home" href="<?= HOME; ?>">
                
                <?= $pg_title; ?>
                
                </a>
            </h1>

                <ul class="main_nav fl-right">
                  <?php require REQUIRE_PATH . '/inc/main_nav.php' ?>
                </ul>

                <div class="clear"></div>

                <ul class="main_nav-active textshadowb boxshadow">
                <?php $lerGen = read('genero');
                      foreach($lerGen as $lerGenero): ?>
                <li><a title="Download Séries do Genero <?= $lerGenero['nome'];?>" href="<?= HOME; ?>/<?= $lerGenero['slug'];?>"><?= $lerGenero['nome'];?></a></li>
                   <?php  endforeach; ?>
                </ul>
                            </div>  
        </header>

        <!--CONTEUDO-->
        <?php $ler = read('temporada',"WHERE pin = 1 ORDER BY id DESC LIMIT 3"); ?>
    
        <div id="slideshow">
        <ul>
        
        <?php
            foreach($ler as $lerSlide):
         echo '<li><a  href="'.HOME.'/'.$lerSlide['slug'].'" target="_blank" title="Baixar o Jogo '.$lerSlide['nome'].' via Torrent" alt="Baixar o Jogo '.$lerSlide['nome'].' Torrent"><img class="imagemativa" src="'.HOME.'/cp/uploads/'.$lerSlide['pin_img'].'"/></a> <p class="legenda boxshadow textshadow radius fontsize1">'.$lerSlide['nome'].'</p></li>';
            endforeach;
             ?>
        </ul>
        </div>
        
   
        
        <?php 

        $url = isset($_GET['url']) ? $_GET['url'] : '';
        $explode = explode('/', $url);
        $queryselect = mysql_query("SELECT * FROM temporada WHERE slug = '$explode[0]'");
        $sel = mysql_fetch_array($queryselect);
        echo $sel['slug'];
        $gen = read('genero', "WHERE slug = '$explode[0]'");
        foreach($gen as $genero){

        if(isset($explode[0]) && $explode[0] == ''){
            include_once "paginas/index.php";
        }elseif($explode[0] != ''){
                if(isset($explode[0]) AND $explode[0] == $genero['slug']){
                    include_once "paginas/categoria.php";
                }elseif(isset($explode[0]) && $explode[0] == 'contato') {
                    include_once "paginas/contato.php";
                }elseif(isset($explode[0]) && $explode[0] == $sel['slug']) {
                    include_once "paginas/jogo.php";                    
                }elseif(isset($explode[0]) && $explode[0] == 'busca') {
                    include_once "paginas/busca.php";
                }else{ include_once "paginas/404.php";}

        }
        
                }

        ?>
        
        
        
        
        
        <!--CONTEUDO-->


        <div class="container">
            
            <div class="content content-page al-center fontsize1b font-light">

                Avanço Games. O Melhor Site para Baixar Jogos Torrent à sua Disposição!
            </div>
        </div>
        
        
        <footer class="container bg-lightgray">
            <section class="main_footer content">
                <h1 class="fontzero">Sobre a Avanço Games - Jogos Torrents</h1>
                
                
                
                <nav class="box box-medium">
                    
                    
                    <h1 class="title font-bold">Mais sobre a Avanço Games</h1>
                    <ul>
                        <?php $selecion = mysql_query("SELECT * FROM games ORDER BY id DESC LIMIT 3");
                                while($selecio = mysql_fetch_array($selecion)){?>
                        <li><a class="shorticon shorticon-section" title="Ultimas Novidades" href="#apresentacao"><?= $selecio['nome'];?></a></li>
                                <?php } ?>      
                    </ul>
                    
                    
                </nav>
                
                <article class="box box-medium">
                    
                    <h1 class="title font-bold">Avanço nas redes sociais:</h1>
                    <ul><li><a class="shorticon shorticon-facebook" target="_blank" rel="nofollow" title="Avanço Games no Facebook" href="https://www.facebook.com/avancogame">Facebook</a></li>
                        <li><a class="shorticon shorticon-google"target="_blank" rel="nofollow" title="Avanço Games no Google Plus" href="https://plus.google.com/100522617584376444521">Google+</a></li>  
                        <li><a class="shorticon shorticon-twitter"target="_blank" rel="nofollow" title="Avanço Games no Twitter" href="https://twitter.com/avancogames">Twitter</a></li>
                    
                                    </ul>
                             </article>
                
                <article class="main_ead box box-medium last">
                    
                    <h1 class="fontzero">Plataforma Avanço</h1>
                    <p class="shorticon shorticon-config"><b>Plataforma EAD:</b><a title="Plataforma EAD da Avanço" href=http://www.avancogames.com.br"> Avanço Games</a></p>
                    <p class="shorticon shorticon-mail"><b>Desenvolvido:</b><a title="Envie um e-mail" href="mailto:avancogame@gmail.com"> Felipe Chiarotti</a></p>
                    
                    <hr>
                    <p class="plast">&copy; <?= date('Y');?> - Avanço Games, Todos os Direitos Reservados
                    
                </article>
                <div class="clear"></div>
            </section>
        </footer>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script async type="text/javascript" src="<?= INCLUDE_PATH;?>js/config.js"></script>
        <script  type="text/javascript" src="<?= INCLUDE_PATH;?>js/jcycle.js" ></script>
        <script  type="text/javascript" src="<?= INCLUDE_PATH;?>js/jquery.lazyload.js"></script>


    </body>    
</html>