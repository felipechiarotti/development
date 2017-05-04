<?php

define('HOME','http://www.avancogames.com.br');


define('INCLUDE_PATH', HOME .'/paginas/');
define('REQUIRE_PATH','paginas/');



$conexao = mysql_connect('localhost','golmpbio_shion','21361qpo');
$banco = mysql_select_db('golmpbio_avancogames');
mysql_set_charset('UTF8', $conexao);


$url = isset($_GET['url']) ? $_GET['url'] : 'index';
$explode = explode('/', $url);

$selectview = mysql_query("SELECT * FROM estatistica");
$visuall = mysql_fetch_array($selectview);
$viewsall = $visuall['view_all'];
$viewall = mysql_query("UPDATE estatistica SET view_all = ('$viewsall' + 1)");


$pg_name = 'Download Series Torrent Completas - Series via Torrent';
$pg_site = 'Download Series Torrent Completas - Series via Torrent';
$pg_google_author = '100522617584376444521';
$pg_google_publisher = '100522617584376444521';

$pg_fb_app = '952783774746727';
$pg_fb_author = 'felipe.chiarotti';
$pg_fb_page = 'avancogame';


$pg_twitter = '@avancogames';
$pg_domain = 'wwww.avancogames.com.br';

$pg_sitekit = INCLUDE_PATH . 'img/sitekit/';

$queryselect = mysql_query("SELECT * FROM games WHERE slug = '$explode[0]'");
$seleciona = mysql_fetch_array($queryselect);


switch($explode[0]):
    case 'index':
        $pg_title = $pg_name;
        $pg_desc = 'Faça o Download de Muitas Séries Completas via Torrent e Totalmente Grátis!';
        $pg_image = $pg_sitekit . 'index.jpg';
        $pg_url = HOME;
        break;
    case 'ps3':
        $pg_title = 'Download Series Torrent Completas - Series via Torrent';
        $pg_desc = 'Baixar Jogos em Torrent Gratis para Playstation 3, Baixar Jogos para PS3 em Torrent, Baixar Jogos Torrent Completos para PS3 ';
        $pg_image = $pg_sitekit . 'index.jpg';
        $pg_url = HOME.'/playstation-3';
        break;
    case 'xbox-360':
        $pg_title = 'Baixar Jogos Torrent para Xbox 360 Completos - Avanço Games';
        $pg_desc = 'Baixar Jogos de Xbox 360, Jogos para Xbox 360 Grátis, Baixar Jogos Xbox 360 Torrent, Baixar Jogos Completos para Xbox 360 Torrent';
        $pg_image = $pg_sitekit . 'index.jpg';
        $pg_url = HOME.'/xbox-360';
        break;
    case 'pc':
        $pg_title = 'Baixar Jogos Torrent para PC Completos e Grátis - Avanço Games';
        $pg_desc = 'Baixar Jogos para PC, Baixar Jogos para PC Grátis, Baixar Jogos Completos para PC via Torrent';
        $pg_image = $pg_sitekit . 'index.jpg';
        $pg_url = HOME.'/pc';
        break;
    case 'jogos-torrent':
        $pg_title = 'Baixar Todos os Jogos Torrent Completos e Grátis - Avanço Games';
        $pg_desc = 'Baixar Jogos via Torrent, Jogos Completos totalmente Gratis via Torrent, Baixar Grátis Jogos para PC, Baixar Grátis Jogos para XBOX 360 e PS3.';
        $pg_image = $pg_sitekit . 'index.jpg';
        $pg_url = HOME.'/jogos-torrent';
        break;
    case 'contato':
        $pg_title = 'Mais Sobre '. $pg_name;
        $pg_desc = 'Informações e Contato sobre a Avanço Games, Fale Conosco!';
        $pg_image = $pg_sitekit . 'index.jpg';
        $pg_url = HOME.'/jogos-torrent';
        break;
    case 'busca':
        $pg_title = 'Buscar' . $busca .' - Avanço Games';
        $pg_desc = 'Encontrar o jogo' . $busca .' na Avanço Games';
        $pg_image = pg_sitekit . 'index.jpg';
        $pg_url = HOME.'/busca';
        break;
    case $seleciona['slug']:
        $pg_title = 'Baixar '.$seleciona['nome'].' ('.$seleciona['lancamento'].') Torrent para '. getCat("$seleciona[category]",'nome') .' Completo - Avanço Games';
        $pg_desc = 'Baixar '.$seleciona['nome'].' ('.$seleciona['lancamento'].') para '. getCat("$seleciona[category]",'nome') .' Torrent - ' .resumo($seleciona['description'],100);
        $pg_image = HOME . '/cp/uploads/'.$seleciona['capa'];
        $pg_url = HOME .'/'.$seleciona['slug'];
        break;
    default:
        $pg_title = '404 - Oooopssss não foi possivel encontrar a página!';
        $pg_desc = 'Baixe jogos via Torrent Para Computador, Xbox 360, Playstation 3, Todos Jogos Torrent aqui na Avanço Games';
        $pg_image = $pg_sitekit . 'index.jpg';
        $pg_url = HOME.'/404';
        break;

endswitch;


//function SitempPing(){
//    $SitemapPing = array();
//    $SitemapPing['g'] = 'https://www.google.com/webmasters/tools/ping?sitemap='.HOME.'/sitemap.xml';
//    $SitemapPing['b'] = 'https://bing.com/webmaster/ping.aspx?siteMap='.HOME.'/sitemap.xml';
//    
//    foreach($SitemapPing as $sitemapUrl):
//        $ch = curl_init($sitemapUrl);
//        curl_setopt($ch, CURLOPT_HEADER, 0);
//        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
//        curl_exec($ch);
//        curl_close($ch);
//        
//        
//    endforeach;
//    
//}
//if(!file_exists('sitemap.xml.gz')):
//    $gzip = gzopen('sitemap.xml.gz', 'w9');
//    $gmap = file_get_content('sitemap.xml');
//    gzwrite($gzip, $gmap);
//    gzclose($gzip);
//    SitemapPing();
//endif;

/********************
FUNÇÃO DE RESUMO DE STRING
*********************/


function resumo($string, $words){
    $string = strip_tags($string);
    $count = strlen($string);

    if($count <= $words){
        return $string;
    }else{
        $strpos = strrpos(substr($string,0,$words),' ');
        return substr($string,0,$strpos).'...';
    }
}

function resumoall($string, $words){
    $string = strip_tags($string);
    $count = strlen($string);

    if($count <= $words){
        return $string;
    }else{
        return substr($string,0,$words).'..';
    }
}


/**************************
 *  FUNÇÃO DE CADASTRO NO BANCO
 * ***********************/

function slug($string,$plataforma,$texto){
$string = str_replace(array('(', ')', ':', "'", "-"), '', $string);
$a = 'ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜüÝÞßàáâãäåæçèéêëìíîïðñòóôõöøùúûýýþÿŔŕ"!@#$%&*()_-+={[}]/?;:.,\\\'<>';
$b = 'aaaaaaaceeeeiiiidnoooooouuuuuybsaaaaaaaceeeeiiiidnoooooouuuyybyRr                              ';
$string = utf8_decode($string);
$string = strtr($string, utf8_decode($a), $b);
$string = strip_tags(trim($string));
$string = str_replace("º","o",$string);
$string = str_replace("  ","-",$string);
$string = str_replace(" ","-",$string);
return strtolower(utf8_encode($string)).$plataforma.$texto;
}

function create($tabela, array $datas){
   $fields = implode(", ",array_keys($datas));
   $values = "'".implode("', '",array_values($datas))."'";
   $qrCreate = "INSERT INTO {$tabela} ($fields) VALUES ($values)";
   $stCreate = mysql_query($qrCreate) or die ('Erro ao cadastrar em '.$tabela.' '.mysql_error());

}

function uploadImage($tmp, $nome, $width, $height, $pasta, $compress){
    $ext = substr($nome,-3);
    
    switch($ext){
        case 'jpg': $img = imagecreatefromjpeg($tmp); break;
        case 'png': $img = imagecreatefrompng($tmp); break;
        case 'gif': $img = imagecreatefromgif($tmp); break;
    }
    
    $x = imagesx($img);
    $y = imagesy($img);
   // $height = ($width*$y) / $x;
    $nova   = imagecreatetruecolor($width, $height);
    
    imagealphablending($nome,false);
    imagesavealpha($nome,true);
    imagecopyresampled($nova, $img, 0, 0, 0, 0, $width, $height, $x, $y);
    switch($ext){
    case 'jpg': $img = imagejpeg($nova, $pasta.$nome,$compress); break;
    case 'png': $img = imagejpeg($nova, $pasta.$nome,$compress); break;
    case 'gif': $img = imagejpeg($nova, $pasta.$nome,$compress); break;
    }  
    imagedestroy($img);
    imagedestroy($nova);

}

/**************************
 *  FUNÇÃO DE LEITURA
 * ***********************/

    function read($tabela, $cond = NULL){
        
        $qrRead = "SELECT * FROM {$tabela} {$cond}";
        $stRead = mysql_query($qrRead) or die ('Erro ao ler em '.$tabela.' '.mysql_error());
        $cField = mysql_num_fields($stRead);
        
        for($y = 0; $y < $cField; $y++){
            $names[$y] = mysql_field_name($stRead, $y);
        }

        for($x = 0; $res = mysql_fetch_assoc($stRead); $x++){
            for($i = 0; $i < $cField; $i++){
                $resultado[$x][$names[$i]] = $res[$names[$i]];
            }
        }
        return $resultado;
    }

    /********************
GET CAT
*********************/
    
    function getAny($tabela, $catId, $campo = NULL){
    $categoria = mysql_real_escape_string($catId);
    $readCategoria = read($tabela,"WHERE id = '$categoria'");
    
    if($readCategoria){
       if($campo){
           foreach($readCategoria as $cat){
               return $cat[$campo];
           }
       }else{
           return $readCategoria;
       }      
    }else{
        return 'Erro ao Ler Categoria';
    }
    }

    function getSerie($serieId, $campo = NULL){
    $serie = mysql_real_escape_string($serieId);
    $readSerie = read('serie',"WHERE id = '$serie'");
    
    if($readSerie){
       if($campo){
           foreach($readSerie as $ser){
               return $ser[$campo];
           }
       }else{
           return $readSerie;
       }      
    }else{
        return 'Erro ao Ler Categoria';
    }
    }    

/********************
GET CAT
*********************/
    function getAutor($autorId, $campo = NULL){
        $autorId = mysql_real_escape_string($autorId);
        $readAutor = read('account',"WHERE user_id = '$autorId'");
        
        if($readAutor){
             foreach($readAutor as $autor):
                if($campo){
                    return $autor[$campo];
                }else{
                 return $autor;
                }
                 endforeach;
        }else{
            echo 'Erro ao Ler Autor';
        }
        
    }