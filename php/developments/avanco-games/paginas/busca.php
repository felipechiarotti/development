
<!--Bloco de Video-->
                        <?php
                 $selectviewall = mysql_query("SELECT * FROM estatistica");
                 $exview = mysql_fetch_array($selectviewall);       
                 $busca = $_POST['busca'];
                 $select = mysql_query("SELECT * FROM games WHERE nome LIKE '%$busca%'");
                 

                 $count = mysql_num_rows($select);
                 ?> 
  
        <article class="container ">
            <div class="content">
                <header class="sectiontitle">
                    
                    <h1 ><mark> Resultados para <?= $busca ;?></mark> via <mark>Torrent</mark></h1>
                    <p class="tagline"></p>
                    <div style="width:80%; margin:0 auto; height:110px;">
                    <script type="text/javascript" src="http://www.adcash.com/ad/display.php?r=432808"></script>
                    </div>
                </header>  
                
                           <div class="al-center" style="margin-top:10px;">  <iframe src="//www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2Favancogame&amp;width=800&amp;height=80&amp;colorscheme=light&amp;show_faces=true&amp;header=true&amp;stream=false&amp;show_border=true&amp;appId=952783774746727" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:100%; height:80px;" allowTransparency="true"></iframe>   </div>        
                <div class="clear">
                    
                </div>
            </div>  
            <footer class="bg-blue ">
                <section class="content main_games " style="padding-bottom:10px;">
                    <h1 >Resultados Encontrados!</h1>
                    <?php
                    $in = 0;
                   
                    while($showgame = mysql_fetch_array($select)){
                    $in++;
                    $last = ($in%4==0 ? 'last' : null);?>
                        <article class="box box-small <?=$last;?>">
                      
                        <div class="thumb">
                        <a href="<?= $showgame['slug'];?>"><div class="plata font-light al-center"><?= $showgame['plataforma'];?></div>
                        
                        <img title="Baixar <?= $showgame['nome'];?>" alt="Baixar <?= $showgame['nome'];?>" src="<?= HOME.'/cp/uploads/'.$showgame['capa'];?>"/></a>
                        </div>
                        <h1 class="sectiontitle fontsize1 font-light al-center"><?= $showgame['nome'];?></h1>
                        
                        </article>
                   
               <?php
                    }
                    
                    
               ?>
                    
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
                        <img src="<?= INCLUDE_PATH;?>/img/tec_semantic.png" alt="Download de Jogos" title="Download de Jogos">
                        <h1>uTorrent</h1>
                        <p class="tagline">Faça o download do programa uTorrent. Instale-o, logo após vá até algum jogo que você queira em nosso site. E clique em "Magnetic Link".</p>
                    </article>
                     <article class="main_tec_item box box-small al-center radius">
                        <img src="<?= INCLUDE_PATH;?>/img/tec_drycss.png" alt="Download de Jogos Confiável" title="Jogos via Torrents Confiáveis">
                        <h1>Site Confiável</h1>
                        <p class="tagline">Avanço Games! É Um Site Totalmente Confiável! Pronto Para Lhe Dar Facilidade e Rapidez!</p>
                    </article>
                     <article class="main_tec_item box box-small al-center ">
                        <img src="<?= INCLUDE_PATH;?>/img/tec_midia.png" alt="Novos Torrents Sempre" title="Jogos via Torrent Diários">
                        <h1>A Todo Momento!</h1>
                        <p class="tagline">Baixe jogos via Torrent em qualquer lugar e à qualquer momento! Site disponivel para todas as plataformas. Inclusive para Celular!</p>
                    </article>
                    
                     <article class="main_tec_item box box-small al-center last">
                        <img src="<?= INCLUDE_PATH;?>/img/tec_geo.png" alt="Avanço Games com muitas Novidades" title="Jogos Torrent Avanço Games">
                        <h1>Totalmente Grátis</h1>
                        <p class="tagline">Faça Download de Jogos para Todas Plataformas via Torrent e Totalmente de Graça !</p>
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
        

        
        <!--content visual-->
