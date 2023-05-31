-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2023 at 09:52 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `movie_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `judul` varchar(30) NOT NULL,
  `alur` double NOT NULL,
  `penokohan` double NOT NULL,
  `akting` double NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`judul`, `alur`, `penokohan`, `akting`, `nilai`) VALUES
('123', 123, 123, 12, 0),
('Avatar', 4, 3.7, 4.7, 4.13),
('Hello World', 3, 3, 3, 3),
('Hello World 2', 5, 3, 3, 3.6666666666666665),
('Narut', 5, 4, 4, 4.333333333333333),
('Narutoo', 5, 4, 4, 4.333333333333333),
('Narutort', 4, 4, 4, 4),
('Spiderman', 5, 5, 5, 5),
('Spiderman 2', 4.3, 4.5, 5, 4.6),
('Spongebob', 4, 5, 4, 4.33),
('The Walking Dead', 3.5, 4, 4.5, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD UNIQUE KEY `judul` (`judul`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
