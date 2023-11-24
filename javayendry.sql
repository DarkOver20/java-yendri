-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2023 a las 19:41:52
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `javayendry`
--
CREATE DATABASE IF NOT EXISTS `javayendry` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `javayendry`;

DELIMITER $$
--
-- Procedimientos
--
CREATE PROCEDURE `juego_cerrado` ()   INSERT INTO eventos (id_juegos, evento, fecha)
  VALUES (NULL, 'Programa cerrado', CURRENT_TIMESTAMP)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `id_eventos` int(11) NOT NULL,
  `id_juegos` int(11) DEFAULT NULL,
  `evento` varchar(30) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos`
--

CREATE TABLE `juegos` (
  `id_juegos` int(11) NOT NULL,
  `titulo` varchar(60) NOT NULL DEFAULT '',
  `descripcion` varchar(120) NOT NULL DEFAULT '',
  `plataforma` varchar(60) NOT NULL DEFAULT '',
  `lanzamiento` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Disparadores `juegos`
--
DELIMITER $$
CREATE TRIGGER `juego_actualizado` AFTER UPDATE ON `juegos` FOR EACH ROW INSERT INTO eventos (id_juegos, evento, fecha)
  VALUES (NEW.id_juegos, 'juego modificado', CURRENT_TIMESTAMP)
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `juego_creado` AFTER INSERT ON `juegos` FOR EACH ROW INSERT INTO eventos (id_juegos, evento, fecha)
  VALUES (NEW.id_juegos, 'Juego insertado', CURRENT_TIMESTAMP)
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id_eventos`),
  ADD KEY `eventos_id_juegos_juegos_id_juegos` (`id_juegos`);

--
-- Indices de la tabla `juegos`
--
ALTER TABLE `juegos`
  ADD PRIMARY KEY (`id_juegos`),
  ADD UNIQUE KEY `titulo` (`titulo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id_eventos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `juegos`
--
ALTER TABLE `juegos`
  MODIFY `id_juegos` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD CONSTRAINT `eventos_id_juegos_juegos_id_juegos` FOREIGN KEY (`id_juegos`) REFERENCES `juegos` (`id_juegos`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
