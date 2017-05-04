        <article class="container">
            <div class="content">
                <header class="sectiontitle">
                    
                    <h1 >404</h1>
                    <p class="tagline">Desculpe, a Página <mark>NÃO EXISTE</mark>.</p>

                   <div class="fb-like-box" data-href="https://www.facebook.com/avancogame"  data-height="290" data-colorscheme="light" data-show-faces="true" data-header="false" data-stream="false" data-show-border="false"></div>

                </header>  
<script type="text/javascript" src="http://www.adcash.com/ad/display.php?r=432808"></script>
                            <div class="clear"></div>
                </div>



        
        <article class="bg-light">
            <div class="content">
              <header class="articletitle">
                  <h1>Deixe uma sugestão de conteúdo:</h1>
                  <p class="tagline">Deseja algum jogo? Informe-nos!</p>
              </header>   
                
                <form name="sendcontent" action="obrigado" method="post">
                  <input class="box box-medium" type="text" title="Informe um Jogo" name="nome" placeholder="Informe um Jogo!"/> 
                  <input class="box box-medium" type="text" title="Informe uma Plataforma" name="plataforma" placeholder="Informe uma Plataforma!"/>  
                  <a href="#" class="btn btn-green radius box box-medium last al-center">Deixe sua Sugestão!</a>
                </form>
                <div class="clear"></div>
            </div>
        </article>


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
                            <?php
                            if(isset($explode[1]) != ''){ ?>
                        <a href="<?= $rel['slug'];?>"><div class="plata font-light al-center"><?= $rel['plataforma'];?></div>
                            <?php }else{ ?>
                            
                            <a href="<?= $rel['slug'];?>"><div class="plata font-light al-center"><?= $rel['plataforma'];?></div>
                            <?php } ?> 
                        <img title="Baixar <?= $rel['nome'];?>" alt="Baixar <?= $rel['nome'];?>" src="<?= $rel['capa'];?>"/></a>
                        </div>
                        <h1 class="sectiontitle fontsize1 font-light al-center"><?= $rel['nome'];?></h1>
                        
                        </article>
                    
               <?php
                    }   
               ?>
                    <div class="clear"></div>
                </section>
            </footer>
        </article>