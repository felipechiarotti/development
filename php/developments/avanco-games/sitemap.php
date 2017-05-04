<?php
header("Content-Type: application/xml; charset=UTF-8");
echo '<?xml version="1.0" encoding="UTF-8"?>';

$hoje = date('Y-m-d');
?>

<urlset
xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9
http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd">
<url>
<loc>http://www.avancogames.com.br/</loc>
  <lastmod><?php echo $hoje;?></lastmod>
  <priority>1.00</priority>
  <changefreq>daily</changefreq>
</url>
<url>
  <loc>http://avancogames.com.br/jogos-torrent</loc>
  <lastmod><?php echo $hoje;?></lastmod>
  <priority>0.80</priority>
  <changefreq>daily</changefreq>
</url>
<url>
  <loc>http://www.avancogames.com.br/pc</loc>
  <lastmod><?php echo $hoje;?></lastmod>
  <priority>0.80</priority>
  <changefreq>daily</changefreq>
</url>
<url>
  <loc>http://www.avancogames.com.br/xbox-360</loc>
  <lastmod><?php echo $hoje;?></lastmod>
  <priority>0.80</priority>
  <changefreq>daily</changefreq>
</url>
<url>
  <loc>http://www.avancogames.com.br/ps3</loc>
  <lastmod><?php echo $hoje;?></lastmod>
  <priority>0.80</priority>
  <changefreq>daily</changefreq>
</url>
<url>
  <loc>http://www.avancogames.com.br/contato</loc>
  <lastmod><?php echo $hoje;?></lastmod>
  <priority>0.80</priority>
  <changefreq>daily</changefreq>
</url>
	<?php
	

include '_app/Config.inc.php';

$sql_tabela = mysql_query("SELECT * FROM games ORDER BY id DESC");

	while($tabela = mysql_fetch_assoc($sql_tabela)){
echo "<url>
		<loc>http://www.avancogames.com.br/".$tabela['slug']."</loc>
		<lastmod>".$hoje."</lastmod>
		<changefreq>daily</changefreq>
		<priority>1.00</priority>
	</url>";
}
	?>
</urlset>
