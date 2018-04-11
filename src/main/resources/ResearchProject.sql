-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 11, 2018 at 11:34 AM
-- Server version: 5.7.21-0ubuntu0.16.04.1
-- PHP Version: 7.0.28-0ubuntu0.16.04.1

DROP DATABASE IF EXISTS `ResearchProject`;
CREATE DATABASE `ResearchProject` DEFAULT charset =utf8;
USE `ResearchProject`;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ResearchProject`
--

-- --------------------------------------------------------

--
-- Table structure for table `aree`
--

DROP TABLE IF EXISTS `aree`;
CREATE TABLE `aree` (
  `id` int(11) NOT NULL,
  `nome` varchar(250) NOT NULL,
  `id_ricercatore` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `progetti`
--

DROP TABLE IF EXISTS `progetti`;
CREATE TABLE `progetti` (
  `codice` int(11) NOT NULL,
  `data_inizio` date NOT NULL,
  `data_fine` date DEFAULT NULL,
  `budget` double NOT NULL,
  `id_team` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ricercatori`
--

DROP TABLE IF EXISTS `ricercatori`;
CREATE TABLE `ricercatori` (
  `id` int(11) NOT NULL,
  `nome` varchar(250) NOT NULL,
  `cognome` varchar(250) NOT NULL,
  `stipendio_base` double NOT NULL,
  `bonus` double NOT NULL,
  `ruolo` char(1) NOT NULL,
  `id_progetto` int(11) NOT NULL,
  `id_team` int(11) NOT NULL,
  `id_area` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `id_teamleader` int(11) NOT NULL,
  `id_area` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aree`
--
ALTER TABLE `aree`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ricercatore` (`id_ricercatore`);

--
-- Indexes for table `progetti`
--
ALTER TABLE `progetti`
  ADD PRIMARY KEY (`codice`),
  ADD KEY `id_team` (`id_team`);

--
-- Indexes for table `ricercatori`
--
ALTER TABLE `ricercatori`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_progetto` (`id_progetto`),
  ADD KEY `id_team` (`id_team`),
  ADD KEY `id_area` (`id_area`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_teamleader` (`id_teamleader`),
  ADD KEY `id_area` (`id_area`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aree`
--
ALTER TABLE `aree`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `progetti`
--
ALTER TABLE `progetti`
  MODIFY `codice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ricercatori`
--
ALTER TABLE `ricercatori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aree`
--
ALTER TABLE `aree`
  ADD CONSTRAINT `aree_ibfk_1` FOREIGN KEY (`id_ricercatore`) REFERENCES `ricercatori` (`id`);

--
-- Constraints for table `progetti`
--
ALTER TABLE `progetti`
  ADD CONSTRAINT `progetti_ibfk_1` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`);

--
-- Constraints for table `ricercatori`
--
ALTER TABLE `ricercatori`
  ADD CONSTRAINT `ricercatori_ibfk_1` FOREIGN KEY (`id_progetto`) REFERENCES `progetti` (`codice`),
  ADD CONSTRAINT `ricercatori_ibfk_2` FOREIGN KEY (`id_team`) REFERENCES `team` (`id`),
  ADD CONSTRAINT `ricercatori_ibfk_3` FOREIGN KEY (`id_area`) REFERENCES `aree` (`id`);

--
-- Constraints for table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `team_ibfk_1` FOREIGN KEY (`id_teamleader`) REFERENCES `ricercatori` (`id`),
  ADD CONSTRAINT `team_ibfk_2` FOREIGN KEY (`id_area`) REFERENCES `aree` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
