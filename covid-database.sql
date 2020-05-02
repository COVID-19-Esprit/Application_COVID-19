-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 27 avr. 2020 à 20:20
-- Version du serveur :  5.7.19
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `covid-database`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `login` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`login`, `password`) VALUES
('esprit', 'covid19');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `code` int(4) NOT NULL AUTO_INCREMENT,
  `commande` varchar(150) NOT NULL,
  `prix` int(20) NOT NULL,
  `status` varchar(25) CHARACTER SET utf8 NOT NULL DEFAULT 'en attente',
  PRIMARY KEY (`code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `information`
--

DROP TABLE IF EXISTS `information`;
CREATE TABLE IF NOT EXISTS `information` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `titre` varchar(50) NOT NULL,
  `content` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `malade`
--

DROP TABLE IF EXISTS `malade`;
CREATE TABLE IF NOT EXISTS `malade` (
  `code` varchar(8) NOT NULL,
  `cin` int(8) NOT NULL,
  `nomMalade` varchar(15) CHARACTER SET utf8 NOT NULL,
  `prenomMalade` varchar(15) CHARACTER SET utf8 NOT NULL,
  `adresseMalade` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ageMalade` int(2) NOT NULL,
  `telephoneMalade` int(8) NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `identification` (`cin`),
  UNIQUE KEY `telephone` (`telephoneMalade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `cin` int(8) NOT NULL,
  `nomMembre` varchar(15) CHARACTER SET utf8 NOT NULL,
  `prenomMembre` varchar(15) CHARACTER SET utf8 NOT NULL,
  `adresseMembre` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ageMembre` int(2) NOT NULL,
  `passwordMembre` varchar(20) CHARACTER SET utf8 NOT NULL,
  `telephoneMembre` int(8) NOT NULL,
  PRIMARY KEY (`cin`),
  UNIQUE KEY `telephone` (`telephoneMembre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `posts`
--

DROP TABLE IF EXISTS `posts`;
CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `titre` varchar(255) CHARACTER SET utf8 NOT NULL,
  `content` varchar(1000) CHARACTER SET utf8 NOT NULL,
  `date-creation` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

DROP TABLE IF EXISTS `question`;
CREATE TABLE IF NOT EXISTS `question` (
  `content-question` varchar(500) CHARACTER SET utf8 NOT NULL,
  `note-question` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
CREATE TABLE IF NOT EXISTS `quiz` (
  `temp` int(2) NOT NULL,
  `toux` varchar(50) CHARACTER SET utf8 NOT NULL,
  `respiration` varchar(50) CHARACTER SET utf8 NOT NULL,
  `douleur` varchar(50) CHARACTER SET utf8 NOT NULL,
  `symptomes` varchar(50) CHARACTER SET utf8 NOT NULL,
  `perte-de-ordorat` varchar(50) CHARACTER SET utf8 NOT NULL,
  `perte-de-apetit` varchar(50) CHARACTER SET utf8 NOT NULL,
  `diarrhee` varchar(50) CHARACTER SET utf8 NOT NULL,
  `maux-de-tete` varchar(50) CHARACTER SET utf8 NOT NULL,
  `id` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `suivi-malade`
--

DROP TABLE IF EXISTS `suivi-malade`;
CREATE TABLE IF NOT EXISTS `suivi-malade` (
  `etat` varchar(50) CHARACTER SET utf8 NOT NULL,
  `temp` int(2) NOT NULL,
  `toux` varchar(50) CHARACTER SET utf8 NOT NULL,
  `respiration` varchar(50) CHARACTER SET utf8 NOT NULL,
  `douleur` varchar(50) CHARACTER SET utf8 NOT NULL,
  `symptomes` varchar(50) CHARACTER SET utf8 NOT NULL,
  `perte-de-odorat` varchar(50) CHARACTER SET utf8 NOT NULL,
  `perte-de-apetit` varchar(50) CHARACTER SET utf8 NOT NULL,
  `diarrhee` varchar(50) CHARACTER SET utf8 NOT NULL,
  `maux-de-tete` varchar(50) CHARACTER SET utf8 NOT NULL,
  `code` varchar(8) NOT NULL,
  KEY `code-fk` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `volentaire`
--

DROP TABLE IF EXISTS `volentaire`;
CREATE TABLE IF NOT EXISTS `volentaire` (
  `cin` int(8) NOT NULL,
  `nomVolentaire` varchar(15) CHARACTER SET utf8 NOT NULL,
  `prenomVolentaire` varchar(15) CHARACTER SET utf8 NOT NULL,
  `adresseVolentaire` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ageVolentaire` int(2) NOT NULL,
  `telephoneVolentaire` int(8) NOT NULL,
  `organisation` varchar(50) NOT NULL,
  PRIMARY KEY (`cin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `suivi-malade`
--
ALTER TABLE `suivi-malade`
  ADD CONSTRAINT `code-fk` FOREIGN KEY (`code`) REFERENCES `malade` (`code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
