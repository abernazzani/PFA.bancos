-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-11-2016 a las 21:28:01
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pfa.bancos`
--
CREATE DATABASE IF NOT EXISTS `pfa.bancos` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pfa.bancos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asalto`
--

CREATE TABLE `asalto` (
  `ID` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `CodigoSucursal` varchar(50) NOT NULL,
  `CodigoJuez` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asalto`
--

INSERT INTO `asalto` (`ID`, `Fecha`, `CodigoSucursal`, `CodigoJuez`) VALUES
(1, '2016-02-02', 'BGLA_1', 'JAlvarez'),
(2, '2016-04-05', 'BNA_1', 'Pedro Pablo Salomon'),
(3, '2016-02-02', 'BNA_1', 'JMaria'),
(4, '2016-02-02', 'BNA_1', 'JMaria'),
(5, '2016-02-02', 'BGLA_1', 'JMaria'),
(6, '2015-05-06', 'BGLA_1', 'JAlvarez'),
(7, '2015-05-06', 'BGLA_1', 'JAlvarez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banda`
--

CREATE TABLE `banda` (
  `CodigoBanda` varchar(50) NOT NULL,
  `NroDeMiembros` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `banda`
--

INSERT INTO `banda` (`CodigoBanda`, `NroDeMiembros`) VALUES
('Banda PPT', 49);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `condena`
--

CREATE TABLE `condena` (
  `CodigoDelincuente` varchar(50) NOT NULL,
  `CodigoAsalto` int(11) NOT NULL,
  `FechaDeInicio` date NOT NULL,
  `FechaFin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratacion`
--

CREATE TABLE `contratacion` (
  `CodigoSucursal` varchar(50) NOT NULL,
  `CodigoVigilante` varchar(50) NOT NULL,
  `Fecha` date NOT NULL,
  `Armas` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `contratacion`
--

INSERT INTO `contratacion` (`CodigoSucursal`, `CodigoVigilante`, `Fecha`, `Armas`) VALUES
('BGLA_1', 'E2348', '2016-05-05', 0),
('BGLA_1', 'V_003', '2016-10-10', 1),
('BGLA_1', 'V_003', '2016-12-08', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delincuente`
--

CREATE TABLE `delincuente` (
  `Codigo` varchar(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Detenido` tinyint(1) NOT NULL,
  `CodigoBanda` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `delincuente`
--

INSERT INTO `delincuente` (`Codigo`, `Nombre`, `Detenido`, `CodigoBanda`) VALUES
('E2341', 'Ernesto Sabatooo', 1, 'Banda PPT'),
('RPerez', 'Rodrigo Perez', 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delincuentesporasalto`
--

CREATE TABLE `delincuentesporasalto` (
  `CodigoDelincuente` varchar(50) NOT NULL,
  `AsaltoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `delincuentesporasalto`
--

INSERT INTO `delincuentesporasalto` (`CodigoDelincuente`, `AsaltoID`) VALUES
('E2341', 1),
('E2341', 3),
('E2341', 6),
('E2341', 7),
('RPerez', 1),
('RPerez', 6),
('RPerez', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entidadbancaria`
--

CREATE TABLE `entidadbancaria` (
  `Codigo` varchar(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Domicilio` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `entidadbancaria`
--

INSERT INTO `entidadbancaria` (`Codigo`, `Nombre`, `Domicilio`) VALUES
('BGLA', 'Banco Galicia', 'Av. Coronel Díaz 5878'),
('BNA', 'Banco de la Nación Argentina', 'Av. Rivadavia 2454');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juez`
--

CREATE TABLE `juez` (
  `Nombre` varchar(50) NOT NULL,
  `Codigo` varchar(50) NOT NULL,
  `FechaDeIngreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `juez`
--

INSERT INTO `juez` (`Nombre`, `Codigo`, `FechaDeIngreso`) VALUES
('Juan Alvarez', 'JAlvarez', '2016-01-01'),
('Juan María', 'JMaria', '2016-12-26'),
('PER-01', 'Pedro', '2016-04-05'),
('PPS', 'Pedro Pablo Salomon', '2016-12-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`ID`, `Nombre`) VALUES
(1, 'Administrador'),
(2, 'Vigilante'),
(3, 'Inspector');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `Codigo` varchar(50) NOT NULL,
  `Domicilio` varchar(50) NOT NULL,
  `NroEmpleados` int(11) NOT NULL,
  `CodigoEntidad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`Codigo`, `Domicilio`, `NroEmpleados`, `CodigoEntidad`) VALUES
('BGLA_1', 'Av. Coronel Díaz 1548', 54, 'BGLA'),
('BNA_1', 'Av. Rivadavia 5148', 15, 'BNA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Nombre` varchar(50) NOT NULL,
  `Contraseña` varchar(50) NOT NULL,
  `ID` int(11) NOT NULL,
  `RolID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Nombre`, `Contraseña`, `ID`, `RolID`) VALUES
('Admin', 'Admin', 1, 1),
('a', 'a', 2, 1),
('usuariovigilante', '123456', 3, 3),
('vigilante', 'vigilante', 4, 3),
('userv2', 'userv2', 5, 3),
('vigi3', 'vigi3', 6, 3),
('inv', 'inv', 7, 1),
('inv2', 'inv2', 8, 2),
('admin1', 'admin1', 9, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vigilante`
--

CREATE TABLE `vigilante` (
  `Codigo` varchar(50) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Usuario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vigilante`
--

INSERT INTO `vigilante` (`Codigo`, `Edad`, `Nombre`, `Usuario`) VALUES
('E2348', 25, 'Brian Fernandez', ''),
('V_001', 25, 'Viilante uno', 'usuariovigilante'),
('V_002', 25, 'V2', 'userv2'),
('V_003', 23, 'V3', 'vigi3');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asalto`
--
ALTER TABLE `asalto`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `CodigoSucursal` (`CodigoSucursal`),
  ADD KEY `CodigoJuez` (`CodigoJuez`);

--
-- Indices de la tabla `banda`
--
ALTER TABLE `banda`
  ADD PRIMARY KEY (`CodigoBanda`);

--
-- Indices de la tabla `condena`
--
ALTER TABLE `condena`
  ADD PRIMARY KEY (`CodigoDelincuente`,`CodigoAsalto`),
  ADD KEY `asalto_condena` (`CodigoAsalto`);

--
-- Indices de la tabla `contratacion`
--
ALTER TABLE `contratacion`
  ADD PRIMARY KEY (`CodigoSucursal`,`CodigoVigilante`,`Fecha`),
  ADD KEY `vigilante_contratacion` (`CodigoVigilante`);

--
-- Indices de la tabla `delincuente`
--
ALTER TABLE `delincuente`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `CodigoBanda` (`CodigoBanda`);

--
-- Indices de la tabla `delincuentesporasalto`
--
ALTER TABLE `delincuentesporasalto`
  ADD PRIMARY KEY (`CodigoDelincuente`,`AsaltoID`),
  ADD KEY `asalto_delincuentesporasalto` (`AsaltoID`);

--
-- Indices de la tabla `entidadbancaria`
--
ALTER TABLE `entidadbancaria`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `juez`
--
ALTER TABLE `juez`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `CodigoEntidad` (`CodigoEntidad`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `RolID` (`RolID`);

--
-- Indices de la tabla `vigilante`
--
ALTER TABLE `vigilante`
  ADD PRIMARY KEY (`Codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asalto`
--
ALTER TABLE `asalto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asalto`
--
ALTER TABLE `asalto`
  ADD CONSTRAINT `Juez_asalto` FOREIGN KEY (`CodigoJuez`) REFERENCES `juez` (`Codigo`),
  ADD CONSTRAINT `asalto_sucursal` FOREIGN KEY (`CodigoSucursal`) REFERENCES `sucursal` (`Codigo`);

--
-- Filtros para la tabla `condena`
--
ALTER TABLE `condena`
  ADD CONSTRAINT `asalto_condena` FOREIGN KEY (`CodigoAsalto`) REFERENCES `asalto` (`ID`),
  ADD CONSTRAINT `delincuente_condena` FOREIGN KEY (`CodigoDelincuente`) REFERENCES `delincuente` (`Codigo`);

--
-- Filtros para la tabla `contratacion`
--
ALTER TABLE `contratacion`
  ADD CONSTRAINT `sucursal_contratacion` FOREIGN KEY (`CodigoSucursal`) REFERENCES `sucursal` (`Codigo`),
  ADD CONSTRAINT `vigilante_contratacion` FOREIGN KEY (`CodigoVigilante`) REFERENCES `vigilante` (`Codigo`);

--
-- Filtros para la tabla `delincuente`
--
ALTER TABLE `delincuente`
  ADD CONSTRAINT `delincuente_banda` FOREIGN KEY (`CodigoBanda`) REFERENCES `banda` (`CodigoBanda`);

--
-- Filtros para la tabla `delincuentesporasalto`
--
ALTER TABLE `delincuentesporasalto`
  ADD CONSTRAINT `asalto_delincuentesporasalto` FOREIGN KEY (`AsaltoID`) REFERENCES `asalto` (`ID`),
  ADD CONSTRAINT `delincuentes_delincuentesporasalto` FOREIGN KEY (`CodigoDelincuente`) REFERENCES `delincuente` (`Codigo`);

--
-- Filtros para la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `sucursal_entidad` FOREIGN KEY (`CodigoEntidad`) REFERENCES `entidadbancaria` (`Codigo`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `rol_usuario` FOREIGN KEY (`RolID`) REFERENCES `rol` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
