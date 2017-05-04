                <li class="menu-anchor gradradial boxshadow"></li>                
                <li><a title="Todos os Jogos Torrent" href="<?= HOME; ?>/jogos-torrent">Todas as Séries</a></li>
                <li><a title="Jogos Torrent para PC" href="<?= HOME; ?>/pc">Séries Mais Baixadas</a></li>
                <li><a title="Contato Avanço Games" target="_blank"  href="<?= HOME; ?>/contato">Contato</a></li>


                    <?php $pesquisa = mysql_query("SELECT * FROM games ORDER BY id DESC");?>
                <img class="searc"  src="<?= INCLUDE_PATH;?>img/busca.png">
                
                <div id="searching">   
                <form name="pesquisa" action="busca" method="POST">
                    <label>
                        <input type="search" list="search" class="fl-left" style="width:73%;" required name="busca" name="busca" placeholder="Pesquise um Jogo">
                        <datalist id="search">
                         <?php 
                         while($search = mysql_fetch_array($pesquisa)){ ?>                                                       ?>

                            <option label="<?= $search['plataforma'];?>" value="<?= $search['nome'];?>">
                         <?php } ?>
                        </datalist>
                        
                    </label><input type="submit" value="Pesquisar" style="margin-top:0px;" name="ok" class="btn">
                </form>
                    
                </div>
