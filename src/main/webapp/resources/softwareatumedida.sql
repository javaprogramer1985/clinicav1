-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.23-0ubuntu0.16.04.1 - (Ubuntu)
-- SO del servidor:              Linux
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para softwareatumedidaclinica
CREATE DATABASE IF NOT EXISTS `softwareatumedidaclinica` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `softwareatumedidaclinica`;

-- Volcando estructura para tabla softwareatumedidaclinica.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `MenuCodigo` tinyint(4) NOT NULL,
  `MenuNombre` varchar(50) NOT NULL,
  `MenuTipo` enum('S','I') NOT NULL,
  `MenuTipoUsuario` enum('1','2') NOT NULL,
  `MenuCodigoSubmenu` tinyint(4) DEFAULT NULL,
  `MenuEstado` bit(1) DEFAULT NULL,
  `MenuUrl` varchar(150) DEFAULT NULL,
  `MenuIcon` varchar(50) DEFAULT NULL,
  `MenuSeleccionado` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`MenuCodigo`),
  KEY `FKCodigoSubMenu` (`MenuCodigoSubmenu`),
  CONSTRAINT `FKCodigoSubMenu` FOREIGN KEY (`MenuCodigoSubmenu`) REFERENCES `menu` (`MenuCodigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla softwareatumedidaclinica.menu: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`MenuCodigo`, `MenuNombre`, `MenuTipo`, `MenuTipoUsuario`, `MenuCodigoSubmenu`, `MenuEstado`, `MenuUrl`, `MenuIcon`, `MenuSeleccionado`) VALUES
	(1, 'Principal', 'I', '1', NULL, b'1', 'home.softwareatumedida', 'fas fa-home', 'mdl-navigation__link--current'),
	(2, 'Medico', 'I', '1', NULL, b'1', 'medico.softwareatumedida', 'fas fa-user-md', ' '),
	(3, 'Agendar cita', 'I', '1', NULL, b'1', 'cita.softwareatumedida', 'fas fa-calendar-alt', ' '),
	(4, 'Crear expediente', 'I', '1', NULL, NULL, 'expediente.softwareatumedida', 'fas fa-folder-minus', ' ');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Volcando estructura para tabla softwareatumedidaclinica.usuarios
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

-- Volcando datos para la tabla softwareatumedidaclinica.usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`UsuarioUsr`, `UsuarioPass`, `UsuarioNombre`, `UsuarioApellido`, `UsuarioFecAlta`, `UsuarioEstado`, `UsuarioFecBaja`, `UsuarioTipo`, `UsuarioDomicilio`) VALUES
	('Admin', 'tsIm+toU+7g=', 'Hilario Martín', 'Herrera Maya', '2018-10-11', 1, '1753-01-01', 'A', 'Desarrollo Calle 7 en Col. Agrícola Pantitlán');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
