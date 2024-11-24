-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2024 a las 18:33:43
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `goblinmarket`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game`
--

CREATE TABLE `game` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `img` varchar(200) NOT NULL,
  `studio` varchar(100) NOT NULL,
  `genre` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `game`
--

INSERT INTO `game` (`id`, `name`, `description`, `price`, `img`, `studio`, `genre`) VALUES
(1, 'Outer Wilds', 'Named Game of the Year 2019 by Giant Bomb, Polygon, Eurogamer, and The Guardian, Outer Wilds is a critically-acclaimed and award-winning open world mystery about a solar system trapped in an endless time loop.', 22.99, 'NOIMG', 'Mobius Digital', 1),
(2, 'Disco Elysium', 'Disco Elysium - The Final Cut is a groundbreaking role playing game. You’re a detective with a unique skill system at your disposal and a whole city to carve your path across. Interrogate unforgettable characters, crack murders or take bribes. Become a hero or an absolute disaster of a human being.', 39.99, 'NOIMG', 'ZA/UM', 2),
(3, 'GRIS', 'Gris is a hopeful young girl lost in her own world, dealing with a painful experience in her life. Her journey through sorrow is manifested in her dress, which grants new abilities to better navigate her faded reality.', 14.79, 'NOIMG', 'Nomada Studio', 1),
(4, 'Super Smash Bros. Ultimate', 'Super Smash Bros. Ultimate, it allows eight players to face off in action-packed combats in which the goal is to catapult popular video game characters off the screen. Ultimate will include each and every player who has been present in the series\' nearly two decades of history.', 58.99, 'NOIMG', 'Nintendo', 6),
(5, 'Celeste', 'Help Madeline survive her inner demons on her journey to the top of Celeste Mountain, in this super-tight platformer from the creators of TowerFall. Brave hundreds of hand-crafted challenges, uncover devious secrets, and piece together the mystery of the mountain.', 19.50, 'NOIMG', 'Maddy Makes Games Inc.', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genre`
--

CREATE TABLE `genre` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `genre`
--

INSERT INTO `genre` (`id`, `name`) VALUES
(1, 'Puzzles'),
(2, 'RPG'),
(3, 'Adventure'),
(4, 'Action'),
(5, 'Metroidvanoia'),
(6, 'Fighting'),
(7, 'Platformer');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tournament`
--

CREATE TABLE `tournament` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `date` date NOT NULL,
  `hour` time NOT NULL,
  `img` varchar(200) NOT NULL,
  `game` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tournament`
--

INSERT INTO `tournament` (`id`, `name`, `description`, `date`, `hour`, `img`, `game`) VALUES
(1, 'Goblin Market\'s Monthly Smash', 'Our monthly tournament of Smash only for our customers. Sixteen entrees available.', '2024-11-29', '18:30:00', 'NOIMG', 4),
(2, 'The Fastest Climber', 'Speed running tournament for the game Celeste. Proove that you are the fastest and win aour prize.', '2025-11-20', '19:00:00', 'NOIMG', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(10) UNSIGNED NOT NULL,
  `username` varchar(150) NOT NULL,
  `email` varchar(180) NOT NULL,
  `pass` varchar(150) NOT NULL,
  `img` varchar(2000) NOT NULL,
  `birthdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `pass`, `img`, `birthdate`) VALUES
(1, 'Beesu', 'alvaro@gmail.com', 'alvaro1234', 'NOIMG', '2000-10-23'),
(2, 'idksxsngster', 'marina@gmail.com', 'marina1234', 'NOIMG', '2000-04-13'),
(3, 'Fresh Tomacco', 'guille@gmail.com', 'guille1234', 'NOIMG', '2000-07-16'),
(4, 'Capitan Cabreo', 'yago@gmail.com', 'yago1234', 'NOIMG', '2000-12-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_games`
--

CREATE TABLE `user_games` (
  `user` int(10) UNSIGNED NOT NULL,
  `game` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user_games`
--

INSERT INTO `user_games` (`user`, `game`) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3),
(3, 1),
(3, 5),
(4, 3),
(4, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_in_tournament`
--

CREATE TABLE `user_in_tournament` (
  `user` int(10) UNSIGNED NOT NULL,
  `tournament` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user_in_tournament`
--

INSERT INTO `user_in_tournament` (`user`, `tournament`) VALUES
(1, 1),
(2, 2),
(3, 1),
(3, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_genre` (`genre`);

--
-- Indices de la tabla `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tournament`
--
ALTER TABLE `tournament`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_game` (`game`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `user_games`
--
ALTER TABLE `user_games`
  ADD PRIMARY KEY (`user`,`game`),
  ADD KEY `game` (`game`);

--
-- Indices de la tabla `user_in_tournament`
--
ALTER TABLE `user_in_tournament`
  ADD PRIMARY KEY (`user`,`tournament`),
  ADD KEY `tournament` (`tournament`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `game`
--
ALTER TABLE `game`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `genre`
--
ALTER TABLE `genre`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tournament`
--
ALTER TABLE `tournament`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `fk_genre` FOREIGN KEY (`genre`) REFERENCES `genre` (`id`);

--
-- Filtros para la tabla `tournament`
--
ALTER TABLE `tournament`
  ADD CONSTRAINT `fk_game` FOREIGN KEY (`game`) REFERENCES `game` (`id`);

--
-- Filtros para la tabla `user_games`
--
ALTER TABLE `user_games`
  ADD CONSTRAINT `user_games_2` FOREIGN KEY (`game`) REFERENCES `game` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_games_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `user_in_tournament`
--
ALTER TABLE `user_in_tournament`
  ADD CONSTRAINT `user_in_tournament_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_in_tournament_ibfk_2` FOREIGN KEY (`tournament`) REFERENCES `tournament` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
