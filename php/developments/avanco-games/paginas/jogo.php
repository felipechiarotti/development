   <script type="text/javascript" src="http://www.adcash.com/script/java.php?option=rotateur&r=432810"></script>   
  <?php  
                                       
                                       $selecionar = mysql_query("SELECT * FROM games WHERE slug = '$explode[0]'");
                                       $showgame = mysql_fetch_array($selecionar);
                                       $side = mysql_query("SELECT * FROM games ORDER BY view DESC LIMIT 3");

                                       $visu = $showgame['view'];
                                       $down = $showgame['down'];
                                       $view = mysql_query("UPDATE games  SET view = ('$visu' + 1) WHERE slug = '$explode[0]'");
                 ?> 

<!--Bloco de Video-->
        <article class="container single">
            <div class="content">
                <header class="single-header">
                    
                                   <h1>Baixar <?= $showgame['nome'];?> (<?= $showgame['lancamento'];?>) para <?= getCat("$showgame[category]",'nome');?> Completo via Torrent</h1>

                                   <ul class="single-info" style="margin-bottom:10px;">
                                       <li>Por: <?= getAutor("$showgame[autor]",'nick'); ?></li>
                                       <li><?=  date('d/m/Y H:i:s',strtotime($showgame['data'])); ?></li> 
                                       <li>Em: <a title="<?= $pg_name;?>" href="<?= HOME;?>">Avanço Games</a> &raquo; <a title="<?= $showgame['plataforma'];?>" href="<?= HOME.'/'.getCat("$showgame[category]",'url');?>"><?= getCat("$showgame[category]",'nome');?></a></li>
                                   </ul>
                </header>  
                <div class="clear">
                    
                </div>
            </div>  
            
            <div class="redemobile"><script type="text/javascript" src="http://www.adcash.com/script/java.php?option=rotateur&r=432809"></script></div>
            <div class="bg-light">
                <div class="content">
                    <div class="box box-forthree fl-left">
                        <img src="<?= HOME.'/cp/uploads/'.$showgame['capa'];?>" alt="[<?= $pg_name;?>]" title="<?= $pg_name;?>"/>
                        <h2 class="box box-full al-center text-shadow" style="background-color:#34495e; margin-bottom:20px; padding:10px; color:#fff;"><?= $showgame['nome'];?> para <?= getCat("$showgame[category]",'nome');?> via Torrent</h2>
                        <div class="fl-left" style="margin-right:20px; width:100%;">
                        <script type="text/javascript" src="http://www.adcash.com/a/display.php?r=439151"></script>
                        </div>
                        <div  class="htmlchars">

                        
                        
                        <p><?= nl2br($showgame['description']);?></p> 
                        
                     
                        
                       <div class="al-center" style="margin-bottom:20px;">
                       <div class="fb-share-button" data-href="<?php $pg_url; ?>" data-layout="box_count"></div>
                       <div class="fb-like" data-href="<?php $pg_url; ?>" data-layout="box_count" data-action="like" data-show-faces="true" data-share="false"></div>
                       </div>

                       <div class="al-center">
<div style="margin-top:20px; width:100%;">
    <div class="redemobile"><script type="text/javascript" src="http://www.adcash.com/script/java.php?option=rotateur&r=439150"></script>
</div>
</div>  
 <?php                    $tags = explode(",",$showgame['tags']);
                       
                       foreach ($tags as $eachtag):
                           echo '<h2>'.$eachtag.'</h2>'; 
                           echo '<br/>';
                       endforeach;
                       
                       
                       ?>                          
<a style="color:#fff; margin-top:20px;" name="magnetic" title="Baixar <?= $showgame['nome'];?> Torrent." alt="Baixar <?= $showgame['nome'];?> Torrent." class="btn radius font-normal btn-big text-shadow btn-blue fontsize1b" href="<?= $showgame['link'];?>" >Download</a>
    <br />
               
                       
                       </div>
                    </div>
                    </div>

                <aside style="width:30%;" class="box-forthreesmall fl-right">
                    <h1 class="fontzero">Sugestão de Conteúdo:</h1>
                    
                    <section class="sidebar-widget">
                        <header>
                            <h1>Jogos mais Vistos:</h1>
                            <p>Confira os Jogos Torrent!</p>
                        </header>
                        
                        <?php while($widget = mysql_fetch_array($side)){ ?>
                        <article class="sidebar-mosview">
                            <img title="<?= $widget['nome'];?>" alt="<?=$widget['nome'];?>" src="<?= HOME.'/cp/uploads/'.$widget['capa'];?>">
                            <h1><a title="<?= $widget['nome'];?>" alt="<?=$widget['nome'];?>" href="<?= $widget['slug'];?>"><?= resumo($widget['nome'],25);?></a></h1>

                        </article>
                        <?php }?>
                    </section>
                    
                    
                    <section class="sidebar-widget">
                        <header>
                            <h1>Curta-nos:</h1>
                            <p>Fique por dentro das Novidades!</p>
                        </header>


<div class="fb-like-box" data-href="https://www.facebook.com/avancogame"  data-height="290" data-colorscheme="light" data-show-faces="true" data-header="false" data-stream="false" data-show-border="false"></div>


                    </section>
                    
                     <section class="sidebar-widget">
                        <header>
                            <h1>Publicidade:</h1>
                            <p>Anúncios para você!</p>
                        </header>

<div style="margin-top:10px; height:300px;" class="al-center">
<script type="text/javascript" src="http://www.adcash.com/a/display.php?r=439148"></script>
</div>


                    </section>
                </aside>
                                           <div class="clear"></div>    
                
                </div>
            </div>


   
        </article>

    <div class="container bg-body">
        <div class="al-center content">
        <p class="fontsize2b font-light">Deixe sua Opinião!</p>
        <p class="fontsize1">Tem uma Dúvida? Gostou do Jogo? Deixe-nos Saber!</p>
<div class="redemobile"> 
<div class="fb-comments" data-href="<?php $pg_url; ?>" data-numposts="5"  data-colorscheme="light"></div>
<div class="fb-like-box" data-href="https://www.facebook.com/avancogame" data-height="290" data-colorscheme="light" data-show-faces="true" data-header="false" data-stream="false" data-show-border="false"></div>
</div>
        </div>
    </div>
                    <section class="container bg-lightgray"style="padding-bottom:30px">
                <div class="content">
                    <div class="sectiontitle">
                <h1 class="shorticon shorticon-sectiontitle shorticon-config ds-inblock">Ficha Técnica:</h1>
                <p class="tagline">Informações sobre o jogo!</p>
                    </div>
                <article class="main_info box box-small"><h1><b>Tamanho: <?=$showgame['tamanho'];?>GB</b></h1></article>
                <article class="main_info box box-small"><h1><b>Visualizado: <?=$showgame['view'];?></b></h1></article>
                <article class="main_info box box-small"><h1><b>Lançamento: <?=$showgame['lancamento'];?></b></h1></article>
                <article class="main_info box box-small last"><h1><b>Plataforma: <?= $showgame['plataforma'];?></b></h1></article>
          
                </div>
                
            </section>
         
        

        <article class="container bg-red">
            <div class="content content-page al-center">
                <header class="sectiontitle">
                    
                    <h1>Ajude-nos a conseguir mais Jogos Torrent</h1>
                    
                    <p class="tagline">Comece Agora Mesmo. Precisamos de sua Ajuda, <mark >Jogos Torrent</mark>, <mark>Baixe nossos Jogos Torrent</mark> para <mark>PC</mark>, <mark>PS3</mark> e <mark>Xbox 360</mark></p>
                    
                </header>
                
                
                <footer>
                    <div class="main_chamada al-center">
                        Os Melhores Jogos Torrents para você Baixar Totalmente Completo e Grátis!
                    </div>
                </footer>
                <div class="clear"</div>
            </div>
        </article>
        
        <!--content visual-->
