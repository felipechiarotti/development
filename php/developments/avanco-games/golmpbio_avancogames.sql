-- phpMyAdmin SQL Dump
-- version 4.0.10.7
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 09, 2015 at 12:19 PM
-- Server version: 5.5.42-cll
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `golmpbio_avancogames`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) DEFAULT NULL,
  `about` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nick` varchar(255) DEFAULT NULL,
  `level` int(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT AUTO_INCREMENT=3 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`user_id`, `user`, `about`, `password`, `nick`, `level`, `avatar`, `cargo`) VALUES
(1, 'felipechi', 'Desenvolvedor e Administrador CEO da Avanço Games, com a intenção de ajudar pessoas que não tem o dinheiro suficiente para comprar um jogo, e procura uma forma de ter o mesmo.', '21361qpo', 'Felipe Chiarotti', 10, NULL, 'Desenvolvedor e CEO '),
(2, 'gudomingues', NULL, 'gu96180159', 'Gustavo Domingues', 1, NULL, 'Moderador');

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `content` text,
  `tags` varchar(255) DEFAULT NULL,
  `data` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`id`, `nome`, `url`, `content`, `tags`, `data`) VALUES
(3, 'PS3', 'ps3', '', 'ps3, playstation 3, console, sony', '2015-05-12 18:31:14'),
(1, 'PC', 'pc', '', 'pc, computador, download jogos para pc, download jogos pc torrent', '2015-05-12 18:31:08'),
(2, 'Xbox 360', 'xbox-360', '', 'xbox 360, download games xbox 360, download jogos torrent xbox 360', '2015-05-12 18:31:11');

-- --------------------------------------------------------

--
-- Table structure for table `episodio`
--

CREATE TABLE IF NOT EXISTS `episodio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `sinopse` varchar(255) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `linklow` varchar(255) DEFAULT NULL,
  `linkhd` varchar(255) DEFAULT NULL,
  `linkfullhd` varchar(255) DEFAULT NULL,
  `legenda` varchar(255) DEFAULT NULL,
  `tamanho` char(11) DEFAULT NULL,
  `formato` varchar(255) DEFAULT NULL,
  `temp_id` int(11) DEFAULT NULL,
  `numepi` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `episodio`
--

INSERT INTO `episodio` (`id`, `nome`, `sinopse`, `date`, `linklow`, `linkhd`, `linkfullhd`, `legenda`, `tamanho`, `formato`, `temp_id`, `numepi`) VALUES
(1, '720p Dual Audio', 'Há muito tempo, em um tempo esquecido, uma força destruiu o equilíbrio das estações. Em uma terra onde os verões podem durar vários anos e o inverno toda uma vida, as reivindicações e as forças sobrenaturais correm as portas do Reino dos Sete Reinos. A ir', '2015-06-19 06:36:18', '', 'magnet:?xt=urn:btih:e358afae9723014ec65ab9059a886149c97f7057&dn=Game+of+Thrones+Primeira+Temporada+Dual+Audio+Pt_Br+%28Dublado%29', '', '', '5.44', 'mkv', 1, NULL),
(2, 'BluRay RIP 720p Dual Áudio', '', '2015-06-19 07:30:08', '', 'magnet:?xt=urn:btih:3222958d59c10b222600e43f9ea5c6a161293658&dn=Game+Of+Thrones+-+1%C2%AA+Temporada+%282011%29+720p+Dual+%C3%81udio+-+Douglasvip', '', '', '4,50', 'mp4', 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `estatistica`
--

CREATE TABLE IF NOT EXISTS `estatistica` (
  `view_all` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `estatistica`
--

INSERT INTO `estatistica` (`view_all`) VALUES
(39543);

-- --------------------------------------------------------

--
-- Table structure for table `genero`
--

CREATE TABLE IF NOT EXISTS `genero` (
  `nome` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sinopse` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `tamanho` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;

--
-- Dumping data for table `genero`
--

INSERT INTO `genero` (`nome`, `id`, `sinopse`, `slug`, `tamanho`) VALUES
('Ação', 1, NULL, 'acao', NULL),
('Aventura', 2, NULL, 'aventura', NULL),
('Animação', 3, NULL, 'animacao', NULL),
('Anime', 4, NULL, 'anime', NULL),
('Desenho', 5, NULL, 'desenho', NULL),
('Infantil', 6, NULL, 'infantil', NULL),
('Comédia', 7, NULL, 'comedia', NULL),
('Criminal', 8, NULL, 'criminal', NULL),
('Culinária', 9, NULL, 'culinaria', NULL),
('Documentario', 10, NULL, 'documentario', NULL),
('Drama', 11, NULL, 'drama', NULL),
('Familiar', 12, NULL, 'familiar', NULL),
('Fantasia', 13, NULL, 'fantasia', NULL),
('Ficção', 14, NULL, 'ficcao', NULL),
('Super-Heróis', 15, NULL, 'super-heroi', NULL),
('História', 16, NULL, 'historia', NULL),
('Terror', 17, NULL, 'terror', NULL),
('Investigação', 18, NULL, 'investigacao', NULL),
('Romance', 19, NULL, 'romance', NULL),
('Artes Marciais', 20, NULL, 'artes-marciais', NULL),
('Médica', 21, NULL, 'medica', NULL),
('Musical', 22, NULL, 'musical', NULL),
('Nacional', 23, NULL, 'nacional', NULL),
('Policial', 24, NULL, 'policial', NULL),
('Realidade', 25, NULL, 'realidade', NULL),
('Reality Show', 26, NULL, 'reality-show', NULL),
('Ciências', 27, NULL, 'ciencias', NULL),
('Ficção Cientifica', 28, NULL, 'ficcao-cientifica', NULL),
('Esporte', 29, NULL, 'esporte', NULL),
('Sobrenatural', 30, NULL, 'sobrenatural', NULL),
('Suspense', 31, NULL, 'suspense', NULL),
('Guerra', 32, NULL, 'guerra', NULL),
('Faroeste', 33, NULL, 'faroeste', NULL),
('series', 34, NULL, 'series', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `serie`
--

CREATE TABLE IF NOT EXISTS `serie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` char(255) DEFAULT NULL,
  `sinopse` text,
  `genero` varchar(255) DEFAULT NULL,
  `imdb` char(3) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `capa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `serie`
--

INSERT INTO `serie` (`id`, `nome`, `sinopse`, `genero`, `imdb`, `slug`, `capa`) VALUES
(1, 'Game of Thrones', 'Há muito tempo, em um tempo esquecido, uma força destruiu o equilíbrio das estações. Em uma terra onde os verões podem durar vários anos e o inverno toda uma vida, as reivindicações e as forças sobrenaturais correm as portas do Reino dos Sete Reinos. A irmandade da Patrulha da Noite busca proteger o reino de cada criatura que pode vir de lá da Muralha, mas já não tem os recursos necessários para garantir a segurança de todos. Depois de um verão de dez anos, um inverno rigoroso promete chegar com um futuro mais sombrio. Enquanto isso, conspirações e rivalidades correm no jogo político pela disputa do Trono de Ferro, o símbolo do poder absoluto.', NULL, '9,5', 'game-of-thrones', '44ea0f4d26436d640ec823e41c4a1b0b.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `temporada`
--

CREATE TABLE IF NOT EXISTS `temporada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `serie` int(11) DEFAULT NULL,
  `dur_epi` int(3) DEFAULT NULL,
  `autor` int(11) DEFAULT NULL,
  `sinopse` text,
  `temporada` int(11) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `qualidade` varchar(255) DEFAULT NULL,
  `lancamento` varchar(255) DEFAULT NULL,
  `capa` varchar(255) DEFAULT NULL,
  `audio` varchar(255) DEFAULT NULL,
  `datemodify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pin` int(1) DEFAULT NULL,
  `generoum` int(2) DEFAULT NULL,
  `generodois` int(2) DEFAULT NULL,
  `pin_img` varchar(255) DEFAULT NULL,
  `view` int(11) DEFAULT NULL,
  `generotres` int(2) DEFAULT NULL,
  `servidor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `temporada`
--

INSERT INTO `temporada` (`id`, `nome`, `serie`, `dur_epi`, `autor`, `sinopse`, `temporada`, `slug`, `qualidade`, `lancamento`, `capa`, `audio`, `datemodify`, `pin`, `generoum`, `generodois`, `pin_img`, `view`, `generotres`, `servidor`) VALUES
(1, 'Game of Thrones 1º Temporada Torrent - HDTV 720p Dual Audio Dublado 2011', 1, 55, 1, 'Há muito tempo, em um tempo esquecido, uma força destruiu o equilíbrio das estações. Em uma terra onde os verões podem durar vários anos e o inverno toda uma vida, as reivindicações e as forças sobrenaturais correm as portas do Reino dos Sete Reinos. A irmandade da Patrulha da Noite busca proteger o reino de cada criatura que pode vir de lá da Muralha, mas já não tem os recursos necessários para garantir a segurança de todos. Depois de um verão de dez anos, um inverno rigoroso promete chegar com um futuro mais sombrio. Enquanto isso, conspirações e rivalidades correm no jogo político pela disputa do Trono de Ferro, o símbolo do poder absoluto.', 1, 'game-of-thrones-1º-temporada-torrent-hdtv-720p-1080p-dual-audio-dublado-2011', 'HDTV 720p Dual Audio', '2011', 'c093b8c558633fb614d03e094fab3d87.jpg', 'Dublado', '2015-06-19 06:29:33', 0, 2, 11, '', NULL, 13, NULL),
(2, 'Game of Thrones 1º Temporada Torrent - Dual Audio BluRay Rip  2011', 1, 55, 1, 'Há muito tempo, em um tempo esquecido, uma força destruiu o equilíbrio das estações. Em uma terra onde os verões podem durar vários anos e o inverno toda uma vida, as reivindicações e as forças sobrenaturais correm as portas do Reino dos Sete Reinos. A irmandade da Patrulha da Noite busca proteger o reino de cada criatura que pode vir de lá da Muralha, mas já não tem os recursos necessários para garantir a segurança de todos. Depois de um verão de dez anos, um inverno rigoroso promete chegar com um futuro mais sombrio. Enquanto isso, conspirações e rivalidades correm no jogo político pela disputa do Trono de Ferro, o símbolo do poder absoluto.', 1, 'game-of-thrones-1º-temporada-torrent-dual-audio-bluray-rip-2011', 'Dual Audio BluRay Rip', '2011', 'c093b8c558633fb614d03e094fab3d87.jpg', '', '2015-06-19 06:47:37', 0, 2, 11, '', NULL, 13, NULL),
(3, 'Game of Thrones 3º Temporada Torrent - HDTV 720p 1080p Dual Audio  2015', 1, 22, 1, 'Há muito tempo, em um tempo esquecido, uma força destruiu o equilíbrio das estações. Em uma terra onde os verões podem durar vários anos e o inverno toda uma vida, as reivindicações e as forças sobrenaturais correm as portas do Reino dos Sete Reinos. A irmandade da Patrulha da Noite busca ..', 3, 'game-of-thrones-3º-temporada-torrent-hdtv-720p-1080p-dual-audio-2015', 'HDTV 720p 1080p Dual Audio', '2015', 'c093b8c558633fb614d03e094fab3d87.jpg', '', '2015-06-20 15:41:10', 1, 2, 11, '1434834787.jpg', NULL, 14, 'Torrent'),
(4, 'Game of Thrones 1º Temporada Torrent - HDTV 720p 1080p Dual Audio  2015', 1, 15, 1, 'aa', 1, 'game-of-thrones-1º-temporada-torrent-hdtv-720p-1080p-dual-audio-2015', 'HDTV 720p 1080p Dual Audio', '2015', '6d069a8ed9d7d3a7f4dc29f4fa51b1e7.jpg', '', '2015-06-20 15:44:50', 1, 4, 11, '1434815090.jpg', NULL, 12, 'Torrent'),
(5, 'Game of Thrones 2º Temporada Torrent - 1080p Dual Audio  2015', 1, 55, 1, 'aa', 2, 'game-of-thrones-2º-temporada-torrent-1080p-dual-audio-2015', '1080p Dual Audio', '2015', 'c093b8c558633fb614d03e094fab3d87.jpg', '', '2015-06-20 21:13:08', 1, 11, 3, '1434834787.jpg', NULL, 0, 'Torrent');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
