      <!--Bloco de Video-->
                        <?php
                 $selectviewall = mysql_query("SELECT * FROM estatistica");
                 $exview = mysql_fetch_array($selectviewall);       
                 $readGenero = read('genero',"WHERE slug = '$explode[0]'");
                 
                 foreach($readGenero as $cat): endforeach;

                 
                 //PAGINAÇÃO
                 
                 

                           $total_reg = 24;
                           if (!isset($explode[1])) 
                           { 
                                   $pc = 1; 
                           }else 
                           { 
                                   $pc = $explode[1];
                           }
                           $inicio = $pc - 1;
                           $inicio = $inicio * $total_reg;

                 ?> 
    

        <article class="container ">
            <div class="content">
                <header class="sectiontitle">
                    
                    <h1 ><mark>Download Series <?php if($explode[0] != 'series'){echo ' de '; echo strtoupper($cat['nome']); }?></mark> Completas via Torrent</h1>
                    <p class="tagline"></p>
                    <div style="width:95%; margin:0 auto;">

                    </div>
                </header>  
                
                
                <div class="clear">
                    
                </div>
            </div>  
            <footer class="gradradial">
                <section class="content main_games " style="padding-bottom:10px;">
                    <h1 class="" >Confira e Baixe Séries via Torrent!</h1>
                    
                    <?php 
                    /*                    if(isset($explode[1])){

                    $in = 0;
                    $limit = mysql_query("$busca ORDER BY id DESC LIMIT $inicio,$total_reg ");
                    while($rel = mysql_fetch_array($limit)){
                    $in++;
                    $last = ($in%4==0 ? 'last' : null);?>
                        <article class="box box-small <?=$last;?>">
                      
                        <div class="thumb">
                        <a href="<?= HOME.'/'.$rel['slug'];?>"><div class="plata font-light al-center"><?= $rel['plataforma'];?></div>
                        
                        <img title="Baixar <?= $showgame['nome'];?>" alt="Baixar <?= $showgame['nome'];?>" src="<?= HOME.'/cp/uploads/'.$rel['capa'];?>"/></a>
                        </div>
                        <h1 class="sectiontitle fontsize1 font-light al-center"><?= resumo($rel['nome'],100);?></h1>
                        
                        </article>
                   
                      <?php
                    } 
                    ?>
                    <div class="radius textshadow pag al-center">
                    <?php for($i = 1; $i < $tp + 1; $i++) {
                    echo '<a href="'.HOME.'/'.$explode[0].'/'.$i.'">'.$i.'</a>';
                    }
                    ?>
                    </div>
                    <?php }  
                  */
                    
                    if($explode[0] != 'series-torrent'){

 
                        
                    $limite = read('temporada',"WHERE generoum = '".$cat['id']."' OR generodois = '".$cat['id']."' ORDER BY id DESC LIMIT $inicio,$total_reg");    
                    $limit = mysql_query("SELECT * FROM temporada WHERE genero = '".$cat['id']."'");

                    $tr = mysql_num_rows($limit);
                    $tp = $tr / $total_reg;

                    foreach($limite as $rel){
                        ?>
                        <article class="radius box box-small">
                      
                        <div class="thumb boxshadowb">
                          
                          
                          <img title="Download <?= $rel['nome']; ?>" alt="Download <?= $rel['nome']; ?>" src="<?= HOME.'/cp/uploads/'.$rel['capa'];?>"/>
                          <a title="Download <?= $rel['nome']; ?>" href="<?= HOME.'/'.$rel['slug'];?>" class="plata"><h1 class="fontsize1 textshadowb"><?= $rel['nome'];?></h1></a>
                          <p class="sinopse textshadowb"><?= resumoall($rel['sinopse'], 300);?></p>
                        </div>

                        </article>
                   
                      <?php
                    } 
                    ?>
                    <div class="radius textshadowb pag al-center">
                    <?php for($i = 1; $i < $tp + 1; $i++) {
                    echo '<a href="'.HOME.'/'.$explode[0].'/'.$i.'">'.$i.'</a>';
                    }
                    ?>
                    </div>
                    <?php 
                               
                    }else{

                    $limite = read('games',"ORDER BY id DESC LIMIT $inicio,$total_reg");
                    $limit = mysql_query("SELECT * FROM games");
                    $tr = mysql_num_rows($limit);
                    $tp = $tr / $total_reg;
                    $in = 0;
                    foreach($limite as $rel){

                    $in++;
                    $last = ($in%4==0 ? 'last' : null);?>
                        <article class="radius box box-small">
                      
                        <div class="thumb boxshadowb">
                          
                          
                          <img title="Download <?= $rel['nome']; ?>" alt="Download <?= $rel['nome']; ?>" src="<?= HOME.'/cp/uploads/'.$rel['capa'];?>"/>
                          <a title="Download <?= $rel['nome']; ?>" href="<?= HOME.'/'.$rel['slug'];?>" class="plata"><h1 class="fontsize1 textshadowb"><?= $rel['nome'];?></h1></a>
                          <p class="sinopse textshadowb"><?= resumoall($rel['sinopse'], 300);?></p>
                        </div>

                        </article>
                   
                      <?php
                    } 
                    ?>
                    <div class="radius textshadow pag al-center">
                    <?php for($i = 1; $i < $tp + 1; $i++) {
                    echo '<a href="'.HOME.'/'.$explode[0].'/'.$i.'">'.$i.'</a>';
                    }
                    ?>
                    </div>
                    <?php                      
                    }?>
                    

                    
              <br />
              <br />

                    <div class="clear"></div>
           

                </section>
            </footer>
        </article>

                
                    
        
        
        <!-- seção relacional-->
        <section class="container bg-orange">
            
            <div class="content" >
                <div class="sectiontitle sectiontitle-nomargin">
                    <h1>Baixar Jogos Torrent.</h1>
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
                <article class="main_info box box-small"><h1><b>Acessos: <?= $exview['view_all'];?></b></h1></article>
                <article class="main_info box box-small"><h1><b>Plataformas: <?= $countPlat; ?></b></h1></article>
                <article class="main_info box box-small last"><h1><b>Administrador: iShionz</b></h1></article>
                </div>
                
            </div>
        </section>
        
