  <!--Bloco de Video-->
        <article class="container ">
            <div class="content">
                <header class="sectiontitle">
                    
                    <h1 >Saiba Mais Sobre a Avanço Games Torrent!</h1>
                    <p class="tagline">Fique por dentro -<mark> Felipe Chiarotti</mark></p>

                </header>  

                <div class="clear">
                    
                </div>
            </div>  
                      
                         
                <article class="bg-orangelight" itemscope itemtype="https://schema.org/Person">
                <div class="content ">
                    <img itemprop="image" class="round fl-left boxhshadow" style="width:16%;" src="<?= HOME; ?>/paginas/img/felipe-chiarotti.jpg" alt="Felipe Chiarotti Giron">
                    <div class="fl-right" style="width:80%;">
                    <header class="articletitle">
                        <h1 itemprop="name">Felipe Chiarotti</h1>
                        <p class="tagline" itemprop="jobTitle">SEO e Programador</p>
                    </header>
                        
                        <div>
                            <p>Felipe Chiarotti possui 17 anos, sempre em busca de conhecimento e aprimoramento</p>
                            <p>Em 2015 deu início à seu projeto "Avanço Games", o qual pretende trazer jogos em Torrent para todos!</p>
                            <p itemprop="description">Apaixonado por PHP, visa sempre melhorar a comunidade <span itemprop="affiliation">Avanço Games</span>.</p>
                            <ul class="main_bus_person ">
                                <li><a itemprop="url" class="boxshadow" target="_blank" href="https://www.facebook.com/felipe.chiarotti" title="Felipe Chiarotti">Facebook</a></li>
                                <li><a itemprop="url" class="boxshadow" target="_blank" href="https://plus.google.com/u/0/100522617584376444521/posts" title="Felipe Chiarotti">Google Plus</a></li>
                                <li><a itemprop="email" class="boxshadow" target="_blank" href="mailto:Felipe Chiarotti <suporte@avancogames.com.br>" title="Felipe Chiarotti" >E-mail</a></li>
                            </ul>
                        </div>
                    </div>
                                            <div class="clear"></div>
                </div>
            </article>
            
            
      <article class="bg-gray" itemscope itemtype="https://schema.org/Organization" style="margin-top:50px;">
                <div class="content ">
                    <img itemprop="image" class="fl-left boxhshadow" style="width:16%;" src="<?= HOME; ?>/paginas/img/about.png" alt="Avanço Games">
                    <div class="fl-right" style="width:80%;">
                    <header class="articletitle">
                        <h1 itemprop="name" >Avanço Games</h1>
                        <p class="tagline textshadow">Jogos Torrent</p>
                    </header>
                        
                        <div>
                            <p itemprop="description">Avanço Games foi fundada em Março de 2015, disponibilizando Download de Jogos via Torrent.</p>
                            <p>Sempre atendendo aos visitantes e adicionando jogos diariamente.</p>
                            
                            <article class="box box-medium">
                                <h1 class="title ">Contato:</h1>
                                <ul class="main_bus_organization">
                                    <li><b>Por E-mail:</b> <span itemprop="email">suporte@avancogames.com.br</span></li>
                                    <li><b>Por Facebook:</b> <a itemprop="url" href="https://www.facebook.com/avancogame" title="Avanço Games no Facebook">Avanço Games no Facebook</a></li>
                                    <li><b>Site Oficial:</b> <a itemprop="sameAs" href="http://www.avancogames.com.br" title="Avanço Games">Avanço Games</a></li>
                                </ul>
                            </article>
                        </div>
                    </div>
                                            <div class="clear"></div>
                </div>
            </article>
            
            <section class="container">
                <div class="content">
                    <header class="sectiontitle">
                        <h1>Fale Conosco</h1>
                        <p clas="tagline">Tire suas Dúvidas !</p>
                    </header>
                    <form action="" method="post">
                        
                        <label>
                            <input type="text" required title="Favor Informe Seu Nome!" name="nome" placeholder="Informe seu Nome!">
                        </label>
                        
                        <label>
                            <input type="email"  required title="Informe Seu E-Mail" name="email" placeholder="Informe seu E-mail!">
                        </label>
                        
                        <label>
                            <textarea  name="mensagem" required title="Favor Descreva uma Mensagem" placeholder="Deixe sua Mensagem Aqui !" rows="8"></textarea>
                        </label>
                        <input type="submit" name="send" class="btn btn-blue radius " value="Enviar"/>
                        <input type="reset"   class="btn btn-red radius" value="Limpar"/>
                    </form>
                    
                    <?php
                    $nome     = $_POST['nome'];
                    $email    = $_POST['email'];
                    $mensagem = $_POST['mensagem'];
                    $corpo  = "Nome: ".$nome."<BR>\n";
                    $corpo .= "Email: ".$email."<BR>\n";
                    $corpo .= "Mensagem: ".$mensagem."<BR>\n";
                    if(isset($_POST['send'])){
                    if(mail("suporte@avancogames.com.br","Contato Site",$corpo)){
                      echo '<span class="trigger al-center trigger-bottom trigger-accept">Obrigado por nos contatar</span>';
                    } else {
                      echo '<span class="trigger al-center trigger-bottom trigger-accept">Preencha Todos os Campos!</span>';
                    }}
                    ?>
                    
                    
                    
                    <div class="clear"></div>
                </div>
            </section>
            <div class="content" style="margin-top:20px; width:80%;"><div class="fb-like-box" data-href="https://www.facebook.com/avancogame"  data-height="290"data-colorscheme="light" data-show-faces="true" data-header="false" data-stream="false" data-show-border="false"></div></div>   

            <footer class="bg-blue ">
                <section class="content main_games " style="padding-bottom:10px;">
                    <h1 >Confira os nossos Jogos!</h1>
                    
                    <?php 
                    $in = 0;
                    $selecta = mysql_query("SELECT * FROM games ORDER BY id DESC LIMIT 12");
                    while($rel = mysql_fetch_array($selecta)){
                    $in++;
                    $last = ($in%4==0 ? 'last' : null);?>
                        <article class="box box-small <?=$last;?>">
                      
                        <div class="thumb">
                        <a href="<?= $rel['slug'];?>"><div class="plata font-light al-center"><?= $rel['plataforma'];?></div>
                        
                        <img title="Baixar <?= $rel['nome'];?>" alt="Baixar <?= $rel['nome'];?>" src="<?= HOME.'/cp/uploads/'.$rel['capa'];?>"/></a>
                        </div>
                        <h1 class="sectiontitle fontsize1 font-light al-center"><?= $rel['nome'];?></h1>
                        <p class="fontsize1 font-light"><?= resumoAll($rel['description'],150);?></p>
                        
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
            

        </section>
        
        <article class="container bg-red">
            <div class="content content-page al-center">
                <header class="sectiontitle">
                    
                    <h1>
                       Faça Parte Da Turma Avanço Games
                    </h1>
                     <p class="tagline">Comece Agora Mesmo. Precisamos de sua Ajuda, <mark >Games Torrent</mark>, <mark>Download Jogos Torrent</mark> e <mark>Computador</mark>, <mark>Playstation</mark> e <mark>Xbox 360</mark></p>
                    
                </header>
                
            
                <footer>
                    <div class="main_chamada al-center">
                        Você baixa onde e quando quiser, os melhores torrents, os melhores jogos, a melhor diversão !
                    </div>
                </footer>
                <div class="clear"</div>
            </div>
        </article>
        
        <!--content visual-->
