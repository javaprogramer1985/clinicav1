-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.50-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para SoftwareatumedidaClinica
CREATE DATABASE IF NOT EXISTS `softwareatumedidaclinica` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `SoftwareatumedidaClinica`;


-- Volcando estructura para tabla SoftwareatumedidaClinica.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `UsuarioUsr` varchar(100) NOT NULL,
  `UsuarioPass` varchar(100) NOT NULL,
  `UsuarioNombre` varchar(100) NOT NULL DEFAULT ' ',
  `UsuarioApellido` varchar(100) NOT NULL DEFAULT ' ',
  `UsuarioFecAlta` date NOT NULL,
  `UsuarioEstado` tinyint(1) NOT NULL DEFAULT '1',
  `UsuarioFecBaja` date NOT NULL,
  `UsuarioTipo` enum('A','C') NOT NULL DEFAULT 'C',
  `UsuarioDomicilio` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`UsuarioUsr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla SoftwareatumedidaClinica.usuarios: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`UsuarioUsr`, `UsuarioPass`, `UsuarioNombre`, `UsuarioApellido`, `UsuarioFecAlta`, `UsuarioEstado`, `UsuarioFecBaja`, `UsuarioTipo`, `UsuarioDomicilio`) VALUES
	('Admin', 'tsIm+toU+7g=', 'Emiliano', 'Herrera Maya', '2018-10-11', 1, '1753-01-01', 'A', 'Desarrollo Calle 7 en Col. Agrícola Pantitlán');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
