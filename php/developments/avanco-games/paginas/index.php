   <script async type="text/javascript" src="http://www.adcash.com/script/java.php?option=rotateur&r=432810"></script>   


<!--Bloco de Video-->
                        <?php  

                 $select = mysql_query("SELECT * FROM games ORDER BY id DESC");
                 $selectviewall = mysql_query("SELECT * FROM estatistica");
                 $exview = mysql_fetch_array($selectviewall);
                 $count = mysql_num_rows($select);
                 $showgame = mysql_fetch_array($select);

                 ?> 
  
        <?php $ler = read('games','WHERE pin = 1 ORDER BY id LIMIT 3'); ?>
    
        <div id="slideshow">
        <ul>
        
        <?php
            foreach($ler as $lerSlide){
         echo '<li><a  href="'.HOME.'/'.$lerSlide['slug'].'" target="_blank" title="Baixar '.$lerSlide['nome'].' via Torrent" alt="Baixar '.$lerSlide['nome'].' Torrent"><img src="'.HOME.'/cp/uploads/'.$lerSlide['pin_img'].'"></a></li>';
            }
             ?>
        </ul>
        </div>
        <article class="container ">
            

                <div class="content">
                <header class="sectiontitle">
                    
                    <h1 class="font-normal">Baixar Jogos Completos em Torrent para PC, Xbox 360 e Playstation 3 Totalmente Grátis! </h1>
                    <p class="tagline">Muitos Jogos via <mark>Torrent</mark> para você se divertir!</p>

                </header>  


                
                
                
               
               <!-- <aside class="al-center">
                    <h1>Download <a class="btn btn-blue radius "title="Veja o Último Lançamento dos Games" target="_blank" href="<?= $showgame['slug'];?>"><?= $showgame['nome'];?></a> para <?= getCat($showgame['category'],'nome'); ?></h1>

                </aside>-->
                <div class="clear">
                    
                </div>
            </div>  
            <footer class="bg-blue">
                <section class="content main_games " style="padding-bottom:10px;">
                    <h1 class="fontzero" >Baixe Diversos Jogos Torrent!</h1>
                    
                    <?php 
                   $in = 0;
                    $read = read('games','ORDER BY id DESC LIMIT 12');

                    if($read){
                        foreach($read as $res){
                            
                        $in++;
                        $last = ($in%4==0 ? 'last' : null);?>
                        <article class="radius box box-small <?=$last;?>">

                        <div class="thumb">
                        <a title="Baixar <?= $res['nome'];?> para <?= getCat($res['category'],'nome'); ?> Torrent" alt="Baixar <?= $res['nome'];?> para <?= getCat($res['category'],'nome'); ?> Torrent" href="<?= $res['slug'];?>"><div class="plata font-light al-center"><?= getCat("$res[category]",'nome');?></div>
                        
                        <img title="Baixar <?= $res['nome'];?> para <?= getCat($res['category'],'nome'); ?> Torrent" alt="Baixar <?= $res['nome'];?> para <?= getCat($res['category'],'nome'); ?>  Torrent" data-original="<?= HOME.'/cp/uploads/'.$res['capa'];?>"/></a>
                        </div>
                            <h1 class="sectiontitle fontsize1"><a href="<?= $res['slug'];?>" title="Baixar <?= $res['nome'];?> para <?= getCat($res['category'],'nome'); ?> Torrent" alt="Baixar <?= $res['nome'];?> para <?= getCat($res['category'],'nome'); ?> Torrent"><?=$res['nome']; ?></a></h1>
                        <p class="fontsize1 font-light"><?= resumoAll($res['description'],120);?></p>

                        </article>
                    
               <?php
                    }   }
               ?>

                    <div class="al-center ">
                        <a href="jogos-torrent"><h1 class="btn radius boxshadow">Ver Todos os Jogos Torrent</h1></a>
                    </div>
                    <div class="clear"></div>

                </section>
            </footer>
        </article>

                
                    
        
        
        <!-- seção relacional-->
        <section class="container bg-orange">
            
            <div class="content" >
                <div class="sectiontitle sectiontitle-nomargin">
                    <h1>Avanço Games! Sua Melhor Opção.</h1>
                    <p class="tagline">Quer Saber Como Baixar um Jogo via Torrent?</p>
                </div>
                <div class="clear"></div>
            </div>
            
            <div class="container bg-body">
                <div class="content " style="padding-bottom:10px;">
                    
                    <article class="main_tec_item box box-small al-center radius">
                        <img src="<?= INCLUDE_PATH;?>/img/tec_semantic.png" alt="Baixar Jogos" title="Baixar Jogos">
                        <h1>uTorrent</h1>
                        <p class="tagline">Baixe o programa uTorrent. Instale-o, logo após vá até algum jogo que você queira em nosso site. E clique em "DOWNLOAD".</p>
                    </article>
                     <article class="main_tec_item box box-small al-center radius">
                        <img src="<?= INCLUDE_PATH;?>/img/tec_drycss.png" alt="Baixar Jogos Torrent Confiáveis" title="Jogos via Torrents Confiáveis">
                        <h1>Site Confiável</h1>
                        <p class="tagline">Avanço Games! É Um Site Totalmente Confiável! Pronto Para Lhe Dar Facilidade e Rapidez com o Jogo que Desejar!</p>
                    </article>
                     <article class="main_tec_item box box-small al-center ">
                        <img src="<?= INCLUDE_PATH;?>/img/tec_midia.png" alt="Novos Jogos Torrents Sempre" title="Jogos via Torrent Diários">
                        <h1>A Todo Momento!</h1>
                        <p class="tagline">Baixe jogos via Torrent em qualquer lugar e à qualquer momento! Site disponivel para todas as plataformas. Inclusive para Celular!</p>
                    </article>
                    
                     <article class="main_tec_item box box-small al-center last">
                        <img src="<?= INCLUDE_PATH;?>/img/tec_geo.png" alt="Avanço Games com muitas Novidades" title="Jogos Torrent Avanço Games">
                        <h1>Totalmente Grátis</h1>
                        <p class="tagline">Baixe Jogos para Todas Plataformas via Torrent e Totalmente de Graça !</p>
                    </article>
          
                </div>
            </div>
            
            <div class="container bg-lightgray"style="padding-bottom:30px">
                <div class="content">
                    <div class="sectiontitle">
                <h1 class="shorticon shorticon-sectiontitle shorticon-config ds-inblock">Ficha Técnica:</h1>
                <p class="tagline">Estatísticas de Nosso Site!</p>
                    </div>
                
                <?php
                $allgames = mysql_query("SELECT * FROM games");
                $plataformas = mysql_query("SELECT * FROM categoria");
                $countPlat = mysql_num_rows($plataformas);
                $countGames = mysql_num_rows($allgames);
                ?>
                <article class="main_info box box-small"><h1><b>Jogos: <?= $countGames; ?></b></h1></article>
                <article class="main_info box box-small"><h1><b>Acessos: <?=$exview['view_all'];?></b></h1></article>
                <article class="main_info box box-small"><h1><b>Plataformas: <?= $countPlat; ?></b></h1></article>
                <article class="main_info box box-small last"><h1><b>Admin: Felipe Chiarotti</b></h1></article>
                </div>
                
            </div>
        </section>
        
        <article class="container bg-red">
            <div class="content content-page al-center">
                <header class="sectiontitle">
                    
                    <h1>
                       Ajude-nos a manter o site com novos Jogos Torrent!
                    </h1>
                    <p class="tagline">Comece Agora Mesmo. Precisamos de sua Ajuda, <mark >Jogos Torrent</mark>, <mark>Baixe nossos Jogos Torrent</mark> para <mark>PC</mark>, <mark>PS3</mark> e <mark>Xbox 360</mark></p>

                    
                </header>
                
            
                <footer>
                    <div class="main_chamada al-center">
                        Você baixa onde e quando quiser, os melhores torrents, os melhores jogos torrent, a melhor diversão !
                    </div>
                </footer>
                <div class="clear"</div>
            </div>
        </article>
        
        <!--content visual-->
